package org.example.pc;

public class Consumer extends Thread{

    private CommonResource cR;

    public Consumer(CommonResource cR){
        this.cR = cR;
    }

    public void run(){

        while (true){

            try {
                cR.consume_Item();
                Thread.sleep(2000);
            }catch (Exception e){
                throw new RuntimeException();
            }

        }

    }

}
