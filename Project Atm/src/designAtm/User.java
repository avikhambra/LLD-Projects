package designAtm;

import designAtm.Card;

public class User {

    private Card card;
    private UserBankAcc userBankAcc;
    public Card getCard(){
        return card;
    }
    public void setCard(Card card){
        this.card = card;
    }

}
