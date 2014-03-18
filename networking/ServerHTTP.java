import java.net.*;
import java.io.*;

class ServerHTTP {
    public static void main(String[] args) {
        String reply = "HTTP/1.1 200 OK\n" +
                       "Date: Mon, 23 May 2005 22:38:34 GMT\n" +
                       "Server: Apache/1.3.3.7 (Unix) (Red-Hat/Linux)\n" +
                       "Last-Modified: Wed, 08 Jan 2003 23:11:55 GMT\n" +
                       "ETag: \"3f80f-1b6-3e1cb03b\"\n" +
                       "Content-Type: text/html; charset=UTF-8\n" +
                       "Content-Length: 131\n" +
                       "Accept-Ranges: bytes\n" +
                       "Connection: close\n\n" +
                       "<html>\n" +
                       "<head>\n" +
                       "  <title>An Example Page</title>\n" +
                       "</head>\n" +
                       "<body>\n" +
                       "  Hello World, this is a very simple HTML document.\n" +
                       "</body>\n" +
                       "</html>\n";

        try {
            ServerSocket main = new ServerSocket(1234);

            while(true) {
                // accepts incoming clients
                System.out.println("Accepting new connection...");
                Socket comm = main.accept();

                System.out.println("Connection established.");

                // Data exchange.
                OutputStream o = comm.getOutputStream();
                PrintWriter writer = new PrintWriter(o);
                writer.println(reply);
                writer.flush();
                comm.close();
                System.out.println("Connection closed.");
            }

        } catch(Exception e) {
            ;
        }
    }
}
