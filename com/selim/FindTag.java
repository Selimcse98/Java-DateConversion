package com.selim;


import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

/**
 * Created by mohammadselimmiah on 21/06/2016.
 */
public class FindTag {
    public static void main(String args[]) {
        String regex = "<(\\\\w+)( +.+)*>((.*))</\\\\1>";
        String input ="<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find())
        {
            System.out.println(" Refex result: " + m.group());
        }
    }
}
