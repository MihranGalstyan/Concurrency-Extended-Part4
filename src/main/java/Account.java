/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class Account {
    private final Object monitor1 = new Object();
    private final Object monitor2 = new Object();

    private int amount1;
    private int amount2;

    public Account(final int amount1, final int amount2) {
        this.amount1 = amount1;
        this.amount2 = amount2;
    }

    public void transferFrom1To2(final int amount) {
        if (amount <= amount1) {
            System.out.println("amount <= amount1");
            synchronized (monitor1) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (monitor2) {
                    amount1 -= amount;
                    amount2 += amount;
                }
            }
        } else {
            System.out.println("Inefficient fund");
        }
    }

    public void transferFrom2To1(final int amount) {
        if (amount <= amount2) {
            System.out.println("amount <= amount1");
            synchronized (monitor2) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (monitor1) {
                    amount2 -= amount;
                    amount1 += amount;
                }
            }
        } else {
            System.out.println("Inefficient fund");
        }
    }
}
