package designAtm;

public class Card {
    private String holderName;
    private String holderCardNo;
    private String cardExpDate;
    private int cvv;
    public static int PIN = 5503;
    private UserBankAcc userBankAcc;
    public void setUserBankAcc(UserBankAcc userBankAcc){
        this.userBankAcc = userBankAcc;
    }
    public int getHolderCardBalance(){
        return userBankAcc.balance;
    }
    public void deductHolderCardBalance(int amount){
         userBankAcc.WithdrawBalance(amount);
    }
    public boolean getValidatePIN(int pinNo){
        return PIN == pinNo;
    }



}
