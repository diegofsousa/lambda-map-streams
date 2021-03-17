package dev.diegofernando.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

public class Java8ParallelStreams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

//        list.parallelStream().

        // Quando usar stream paralelo?
        /*
        * usamos quando precisamos ganhar performance
        * - geralmente quando temos milhares ou milhoes de itens em lista.
        * - do contrário podemos perder performance.
        * */


        // forEach x forEachOrdered
        list.parallelStream()
                .forEach(System.out::println); // for each imprime sem ordem

        list.parallelStream()
                .forEachOrdered(System.out::println); // for each imprime em ordem

        // findAny
        list.parallelStream()
                .findAny()
                .ifPresent(System.out::println); // retorna um numero qualquer
        list.stream()
                .findAny()
                .ifPresent(System.out::println); // sempre retorna o primeiro elemento pronto, no caso o 1

        System.out.println("----------");
        // unordered
        list.parallelStream()
                .unordered() // em casos de skip e/ou limite em parallelStream é interessante usar o "unordered"
                .skip(1)
                .limit(2)
                .forEachOrdered(System.out::println);

        System.out.println("----------");
        // reduce
        list.parallelStream()
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

        System.out.println("----------");
        // toMap
        ConcurrentMap<Integer, Boolean> collect = list.parallelStream()
                .collect(
                   Collectors
                     .toConcurrentMap(n -> n, n -> n % 2 == 0)
                );

        System.out.println(collect);

        System.out.println("----------");
        // groupingBy

        Map<Boolean, List<Integer>> collect2 = list.parallelStream()
                .collect(Collectors
                        .groupingBy(n -> n % 2 == 0)
                );
        System.out.println(collect2);


    }
}
