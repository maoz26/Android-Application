package com.example.oranmoshe.finalmobileproject;

import java.io.Serializable;

/**
 * Created by oranmoshe on 12/2/15.
 */
public class TaskItem implements Serializable {

    private String name;
    private static final long serialVersionUID = 46543445;

    TaskItem(String name){
        this.name = name;
    }

    public String GetName(){
        return this.name;
    }

}
