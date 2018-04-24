package com.company;

public class FirstTask implements Task {

    @Override
    public void run(int taskNumber) throws InterruptedException {
        System.out.println("Zadanie nr 1");
        long time = System.currentTimeMillis();
        Thread tmp1 = new Thread(){
            @Override
            public void run(){
                while(true)
                {
                    if (time + 10000 > System.currentTimeMillis()) {
                        continue;
                    }
                    else
                        break;
                }
            }
        };
        Thread tmp2 = new Thread(){
            @Override
            public void run(){
                while(true)
                {
                    if (time + 10000 > System.currentTimeMillis()) {
                        continue;
                    }
                    else
                        break;
                }
            }
        };
        Thread tmp3 = new Thread(){
            @Override
            public void run(){
                while(true)
                {
                    if (time + 10000 > System.currentTimeMillis()) {
                        continue;
                    }
                    else
                        break;
                }
            }
        };
        tmp1.start();
        tmp2.start();
        tmp3.start();
        while(true)
        {
            if (time + 10000 > System.currentTimeMillis()) {
                tmp1.interrupt();
                tmp2.interrupt();
                tmp3.interrupt();
                continue;

             }
            else
                break;
        }
    }
}

