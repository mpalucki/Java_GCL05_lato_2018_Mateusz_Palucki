package com.example.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
@PropertySource("classpath:global.properties")
public class GlobalProperties {

    @Value("${path}")
    private Properties path = null;

    public String getPath()  {

            InputStream is = null;
            try {
                this.path = new Properties();
                path.load(new FileInputStream("C:\\Users\\HP\\IdeaProjects\\SpringBootGalleries\\src\\main\\java\\com\\example\\Properties\\global.properties"));
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            return this.path.getProperty("path");
    }
}
