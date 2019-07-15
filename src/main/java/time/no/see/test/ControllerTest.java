package time.no.see.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:springmvc.xml,classpath:spring-beans.xml" })
@WebAppConfiguration
public class ControllerTest {
	
	private  MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext applicationContext;
	
	
	
	@Before()  //这个方法在每个方法执行之前都会执行一遍
	    public void setup() {
	        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
	        mockMvc = MockMvcBuilders.standaloneSetup(null).build();//两种方式都可以初始化mockMvc，推荐用这种，上面的会自动跳转地址status判断方法无效
	    }
	
	
}
