package org.example.pc;

import java.util.LinkedList;
import java.util.Queue;

public class CommonResource {

    private Queue<Integer> que;
    private int capacity;

    public CommonResource(int capacity){
        que = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized void produce_Item(int item) throws Exception{

        if(que.size() == capacity){
            wait();
        }

        que.add(item);
        System.out.println("Producer item " + item);
        notify();

    }

    public synchronized void consume_Item() throws Exception{

        if(que.isEmpty()){
            wait();
        }

        int rem = que.poll();
        System.out.println("Consume item " + rem);
        notify();

    }


}
