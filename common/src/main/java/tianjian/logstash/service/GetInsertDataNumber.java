package tianjian.logstash.service;

import tianjian.domain.logstash.LogStashInfo;

import java.io.IOException;

/**
 * 获取已插入数据的数目
 */
public interface GetInsertDataNumber {
    long getInsertDataNumber(LogStashInfo info) throws IOException;
}
