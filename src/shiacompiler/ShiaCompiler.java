/*
 * Shia - basically a shitpost programming language
 * Lachy Stevens 2015
 */
package shiacompiler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ShiaCompiler {
    
    public static File dir;
    public static BufferedReader reader;
    public static Map<String, Object> userVariables = new HashMap<>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        start();
    }
    
    public static void start() throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        //Taking user input
        switch (input.nextLine()){
            case "open":
                System.out.println("What file would you like to open? ");
                String fileName = input.next();
                File file = new File(dir, fileName);
                run(file);
                break;
            case "dir":
                System.out.println("Where would you like to change the directory to? ");
                String directory = input.next();
                dir = new File(directory);
                System.out.println("The directory has been changed to "+directory);
                start();
            case "quit":
                break;
            default:
                System.out.println("That is not a valid command!");
                start();
                
                
        }
    }
    
    //FUNCTION DECLARATIONS

    public static void run(File f) throws FileNotFoundException, IOException{
        reader = new BufferedReader(new FileReader(f));
        if(reader.readLine() != null){
            interpret(reader.readLine());
        }
    }
    
    public static void readAgain() throws FileNotFoundException, IOException{
        if(reader.readLine() != null){
            interpret(reader.readLine());
        }
    }
    
    public static void interpret(String input) throws IOException{
        switch (input){
            case "Just Say It!":
                System.out.println(reader.readLine());
                break;
            case "Just Shout It!":
                System.out.println(userVariables.get(reader.readLine()));
                break;
            case "Just Int It!":
                userVariables.put(reader.readLine(), Integer.valueOf(reader.readLine()));
                break;
            case "Just String It!":
                userVariables.put(reader.readLine(), (reader.readLine()));
                break;
            case "Just Add It!":
                System.out.println((int)userVariables.get(reader.readLine()) + (int)userVariables.get(reader.readLine()));
                break;
            case "If you’re tired of starting over, stop giving up!":
                int one, two;
                String operator;
                one = Integer.valueOf(reader.readLine());
                operator = reader.readLine();
                two = Integer.valueOf(reader.readLine());
                
                break;
            
                
            default:
                System.out.println("error");
                break;
        }
        readAgain();
        
    }
    
}
