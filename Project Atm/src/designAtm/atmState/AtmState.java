package designAtm.atmState;
import designAtm.Atm;
import designAtm.Card;
import designAtm.TransactionTypes;

public abstract class AtmState {

    public void insertCard(Atm atm, Card card) {

    }
    public void authenticatePin(Atm atm, Card card, int pin) {

    }
    public void selectOperation(Atm atm, Card card, TransactionTypes transactionType) {

    }
    public void cashWithdraw(Atm atm, Card card, int amount) {

    }
    public void displayBalance(Atm atm, Card card) {

    }
    public void returnCard(Atm atm) {

    }
    public void exit(Atm atm){

    }



}
