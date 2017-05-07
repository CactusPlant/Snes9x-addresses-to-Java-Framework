import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Cactus on 5/4/2017.
 */
public class Snes9xSocket implements Runnable {
    //Socket that listens for LUA script to provide address values
    //Values from lua script should be separated by the CHAR provided on
    //Socket Creation

    AddressManager addressManager;
    //Value to be the delimiter for the lua Script
    private String splitter;
    Snes9xSocket(AddressManager manager,String splitter){
        this.splitter = splitter;
        this.addressManager = manager;
    }


    @Override
    public void run() {
        try {
            //Creates Sockets to communicate with LUA Script
            ServerSocket ssock = new ServerSocket(25565);
            String fromClient;
            BufferedReader in;

            while(true){
                Socket sock = ssock.accept();
                in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                fromClient = in.readLine();
                ArrayList<String> contents = new ArrayList<String>();
                for (String s: fromClient.split(splitter)){
                    contents.add(s);
                }

                //Code to handle the acquired address values
                addressManager.run(contents);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
