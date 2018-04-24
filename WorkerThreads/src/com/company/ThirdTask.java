package com.company;

public class ThirdTask implements Task {
    @Override
    public void run(int taskNumber) throws InterruptedException {
        System.out.println("Zadanie nr 3");
        long time = System.currentTimeMillis();
        while(true)
        {
            Thread.yield();
            if(time+10000 > System.currentTimeMillis()) {
                Thread.yield();     //ustępuje użycia procesora innym wątkom
                continue;
            }
            else
                break;


        }
    }
}
