package com.gvssimux.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageJumpController {

    /**
     * 跳转页面
     */
    @RequestMapping("/to1")
    public String toExportexcel(Model model)throws JsonProcessingException{

        return "exportexcel";
    }



    /**
     * 跳转页面
     */
    @RequestMapping("/to2")
    public String toLeadingexcel(Model model)throws JsonProcessingException{

        return "leadingexcel";
    }


    /**
     * 跳转页面form-wizards.html
     */
    @RequestMapping("/toformwizards")
    public String toformWizards(Model model)throws JsonProcessingException{

        return "form-wizards";
    }

    /**
     * 跳转页面form-wizard.html
     */
    @RequestMapping("/toformwizard")
    public String toformWizard(Model model)throws JsonProcessingException{

        return "form-wizard";
    }



    /**
     * 跳转到home页面
     */
    @RequestMapping("/tohome")
    public String tohome()throws JsonProcessingException{

        return "home";
    }

    /**
     * 跳转到datas.html
     */
    @RequestMapping("/todatas")
    public String toDatas()throws JsonProcessingException{

        return "datas";
    }


    /**
     * 跳转页面auth-login.html
     */
    @RequestMapping("/toauthlogin")
    public String toAuthLogin()throws JsonProcessingException{

        return "auth-login";
    }

    /**
     * 跳转页面search
     */
    @RequestMapping("/tosearch")
    public String toSearch()throws JsonProcessingException{

        return "search";
    }




}
