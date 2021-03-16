package dev.diegofernando.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;

public class Java8StreamReduce {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        // Reduce é um acumulador. É uma função associativa, ou seja, o resultado independe da forma que é feita.
        // Exemplo de não-associativa: subtração. Se fizermos subtração paralelo, teremos resultados diferentes.

        // Operação mais básica de reduce
        Optional<Integer> reduce = list.stream()
                .reduce((n1, n2) -> n1 + n2);
        // n1 é 1, n2 é 2 na primeira iteração, na segunda n1 é 3 e n2 é 3, na terceira m1 é 6 e n2 é 3... o resultado final é 21.

        System.out.println(reduce.get());


        System.out.println("-----------------------");
        // Operação mais básica de reduce com multiplicação
        Optional<Integer> reduce2 = list.stream()
                .reduce((n1, n2) -> n1 * n2);
        System.out.println(reduce2.get());

        System.out.println("-----------------------");
        // Operação mais básica de reduce com concat
        String s = "Diego é o dev mais bonito do brasil, e o mais mentiroso também";
        String[] split = s.split(" ");
        List<String> listStr = Arrays.asList(split);

        Optional<String> concatenacao = listStr.stream()
                .reduce((s1, s2) -> s1.concat(s2));
        System.out.println(concatenacao.get());

        // Conceito: VALOR DE IDENTIDADE -> É um valor base em que passado ao n1 o resultado final será n2 (como se só tivesse o n2).
        // Resumindo é um valor neutro.
        System.out.println("-----------------------");
        Integer reduce3 = list.stream()
                .reduce(0, (n1, n2) -> n1 + n2);

        System.out.println(reduce3);


        System.out.println("-----------------------");
        // Operação mais básica de reduce com multiplicação
        Integer reduce4 = list.stream()
                .reduce(1, (n1, n2) -> n1 * n2);
        System.out.println(reduce4);

        System.out.println("-----------------------");
        // Operação mais básica de reduce com concat

        String concatenacao1 = listStr.stream()
                .reduce("",(s1, s2) -> s1.concat(s2));
        System.out.println(concatenacao1);

        // reduce - mínimo valor
        System.out.println("-----------------------");
        //maneira ingenua sem valor identidade
//        OptionalDouble menorValor = DoubleStream.of(1.5, 2.9, 6.7)
//                .reduce((d1, d2) -> Math.min(d1, d2));

        double menorValor = DoubleStream.of(1.5, 2.9, 6.7)
        .reduce(Double.POSITIVE_INFINITY,(d1, d2) -> Math.min(d1, d2));
        System.out.println(menorValor);

        // Função de combinação - é uma função que pega os grupos formados na associação faz operações
        // com a possibilidade de ser mais performático

        String reduceCombiner = list.stream()
                .reduce(
                        "",
                        (n1, n2) -> n1.toString().concat(n2.toString()),
                        (n1, n2) -> n1.concat(n2)
                );
        System.out.println(reduceCombiner);


        // Diferença entra reduce e collect
        // Collect é mutável, reduce é imutavel


    }
}
