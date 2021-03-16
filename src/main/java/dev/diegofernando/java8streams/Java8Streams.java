package dev.diegofernando.java8streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8Streams {
    public static void main(String[] args) {
        List<Integer> lista = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);
        // Java 8: Streams

        // Java 5
        for (Integer integer:
             lista) {
            System.out.println(integer);
        }

        // Java 8 lambda
        // STREAM -> fluxo de dados
        lista.stream().forEach(e -> System.out.println(e));

        // Usando skip
        System.out.println("\n\n");
        lista.stream()
                .skip(2) // pula os dois primeiros elementos = operação intermediária
                .forEach(e -> System.out.println(e));

        // Usando skip
        System.out.println("\n\n");
        lista.stream()
                .limit(2) // limitar a 2 elementos = operação intermediária
                .forEach(e -> System.out.println(e));

        // Usando distinct
        System.out.println("\n\n");
        lista.stream()
                .distinct() // não permite processar elementos repetidos - comparação de equals e hashcode = operação intermediária
                .forEach(e -> System.out.println(e));

        // Usando filter
        System.out.println("\n\n");
        lista.stream()
                .filter(e -> e % 2 == 0) // seleciona numeros pares = operação intermediária
                .forEach(e -> System.out.println(e));

        // Usando filter
        System.out.println("\n\n");
        lista.stream()
                .map(e -> e * 2) // map é uma transformação de dados = operação intermediária
                .forEach(e -> System.out.println(e));

        // DICA: o ideal é sempre filtrar os itens antes de fazer uma transformação.

        System.out.println("\n\n");
        Stream<Integer> map = lista.stream()
                .limit(2) // limitar a 2 elementos = operação intermediária
                .map(e -> e * 2);
        map.forEach(System.out::println); // Só da pra fazer uma operação final por stream
//        map.forEach(System.out::println); // Se chamar de novo dá erro.

        System.out.println("\n\n");
        long count = lista.stream()
                .map(e -> e * 2)
                .count(); // usando count como operação final

        System.out.println(count);

        System.out.println("\n\n");
        Optional<Integer> min = lista.stream()
                .map(e -> e * 2)
                .min(Comparator.naturalOrder());// usa o compareTo da minha lista (também existe o max)

        System.out.println(min.get());

        // Coletando resultados

        // Usando collect
        System.out.println("\n\n");
        List<Integer> novaLista = lista.stream()
                .filter(e -> e % 2 == 0) // seleciona numeros pares = operação intermediária
                .map(e -> e * 3) // transforma = operação intermediária
                .collect(Collectors.toList());// pega todoh o resultado do stream e armazena em uma lista

        System.out.println(novaLista);

        // Usando collect - group by
        System.out.println("\n\n");
        Map<Boolean, List<Integer>> collect = lista.stream()
                .map(e -> e * 3) // transforma = operação intermediária
                .collect(Collectors.groupingBy(e -> e % 2 == 0));// pega todoh e faz um group by
        System.out.println(collect);

        // Usando collect - group by
        System.out.println("\n\n");
        Map<Integer, List<Integer>> collect1 = lista.stream()
                .collect(Collectors.groupingBy(e -> e % 3));// pega todoh e faz um group by
        System.out.println(collect1);

        // Usando collect - joining - so funciona com string

        System.out.println("\n\n");
        String collect2 = lista.stream()
                .map(e -> String.valueOf(e))
                .collect(Collectors.joining(" - "));
        System.out.println(collect2);

        // stream - loops implicitos - o java cuida da iteração
        // for, while, do...while = loops explicidos - o dev cuida da iteração - vc pode dar um tiro no pé


    }
}
