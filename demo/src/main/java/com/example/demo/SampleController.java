package com.example.demo;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {

    @RequestMapping("/")
    public String topPage(Model model) {
        return "topPage";
    }

    @RequestMapping("/jquery-ajax")
    public String jquery(Model model) {
        return "jquery-ajax";
    }

    @RequestMapping("/index")
    public  String index(Model model){
        return "index";
    }

    @RequestMapping(name = "/index", method = RequestMethod.POST)
    public  String index(@RequestParam("name") String name, Model model){
        model.addAttribute("Items", "タイトル："+name);
        return "index";
    }

}
