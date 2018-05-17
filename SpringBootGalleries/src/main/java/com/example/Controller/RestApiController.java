package com.example.Controller;

import java.io.*;
import java.util.List;

import com.example.Picture.OutcomeToJson;
import com.example.Picture.Picture;
import com.example.Picture.PictureService;
import com.example.Properties.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.websystique.springboot.model.User;
//import com.websystique.springboot.service.com.example.Picture.PictureService;
//import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/gallery")
public class RestApiController {

    @Autowired
    private PictureService pictureService;

    private GlobalProperties prop = new GlobalProperties();

    @RequestMapping(method = RequestMethod.GET, value = "/pictures")
    public List<Picture> getPictures() {
        return pictureService.getPictures();
    }
    @GetMapping(value = "/picture/{index}", produces = MediaType.IMAGE_JPEG_VALUE)


    public ResponseEntity<InputStreamResource> getImage(@PathVariable int index) throws FileNotFoundException {
        Picture picture = pictureService.getPictureByID(index);
        if (picture != null) {
            File initialFile = new File(prop.getPath() + picture.getName());
            //File initialFile = new File("C:\\Users\\HP\\IdeaProjects\\SpringBootGalleries\\src\\main\\resources\\" + picture.getName());
            InputStream targetStream = new FileInputStream(initialFile);
            return ResponseEntity
                    .ok()
                    .contentType(MediaType.IMAGE_JPEG)
                    .body(new InputStreamResource(targetStream));
        }
        return null;

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/picture/{index}")
    public OutcomeToJson deletePictureByID(@PathVariable int index) {
        return pictureService.deletePictureByID(index);
    }
}

