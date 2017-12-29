package tianjian.util;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileUtil {
    /**
     * @Description: Guava文件读取
     *
     * @param file
     * @return
     *
     * @Title: FileGuava.java
     * @Copyright: Copyright (c) 2014
     *
     * @author Comsys-LZP
     * @date 2014-6-26 下午01:20:50
     * @version V2.0
     */
    private static List<String> readFile(File file) throws Exception {
        if (!file.exists()) {
            return null;
        }
        return Files.readLines(file, Charsets.UTF_8);
    }

    /**
     * @Description: 从文件中获取有规则的数据
     *
     * @param file
     * @return
     *
     * @Title: FileGuava.java
     * @Copyright: Copyright (c) 2014
     *
     * @author Comsys-LZP
     * @date 2014-6-26 下午01:56:42
     * @version V2.0
     */
    public List<String[]> readFileData(File file) throws Exception {
        List<String[]> list = new ArrayList<String[]>();
        for (String rLine : readFile(file)) {
            list.add(rLine.split("\\s+"));
        }
        return list;
    }

    /**
     * @Description: Guava写文件
     *
     * @param content
     * @param file
     *
     * @Title: FileGuava.java
     * @Copyright: Copyright (c) 2014
     *
     * @author Comsys-LZP
     * @date 2014-6-26 下午01:32:06
     * @version V2.0
     */
    public static void writeFile(String content, File file) throws Exception {
        if (!file.exists()) {
            file.createNewFile();
        }
        Files.write(content, file, Charsets.UTF_8);
    }

    public static String readFileToString(File file) throws IOException {
        return Files.toString(file, Charsets.UTF_8);
    }
}
