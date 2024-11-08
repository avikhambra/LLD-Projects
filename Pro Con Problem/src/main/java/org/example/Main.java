package org.example;

import org.example.pc.CommonResource;
import org.example.pc.Consumer;
import org.example.pc.Producer;

public class Main {
    public static void main(String[] args) {

        CommonResource cR = new CommonResource(5);

        Producer pro = new Producer(cR);
        Consumer con = new Consumer(cR);

        pro.start();
        con.start();


    }
}