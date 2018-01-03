package tianjian.plugins;

import com.alibaba.fastjson.JSON;

import javax.sql.DataSource;
import java.util.List;

public abstract class SqlStreamPlugins implements InputStreamPlugin, OutputStreamPlugin {

    @Override
    public List<JSON> getResourceDatas() {
        return null;
    }

    @Override
    public boolean insertIntoTargerServer() {
        return false;
    }

    public abstract DataSource getDataSource();


}