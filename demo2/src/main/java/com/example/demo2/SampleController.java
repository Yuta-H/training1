package com.example.demo2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class SampleController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ResourceLoader resourceLoader;

    @ModelAttribute
    UserForm UserForm(){
        return new UserForm();
    }

    @RequestMapping(path = "/sample", method = RequestMethod.GET)
    String index(Model model){
        List<User> list = jdbcTemplate.queryForObject("select * from user", new UserMapper());
        model.addAttribute("list", list);
        return  "sample/index";
    }
    @RequestMapping(path = "/sample/{id}", method = RequestMethod.GET)
        String show(Model model, @PathVariable("id") int id){
        List<User> list = jdbcTemplate.queryForObject("select * from user where id = ? ", new Object[] { id },
                new UserMapper());
        model.addAttribute("list", list);
        return "sample/index";
    }
    @RequestMapping(path = "/sample", method = RequestMethod.POST)
    String create(Model model, @ModelAttribute UserForm userForm){
        jdbcTemplate.update("INSERT  INTO user (name) VALUES (?)", userForm.getName());
        return "redirect:/sample";
    }
    @RequestMapping(path = "/sample/{id}", method = RequestMethod.PUT)
    String update(Model model, @ModelAttribute UserForm userForm, @PathVariable("id") int id){
        jdbcTemplate.update("UPDATE user SET name = ? WHERE id = ? ", userForm.getName(), id);
            return "redirect:/sample";
    }
    @RequestMapping(path = "/sample/{id}", method = RequestMethod.DELETE)
    String destroy(Model model, @PathVariable("id") int id){
        jdbcTemplate.update("DELETE from user where id = ? ", id);
        return "redirect:/sample";
    }

    @RequestMapping(path = "/sample/upload", method = RequestMethod.GET)
    String uploadview(Model model) {
        return  "sample/upload";
    }
    @RequestMapping(path = "/sample/upload", method = RequestMethod.POST)
    String upload(RedirectAttributes redirectAttributes, UploadForm uploadForm){
        if(uploadForm.getFile().isEmpty()){
            return "sample/upload";
        }

        Path path = Paths.get("/Users/horiyuuta/workspace/training/demo2/static/img/");
        if(!Files.exists(path)){
            try {
                Files.createDirectories(path);
                System.out.println(path.getParent());
            } catch (NoSuchFileException ex) {
                System.err.println(ex);
            } catch (IOException ex){
                System.err.println(ex);
            }
        }

        int dot = uploadForm.getFile().getOriginalFilename().lastIndexOf(".");
        String extention = "";
        if (dot > 0){
            extention = uploadForm.getFile().getOriginalFilename().substring(dot).toLowerCase();
        }
        String filename = DateTimeFormatter.ofPattern("yyyMMddHHmmssSSS").format(LocalDateTime.now());
        Path uploadfile = Paths
                .get("/Users/horiyuuta/workspace/training/demo2/static/img/"+ filename + extention);
        String showFile = filename + extention;

        System.out.println("ファイル名：" + showFile);
        redirectAttributes.addFlashAttribute("showFile",showFile);
        try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
            byte[] bytes = uploadForm.getFile().getBytes();
            os.write(bytes);
        } catch (IOException ex){
            System.out.println(ex);
        }

//        Resource resource =resourceLoader.getResource("classpath:" + "/img/" +  showFile);
//        try {
//
//            System.out.println("###" + resource.getURL().getPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return "redirect:/sample";
    }
}
