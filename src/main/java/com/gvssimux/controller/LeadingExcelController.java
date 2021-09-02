package com.gvssimux.controller;

import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        PrintWriter out = null;
        response.setCharacterEncoding("utf-8");  //防止ajax接受到的中文信息乱码
        out = response.getWriter();
        out.print("文件导入成功！");
        out.flush();
        out.close();
    }

}