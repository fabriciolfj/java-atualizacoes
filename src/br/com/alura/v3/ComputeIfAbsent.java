package br.com.alura.v3;


import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.function.Function;

public class ComputeIfAbsent {

    //computa se a chave estiver ausente, caso contrario apenas devolve o valor
    public static void main(String[] args) throws UnknownHostException {
        var map = new HashMap<String, String>();
        map.put("mysql", "192.168.0.1");
        map.put("postgres", "127.0.0.1");

        var address = Inet4Address.getLocalHost().getHostAddress();
        Function<String, String> jdbc = k -> k + "://" + address + "/customers_db";

        String mongoDb = map.computeIfAbsent("mongodb", jdbc);

        String mongoDb2 = map.computeIfAbsent("mongodb", jdbc);
        System.out.println(mongoDb);
        System.out.println(map);
    }
}
