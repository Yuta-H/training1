package com.example.demo_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {

    @RequestMapping(value = "/text-local-date-time", method = RequestMethod.POST)
    public String textLocalDateTime(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss"));
    }
    @RequestMapping(value="/json-local-date-time", method = RequestMethod.POST)
    public List<DateBean> jsonLocalDateTime(){
        List<DateBean> list = new ArrayList<DateBean>();
        DateBean bean = new DateBean();
        bean.setJsonLocalDateTime(LocalDateTime.now());
        list.add(bean);
        return list;
    }
}
