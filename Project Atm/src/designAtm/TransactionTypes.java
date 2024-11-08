package designAtm;

public enum TransactionTypes {
    CASH_WITHDRAW,BALANCE_CHECK;

    public static void showAllTransactionTypes(){

        int i = 1;
        for(TransactionTypes transactionType : TransactionTypes.values()){
            System.out.println("Transaction Type " + (i++)  + "-> " + transactionType);
        }

    }

}
