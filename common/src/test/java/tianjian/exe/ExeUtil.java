package tianjian.exe;

import java.util.Date;

public class ExeUtil {

    public void run() {
        System.out.println("call at " + (new Date()));
        try {
            String cmdStr1="C:/Users/Administrator/Downloads/nssm-2.24/win64/nssm.exe stop logstash1";
            Runtime.getRuntime().exec("cmd.exe /c start "+cmdStr1);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExeUtil exeUtil = new ExeUtil();
        exeUtil.run();
    }

}
