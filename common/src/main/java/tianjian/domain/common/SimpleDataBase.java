package tianjian.domain.common;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/12/20.
 * @Validated 注解只有自动注入配置文件才会起作用
 */
@Validated
public class SimpleDataBase {
    private String url;

    @NotNull
    private String needValue;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNeedValue() {
        return needValue;
    }

    public void setNeedValue(String needValue) {
        this.needValue = needValue;
    }
}
