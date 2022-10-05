/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class MFP {
    private static final Object PRINTER_MONITOR = new Object();
    private static final Object SCANNER_MONITOR = new Object();
    private static final Object BUSY = new Object();

    public void print(int pages) {
        synchronized (PRINTER_MONITOR) {
            synchronized (BUSY) {
                try {
                    for (int i = 1; i <= pages; i++) {
                        System.out.println("Printed " + i + " pages");
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void scan(int pages) {
        synchronized (SCANNER_MONITOR) {
            synchronized (BUSY) {
                try {
                    for (int i = 0; i <= pages; i++) {
                        System.out.println("Scanned " + i + " pages");
                        Thread.sleep(2000);
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
