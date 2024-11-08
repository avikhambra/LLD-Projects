package designAtm.atmState;

import amountWithdraw.CashWithdrawProcesser;
import amountWithdraw.FiveHundredWithdrawPro;
import amountWithdraw.HundredWithdrawPro;
import amountWithdraw.TwoThousandWithdrawPro;
import designAtm.Atm;
import designAtm.Card;

public class CashWithdraw extends AtmState{

    @Override
    public void cashWithdraw(Atm atm, Card card, int amount) {

          System.out.println("Total Balance in ATM " + atm.getAtmTotalBalance() + "/ We Collect This Amount " + amount);
          System.out.println("Total Balance In Our Card " + card.getHolderCardBalance());
          System.out.println("Total Balance In Our Card After Deduct " + (card.getHolderCardBalance() - amount));

          if(atm.getAtmTotalBalance() < amount){
              System.out.println("Insufficient Balance In This ATM.");
              exit(atm);
          }else if(card.getHolderCardBalance() < amount){
              System.out.println("Insufficient Balance In Your Card.");
              exit(atm);
          }else{

              System.out.println("ATM Machine is Started.");

              atm.deductAtmBal(amount);
              card.deductHolderCardBalance(amount);

              //Processer
               CashWithdrawProcesser cashWithdrawProcesser
                       = new TwoThousandWithdrawPro(new FiveHundredWithdrawPro(new HundredWithdrawPro( null)));

               cashWithdrawProcesser.withdraw(atm, amount);

               exit(atm);

          }

    }

    public void exit(Atm atm){
        returnCard();
        atm.setAtmState( new IdleState());
    }

    public void returnCard(){
        System.out.println("Your Card is returned Plz Collect Your Card!");
    }

}
