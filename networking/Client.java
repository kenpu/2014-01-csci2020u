import java.io.*;
import java.net.*;

class Client {
    public static void main(String[] args) {
        try {
            int port = Integer.parseInt(args[0]);
            Socket comm = new Socket("localhost", port);

            // talk to the server.
            BufferedReader reader = new BufferedReader(
                                        new InputStreamReader(comm.getInputStream()));
            PrintWriter writer = new PrintWriter(comm.getOutputStream());

            BufferedReader user = new BufferedReader(
                                    new InputStreamReader(System.in));

            String line = user.readLine();
            String reply;

            while(line != null) {
                System.out.println("DEBUG: write to server");
                writer.println(line); writer.flush();

                reply = reader.readLine();
                System.out.println(">" + reply);
                if(line.equals("bye")) break;
                line = user.readLine();
            }
        } catch(Exception e) {
            ;
        }
    }
}
