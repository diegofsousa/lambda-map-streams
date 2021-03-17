package dev.diegofernando.methodreference;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Java8MethodReference {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        // Method reference usa o "::"
        list.stream()
                .forEach(System.out::println);

        // Sem method reference
        list.stream()
                .forEach(n -> System.out.println(n));

        // usando um method reference nosso
        list.stream()
                .map(Java8MethodReference::multipliquePorDois)
                .forEach(System.out::println);

        // uso com construtores
        list.stream()
                .map(BigDecimal::new)
                .forEach(System.out::println);

        // uso com instancias
        BigDecimal dois = new BigDecimal(2);
        list.stream()
                .map(BigDecimal::new)
                .map(dois::multiply)
                .forEach(System.out::println);

    }

    private static Integer multipliquePorDois(Integer i){
        return i * 2;
    }
}
