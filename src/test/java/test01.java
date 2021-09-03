
import com.gvssimux.service.FangchanServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class test01 {

    //根据uname和uuid查询User
    @Test
    public void tt(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);


        System.out.println(mapper.selectAllUser("单子健","3402000"));
        System.out.println(1111);
        System.out.println("根据uname查询User");
    }



    //根据fid查询房产信息
    @Test
    public void tt1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FangchanServiceImpl mapper = context.getBean("FangchanServiceImpl", FangchanServiceImpl.class);

        System.out.println(mapper.selectAllFanchan("fid111"));
        System.out.println("根据fid查询房产信息");
    }


    //根据房屋地址名模糊查询房产
    @Test
    public void tt2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FangchanServiceImpl mapper = context.getBean("FangchanServiceImpl", FangchanServiceImpl.class);

        System.out.println(mapper.getLikeFanchanByAddress("安徽"));
        System.out.println("根据房屋地址名模糊查询房产");
    }



    //通过产权人查房产
    @Test
    public void tt3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl mapper = context.getBean("UserServiceImpl", UserServiceImpl.class);

        System.out.println(mapper.getFByUname("单子健"));
        System.out.println("通过产权人查房产");
    }


    //单个查询
    @Test
    public void tt4(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FangchanServiceImpl mapper = context.getBean("FangchanServiceImpl", FangchanServiceImpl.class);

        System.out.println(mapper.getFByFid("fid111"));
        System.out.println("单个查询");
    }






}
