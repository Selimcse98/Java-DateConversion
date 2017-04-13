import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegexDateConversion {
    public static void main(String args[]) {
        String inputDateStr = "2001-07-05T05:08:56.235+10:00",outputDateStr;
        outputDateStr = dateFormatConversion(inputDateStr);
        System.out.println(outputDateStr);
    }

    public static String dateFormatConversion(String inputDateStr) {
        //String DATE_PATTERN = "(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)";
        String outputDateStr="";
        DateFormat inputFormatter = null, outputFormatter = null;
        Date inputDate = null;



        if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})[+-]([0-9]{4})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"); //2001-07-04T12:08:56.235-0700
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SSSZ");

        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})[+-]([0-9]{4})")) {
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ"); //2001-07-04 12:08:56.235-0700
            System.out.println("Pattern Selected: yyyy-MM-dd HH:mm:ss.SSSZ");

        } else if(inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})[+-]([0-9]{2}):([0-9]{2})")){
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"); //2001-07-05T05:08:56.235+10:00
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

        } else if(inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})[+-]([0-9]{2}):([0-9]{2})")){
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSXXX"); //2001-07-05 05:08:56.235+10:00
            System.out.println("Pattern Selected: yyyy-MM-dd HH:mm:ss.SSSXXX");

        } else if(inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})")){
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS"); //2001-07-04T12:08:56.235
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss.SSS");

        } else if(inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})")){
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS"); //2001-07-04 12:08:56.235
            System.out.println("Pattern Selected: yyyy-MM-dd HH:mm:ss.SSS");

        } else if(inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2})")){
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"); //2001-07-04T12:08:56
            System.out.println("Pattern Selected: yyyy-MM-dd'T'HH:mm:ss");

        } else if(inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2}) ([0-9]{2}):([0-9]{2}):([0-9]{2})")){
            inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //2001-07-04 12:08:56
            System.out.println("Pattern Selected: yyyy-MM-dd HH:mm:ss");

        }

        else {
            System.out.println("Not matching");
            System.exit(1);
        }

        try {
            inputDate = inputFormatter.parse(inputDateStr);
            //outputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"); //2001-07-05T05:08:56.235+10:00
            outputFormatter = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z"); //Wed, 4 Jul 2001 12:08:56 -0700
            outputDateStr = outputFormatter.format(inputDate);
            //System.out.println(outputDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return outputDateStr;
//        if(inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})T([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3})[+-]([0-9]{4})")){
//            //String pattern =(([0-9]{4})-([0-9]{2})-[0-9]{2}'T'([0-9]{2}):([0-9]{2}):([0-9]{2}).([0-9]{3}))([+-]([0-9]{3}));
//            inputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//            System.out.println("I am set 29/07/2013");
//        } else if (inputDateStr.matches("([0-9]{2})-([0-9]{2})-([0-9]{4})")) {
//            inputFormatter = new SimpleDateFormat("dd-MM-yyyy");
//            System.out.println("I am set 29/07/2013");
//        } else if (inputDateStr.matches("([0-9]{4})([0-9]{2})([0-9]{2})")) {
//            inputFormatter = new SimpleDateFormat("yyyyMMdd");
//        } else if (inputDateStr.matches("([0-9]{4})-([0-9]{2})-([0-9]{2})")) {
//            inputFormatter = new SimpleDateFormat("yyyy-MM-dd");
//        } else if (inputDateStr.matches("([0-9]{4})/([0-9]{2})/([0-9]{2})")) {
//            inputFormatter = new SimpleDateFormat("yyyy/MM/dd");
//        }
//        try {
//            inputDate = inputFormatter.parse(inputDateStr);
//            outputFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//            System.out.println(outputFormatter.format(inputDate));
//
//        } catch (Exception ex) {    //Catch the Exception in case the format is not found.
//            ex.printStackTrace();
//        }
//
    }
}
/*
"yyyy-MM-dd'T'HH:mm:ss.SSSXXX"	2001-07-04T12:08:56.235-07:00 SimpleDateFormat(yyyy-MM-dd'T'HH:mm:ss.SSSXXX)
yyyy-MM-dd'T'HH:mm:ss.SSS
yyyy-MM-dd'T'HH:mm:ss        SimpleDateFormat(yyyy-MM-dd'T'HH:mm:ss)
yyyy-MM-dd HH:mm:ss Z
2013-09-29T18:46:19Z = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
DateTimeFormat (yyyy-MM-dd'T'HH:mm:ss.SSSZZ) = SimpleDateFormat(yyyy-MM-dd'T'HH:mm:ss.SSSXXX) = 2013-03-06T11:49:05.490+0100
SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX") 2010-03-01T00:00:00-08:00

String dateString = "2010-03-01T00:00:00-08:00";
String pattern = "yyyy-MM-dd'T'HH:mm:ssZ";
DateTimeFormatter dtf = DateTimeFormat.forPattern(pattern);
DateTime dateTime = dtf.parseDateTime(dateString);
System.out.println(dateTime);
OffsetDateTime dt = OffsetDateTime.parse("2010-03-01T00:00:00-08:00");


=============================================
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String formatDateTime = date.format(formatter);
String regex = "^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$";
String regex = "^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$";
String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";

ZonedDateTime a = ZonedDateTime.parse("2012-06-30T12:30:40Z[GMT]");
ZonedDateTime b = ZonedDateTime.parse("2012-06-30T12:30:40Z[UT]");
ZonedDateTime c = ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]");
ZonedDateTime d = ZonedDateTime.parse("2012-06-30T12:30:40+01:00[+01:00]");
ZonedDateTime e = ZonedDateTime.parse("2012-06-30T12:30:40+01:00[GMT+01:00]");
ZonedDateTime f = ZonedDateTime.parse("2012-06-30T12:30:40+01:00[UT+01:00]");
ZonedDateTime g = ZonedDateTime.parse("2012-06-30T12:30:40+01:00[UTC+01:00]");
ZonedDateTime h = ZonedDateTime.parse("2012-06-30T12:30:40-01:00[-01:00]");
ZonedDateTime i = ZonedDateTime.parse("2012-06-30T12:30:40-01:00[GMT-01:00]");
ZonedDateTime j = ZonedDateTime.parse("2012-06-30T12:30:40-01:00[UT-01:00]");
ZonedDateTime k = ZonedDateTime.parse("2012-06-30T12:30:40-01:00[UTC-01:00]");
ZonedDateTime l = ZonedDateTime.parse("2012-06-30T12:30:40+01:00[Europe/London]");

ZonedDateTime m = ZonedDateTime.parse("2012 06 30 12 30 40 Europe/London", aDateTimeFormatter); //2012-06-30T12:30:40+01:00[Europe/London]

// where DateTimeFormatter aDateTimeFormatter = DateTimeFormatter.ofPattern("y M d H m s VV");
 */
