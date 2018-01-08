package tianjian.domain.elas.search;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class Fuzziness implements SearchUtil{
    private List<String> fields;
    private String query;
    private String fuzziness = "AUTO";

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public String getQuery() {
        return query;
    }

    public String getFuzziness() {
        return fuzziness;
    }

    public void setFuzziness(String fuzziness) {
        this.fuzziness = fuzziness;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
