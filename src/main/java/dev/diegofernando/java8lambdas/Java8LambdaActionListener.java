package dev.diegofernando.java8lambdas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Java8LambdaActionListener {
    // Java 8 com funções lambda
    public static void main(String[] args) {
        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Olá mundo!");
            }
        });

        JButton jButton2 = new JButton();
        jButton2.addActionListener(actionEvent -> System.out.println("Olá mundo!"));

        // Conceito SAM - Single Abstract Method
        // Qualquer interface que tem um método abstrato. ActionListener e Runnable são exemplos claros disso
        // Como é a estrutura de uma lambda
        // jButton2.addActionListener(actionEvent -> System.out.println("Olá mundo!"));
        //                                ^                       ^
        //                            variável              implementação
        // A interface Runnable é anotada com @FunctionalInterface. Esta anotação é informativa para que saibamos que a interface respeita o SAM (não é obrigatória)
    }
}
