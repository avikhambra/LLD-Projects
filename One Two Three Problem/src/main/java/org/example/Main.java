package org.example;

import org.example.onetwothree.CommonResorce;
import org.example.onetwothree.One;
import org.example.onetwothree.Three;
import org.example.onetwothree.Two;

public class Main {
    public static void main(String[] args) {

        CommonResorce cR = new CommonResorce();

        One one   = new One(cR);
        Thread t1 = new Thread(one);
        t1.setName("First_Thread --> ");

        Two two = new Two(cR);
        Thread t2 = new Thread(two);
        t2.setName("Second_Thread --> ");

        Three three = new Three(cR);
        Thread t3 = new Thread(three);
        t3.setName("Third_Thread --> ");

        t1.start();
        t2.start();
        t3.start();


    }
}