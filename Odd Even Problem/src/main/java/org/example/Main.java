package org.example;

import org.example.oddeven.CommonResorce;
import org.example.oddeven.Even;
import org.example.oddeven.Odd;

public class Main {
    public static void main(String[] args) {

        CommonResorce cR = new CommonResorce();

        Odd o     = new Odd(cR);
        Thread o1 = new Thread(o);

        Even e    = new Even(cR);
        Thread e1 = new Thread(e);

        o1.start();
        e1.start();

    }
}