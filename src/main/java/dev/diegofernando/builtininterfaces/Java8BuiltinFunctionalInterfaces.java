package dev.diegofernando.builtininterfaces;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class Java8BuiltinFunctionalInterfaces {
    public static void main(String[] args) {
        Stream.generate(() -> new Random().nextInt()) // funcionamento de Supplier - é um SUM
                .limit(5)
                .forEach(e -> System.out.println(e)); // funcionamento de um Consumer - é um SUM

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream()
                .filter(e -> e % 2 == 0) // funcionamento de um Predicate - é um SUM
                .map(e -> e.doubleValue()) // funcionamento de um Function - é um SUM
                .reduce((e1, e2) -> e1 + e2) // funcionamento de um UaryOperator ou BinaryOperator - são SUM's
                .ifPresent(System.out::println);
    }
}
