
abstract class Account {

    public double totalBalance;

    void showBalance() {
        System.out.println("Your Balance: " + totalBalance);
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);
}

class CurrentAccount extends Account {

    public double yearlyCharge = 0.1;
    public double loanRate = 0.7;

    @Override
    void deposit(double amount) {
        super.totalBalance += amount;
    }

    @Override
    void withdraw(double amount) {
        double rB = super.totalBalance - amount;
        if (rB >= (0.05 * super.totalBalance)) {
            super.totalBalance -= amount;
            System.out.println("Withdraw Success");
        } else {
            System.out.println("Withdraw Failed, Insufficient Balance");
        }
    }
}

public class Bank {

    public static void main(String[] args) {
        Account acc = new CurrentAccount();
        acc.deposit(50);
        acc.showBalance();
        acc.withdraw(47.5);
        acc.showBalance();
    }
}
