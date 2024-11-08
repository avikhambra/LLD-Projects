package amountWithdraw;


import designAtm.Atm;

public class TwoThousandWithdrawPro extends CashWithdrawProcesser {
    public TwoThousandWithdrawPro(CashWithdrawProcesser nextCashWithdrawPro) {
        super(nextCashWithdrawPro);
    }

    public void withdraw(Atm atm, int remainingAmount) {

        int required =  remainingAmount/2000;
        int balance = remainingAmount%2000;

        if(required <= atm.getNoTwoThousandNote()) {
            atm.deductTwoThousandNotes(required);
        }else if(required > atm.getNoTwoThousandNote() ) {
            atm.deductTwoThousandNotes( atm.getNoTwoThousandNote() );
            balance = balance + (required - atm.getNoTwoThousandNote()) * 2000;
        }

        System.out.println("TwoThousandNotes is " + required + " Duducted ");

        if(balance != 0){
            super.withdraw(atm, balance);
        }


    }
}
