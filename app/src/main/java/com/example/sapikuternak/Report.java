package com.example.sapikuternak;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class Report{

    private String report1;
    private String report2;
    private String report3;
    private String desc;

    public Report(){

    }

    public String getReport1() {
        return report1;
    }

    public void setReport1(String report1) {
        this.report1 = report1;
    }

    public String getReport2() {
        return report2;
    }

    public void setReport2(String report2) {
        this.report2 = report2;
    }

    public String getReport3() {
        return report3;
    }

    public void setReport3(String report3) {
        this.report3 = report3;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return " "+report1+"\n" +
                " "+report2 +"\n" +
                " "+report3 +"\n" +
                " "+desc;
    }

    public Report(String r1, String r2, String r3, String des){
        report1 = r1;
        report2 = r2;
        report3 = r3;
        desc = des;
    }
}