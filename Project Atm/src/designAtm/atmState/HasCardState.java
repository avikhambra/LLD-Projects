package designAtm.atmState;
import designAtm.Atm;
import designAtm.Card;

public class HasCardState extends AtmState{
    public void authenticatePin(Atm atm, Card card, int pin) {

        boolean isValidPINEntered = card.getValidatePIN(pin);

        if(isValidPINEntered){
            System.out.println("PIN Is Valid");
            atm.setAtmState(new SelectOperation());
        }else {
            System.out.println("Invalid PIN");
            exit(atm);

        }

    }

    public void exit(Atm atm){
        returnCard();
        atm.setAtmState( new IdleState());
    }

    public void returnCard(){
        System.out.println("Your Card is returned plz Collect Your Card!");
    }

}
