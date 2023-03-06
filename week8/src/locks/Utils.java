package locks;

import java.util.concurrent.TimeUnit;

public class Utils {
    static void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
