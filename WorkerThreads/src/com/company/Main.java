package com.company;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        System.out.println("tworze nowy wątek głowny:");
        Worker tmp = new Worker("John");
        //Thread luz = new Thread((Runnable) tmp);
        tmp.setListener(new WorkerListener() {
            @Override
            public void onWorkerStarted() {
                System.out.println("onWorkerStarted");
            }

            @Override
            public void onWorkerStopped() {
                System.out.println("onWorkerStopped");
            }

            @Override
            public void onTaskStarted(int taskNumber, String taskName) {
                System.out.println("onTaskStarted "+taskNumber+" "+taskName);
            }

            @Override
            public void onTaskCompleted(int taskNumber, String taskName) {
                System.out.println("onTaskCompleted "+taskNumber+" "+taskName);
            }
        });


        try {
            tmp.enqueueTask("jedynka", new FirstTask());
            tmp.enqueueTask("dwójka",new SecTask());
            tmp.enqueueTask("trójka",new ThirdTask());
            tmp.enqueueTask("czwórka",new FourthTask());
            tmp.enqueueTask("piątka",new FifthTask());

            tmp.start();


        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try{
            tmp.enqueueTask("jedynka", new FirstTask());
            tmp.enqueueTask("dwójka",new SecTask());
            tmp.enqueueTask("trójka",new ThirdTask());
            tmp.enqueueTask("czwórka",new FourthTask());
            tmp.enqueueTask("piątka",new FifthTask());
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        Thread.sleep(15000);


        tmp.Stop();
        tmp.join(); // method waits for a thread to die
    }
            //Thread.sleep(10000);
            //tmp.Stop();


}


