package tianjian.logstash.service;

import tianjian.domain.logstash.LogStashInfo;

/**
 * 启动前对服务进行检查,判断当前服务是否空闲(有可能有其他用户正在使用logstash)
 * 该实现不支持多个实例同时启动,logstash吃资源还是比较猛的
 * 也有可能需要对对资源进行清理
 */
public interface OperatorBefoeStartService {
    boolean operatorDataBeforeStartService(LogStashInfo info);
}
