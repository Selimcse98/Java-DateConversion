package com.selim;

/**
 * Created by mohammadselimmiah on 16/06/2016.
 */
import java.util.regex.*;

public class MyDup {
    public static void main(String args[]) {
        String input = "This This is text text another another";
        String originalText = input;
        String output = "";
        Pattern p = Pattern.compile("\\b(\\w+)\\b\\s+\\b\\1\\b", Pattern.MULTILINE + Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(input);
       // System.out.println(m);
        if (!m.find())
            output = "No duplicates found, no changes made to data";
        else {
            while (m.find()) {
                System.out.println("===== "+m.group()+"\t 1: "+m.group(1));

                if (output == "") {
                    output = input.replaceFirst(m.group(), m.group(1));
                } else {
                    output = output.replaceAll(m.group(), m.group(1));
                }
            }

            input = output;
            m = p.matcher(input);
            while (m.find()) {
                output = "";
                if (output == "") {
                    output = input.replaceAll(m.group(), m.group(1));
                } else {
                    output = output.replaceAll(m.group(), m.group(1));
                }
            }
        }
        System.out.println("After removing duplicate the final string is \n" + output);
    }
}
