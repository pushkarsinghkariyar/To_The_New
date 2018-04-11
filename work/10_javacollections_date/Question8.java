package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Question8 {
    public static void main(String[] args) throws Exception{
        Date dNow = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat("E dd-MMM-yyyy 'at' hh:mm:ss a zzz");
        System.out.println("Current Date: " + ft.format(dNow));

    }
}
