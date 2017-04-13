/**
 * Created by mohammadselimmiah on 13/4/17.
 */
public class Test {
    public static void main(String args[]) {
        String inputDateStr = "2009-12-31 23:59:59 +0100", ouputFormatStr = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", outputDateStr;
        outputDateStr = dateFormatConversion(inputDateStr, ouputFormatStr);
        System.out.println("Input String: " + inputDateStr);
        System.out.println("Output String: " + outputDateStr);
    }
}
