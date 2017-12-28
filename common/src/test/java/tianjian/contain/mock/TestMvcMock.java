package tianjian.contain.mock;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import tianjian.bean.VehicleDetails;
import tianjian.service.UserVehicleService;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UserVehicleService.class)
public class TestMvcMock {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserVehicleService userVehicleService;

    @Autowired
    private WebClient webClient;

    @Test
    public void testExample() throws Exception {
        given(this.userVehicleService.getVehicleDetails())
                .willReturn(new VehicleDetails("Honda", "Civic"));
        this.mvc.perform(get("/sboot/vehicle").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string("{\"make\":\"Honda\",\"model\":\"Civic\"}"));
    }


    @Test
    @Ignore
    public void testExample1() throws Exception {
        given(this.userVehicleService.getVehicleDetails("sboot"))
                .willReturn(new VehicleDetails("Honda", "Civic"));
        this.mvc.perform(get("/sboot/vehicle").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string("{\"make\":\"Honda\",\"model\":\"Civic\"}"));
    }

    /**
     * @throws Exception
     * 需要配合页面进行测试已放弃
     */
    @Test
    @Ignore
    public void testExample2() throws Exception {
        given(this.userVehicleService.getVehicleDetails())
                .willReturn(new VehicleDetails("Honda", "Civic"));
        HtmlPage page = this.webClient.getPage("/sboot/vehicle.ftl");
        assertThat(page.getBody().getTextContent()).isEqualTo("Honda Civic");
    }
}
