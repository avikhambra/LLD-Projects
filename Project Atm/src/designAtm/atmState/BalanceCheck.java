package designAtm.atmState;

import designAtm.Atm;
import designAtm.Card;

public class BalanceCheck extends AtmState{

    @Override
    public void displayBalance(Atm atm, Card card) {

        System.out.println("See Your Acc Balance With Card " + card.getHolderCardBalance());

    }

}
