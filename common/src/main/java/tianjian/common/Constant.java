package tianjian.common;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    /**
     * 查询DSL语言
     */
    public static final String SEARCH_DSL = "${index}/_search?q=${fileName}:${fileValue}&size=${size}&from=${from}&sort=${sortName}:${type}";

    /**
     * 文章的索引
     */
    public static final String INDEX_ARTICLE = "article/freezone";

    /**
     * 评论的索引
     */
    public static final String INDEX_COMMENT = "comment/abusivearea";

    /**
     * 目录的索引
     */
    public static final String INDEX_MY = "myindex/mulu";

    public static final String LOGSTASH_MYSQL = "logstash/template/mysql_template.config";

    public static final String LOGSTASH_ORACLE = "logstash/template/oracle_template.config";

    public static Map<String,String> PARAMS = new HashMap<String,String>();

    static {
        PARAMS.put("mysql", LOGSTASH_MYSQL);
        PARAMS.put("oracle", LOGSTASH_ORACLE);
    }


}
