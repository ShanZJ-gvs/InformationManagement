import com.fasterxml.jackson.core.JsonProcessingException;
import com.gvssimux.pojo.Fangchan;
import com.gvssimux.pojo.User;
import com.gvssimux.service.FangchanServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import com.gvssimux.util.JsonUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public class test02 {

    //插入测试
    @Test
    public void t1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);


        String uid = String.valueOf(UUID.randomUUID());
        User user = new User(uid);

        mapper.insertSelective(user);


        System.out.println(1111);
        System.out.println("根据uname查询User");
    }
}
