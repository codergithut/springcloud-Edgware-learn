package tianjian.logstash.service;

import tianjian.domain.logstash.LogStashInfo;

/**
 * 当服务关闭清除资源,默认空实现
 */
public interface ClearDataBeforeAfterStopService {
    boolean clearDataBeforeAfterStopService(LogStashInfo info);
}
