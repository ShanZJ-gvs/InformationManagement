package com.gvssimux.service;


import javax.servlet.ServletOutputStream;

import com.gvssimux.pojo.Fangchan;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.gvssimux.pojo.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;


public class ExcleImpl {

    public void export(String[] titles, ServletOutputStream out) throws Exception{
        try{
            // 第一步，创建一个workbook，对应一个Excel文件
            HSSFWorkbook workbook = new HSSFWorkbook();

            // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
            HSSFSheet hssfSheet = workbook.createSheet("sheet1");

            // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short

            HSSFRow row = hssfSheet.createRow(0);
            // 第四步，创建单元格，并设置值表头 设置表头居中
            HSSFCellStyle hssfCellStyle = workbook.createCellStyle();

            //居中样式
            hssfCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

            HSSFCell hssfCell = null;
            for (int i = 0; i < titles.length; i++) {
                hssfCell = row.createCell(i);//列索引从0开始
                hssfCell.setCellValue(titles[i]);//列名1
                hssfCell.setCellStyle(hssfCellStyle);//列居中显示
            }

            //第五步，写入实体数据



/** 博客demo
 *              //第五步，写入实体数据
 *             Person  person1=new Person("1","张三","123","26");
 *             Person  person2=new Person("2","李四","123","18");
 *             Person  person3=new Person("3","王五","123","77");
 *             Person  person4=new Person("4","徐小筱","123","1");
 *
 *
 *             //这里我把list当做数据库啦
 *             ArrayList<Person> list=new ArrayList<Person>();
 *             list.add(person1);
 *             list.add(person2);
 *             list.add(person3);
 *             list.add(person4);
 *
            for (int i = 0; i < list.size(); i++) {
                row = hssfSheet.createRow(i+1);
                Fangchan fangchan = list.get(i);

                // 第六步，创建单元格，并设置值
                String  id = null;
                if(fangchan.getId() != null){
                    id = fangchan.getId();
                }
                row.createCell(0).setCellValue(id);
                String name = "";
                if(fangchan.getName() != null){
                    name = fangchan.getName();
                }
                row.createCell(1).setCellValue(name);
                String password = "";
                if(fangchan.getPassword() != null){
                    password = fangchan.getPassword();
                }
                row.createCell(2).setCellValue(password);
                String age=null;
                if(fangchan.getAge() !=null){
                    age = fangchan.getAge();
                }
                row.createCell(3).setCellValue(age);
            }
 **/

/**
//自己的demo 可以运行
        // 第五步，写入实体数据
            Fangchan  f1 = new Fangchan("fid111", "uid111", "天安门", "北京", 12000.2, 10000.0, 213213.0);
            Fangchan  f2 = new Fangchan("fid111", "uid111", "天安门", "北京", 12000.2, 10000.0, 213213.0);

            ArrayList<Fangchan> list=new ArrayList<Fangchan>();
            list.add(f1);
            list.add(f2);
            for (int i = 0; i < list.size(); i++) {
                row = hssfSheet.createRow(i+1);
                Fangchan fangchan = list.get(i);

                // 第六步，创建单元格，并设置值
                String  fid = "";
                if(fangchan.getFid() != null){
                    fid = fangchan.getFid();
                }
                row.createCell(0).setCellValue(fid);
                String uid = "";
                if(fangchan.getUid() != null){
                    uid = fangchan.getUid();
                }
                row.createCell(1).setCellValue(uid);
                String fname = "";
                if(fangchan.getFname() != null){
                    fname = fangchan.getFname();
                }
                row.createCell(2).setCellValue(fname);
                String faddress=null;
                if(fangchan.getFaddress() !=null){
                    faddress = fangchan.getFaddress();
                }
                row.createCell(3).setCellValue(faddress);
                int ispay = 0;
                if(fangchan.getIspay() !=null){
                    ispay = fangchan.getIspay();
                }
                row.createCell(4).setCellValue(ispay);
                int isloans = 0;
                if(fangchan.getIsloans() !=null){
                    isloans = fangchan.getIsloans();
                }
                row.createCell(5).setCellValue(isloans);
                Double fcost = Double.valueOf(0);
                if(fangchan.getFcost() !=null){
                    fcost = fangchan.getFcost();
                }
                row.createCell(6).setCellValue(fcost);
                Double farea1 = Double.valueOf(0);
                if(fangchan.getFarea1() !=null){
                    farea1 = fangchan.getFarea1();
                }
                row.createCell(7).setCellValue(farea1);
                Double farea2 = Double.valueOf(0);
                if(fangchan.getFarea2() !=null){
                    farea2 = fangchan.getFarea2();
                }
                row.createCell(8).setCellValue(farea2);
            }
*/

/**从数据库获取
 * */
            //第五步，写入实体数据
            ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
            FangchanServiceImpl mapper = context.getBean("FangchanServiceImpl", FangchanServiceImpl.class);

            final List<Fangchan> list = mapper.selectAllF();

            for (int i = 0; i < list.size(); i++) {
                row = hssfSheet.createRow(i + 1);
                Fangchan fangchan = list.get(i);

                // 第六步，创建单元格，并设置值
                String fid = "";
                if (fangchan.getFid() != null) {
                    fid = fangchan.getFid();
                }
                row.createCell(0).setCellValue(fid);
                String uid = "";
                if (fangchan.getUid() != null) {
                    uid = fangchan.getUid();
                }
                row.createCell(1).setCellValue(uid);
                String fname = "";
                if (fangchan.getFname() != null) {
                    fname = fangchan.getFname();
                }
                row.createCell(2).setCellValue(fname);
                String faddress = null;
                if (fangchan.getFaddress() != null) {
                    faddress = fangchan.getFaddress();
                }
                row.createCell(3).setCellValue(faddress);
                int ispay = 0;
                if (fangchan.getIspay() != null) {
                    ispay = fangchan.getIspay();
                }
                row.createCell(4).setCellValue(ispay);
                int isloans = 0;
                if (fangchan.getIsloans() != null) {
                    isloans = fangchan.getIsloans();
                }
                row.createCell(5).setCellValue(isloans);
                Double fcost = Double.valueOf(0);
                if (fangchan.getFcost() != null) {
                    fcost = fangchan.getFcost();
                }
                row.createCell(6).setCellValue(fcost);
                Double farea1 = Double.valueOf(0);
                if (fangchan.getFarea1() != null) {
                    farea1 = fangchan.getFarea1();
                }
                row.createCell(7).setCellValue(farea1);
                Double farea2 = Double.valueOf(0);
                if (fangchan.getFarea2() != null) {
                    farea2 = fangchan.getFarea2();
                }
                row.createCell(8).setCellValue(farea2);

            }


            // 第七步，将文件输出到客户端浏览器
            try {
                workbook.write(out);
                out.flush();
                out.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception("导出信息失败！");

        }
    }
}