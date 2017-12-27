package tianjian.domain.common;

import java.util.ArrayList;
import java.util.List;

public class FooProperties {
    private final List<MyPojo> list = new ArrayList<>();

    public List<MyPojo> getList() {
        return this.list;
    }
}
