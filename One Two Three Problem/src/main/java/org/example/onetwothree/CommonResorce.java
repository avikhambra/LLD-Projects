package org.example.onetwothree;

public class CommonResorce {

    private int n;
    boolean flag1;
    boolean flag2;

    public CommonResorce(){
        n = 1;
        flag1 = false;
        flag2 = false;
    }

    public synchronized void print_one() throws InterruptedException{

        if(flag1 == false && flag2 == false){
            System.out.println(Thread.currentThread().getName() + n);
            n++;
            flag2 = true;
            notify();
        }else{
            wait();
        }

    }

    public synchronized void print_two() throws InterruptedException{

        if(flag1 == false && flag2 == true){
            System.out.println(Thread.currentThread().getName() + n);
            n++;
            flag1 = true;
            notify();
        }else{
            wait();
        }

    }

    public synchronized void print_three() throws InterruptedException{

        if(flag1 == true && flag2 == true){
            System.out.println(Thread.currentThread().getName() + n);
            n++;
            flag1 = false;
            flag2 = false;
            notify();
        }else{
            wait();
        }

    }

}
