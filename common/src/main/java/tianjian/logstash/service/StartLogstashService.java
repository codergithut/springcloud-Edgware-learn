package tianjian.logstash.service;

import tianjian.domain.logstash.LogStashInfo;

/**
 * 启动logstash服务进行数据传输
 */
public interface StartLogstashService {
    boolean startLogstashServcie(LogStashInfo info);
}
