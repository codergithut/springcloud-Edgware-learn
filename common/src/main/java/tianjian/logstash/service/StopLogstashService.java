package tianjian.logstash.service;

import tianjian.domain.logstash.LogStashInfo;

import java.io.IOException;

/**
 * 停止数据传输服务
 */
public interface StopLogstashService {
    /**
     * @param info
     * @return 停止服务true 成功, false 失败
     */
    boolean stopLogStashServcie(LogStashInfo info) throws IOException;

    /**
     *
     * @param info
     * @return 清除资源 true 成功, false 失败
     */
    boolean clearDataAfterStopService(LogStashInfo info);

    /**
     *
     * @param logStashInfo
     * @return true 传输完成, false 正在传输
     */
    boolean judgeServiceIsEnd(LogStashInfo logStashInfo) throws InterruptedException, IOException;
}
