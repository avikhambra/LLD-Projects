package org.example.pc;

public class Producer extends Thread{

    private CommonResource cR;

    public Producer(CommonResource cR){
        this.cR = cR;
    }

    public void run(){

        int i = 0;

        while(true){

            try {
                cR.produce_Item(i);
                i++;
                Thread.sleep(2000);
            }catch (Exception e){
                throw new RuntimeException(e);
            }

        }

    }

}
