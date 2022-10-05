/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class Main {
    public static void main(final String[] args) {

        //Deadlock example
        Account account = new Account(1000, 1000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                account.transferFrom1To2(300);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                account.transferFrom2To1(500);
            }
        }).start();
    }
}
