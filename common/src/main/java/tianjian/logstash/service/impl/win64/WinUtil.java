package tianjian.logstash.service.impl.win64;

public class WinUtil {
    public static void WinExeUtil(String cmd) {
        try {
            String cmdStr1="C:/Users/Administrator/Downloads/nssm-2.24/win64/nssm.exe stop logstash1";
            Runtime.getRuntime().exec("cmd.exe /c start "+cmd);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
