package designAtm;

import designAtm.atmState.AtmState;

public class Atm {

    //(i)State DP m Context ki trha kam kerga
    private AtmState atmState;
    public  void setAtmState(AtmState atmState){
        this.atmState = atmState;
    }
    public AtmState getAtmState(){
        return atmState;
    }

    public void printCurrentAtmState(){
        System.out.println(" This Is Our Current Atm State -> " + atmState.getClass().toString());
    }

    //(ii)
    public int atmTotalBalance;
    public int noTwoThousandNote;
    public int noFiveHundredNote;
    public int noHundredNote;
    public void setAtmTotalBalance(int atmTotalBalance, int noTwoThousandNote, int noFiveHundredNote, int noHundredNote){
        this.atmTotalBalance = atmTotalBalance;
        this.noTwoThousandNote = noTwoThousandNote;
        this.noFiveHundredNote = noFiveHundredNote;
        this.noHundredNote = noHundredNote;
    }
 
    public int getAtmTotalBalance(){
        return atmTotalBalance;
    }
    public int getNoTwoThousandNote(){
        return noTwoThousandNote;
    }
    public int getNoFiveHundredNote(){
        return noFiveHundredNote;
    }
    public int getNoHundredNote(){
        return noHundredNote;
    }

    //Note: kitna ATM m bal baki h , kitne 1000,500,100 k note baki h.
    public void deductAtmBal(int deductBal){
         this.atmTotalBalance -= deductBal;
    }
    public void deductFiveHundredNotes(int deductFiveHundred){
          this.noFiveHundredNote -= deductFiveHundred;
    }
    public void deductTwoThousandNotes(int deductTwoThousand){
          this.noTwoThousandNote -= deductTwoThousand;
    }

    public void deductHundredNotes(int deductHundred){
         this.noHundredNote -= deductHundred;
    }


    //(iii)Seglonton
    static Atm atm = new Atm();
    private Atm(){
    }
    public static Atm getAtm(){
        return atm;
    }



}
