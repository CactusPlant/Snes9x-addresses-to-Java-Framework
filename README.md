# Snes9x-addresses-to-Java-Framework

### Description
Snes9x to Java Framework allows for easy communication between the SNES9X emulator, and an exteral Java application.

### Lua Script for Snes9x
#### ***Requires luaSocket***
The Snes9x rr versions of the emulator allow for LUA scripts to be ran. The lua script included has a main loop that can be easily edited to export memory addresses to the external program running in parallel to the emulator.
<Enter>
For details on snes9x lua syntax see https://code.google.com/archive/p/snes9x-rr/wikis/LuaScriptingFunctions.wiki
<Enter>
Addresses retrieved directly from the emulators RAM can be easily added to the Array that will be sent to the Java SocketServer by using the *addOrUpdate* function 
<Enter>
addOrUpdate(name, value(the address to export))
<Enter>
Function adds values to an array to be split by the AddressManager class in the Java Application

### Java Classes
#### AddressManager
An Abstract class designed to handle the manipulation of the recieved data. The *run* command should be overridden with the data manipulation for your program. 
#### Example code:

public class DataManager extends AddressManager {
    private static DataManager ourInstance = new DataManager();

    public static DataManager getInstance() {
        return ourInstance;
    }

    private DataManager() {
    }
    
    @Override
    public void run(ArrayList<String> arrayList) {
    //Your Code here
    }

### Snes9xFramework Class
Class handles the communication to the Lua Script. Class should not have to be edited
#### Example Code to impliment Framework:

public class MainWindow{
    DataManager dm = DataManager.getInstance();
    new Thread(new Snes9xSocket(dm,",")).start();
    }
