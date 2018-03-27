package sample;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.GroupBuilder;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import javax.swing.text.TabableView;
import javax.swing.text.TableView;
import javax.swing.text.html.ListView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.Scanner;

public class clockController extends Parent implements Runnable, Initializable {

    @FXML
    private SplitPane mainPane;

    @FXML
    private AnchorPane anchorPaneWithCanvas;

    @FXML
    private Canvas myCanvas;

    public javafx.scene.control.ListView getListOfAlarms() {
        return listOfAlarms;
    }

    @FXML
    private javafx.scene.control.ListView listOfAlarms;

    @FXML
    private Menu myMenu;


    public void setMainPane(SplitPane mainPane) {
        this.mainPane = mainPane;
    }

    private ObservableList<String> data1 = FXCollections.observableArrayList();

    private GraphicsContext gc;



    public void close()
    {
        System.exit(0);
    }
    public void deleteAlarm() {

       int index=listOfAlarms.getSelectionModel().getSelectedIndex();
       ObservableList<String> data1 = FXCollections.observableArrayList();

    }






    public void ring()
    {
        String musicFile = "Kalimba.mp3";     // For example

        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }







    public void showAlarmPane() throws IOException {

        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("addAlarm.fxml"));
        root = loader.load();
        addAlarm controller = loader.getController();
        controller.setData(data1);

        Scene addAlarmScene = new Scene(root);
        Stage window = new Stage();
        window.setScene(addAlarmScene);
        window.setTitle("Add");
        window.show();

        SortedList<String> sorted = new SortedList(data1);
        listOfAlarms.setItems(sorted.sorted());
    }




    @FXML
    void showAuthor(Event event) throws IOException {

        Parent root;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("author.fxml"));
        root = loader.load();
        Scene addAuthorScene = new Scene(root);
        Stage window1 = new Stage();
        window1.setScene(addAuthorScene);
        window1.setTitle("About author");
        window1.show();
    }




    @Override
    public void run() {

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        gc = myCanvas.getGraphicsContext2D();
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                gc.setStroke(Color.BLACK);
                gc.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
                gc.strokeOval(20, 20, 205, 205);
                double size = myCanvas.getWidth();
                double center = size / 2;
                double time = (int) System.currentTimeMillis();
                double anim, anim2;
                double radius = size - 120;
                time = ((time + 2500) % 60000 / 60000.0 * Math.PI * 2);
                anim = (int) ((center - 10) + (Math.sin(time)) * radius / 2);
                anim2 = (int) ((center - 10) - (Math.cos(time)) * radius / 2);
                gc.setStroke(Color.RED);
                gc.strokeLine(center - 10, center - 10, anim, anim2);
                time = (int) System.currentTimeMillis();
                time = ((time + 1560000) % 3600000 / 3600000.0 * Math.PI * 2);
                anim = (int) ((center - 10) + (Math.sin(time)) * radius / 2);
                anim2 = (int) ((center - 10) - (Math.cos(time)) * radius / 2);
                gc.setStroke(Color.BLACK);
                gc.strokeLine(center - 10, center - 10, anim, anim2);
                time = (int) System.currentTimeMillis();
                time = ((time + 1000000) % 43200000 / 43200000.0 * Math.PI * 2);
                radius -= 40;
                anim = (int) ((center - 10) + (Math.sin(time)) * radius / 2);
                anim2 = (int) ((center - 10) - (Math.cos(time)) * radius / 2);
                gc.setStroke(Color.BLACK);
                gc.strokeLine(center - 10, center - 10, anim, anim2);

                for (int i = 0; i < 12; i++) {
                    int x1, x2;
                    radius = size - 100;
                    x1 = (int) ((center - 15) + (Math.sin((i +1) / 12.0 * Math.PI * 2)) * radius / 2);
                    x2 = (int) ((center - 5) - (Math.cos((i +1) / 12.0 * Math.PI * 2)) * radius / 2);
                    gc.fillText(Integer.toString(i+1), x1, x2);
                }

                ObservableList<String> tmp = FXCollections.observableArrayList();
                int hours,minutes,seconds,mili;
                tmp = listOfAlarms.getItems();
                String text;
                String text1;
                for(int i=0;i<tmp.size();i++)
                {
                    long time1 = System.currentTimeMillis();
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTimeInMillis(time1);
                    //System.out.println(calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND));
                    //System.out.println(tmp.get(i));
                    text = (calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE)+":"+calendar.get(Calendar.SECOND)).toString();
                    text1 = tmp.get(i);
                    if(text1.equals(text))
                    {
                        ring();
                        break;
                    }
                    //System.out.println(tmp.get(i));
                }
            }
        };
        timer.start();

    }

}