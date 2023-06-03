package reverse_echo;

import java.net.*;
import java.io.*;

public class ReverseEcho {
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(2000);
        Socket stk = ss.accept(); // returns a socket

        BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
        PrintStream ps = new PrintStream(stk.getOutputStream());

        String msg;
        StringBuilder sb;

        do {
            msg = br.readLine();
            sb = new StringBuilder(msg);
            sb.reverse();
            msg = sb.toString();
            ps.println(msg);
        } while (!msg.equals("dne"));
    }
}

class Client { // there cannot be more public classes inside a file.
    public static void main(String[] args) throws Exception {

        Socket stk = new Socket("localhost", 2000);
        BufferedReader keyb = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(stk.getInputStream()));
        PrintStream ps = new PrintStream(stk.getOutputStream());

        String msg;
        StringBuilder sb;

        do {
            msg = keyb.readLine();
            ps.println(msg);
            msg=br.readLine();
            System.out.println("From Server"+msg);
        } while (!msg.equals("dne"));
        stk.close();
    }
}


