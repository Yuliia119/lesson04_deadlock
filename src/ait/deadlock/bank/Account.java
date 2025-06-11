package ait.deadlock.bank;

import java.util.Objects;

public class Account {
    private int accNumer;
    private int balance;

    public Account(int accNumer) {
        this.accNumer = accNumer;
    }

    public int getAccNumer() {
        return accNumer;
    }

    public int getBalance() {
        return balance;
    }

    public  void debit(int sum){
        balance += sum;  // пополнение счёта
    }

    public  void credit(int sum){
        balance -= sum;  // списание со счёта
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return accNumer == account.accNumer;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accNumer);
    }
}
