package org.example.onetwothree;

public class Three implements Runnable{

    private CommonResorce cR;

    public Three(CommonResorce cR){
        this.cR = cR;
    }

    public void run(){

        try {
            while (true){
                cR.print_three();
                Thread.sleep(2000);
            }
        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
