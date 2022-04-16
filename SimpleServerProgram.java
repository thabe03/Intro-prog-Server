import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServerProgram {

     public static void main(String args[]) {
          ServerSocket l = null; // déclare null, doit étre déclaré, listener
          String line; // renvoie à l'écran
          BufferedReader is; // input stream
          BufferedWriter os; // output stream
          Socket s = null; // déclare null, doit étre déclaré, connection pour éventuellement accepter le client
          try {
               l = new ServerSocket(9999); // SOCKADDR_IN s... s.sin_port=htons(9999), au serveur 9999 qui accept() un client
          } catch (Exception e) {
               System.err.println("Error");
          }
          try {
               System.out.println("Server is waiting to accept user...");
               s = l.accept(); // connection établie
               System.out.println("Accept a client!");
               is = new BufferedReader(new InputStreamReader(s.getInputStream())); // read input de la socket
               os = new BufferedWriter(new OutputStreamWriter(s.getOutputStream())); // write output de la socket
               os.write(">> OK");
               os.newLine(); // <br> ou \n
               os.flush(); // obliger pour arréter l'exécution
          } catch (Exception e) {
               System.err.println("Error");
          }
          System.out.println("Sever stopped!");
     }
}