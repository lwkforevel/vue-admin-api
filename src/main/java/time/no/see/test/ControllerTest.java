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
	
	
	
	@Before()  //���������ÿ������ִ��֮ǰ����ִ��һ��
	    public void setup() {
	        //mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //��ʼ��MockMvc����
	        mockMvc = MockMvcBuilders.standaloneSetup(null).build();//���ַ�ʽ�����Գ�ʼ��mockMvc���Ƽ������֣�����Ļ��Զ���ת��ַstatus�жϷ�����Ч
	    }
	
	
}
