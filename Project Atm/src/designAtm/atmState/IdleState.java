package designAtm.atmState;
import designAtm.Atm;
import designAtm.Card;

public class IdleState extends AtmState{//ATM abhi kuch nhi ker rhaa tha , ab suru kerga
    public void insertCard(Atm atm, Card card) {

        System.out.println("Card Inserted");
        atm.setAtmState(new HasCardState() );

    }

}
