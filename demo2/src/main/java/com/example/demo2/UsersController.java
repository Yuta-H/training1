package com.example.demo2;



import com.example.demo2.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.example.demo2.utill.ImageTypeCheck.getFormat;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository repositry;

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    @Transactional
    public List<User> get() {
        return repositry.findAll();
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.GET)
    public List<User> show(Model model, @PathVariable("id") int id) {
        return repositry.findById(id);
    }

    @RequestMapping(path = "/users", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public User create(Model model, @RequestBody User user) {
        return repositry.save(user);
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.PUT)
    public User update(Model model, @PathVariable("id") int id, @RequestBody User user) {
        user.setId(id);
        return repositry.save(user);
    }

    @RequestMapping(path = "/users/{id}", method = RequestMethod.DELETE)
    public void destroy(Model model, @PathVariable("id") int id) {
        repositry.delete(id);
    }

    @RequestMapping(path = "/users/upload", method = RequestMethod.PUT)
    public void upload(InputStream req) throws IOException {

        ByteArrayOutputStream byteos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int size = 0;
        while ((size = req.read(buf, 0, buf.length)) != -1) {
            byteos.write(buf, 0, size);
        }

        String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now()) + "." + getFormat(byteos.toByteArray());
        Path uploadfile = Paths.get("/Users/horiyuuta/workspace/training/demo2/static/img/" + filename );

        try (OutputStream os = Files.newOutputStream(uploadfile, StandardOpenOption.CREATE)) {
            os.write(byteos.toByteArray());
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}