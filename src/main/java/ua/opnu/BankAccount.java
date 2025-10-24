package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee = 0;

    // Додавання грошей
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Отримання балансу
    double getBalance() {
        return balance;
    }

    // Зняття грошей з урахуванням комісії
    boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
            return true;
        }
        return false;
    }

    // Переказ грошей іншому рахунку
    boolean transfer(BankAccount receiver, double amount) {
        if (amount > 0 && balance >= amount + transactionFee) {
            balance -= (amount + transactionFee);
            receiver.balance += amount;
            return true;
        }
        return false;
    }
}
