package tianjian.logstash.service;

import tianjian.domain.logstash.LogStashInfo;

/**
 * 停止数据传输服务
 */
public interface StopLogstashService {
    boolean stopLogStashServcie(LogStashInfo info);
}
