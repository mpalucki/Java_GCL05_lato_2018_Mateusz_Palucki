package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class addAlarm {

    @FXML
    private TextField textAlarm;

    private ObservableList<String> data = FXCollections.observableArrayList();

    public void setData(ObservableList<String> data) {
        this.data = data;
    }
    @FXML
    public void getAlarm()
    {
        String text;
        text = textAlarm.getText();
        Pattern pat = Pattern.compile("(20|21|22|23|1[0-9]|[1-9]):([0-9]|[1-5][0-9]):([0-9]|[1-5][0-9])");
        Matcher match = pat.matcher(text);
        if(match.matches()) {
            data.add(textAlarm.getText());
        }
    }

    public void deleteAlarm(int index)
    {
        data.remove(index);
    }



}
