package ait.deadlock.bank;

public class Transfer implements Runnable{
    private Account accFrom;
    private Account accTo;
    private  int sum;

    public Transfer(Account accFrom, Account accTo, int sum) {
        this.accFrom = accFrom;
        this.accTo = accTo;
        this.sum = sum;
    }


    @Override
    public void run() {
        // блокируем потоки упорядоченно. Первым будет тот у кого наименьший номер.
        Account first = accFrom.getAccNumer() < accTo.getAccNumer() ? accFrom : accTo;
        Account second = accFrom.getAccNumer() < accTo.getAccNumer() ? accTo : accFrom;
        synchronized (first) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (second) {
                if (accFrom.getBalance() >= sum) {
                    accFrom.credit(sum);
                    accTo.debit(sum);
                }
            }
        }
    }
}
