package tianjian.domain.client;

import java.util.Date;

/**
 * 文章对象
 */
public class Article extends EsEntity{

    /**
     * 资源id
     */
    private String answersid;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 文章作者
     */
    private String author;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 跟新时间
     */
    private Date updatetime;

    /**
     * 文章内容
     */
    private String htmlcontent;

    /**
     * 文章url
     */
    private String url;

    /**
     * 类别ID
     */
    private String categoryid;

    /**
     * 点赞数
     */
    private int rate;

    /**
     * 描述
     */
    private String describe;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getHtmlcontent() {
        return htmlcontent;
    }

    public void setHtmlcontent(String htmlcontent) {
        this.htmlcontent = htmlcontent;
    }

    public String getAnswersid() {
        return answersid;
    }

    public void setAnswersid(String answersid) {
        this.answersid = answersid;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    @Override
    public String getId() {
        return answersid;
    }

    @Override
    public void setId(String id) {
        this.answersid = id;

    }
}