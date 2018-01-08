package tianjian.logstash;

import org.junit.Ignore;
import org.junit.Test;
import tianjian.domain.logstash.LogStashInfo;
import tianjian.logstash.service.impl.SearchGetInsertDataNumberImpl;

import java.io.IOException;

import static tianjian.common.Constant.LOGSTASH_MYSQL;

public class TestLogstashConfigFile {

    @Test
    @Ignore
    public void testLogstashFile() throws IOException {
        LogStashInfo logStashInfo = new LogStashInfo();
        logStashInfo.setEl_host("127.0.0.1");
        logStashInfo.setEl_port("9200");
        logStashInfo.setEl_index("test");
        logStashInfo.setDb_sql("SELECT * from test");
        logStashInfo.setDb_username("root");
        logStashInfo.setDb_password("root");
        logStashInfo.setDb_url("jdbc:mysql://localhost/mysql?serverTimezone=UTC");
        logStashInfo.setDb_connection_path("E:/Workbench/Maven/Repository/mysql/mysql-connector-java/5.1.41/mysql-connector-java-5.1.41.jar");

        logStashInfo.saveLogStashInfoAsFile(LOGSTASH_MYSQL, "D:\\es\\logstash\\logstash-5.6.2\\bin\\logstash1.config");

    }

    @Test
    public void getInsertDataNumberTest() throws IOException {
        LogStashInfo logStashInfo = new LogStashInfo();
        logStashInfo.setEl_host("127.0.0.1");
        logStashInfo.setEl_port("9200");
        logStashInfo.setEl_index("test");
        logStashInfo.setDb_sql("SELECT * from test");
        logStashInfo.setDb_username("root");
        logStashInfo.setDb_password("root");
        SearchGetInsertDataNumberImpl searchGetInsertDataNumber = new SearchGetInsertDataNumberImpl();
        searchGetInsertDataNumber.getInsertDataNumber(logStashInfo);
    }

}
