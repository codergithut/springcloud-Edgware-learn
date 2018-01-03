package tianjian.logstash.service;

import tianjian.domain.logstash.LogStashInfo;

/**
 * 获取需要插入的数据条数
 */
public interface GetTotalDataNumber {
    long getTotalDataNumber(LogStashInfo info);
}
