package dev.diegofernando.stream;

import java.util.*;
import java.util.stream.Collectors;

public class Java8StreamCollect {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // da esquerda para direira = fornecedor - acumulador - combinação
        List<Integer> collect = list.stream()
                .collect(
                    () -> new ArrayList<>(), // instancia do que eu quero usar para armazenar o resultado
                    (l, e) -> l.add(e), // como que eu armazeno um resultado dentro disso
                    (l1, l2) -> l1.addAll(l2) // como que eu combino as threads que estão trabalhando nisso
                );

        System.out.println(list);
        System.out.println(collect);

        // toList
        System.out.println("------------------");
        List<Integer> collect2 = list.stream()
                .filter((n) -> n % 2 == 0)
                .collect(Collectors.toList()); //toSet, toCollection para criar o que quiser: Set, ArrayDeque, etc.

        System.out.println(collect2);

        // joining
        System.out.println("------------------");
        String join = list.stream()
                .map(n -> n.toString())
                .collect(Collectors.joining(" - "));// Usa StringBuilder, então se torna mais performatico

        System.out.println(join);

        //averaging
        System.out.println("------------------");
        Double media = list.stream()
                .collect(Collectors.averagingInt(n -> n.intValue()));

        System.out.println(media);

        //soma
        System.out.println("------------------");
        Integer summing = list.stream()
                .collect(Collectors.summingInt(n -> n.intValue()));

        System.out.println(summing);

        //sommarizing - traz algumas estatisticas
        System.out.println("------------------");
        IntSummaryStatistics stats = list.stream()
                .collect(Collectors.summarizingInt(n -> n.intValue()));

        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());

        // counting
        System.out.println("------------------");
        Long count = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.counting());
        System.out.println(count);

        // max/min
        System.out.println("------------------");
        list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.maxBy(Comparator.naturalOrder()))
                .ifPresent(System.out::println);

        // operações um pouco mais complexas
        // groupingBy
        System.out.println("------------------");
        Map<Integer, List<Integer>> groupingBy = list.stream()
                .collect(Collectors.groupingBy(n -> n % 3));
        System.out.println(groupingBy);

        // partitioningBy
        System.out.println("------------------");
        Map<Boolean, List<Integer>> partitioningBy = list.stream()
                .collect(Collectors.partitioningBy(n -> n % 3 == 0));// sempre deve fazer algo para que retorne um booleano
        System.out.println(partitioningBy);

        // toMap
        // partitioningBy
        System.out.println("------------------");
        Map<Integer, Integer> toMap = list.stream()
                .collect(Collectors.toMap(n -> n, n -> n * 2));// faz um map primeiro parametro dizermos a chave e o segundo dizemos o valor.
        System.out.println(toMap);

    }
}
