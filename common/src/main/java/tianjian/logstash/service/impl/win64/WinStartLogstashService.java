package tianjian.logstash.service.impl.win64;

import org.springframework.stereotype.Service;
import tianjian.domain.logstash.LogStashInfo;
import tianjian.logstash.service.StartLogstashService;

import java.io.IOException;

import static tianjian.common.Constant.PARAMS;

@Service
public class WinStartLogstashService implements StartLogstashService{

    @Override
    public boolean startLogstashServcie(LogStashInfo info) {
        String cmd = "C:/Users/Administrator/Downloads/nssm-2.24/win64/nssm.exe start logstash1";
        try {
            info.saveLogStashInfoAsFile(PARAMS.get(info.getDbType()), "D:/es/logstash/logstash-5.6.2/bin/logstash1.config");
            WinUtil.WinExeUtil(cmd);
        } catch (IOException e) {
            return false;
        }
        operatorDataBeforeStartService(info);
        return true;
    }

    @Override
    public boolean operatorDataBeforeStartService(LogStashInfo info) {
        return false;
    }
}
