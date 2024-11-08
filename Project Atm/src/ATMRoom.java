import designAtm.Atm;
import designAtm.Card;
import designAtm.UserBankAcc;
import designAtm.TransactionTypes;
import designAtm.User;
import designAtm.atmState.IdleState;

public class ATMRoom {
    Atm atm;
    User user;
    public static void main(String args[]) {

        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        atmRoom.atm.setAtmState(new IdleState());

        atmRoom.atm.printCurrentAtmState();
        atmRoom.atm.getAtmState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getAtmState() .authenticatePin(atmRoom.atm, atmRoom.user.getCard(), 5503);
        atmRoom.atm.getAtmState().selectOperation(atmRoom.atm, atmRoom.user.getCard(), TransactionTypes.CASH_WITHDRAW);
        atmRoom.atm.getAtmState().cashWithdraw(atmRoom.atm, atmRoom.user.getCard(), 2700);

        atmRoom.atm.printCurrentAtmState();

    }

    private void initialize() {

        //create ATM
        atm = Atm.getAtm();
        atm.setAtmTotalBalance (5500, 2, 2, 5);

        //create User
        this.user = createUser();
    }

    private User createUser() {
        

        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard() {

        Card card = new Card();
        card.setUserBankAcc(createBankAccount());
        return card;
    }

    private UserBankAcc createBankAccount() {

        UserBankAcc bankAccount = new UserBankAcc();
        bankAccount.balance = 3000;

        return bankAccount;

    }
}