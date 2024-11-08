package designAtm;

public class UserBankAcc {
    public int balance;
    public void WithdrawBalance(int amount){
        this.balance -= amount;
    }

}
