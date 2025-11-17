interface BankingService {
    void deposit(double a);
    void withdraw(double a);
}

class Account implements BankingService {
    double balance = 0;
    public void deposit(double a) {
        if(a <= 0) System.out.println("Invalid");
        else {
            balance += a;
            System.out.println("Balance = " + balance);
        }
    }
    public void withdraw(double a) {
        if(a > balance) System.out.println("Insufficient funds");
        else {
            balance -= a;
            System.out.println("Balance = " + balance);
        }
    }
}

class Transaction {
    void log(String msg) {
        System.out.println("Transaction recorded: " + msg);
    }
}

public class Bank {
    public static void main(String[] args) {
        Account a = new Account();
        Transaction t = new Transaction();
        a.deposit(1000);
        a.withdraw(500);
        a.withdraw(1500);
        a.deposit(-100);
        t.log("Sample");
    }
}
