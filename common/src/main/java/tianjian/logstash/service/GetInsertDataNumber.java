package tianjian.logstash.service;

import tianjian.domain.logstash.LogStashInfo;

/**
 * 获取已插入数据的数目
 */
public interface GetInsertDataNumber {
    long getInsertDataNumber(LogStashInfo info);
}
