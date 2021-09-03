import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.Fangchan;
import com.gvssimux.service.FangchanServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class test02 {
    @Test
    public void t1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);



        System.out.println(mapper.selectAllUser("单子健","3402000"));
        System.out.println(1111);
        System.out.println("根据uname查询User");
    }
}
