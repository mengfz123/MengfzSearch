package com.ivan.mengfzsearch.controller;

import com.ivan.mengfzsearch.utils.HttpRequestUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

/**
 * @创建人：WUHUI
 * @创建时间：2019-6-28
 * @描述：
 **/
@Controller
public class mainController {

    @RequestMapping("/home")
    public String home(){
        return "index";
    }

    @RequestMapping("/search")
    public String search(@RequestParam String keyword){

        String reqUrl="";
        Map reqMap=new HashMap();

        String s = HttpRequestUtil.doGet(reqUrl, reqMap);

        return "result";
    }
}
