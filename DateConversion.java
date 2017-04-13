import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConversion {
    public static void main(String args[]) {
        String inputDateStr = "2009-12-31T23:59:59+01:00", ouputFormatStr = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", outputDateStr;
        outputDateStr = dateFormatConversion(inputDateStr, ouputFormatStr);
        System.out.println("Input String: " + inputDateStr);
        System.out.println("Output String: " + outputDateStr);
    }

    public static String dateFormatConversion(String inputDateStr, String ouputFormatStr) {
        String outputDateStr = "";
        DateFormat inputFormatter = null, outputFormatter = null;
        Date inputDate = null;

        if((inputDateStr == null) || (inputDateStr.length()==0))
            return "";

        if((ouputFormatStr == null) || (ouputFormatStr.length()==0))
            ouputFormatStr = "yyyy-MM-dd'T'HH:mm:ss.SSS"; //Default

        if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})[+-]([0-9]{4})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"); //2001-07-04T12:08:56.235-0700 //ss.SSSZ ss.SSZ ss.SZ
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{2})[+-]([0-9]{4})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSZ"); //2001-07-04T12:08:56.23-0700 //ss.SSZ
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SSZ");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{1})[+-]([0-9]{4})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SZ"); //2001-07-04T12:08:56.2-0700 //ss.SZ
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SZ");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2})[+-]([0-9]{2}):([0-9]{2})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"); //2013-01-17T00:00:00-06:00 //ssXXX
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ssXXX");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})[+-]([0-9]{2}):([0-9]{2})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"); //2001-07-05T05:08:56.235+10:00 ////ss.SSSXXX
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{2})[+-]([0-9]{2}):([0-9]{2})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSXXX"); //2001-07-05T05:08:56.23+10:00 ////ss.SSXXX
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SSXXX");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{1})[+-]([0-9]{2}):([0-9]{2})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SXXX"); //2001-07-05T05:08:56.3+10:00 //ss.SXXX
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SXXX");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2})[+-]([0-9]{4})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ"); //2001-07-05T05:08:56+1200 //ssZ
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ssZ");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS"); //2001-07-04T12:08:56.235 //ss.SSS
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SSS");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{2})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS"); //2001-07-04T12:08:56.23 //ss.SS
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SS");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{1})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.S"); //2001-07-04T12:08:56.2 //ss.S
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.S");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); //2001-07-04T12:08:56 //ss
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):([0-9]{2}) [+-]([0-9]{4})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z"); //2009-12-31 23:59:59 +0100
            System.out.println("Pattern Selected: yyyy-MM-dd HH:mm:ss Z");

        } else {
            System.out.println("Not matching");
            System.exit(1);
        }

        try {
            inputDate = inputFormatter.parse(inputDateStr);
            outputFormatter = new SimpleDateFormat(ouputFormatStr);
            outputDateStr = outputFormatter.format(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return outputDateStr;
    }
}

/*
    yyyy-MM-dd'T'HH:mm:ss.SZ = yyyy-MM-dd'T'HH:mm:ss.SSZ = yyyy-MM-dd'T'HH:mm:ss.SSSZ //2001-07-05T05:08:06.235+1000
    yyyy-MM-dd'T'HH:mm:ss.SSSXXX //2001-07-05T05:08:56.235+10:00
    yyyy-MM-dd HH:mm:ss Z //2009-12-31 23:59:59 +0100
    yyyy-MM-dd'T'HH:mm:ssXXX //2013-01-17T00:00:00-06:00 //ssXXX
    yyyy-MM-dd'T'HH:mm:ss.SSS //2001-07-04T12:08:56.235 //ss.SSS
    yyyy-MM-dd'T'HH:mm:ss //2001-07-04T12:08:56 //ss
    yyyy-MM-dd'T'HH:mm:ssZ = yyyy-MM-dd'T'HH:mm:ssZZZZZ //2001-07-05T05:08:56+1200 //ssZ
    yyyy-MM-dd HH:mm:ssX //2010-01-01 09:59:59+11 //ssX
    yyyy-MM-dd HH:mm:ssZ //2010-01-01 09:59:59+1100 //ssZ
    yyyy-MM-dd HH:mm:ss.SSS //2010-01-01 09:59:59.000 //ss.SSS
    yyyy-MM-dd HH:mm:ss.SSS Z //2010-01-01 09:59:59.000 +1100
    yyyy-mm-dd HH:mm:ss'Z' = yyyy-MM-dd'T'HH:mm:ss'Z' //2010-59-01 09:59:59Z
*/