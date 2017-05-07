import java.util.ArrayList;

/**
 * Created by Cactus on 5/4/2017.
 */
public abstract class AddressManager {
    //Manages address values to be Interpreted between socket and GUI.
    //Recommended an address manager be a Singleton.

    //Code ran when Snes9xSocket receives data from LUA script
    public abstract void run(ArrayList<String> data);
}
