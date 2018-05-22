package com.example.demo.Picture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import com.example.demo.Picture.OutcomeToJson;
import com.example.demo.Picture.Picture;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;


@Service
public class PictureService {


    BasicFileAttributes attr;

    BufferedImage bimg;

    String path1 = "C:\\Users\\HP\\IdeaProjects\\SpringBootGalleries\\src\\main\\resources\\Koala.jpg";
    String path2 = "C:\\Users\\HP\\IdeaProjects\\SpringBootGalleries\\src\\main\\resources\\Penguins.jpg";
    String path3 = "C:\\Users\\HP\\IdeaProjects\\SpringBootGalleries\\src\\main\\resources\\sid.jpg";
    String path4 = "C:\\Users\\HP\\IdeaProjects\\SpringBootGalleries\\src\\main\\resources\\Tulips.jpg";


    OutcomeToJson oson = new OutcomeToJson();

    public PictureService() throws IOException {
    }

    String getDate(String path) throws IOException {
        Path file = Paths.get(path);
        attr = Files.readAttributes(file, BasicFileAttributes.class);
        return (String.valueOf(attr.creationTime()));
    }

    Long getSize(String path) throws IOException {
        Path file= Paths.get(path);
        attr= Files.readAttributes(file,BasicFileAttributes.class);
        return attr.size();

    }
    String getName(String path){
        Path file= Paths.get(path);
        return(file.getFileName().toString());

    }
    String getResolution(String path) throws IOException {
        bimg= ImageIO.read(new File(path));
        String width=Integer.toString(bimg.getWidth());
        String height=Integer.toString(bimg.getHeight());
        String resolution=width+"x"+height;
        return resolution;
    }

    private List<Picture> picture=  new ArrayList<Picture>(Arrays.asList(

//            new Picture(1,getName(path1),getResolution(path1),getSize(path1),getDate(path1),path1),
//            new Picture(2,getName(path2),getResolution(path2),getSize(path2),getDate(path2),path2),
//            new Picture(3,getName(path3),getResolution(path3),getSize(path3),getDate(path3),path3),
//            new Picture(4,getName(path4),getResolution(path4),getSize(path4),getDate(path4),path4)
    ));

    public List<Picture>getPictures(){
        URL url = this.getClass().getClassLoader().getResource("static/");
        File file = null;
        int i=0;
        List<Picture> tmp_picture = new ArrayList<>();
        try {
            file = new File(url.toURI());
            for(File f : file.listFiles())
            {

                String path = f.getPath();
                String extension = path.substring(path.lastIndexOf('.')+1);
                if(extension.equals("jpg") || extension.equals("bmp")) {
                    tmp_picture.add(new Picture(i++, getName(path), getResolution(path), getSize(path), getDate(path), path));

                }
            }
        } catch (URISyntaxException e) {
            file = new File(url.getPath());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return tmp_picture;
    }

    public Picture getPictureByID(int index){
        for ( int i=0;i<picture.size();i++)
        {
            if(picture.get(i).getId()==(index)){

                return picture.get(i);
            }

        }
        return null;
    }

    public OutcomeToJson deletePictureByID(int index){
        if(picture.removeIf(pic -> pic.getId() == index)){
            oson.setResult(true);
        }
        else {
            oson.setResult(false);
        }
        return oson;
    }
}
