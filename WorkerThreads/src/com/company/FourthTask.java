package com.company;

public class FourthTask implements Task {
    @Override
    public void run(int taskNumber) throws InterruptedException {
        System.out.println("Zadanie nr 4");
        Thread.sleep(10000);
    }
}
