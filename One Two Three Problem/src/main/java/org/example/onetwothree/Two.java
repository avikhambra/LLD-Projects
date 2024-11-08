package org.example.onetwothree;

public class Two implements Runnable{

    private CommonResorce cR;

    public Two(CommonResorce cR){
        this.cR = cR;
    }

    public void run(){

        try {
            while (true){
                cR.print_two();
                Thread.sleep(2000);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
