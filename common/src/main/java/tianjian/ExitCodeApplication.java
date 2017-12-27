package tianjian;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class ExitCodeApplication {

    /**
     *
     * @return 项目停止返回码为42
     */
    @Bean
    public ExitCodeGenerator exitCodeGenerator() {
        return new ExitCodeGenerator() {
            @Override
            public int getExitCode() {
                return 42;
            }
        };
    }

    public static void main(String[] args) {
        /**
         * 启动并停止
         */
        System.exit(SpringApplication
                .exit(SpringApplication.run(ExitCodeApplication.class, args)));
    }

}
