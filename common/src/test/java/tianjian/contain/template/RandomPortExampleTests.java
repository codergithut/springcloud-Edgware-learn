package tianjian.contain.template;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tianjian.domain.bean.Details;
import tianjian.service.MyBean;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RandomPortExampleTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    MyBean myBean;

    @Test
    public void exampleTest() {
        String body = this.restTemplate.getForObject("/xx", String.class);
        assertThat(body).isEqualTo("Hello World");
        Details details = this.restTemplate.getForObject("/test/details", Details.class);
        assertEquals(details.getName(), "test");
//        System.out.println(myBean.someRestCall("test"));
    }

}
