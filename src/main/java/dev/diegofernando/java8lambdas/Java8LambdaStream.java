package dev.diegofernando.java8lambdas;

import java.util.Arrays;
import java.util.List;

public class Java8LambdaStream {
    // Java 8 com funções lambda
    public static void main(String[] args) {

        // O lambda não foi criado apenas para reduzir a quantidade de código.
        // Também para proporcionar o uso de STREAM

        // STREAM é um fluxo de dados.

        List<Integer> asList = Arrays.asList(1, 2, 3, 4);


        // Maneira tradicional
        for (Integer integer : asList) {
            System.out.println(integer);
        }

        // Usando stream / forEach
        asList.stream().forEach(e -> System.out.println(e));

        // Usando stream / forEach / filter
        asList.stream()
                .filter(e -> e % 2 == 0)
                .forEach(e -> System.out.println(e));

    }
}
