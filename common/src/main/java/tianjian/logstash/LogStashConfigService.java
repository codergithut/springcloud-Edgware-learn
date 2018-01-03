package tianjian.logstash;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tianjian.common.reflection.ReflectionAction;
import tianjian.common.Constant;
import tianjian.domain.logstash.LogStashInfo;

@Service
public class LogStashConfigService {

    @Autowired
    ReflectionAction reflectionAction;

    /**
     *
     * @param logStashInfo
     * @throws Exception
     * 需要根据该配置文件启动logstash服务
     */
    public void logstashConfigGet(LogStashInfo logStashInfo) throws Exception {
        reflectionAction.checkObject(logStashInfo);
        logStashInfo.saveLogStashInfoAsFile(Constant.LOGSTASH_MYSQL, "logstash.config");


    }

}
