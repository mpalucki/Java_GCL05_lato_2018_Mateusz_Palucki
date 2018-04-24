package com.company;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

public class Worker {
    String workerName;
    boolean isStarted=false;
    boolean isWorking=false;
    LinkedBlockingQueue<TaskExecute> tasks;
    Thread newThread;

    WorkerListener listener;

    public Worker(String name){
        this.workerName = name;
        tasks = new LinkedBlockingQueue<TaskExecute>();
    }

    /*@Override
    public void run() {
        listener.onWorkerStarted();
        while (true)
        {
            int taskNumber = 0;
            try {
                TaskExecute temp=tasks.poll();
                listener.onTaskStarted(taskNumber,temp.getTaskName());
                temp.getTask().run(taskNumber);
                listener.onTaskCompleted(taskNumber,temp.getTaskName());
                taskNumber++;
            } catch (InterruptedException e) {
                break;
            }
        }
        listener.onWorkerStopped();
    }*/

    public void enqueueTask(String taskName, Task task) throws InterruptedException {
       TaskExecute new_task = new TaskExecute(task,taskName);
        tasks.offer(new_task);
    }


    public synchronized void start() throws InterruptedException {

        if(newThread!=null)
            return;

        String name="Worker" + workerName + " thread";
        newThread = new Thread(name){
            @Override
            public void run() {
                int taskNumber = 1;
                listener.onWorkerStarted();
                while (true)
                {
                    try{
                        TaskExecute temp=tasks.take(); // Queue with poll() throws nullpointerexception
                        listener.onTaskStarted(taskNumber,temp.getTaskName());
                        temp.getTask().run(taskNumber);
                        listener.onTaskCompleted(taskNumber,temp.getTaskName());
                        taskNumber++;
                    } catch (InterruptedException e) {
                        break;
                    }
                }
                listener.onWorkerStopped();
            }

        };

        newThread.start();
        //newThread.join();
        isStarted = true;

    }

    public synchronized void Stop() {

        isWorking = false;
        newThread.interrupt();
        //newThread = null;

    }
    public void setListener(WorkerListener worker){
        listener = worker;
    }
    public boolean isStarted(){
        return isStarted;
    }
    public boolean isWorking(){
        return isWorking;
    }

    public boolean isEmptyQueue()
    {
        if(tasks == null)
            return true;
        else
            return false;
    }
    public void join() throws InterruptedException {
        newThread.join();
    }
}
