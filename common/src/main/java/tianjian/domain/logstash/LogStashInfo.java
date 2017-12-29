package tianjian.domain.logstash;

import tianjian.common.Type;
import tianjian.common.annotation.DefaultValue;
import tianjian.common.annotation.NotNull;
import tianjian.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class LogStashInfo {

    @DefaultValue(getDefaultValue = "127.0.0.1", getType = Type.STRING)
    private String el_host;
    @DefaultValue(getDefaultValue = "9200", getType = Type.STRING)
    private String el_port;
    @DefaultValue(getDefaultValue = "logstash", getType = Type.STRING)
    private String el_index;

    @NotNull
    private String db_url;

    @NotNull
    private String db_connection_path;

    @NotNull
    private String db_username;

    @NotNull
    private String db_password;

    @NotNull
    private String db_sql;

    public String getEl_host() {
        return el_host;
    }

    public void setEl_host(String el_host) {
        this.el_host = el_host;
    }

    public String getEl_port() {
        return el_port;
    }

    public void setEl_port(String el_port) {
        this.el_port = el_port;
    }

    public String getEl_index() {
        return el_index;
    }

    public void setEl_index(String el_index) {
        this.el_index = el_index;
    }

    public String getDb_url() {
        return db_url;
    }

    public void setDb_url(String db_url) {
        this.db_url = db_url;
    }

    public String getDb_connection_path() {
        return db_connection_path;
    }

    public void setDb_connection_path(String db_connection_path) {
        this.db_connection_path = db_connection_path;
    }

    public String getDb_username() {
        return db_username;
    }

    public void setDb_username(String db_username) {
        this.db_username = db_username;
    }

    public String getDb_password() {
        return db_password;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }

    public String getDb_sql() {
        return db_sql;
    }

    public void setDb_sql(String db_sql) {
        this.db_sql = db_sql;
    }

    public boolean saveLogStashInfoAsFile(String templatePath, String file) throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource(templatePath);
        File saveFile = new File(file);
        String template_String = FileUtil.readFileToString(new File(url.getFile()));
        template_String = template_String.replace("${dburl}", db_url)
                .replace("${user}", db_username)
                .replace("${password}", db_password)
                .replace("${connection}", db_connection_path)
                .replace("${sql}", db_sql)
                .replace("${host}", el_host)
                .replace("${port}", el_port)
                .replace("${index}", el_index);
        try {
            FileUtil.writeFile(template_String, saveFile);
            System.out.println(saveFile.getAbsolutePath());
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
