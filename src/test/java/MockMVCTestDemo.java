import com.zohn.springboot01.ZohnApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZohnApplication.class)
@AutoConfigureMockMvc// 自动装配mvc
public class MockMVCTestDemo {

    @Autowired
    MockMvc mockMvc;

    // /testJson

    /**
     * 模仿浏览器发送Get请求 测试 /testJson  接口 [API:Application Programming Interface]
     */
    @Test
    public void apiTest() {
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/testJson")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
            int status = mvcResult.getResponse().getStatus(); // 状态码
            //mvcResult.getResponse().getHeader()
            System.out.println(status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
