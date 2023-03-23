package lab01.example.model;

public class SimpleBankAccountWithAtm extends SimpleBankAccount {

    private final double ATM_FEE = 1;

    public SimpleBankAccountWithAtm(AccountHolder holder, double balance) {
        super(holder, balance);
    }

    @Override
    public void deposit(final int userID, final double amount) {
        if (checkUser(userID)) {
            this.balance += amount - ATM_FEE;
        }
    }

    @Override
    public void withdraw(final int userID, final double amount) {
        if (checkUser(userID) && isWithdrawAllowed(amount)) {
            this.balance -= amount + ATM_FEE;
        }
    }

    private boolean isWithdrawAllowed(final double amount){
        return this.balance >= (amount + ATM_FEE);
    }

}
