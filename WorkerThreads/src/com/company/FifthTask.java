package com.company;

public class FifthTask implements Task {

    @Override
    public void run(int taskNumber) throws InterruptedException {
        System.out.println("Zadanie nr 5");
        Thread.sleep(10000);
    }
}
