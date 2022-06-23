package br.com.github.v3;


import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.function.BiFunction;

public class Compute {

    //computa independente se há ou não o valor da chave, caso o valor computado tenha resultado nulo, este é removido do mapa
    public static void main(String[] args) throws UnknownHostException {
        var map = new HashMap<String, String>();
        map.put("mysql", "192.168.0.1");
        map.put("postgres", "127.0.0.1");
        var address = Inet4Address.getLocalHost().getHostAddress();

        BiFunction<String, String, String> jdbc = (k,v) -> k + "://" + (v == null ? address : v) + "/customers_db";

        String mongoDb = map.compute("mongodb", jdbc);

        String mongoDb2 = map.compute("mongodb", jdbc);
        System.out.println(mongoDb);
        System.out.println(map);
    }
}
