package ait.volatiles.task;

public class InfiniteLoop implements Runnable {
    private volatile boolean flag = true;     // volatile - управление простыми флагами
    // private AtomicBoolean flag = new AtomicBoolean (true); //  atomic - для сложных операций в многопоточной среде

    public boolean isFlag() {
        return flag;

    }

    public void setFlag(boolean flag) {
        this.flag = flag;
        // this.flag.set(flag);
    }

    @Override
    public void run() {
        while (isFlag()) {
        }
        System.out.println(Thread.currentThread().getName() + " finished");
    }
}
