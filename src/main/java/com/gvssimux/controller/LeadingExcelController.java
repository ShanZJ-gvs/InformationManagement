package com.gvssimux.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gvssimux.pojo.Fangchan;
import com.gvssimux.service.FangchanServiceImpl;
import com.gvssimux.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.gvssimux.pojo.Family;
import com.gvssimux.service.ImportExcelUtil;

@Controller
public class LeadingExcelController {

    @RequestMapping("/upform")
    public String form(HttpServletRequest request)throws Exception{
        System.out.println("执行==》LeadingExcelController.java ==>upform");
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        InputStream in =null;
        List<List<Object>> listob = null;
        MultipartFile file = multipartRequest.getFile("upfile");

        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }
        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());
        in.close();

        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            Family family = new Family();
            family.setJtbh(String.valueOf(lo.get(0)));
            family.setXm(String.valueOf(lo.get(1)));
            family.setHy(String.valueOf(lo.get(2)));
            family.setBz(String.valueOf(lo.get(3)));

            System.out.println("打印信息-->"+family.toString());
        }


        return null;
    }

    @RequestMapping(value="/upajax")
    public  void  ajaxUploadExcel(HttpServletRequest request,HttpServletResponse response) throws Exception {
        System.out.println("执行==》LeadingExcelController.java ==>upajax");

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        System.out.println("执行==》LeadingExcelController.java ==>upajax");

        InputStream in =null;
        List<List<Object>> listob = null;
        System.out.println("执行==》LeadingExcelController.java ==>upajax");
        MultipartFile file = multipartRequest.getFile("upfile");
        if(file.isEmpty()){
            throw new Exception("文件不存在！");
        }

        System.out.println("执行==》LeadingExcelController.java ==>upajax");

        in = file.getInputStream();
        listob = new ImportExcelUtil().getBankListByExcel(in,file.getOriginalFilename());

        System.out.println("执行==》LeadingExcelController.java ==>upajax");


/**         //博客demo
         //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        for (int i = 0; i < listob.size(); i++) {
            List<Object> lo = listob.get(i);
            Family family = new Family();
            family.setJtbh(String.valueOf(lo.get(0)));
            family.setXm(String.valueOf(lo.get(1)));
            family.setHy(String.valueOf(lo.get(2)));
            family.setBz(String.valueOf(lo.get(3)));

            System.out.println("打印信息-->"+family.toString());
            System.out.println("listob.size()==>"+listob.size());
        }*/


      //自己写的demo
        //创建数据库工厂
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        FangchanServiceImpl mapper = context.getBean("FangchanServiceImpl", FangchanServiceImpl.class);
        //该处可调用service相应方法进行数据保存到数据库中，现只对数据输出
        System.out.println("打印信息-->"+111);
        for (int i = 0; i < listob.size(); i++) {
            System.out.println("打印信息-->"+222);
            List<Object> lo = listob.get(i);
            System.out.println("打印信息-->"+333);
            Fangchan fangchan = new Fangchan();
            System.out.println("打印信息-->"+444);
            /*前三列不加判空的原因是：在获取数据流是，前三列就不能为空，
            * 不知道为什么，可能是我copy的代码中，在获取数据流时，就设置了前三列不可为空
            * */
            //if (!lo.get(0).equals(null)&& lo.get(0)!=null&&lo.get(0)!="") {
                fangchan.setFid(String.valueOf(lo.get(0)));
            //}
            System.out.println("打印信息-->"+555);
            //if (!lo.get(1).equals(null)&& lo.get(1)!=null&&lo.get(1)!="") {
                fangchan.setUid(String.valueOf(lo.get(1)));
            //}
            System.out.println("打印信息-->"+666);
            //if (!lo.get(2).equals(null)&& lo.get(2)!=null&&lo.get(2)!="") {
                System.out.println(111);
                fangchan.setFname(String.valueOf(lo.get(2)));
            //}
            System.out.println("打印信息-->"+777);
            if (!lo.get(3).equals(null)&& lo.get(3)!=null&&lo.get(3)!="") {
                fangchan.setFaddress(String.valueOf(lo.get(3)));
            }
            System.out.println("打印信息-->"+888);
            if (!lo.get(4).equals(null)&& lo.get(4)!=null&&lo.get(4)!="") {
                fangchan.setIspay(Integer.parseInt((String) lo.get(4)));
            }
            System.out.println("打印信息-->"+999);
            if (!lo.get(5).equals(null)&& lo.get(5)!=null&&lo.get(5)!="") {
                fangchan.setIsloans(Integer.parseInt((String) lo.get(5)));
            }
            System.out.println("打印信息-->"+1010);
            if (!lo.get(6).equals(null)&& lo.get(6)!=null&&lo.get(6)!=""){
                fangchan.setFcost(Double.parseDouble((String) lo.get(6)));
            }
            System.out.println("打印信息-->"+1111);
            if (!lo.get(7).equals(null)&& lo.get(7)!=null&&lo.get(7)!=""){
                fangchan.setFarea1(Double.parseDouble((String) lo.get(7)));
            }

            System.out.println("打印信息-->"+2222);
            if (!lo.get(8).equals(null)&& lo.get(8)!=null&&lo.get(8)!=""){
                fangchan.setFarea2(Double.parseDouble((String) lo.get(8)));
            }


            //将数据插入数据库
            mapper.insertSelective(fangchan);
            System.out.println("打印信息-->i="+i+" "+fangchan.toString());
            System.out.println("listob.size()==>"+listob.size());

        }


        System.out.println("打印信息-->"+1111000000);

        PrintWriter out = null;
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
        out = response.getWriter();
        out.print("文件导入成功！");
        out.flush();
        out.close();
    }

}