package tianjian.logstash.service.impl.win64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tianjian.domain.logstash.LogStashInfo;
import tianjian.logstash.service.GetInsertDataNumber;
import tianjian.logstash.service.StopLogstashService;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class WinStopLogstashService implements StopLogstashService{

    @Autowired
    GetInsertDataNumber getInsertDataNumber;

    public boolean judgeServiceIsEnd(LogStashInfo logStashInfo) throws IOException {

        /**
         * 如果有5次连续获得的插入数据都没有变认为程序已经将数据完全导入可以正常关闭程序了
         * 检查时间是每隔3秒钟检查一次,也就是说最快也要15s钟服务才会停止
         */
        long initNumber = 0 ;
        int count = 0;
        while(count < 5) {
            long insertNumber = getInsertDataNumber.getInsertDataNumber(logStashInfo);
            if(insertNumber == initNumber) {
                count ++;
            } else {
                count = 0;
                initNumber = insertNumber;
            }
            try {
                Thread.sleep(3000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return true;
    }


    /**
     *
     * @param info
     * @return 停止服务 1 先检查服务是否满足停止条件 2 停止服务 3 清理资源
     */
    @Override
    public boolean stopLogStashServcie(LogStashInfo info) throws IOException {
        /**
         * 1 判断服务是否结束
         */
        judgeServiceIsEnd(info);

        /**
         * 2 停止传输服务
         */
        String cmd = "C:/Users/Administrator/Downloads/nssm-2.24/win64/nssm.exe stop logstash1";
        try {
            WinUtil.WinExeUtil(cmd);
        } catch (IOException e) {
            return false;
        }

        /**
         * 3 清理资源
         */
        clearDataAfterStopService(info);
        return true;
    }

    @Override
    public boolean clearDataAfterStopService(LogStashInfo info) {
        return true;
    }
}
