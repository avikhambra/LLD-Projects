package designAtm.atmState;

import designAtm.Atm;
import designAtm.Card;
import designAtm.TransactionTypes;

public class SelectOperation extends AtmState{

    public void selectOperation(Atm atm, Card card, TransactionTypes transactionType) {

        TransactionTypes.showAllTransactionTypes();

        System.out.println("You Selected "+  transactionType + " Operation!");

        switch (transactionType){

            case BALANCE_CHECK:
                 atm.setAtmState(new BalanceCheck() );
                 atm.getAtmState().displayBalance(atm , card);
                 exit(atm);
            break;

            case CASH_WITHDRAW:
                atm.setAtmState(new CashWithdraw() );
                exit(atm);
            break;

            default: System.out.println("Invalid TransactionTypes");

        }

    }

}
