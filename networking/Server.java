import java.net.*;
import java.io.*;

class Server {
    public static void handle(Socket comm) throws Exception {
        OutputStream o = comm.getOutputStream();
        InputStream i = comm.getInputStream();

        PrintWriter writer = new PrintWriter(o);
        BufferedReader reader = new BufferedReader(new InputStreamReader(i));

        String line = reader.readLine();
        while(line != null) {
            System.out.println("DEBUG received: " + line);
            if(line.equals("bye")) {
                break;
            } else {
                writer.printf("You just said \"%s\"\n", line);
                writer.flush();
            }
            line = reader.readLine();
        }
        writer.println("Bye, thanks for connecting.");
    }

    public static void main(String[] args) {
        try {
            ServerSocket main = new ServerSocket(2000);

            while(true) {
                // accepts incoming clients
                System.out.println("Accepting new connection...");
                Socket comm = main.accept();

                System.out.println("Connection established.");

                // Data exchange.
                handle(comm);

                comm.close();
                System.out.println("Connection closed.");
            }

        } catch(Exception e) {
            ;
        }
    }
}
