package org.example.oddeven;

public class Even implements Runnable{

    private CommonResorce cR;

    public Even(CommonResorce cR){
        this.cR = cR;
    }

    public void run(){

        while (true){

            try {
                cR.print_Even();
                Thread.sleep(2000);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }

    }

}
