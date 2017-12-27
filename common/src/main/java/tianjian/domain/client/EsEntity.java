package tianjian.domain.client;

import com.alibaba.fastjson.JSON;

/**
 * 为需要es处理的实体类进行主键标记和提供数据json格式化
 */
public abstract class EsEntity{

    public abstract String getId();

    public abstract void setId(String id);

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
