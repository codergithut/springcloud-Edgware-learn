package tianjian.config;

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
}
