package tr.org.open.seruvent.citybugs.util;

import java.util.UUID;

public class SeruventUtils {


    public static String generateRandomString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

}
