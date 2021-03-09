package leetcode.mockInterview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class FooBar {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(1);

    }
    private int n;
    // private Object lock;
    private ReentrantLock reLock;
    private Condition fooCon;
    private Condition barCon;

    public FooBar(int n) {
        this.n = n;
        // lock = new Object();
        reLock = new ReentrantLock();
        fooCon = reLock.newCondition();
        barCon = reLock.newCondition();
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            reLock.lock();
            try{
                barCon.signal();
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooCon.await();
            }finally{
                reLock.unlock();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            reLock.lock();
            try{
                fooCon.signal();
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                barCon.await();
            }finally{
                reLock.unlock();
            }
        }
    }

}
