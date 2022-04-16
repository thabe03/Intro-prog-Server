import java.io.*;
import java.net.*;

public class SimpleClientDemo {

    public static void main(String[] args) {
        String serverHost = "localhost";
        Socket s = null;
        BufferedWriter os = null;
        BufferedReader is = null;
        try {
            s = new Socket(serverHost, 9999);
            os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            is = new BufferedReader(new InputStreamReader(s.getInputStream()));
        } catch (Exception e) {
            System.err.println("Error");
            return;
        }
        try {
            os.write("HELO");
            os.newLine();
            os.flush();
            os.write("I am Tom Cat");
            os.newLine();
            os.flush();
            os.write("QUIT");
            os.newLine();
            os.flush();
            String r;
            while ((r = is.readLine()) != null) {
                System.out.println(r);
                if (r.indexOf("OK") != -1) {
                    break;
                }
            }
            os.close();
            is.close();
            s.close();
        } catch (Exception e) {
            System.err.println("Error");
        }
    }

}