package amountWithdraw;

import designAtm.Atm;

public class FiveHundredWithdrawPro extends CashWithdrawProcesser{
    public FiveHundredWithdrawPro(CashWithdrawProcesser cashWithdrawalProcessor) {
        super(cashWithdrawalProcessor);
    }

    public void withdraw(Atm atm, int remainingAmount) {

        int required =  remainingAmount/500;
        int balance = remainingAmount%500;

        if(required <= atm.getNoFiveHundredNote()) {
            atm.deductFiveHundredNotes(required);
        }else if(required > atm.getNoFiveHundredNote() ) {
            atm.deductFiveHundredNotes( atm.getNoFiveHundredNote() );
            balance = balance + (required - atm.getNoFiveHundredNote() ) * 500;
        }

        System.out.println("FiveHundredNotes is " + required + " Duducted ");

        if(balance != 0){
            super.withdraw(atm, balance);
        }

    }

}
