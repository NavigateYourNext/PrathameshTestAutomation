package com.ezsolutions.hooks;

import io.cucumber.java.Before;

import java.io.File;

public class Hookes {

    @Before
    public void initialise(){
        try{
            File file = new File("C:/SampleTestAutomation/executionLogs.log");
            file.delete();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
