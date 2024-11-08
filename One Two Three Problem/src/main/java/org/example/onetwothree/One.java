package org.example.onetwothree;

public class One implements Runnable{

    private CommonResorce cR;

    public One(CommonResorce cR){
        this.cR = cR;
    }

    public void run(){

        try {
            while (true){
                cR.print_one();
                Thread.sleep(2000);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
