package com.example.demo.Controller;

import com.example.demo.Picture.Picture;
import com.example.demo.Picture.PictureService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;


@RestController
public class SampleRestController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/gallery")
    public void index(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }


    @RequestMapping(value = "/infos")
    public List<Picture> getInfos(){
        return pictureService.getPictures();
    }


    @RequestMapping(value = "/gallery/panel")
    public void delete(HttpServletResponse response) throws IOException {
        response.sendRedirect("/#/panel");
    }

    @RequestMapping(value = "/pictures/{name}",method = RequestMethod.DELETE)
    public void deletePicture(@PathVariable(name = "name") String pictureName) {
        URL url = this.getClass().getClassLoader().getResource("static/"+pictureName);
        File file = null;
        try {
            file = new File(url.toURI());
            Files.delete(Paths.get(url.toURI()));
        } catch (URISyntaxException e) {
            file = new File(url.getPath());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}
