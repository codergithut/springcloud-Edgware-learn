package tianjian.logstash.service.impl.win64;

import java.io.IOException;

public class WinUtil {
    public static void WinExeUtil(String cmd) throws IOException {
        Runtime.getRuntime().exec("cmd.exe /c start "+cmd);
    }
}
