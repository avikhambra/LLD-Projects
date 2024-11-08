package org.example.oddeven;

public class Odd implements Runnable{

    private CommonResorce cR;

    public Odd(CommonResorce cR){
        this.cR = cR;
    }

    public void run(){

        while (true){

            try {
                cR.print_Odd();
                Thread.sleep(2000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }

    }

}
