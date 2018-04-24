package com.company;

public class SecTask implements Task {

    @Override
    public void run(int taskNumber) throws InterruptedException {
        System.out.println("Zadanie nr 2");
        Thread.sleep(10000);
    }
}
