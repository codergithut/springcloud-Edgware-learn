package tianjian.contain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import tianjian.cofig.HelloConfig;

@RunWith(SpringRunner.class)
@SpringBootTest
@Import(HelloConfig.class)
public class MyTests {

    @Autowired
    HelloConfig.TestConfig  testConfig;

    @Test
    public void exampleTest() {
        System.out.println(testConfig.getAge());
    }

}
