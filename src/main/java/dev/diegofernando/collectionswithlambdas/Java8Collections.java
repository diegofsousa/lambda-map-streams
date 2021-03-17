package dev.diegofernando.collectionswithlambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Java8Collections {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // list
        list.forEach(System.out::println);
        list.removeIf(n -> n % 2 == 0);
        list.forEach(System.out::println);
        list.replaceAll(n -> n * 2);
        list.forEach(System.out::println);

        // forEach
        HashMap<Integer, String> map = new HashMap<>();
        map.put(0, "Diego");
        map.put(1, "Fernando");
        map.put(2, "Analista");
        map.forEach((k, v) -> System.out.println(k + " - " + v)); // É um biconsumer.. retorna dois parametros.

        // compute
        map.compute(1, (k, v) -> v + " agora");
        map.forEach((k, v) -> System.out.println(k + " - " + v));

        // merge
        map.merge(2, "!", (v1, v2) -> v1 +  v2); // v1 é a posição 2 e v2 é "!". logo ele concatenou.
        map.merge(3, "!", (v1, v2) -> v1 +  v2); // v1 é a posição 2 (não existe) e v2 é "!". logo ele apresentou só "!".
        map.forEach((k, v) -> System.out.println(k + " - " + v));

        // replaceAll
        map.replaceAll((k, v) -> v + "!");
        map.forEach((k, v) -> System.out.println(k + " - " + v));



    }
}
