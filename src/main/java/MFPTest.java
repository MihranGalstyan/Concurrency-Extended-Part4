import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Mihran Galstyan
 * All rights reserved
 */
public class MFPTest {
    public static void main(final String[] args) {
        MFP mfp = new MFP();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mfp.print(5);
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mfp.scan(5);
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mfp.print(3);
            }
        });
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                mfp.scan(5);
            }
        });
        executorService.shutdown();

    }
}
