package br.com.alura.v3.otimizacao;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;

public record Event(String location, int price, String eventType, int eventRankId) {

    public static int evaluateLocationProximity(String location1, String location2) {
        return Math.abs(location1.hashCode() - location2.hashCode());
    }

    public static int evaluateProvidersAffinity(String localEventType, int localPrice, String targetEvtType, int targetPrice) {
        if (localEventType.equalsIgnoreCase(targetEvtType)) {
            return Math.abs(localPrice - targetPrice);
        }

        return (100 + Math.abs(localPrice - targetPrice));
    }



    public static List<Event> getNearEvents(int number, List<Event> events, String targetLocation, BiFunction<String, String, Integer> biFunction,
                                            String targetType, int targetPrice) {

        var distanceEventsMap = events.stream()
                .parallel()
                .collect(groupingByConcurrent(event -> biFunction.apply(event.location(), targetLocation),
                        ConcurrentSkipListMap::new,//fornece uma implementação simultânea escalável de um Map que, em nosso caso, é classificado pela ordenação natural da chave (a distância entre dois eventos)
                            groupingBy(ev -> evaluateProvidersAffinity(ev.eventType(), ev.price(), targetType, targetPrice),
                                ConcurrentSkipListMap::new,
                                Collectors.toCollection(() -> new TreeSet<>(Comparator.comparingInt(Event::eventRankId))))
                ));

        return distanceEventsMap.values()
                .stream()
                .parallel()
                .flatMap(v -> v.values().stream().parallel().flatMap(Set::stream))
                .limit(number)
                .collect(Collectors.toList());

    }
}
