package amountWithdraw;

import designAtm.Atm;

public abstract class CashWithdrawProcesser {

      CashWithdrawProcesser nextCashWithdrawalProcessor;

       public CashWithdrawProcesser(CashWithdrawProcesser cashWithdrawalProcessor) {

            this.nextCashWithdrawalProcessor = cashWithdrawalProcessor;

       }

      public void withdraw(Atm atm, int remainingAmount) {

            if (nextCashWithdrawalProcessor != null) {
                  nextCashWithdrawalProcessor.withdraw(atm, remainingAmount);
            }



      }




}
