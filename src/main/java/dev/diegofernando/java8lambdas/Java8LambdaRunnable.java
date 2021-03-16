package dev.diegofernando.java8lambdas;

public class Java8LambdaRunnable {
    // Java 8 com funções lambda

    public static void main(String[] args) {

        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println("Olá mundo");
            }
        }).run();


        // transformando em lambda
        new Thread(() -> System.out.println("Olá mundo")).run();
    }


}
