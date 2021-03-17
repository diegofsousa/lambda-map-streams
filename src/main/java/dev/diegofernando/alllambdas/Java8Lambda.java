package dev.diegofernando.alllambdas;

import java.util.stream.IntStream;

public class Java8Lambda {
    public static void main(String[] args) {
        IntStream.range(0, 5)
                .filter(n -> n % 2 ==0)
                .forEach(System.out::println);

        // Quando usar parênteses na expressão lambda

        // quando devemos declarar o tipo
        // quando temos mais de um argumento
        IntStream.range(0, 5)
                .filter((int n) -> n % 2 ==0)
                .reduce((n1, n2) -> n1 + n2)
                .ifPresent(System.out::println);

        // quando não temos nenhum argumento
        Runnable runnable = () -> System.out.println("Runnable");

        // Quando usar chaves na expressão lambda

        // em qualquer expressão desde que também adicione return (quando nao for void) e ponto-virgula
        // expressões com chaves comportam trchos de codigo também
        IntStream.range(0, 5)
                .filter((int n) -> {
                    System.out.println("Operação");
                    return n % 2 ==0;
                })
                .forEach(System.out::println);

    }
}
