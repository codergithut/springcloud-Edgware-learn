package tianjian.domain.elas.search;

/**
 * Created by Administrator on 2017/12/13.
 * 常用統計謂詞
 */
public enum SortEnum {

    ASC("asc"), DESC("desc");

    private String name;

    SortEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
