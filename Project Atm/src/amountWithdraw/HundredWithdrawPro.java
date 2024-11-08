package amountWithdraw;

import designAtm.Atm;

public class HundredWithdrawPro extends CashWithdrawProcesser{
    public HundredWithdrawPro(CashWithdrawProcesser cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public void withdraw(Atm atm, int remainingAmount) {

        int required =  remainingAmount/100;
        int balance = remainingAmount%100;

        if(required <= atm.getNoHundredNote()) {
            atm.deductHundredNotes(required);
        }else if(required > atm.getNoHundredNote() ) {
            atm.deductTwoThousandNotes( atm.getNoHundredNote() );
            balance = balance + (required - atm.getNoHundredNote() ) * 100;
        }

        System.out.println("OneHundredNotes is " + required + " Duducted ");

        if(balance != 0){
            super.withdraw(atm, balance);
        }


    }

}
