package tianjian.domain.client;

public class Index extends EsEntity{

    /**
     * 目录id
     */
    private String id;

    /**
     * 是不是根目录(最上层目录)
     */
    private String isroot;

    /**
     * 资源分类id(和文章的分类id关联)
     */
    private String categoryid;

    /**
     * 资源描述
     */
    private String description;

    /**
     * 父资源ID(每个资源有一个或0个父目录)
     */
    private String parentid;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getIsroot() {
        return isroot;
    }

    public void setIsroot(String isroot) {
        this.isroot = isroot;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
