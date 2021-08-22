import java.net.*;
import java.io.*;
 
class Server {
 
    public static void main(String args[]) throws IOException {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(95);
        } catch (IOException ioe) {
            System.out.println("Error finding port");
            System.exit(1);
        }
        Socket soc = null;
        try {
            soc = ss.accept();
            System.out.println("Connection accepted at :" + soc);
        } catch (IOException ioe) {
            System.out.println("Server failed to accept");
            System.exit(1);
        }
        DataOutputStream dos = new DataOutputStream(soc.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(soc.getInputStream()));
        String s;
        System.out.println("Server waiting for message from tthe client");
        boolean quit = false;
        do {
            String msg = "";
            s = br.readLine();
            int len = s.length();
            if (s.equals("exit")) {
                quit = true;
            }
            for (int i = 0; i < len; i++) {
                msg = msg + s.charAt(i);
                dos.write((byte) s.charAt(i));
            }
 
            System.out.println("From client :" + msg);
            dos.write(13);
            dos.write(10);
            dos.flush();
        } while (!quit);
        dos.close();
        soc.close();
 
    }
}