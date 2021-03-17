package dev.diegofernando.alllambdas;

import java.util.Arrays;
import java.util.List;

public class Java8LambdaDebug {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 5, 8, 9);

        list.stream()
                .peek(n -> System.out.println(n + " debugado")) // para adicionar logs nas operações
                .map((n) ->{
                    StringBuilder builder = new StringBuilder();
                    builder.append(n);
                    builder.append("s");
                    builder.append("a");
                    return builder;
                })
                .forEach(System.out::println);
    }
}
