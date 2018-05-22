package com.example.demo.Picture;

import java.io.Serializable;

public class OutcomeToJson implements Serializable {

    boolean result;

    public OutcomeToJson()
    {
        this.result =false;
    }
    public void setResult(boolean ser)
    {
        this.result = ser;
    }

    public boolean isResult() {
        return result;
    }

}
