package tianjian.logstash;

import org.junit.Test;
import tianjian.domain.logstash.LogStashInfo;

import java.io.IOException;

import static tianjian.config.common.Constant.LOGSTASH_MYSQL;

public class TestLogstashConfigFile {

    @Test
    public void testLogstashFile() throws IOException {
        LogStashInfo logStashInfo = new LogStashInfo();
        logStashInfo.setEl_host("127.0.0.1");
        logStashInfo.setEl_port("9200");
        logStashInfo.setEl_index("test");
        logStashInfo.setDb_sql("SELECT * from ZHJG_JSYDBP_PC");
        logStashInfo.setDb_username("tianjain");
        logStashInfo.setDb_password("tianjian");
        logStashInfo.setDb_url("jdbc:oracle:thin:@//172.24.18.134:1521/orcl");
        logStashInfo.setDb_connection_path("D:/es/logstash-6.1.0/bin/ojdbc6-11.2.0.4.jar");

        logStashInfo.saveLogStashInfoAsFile(LOGSTASH_MYSQL, "mysql.config");

    }
}
