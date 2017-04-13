import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class Linux {
    public static void main(String args[]) {
        try {
            File f;

            if (args.length > 0) {
                if (!(args[0].trim().contains("/") || args[0].trim().equals("."))) {
                    System.out.println("Please provide directory path as argument");
                    exit(1);
                }

                if (args[0].trim().equals(".")) {
                    String command[] = new String[]{"sh", "-c", "pwd"};
                    Process p = Runtime.getRuntime().exec(command);
                    BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line = br.readLine();
                    //System.out.println(line);
                    f = new File(line);
                } else
                    f = new File(args[0].trim());
            } else
                f = new File("/opt/WebSphere/translog"); // current directory
            File[] files = f.listFiles();
            if (files != null)
                for (File file : files) {
                    if (file.isDirectory()) { ///opt/WebSphere/translog/WFCSPATESBNODE04.AppTarget/
                        File parentFiles[] = file.listFiles();
                        if (parentFiles != null)
                            for (File parentFile : parentFiles) {
                                if (parentFile.getName().contains("partnerlog") || parentFile.getName().contains("tranlog")) {
                                    File dir = new File(parentFile.getCanonicalPath());
                                    File[] files1 = dir.listFiles();
                                    if (files1 != null)
                                        for (File file1 : files1)
                                            if (file1.isFile() && file1.getName().contains("log")) {
                                                    System.out.println(file1.getAbsoluteFile());
                                                //System.out.println(file1.getCanonicalPath());
                                            }
                                }
                            }
                    }
                }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
