package com.example.Controller;

import com.example.Picture.PictureService;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@SpringBootApplication(scanBasePackages={
        "com.example.Controller", "com.example.Picture"})  //aplikacja dokona samokonfiguracji według domyślnych wartości, załaduje potrzebne moduły itp.
public class SpringBootRestApiApp {
    private static PictureService pictureService;
    public static void main(String[] args) throws IOException {
        SpringApplication.run(SpringBootRestApiApp.class, args);
    }

}