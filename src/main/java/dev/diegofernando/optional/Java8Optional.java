package dev.diegofernando.optional;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;

public class Java8Optional {
    public static void main(String[] args) {
//        String s = "diego";
        String s = "1";
        Optional<Integer> optionalInteger = converteEmNumero(s);
        System.out.println(optionalInteger.isPresent());

        optionalInteger.ifPresent(n -> System.out.println(n)); // programação declarativa

        Integer anElse = converteEmNumero(s).orElse(2);
        System.out.println(anElse);

//        Integer anElse = converteEmNumero(s).orElseGet(() -> {return operacaoPesada();}); // orElseGet recebe um lambda
        Integer anElse1 = converteEmNumero(s).orElseThrow(() -> new NullPointerException("Valor vazio"));
        System.out.println(anElse1);

        Stream.of(1,2,3)
                .findFirst()
                .ifPresent(n -> System.out.println(n));

        // ------------------------
        int anElse3 = converteEmNumeroPrimitivo(s).orElseThrow(() -> new NullPointerException("Valor vazio"));
        System.out.println(anElse3);

    }
    public static Optional<Integer> converteEmNumero(String numeroStr){
//        return Optional.of(Integer.valueOf(numeroStr)); forma 1 - ingenua

        // forma mais legalzinha
        try {
            return Optional.of(Integer.valueOf(numeroStr));
        } catch (Exception e){
            return Optional.empty();
        }
    }

    //ATENÇÃO: OPTIONAL SÓ SERVE PARA RETORNO. NÃO FAZ SENTIDO PARA RECEBER ARGUMENTO.

    public static OptionalInt converteEmNumeroPrimitivo(String numeroStr){ //Tem OptionalDouble e OptionalLong
//        return Optional.of(Integer.valueOf(numeroStr)); forma 1 - ingenua

        // forma mais legalzinha
        try {
            return OptionalInt.of(Integer.parseInt(numeroStr));
        } catch (Exception e){
            return OptionalInt.empty();
        }
    }
}
