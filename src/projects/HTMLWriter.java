package projects;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class HTMLWriter {

    private static final String FILE_PATH = "/home/nikhil/Desktop/Java-Code/Magic/src/projects/hand.html";
    private static final String FILE_PATH_1 = "/home/nikhil/Desktop/Java-Code/Magic/html/hand1.html";
    private static final String FILE_PATH_2 = "/home/nikhil/Desktop/Java-Code/Magic/html/hand2.html";
    
    public static void GenerateHand(Hand hand) throws IOException {
        
        String outputStr = "";
        
        try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_PATH_1)))) {
            
            for (String line; (line = br.readLine()) != null; ) { 
                
                outputStr += line;
            }
        }
        
        int counter = 0;
        for (Card card : hand.getCards()) {
            
            counter += 1;
            String filename = card.getName().replace(" ", "_").replace("'", "") + ".jpg";
            outputStr += "<img src='/home/nikhil/Desktop/Java-Code/Magic/html/" + filename + "' />";
            if (counter % 4 == 0) {
                outputStr += "<br />";
            }
        }
        
        try (BufferedReader br = new BufferedReader(new FileReader(new File(FILE_PATH_2)))) {
            
            for (String line; (line = br.readLine()) != null; ) { 
                
                outputStr += line;
            }
        }
        
        try{
            PrintWriter writer = new PrintWriter(FILE_PATH, "UTF-8");
            writer.println(outputStr);
            writer.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}
