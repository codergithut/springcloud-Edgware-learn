package tianjian.domain.client;

import java.util.Date;

/**
 * 评论对象
 */
public class Comment extends EsEntity {

    /**
     * 用户id
     */
    private String userid;

    /**
     * 回复的资源id
     */
    private String replyid;

    /**
     * 评论类型,对资源进行评论,对评论进行评论
     */
    private String type;

    /**
     * 评论资源id
     */
    private String commentid;

    /**
     * 评论内容
     */
    private String commentcontent;

    /**
     * 评论创建时间
     */
    private Date createtime;

    /**
     * 评论跟新时间
     */
    private Date updatetime;


    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid;
    }

    public String getReplyid() {
        return replyid;
    }

    public void setReplyid(String replyid) {
        this.replyid = replyid;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getId() {
        return commentid;
    }

    @Override
    public void setId(String id) {
        this.commentid = id;
    }
}
