// Gerará os arquivos pro programa ARToolkit
//lembrar de por os if windows/linux

package tatica_aumentada;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import static tatica_aumentada.Functions.listOfPlayers;

public class VRML {
    
    static void generateObject_data_VRML(String oi){
       try {            
            FileWriter fileWriter = new FileWriter("ARToolKit\\bin\\Data\\object_data_vrml2");            
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);          
                bufferedWriter.write("#the number of patterns to be recognized");
                bufferedWriter.newLine();
                bufferedWriter.write(String.valueOf(Functions.listOfSelectedPlayers.size())); // quantos cartoes vou usar
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                for (int i = 0; i < Functions.listOfSelectedPlayers.size(); i++)
                {
                    bufferedWriter.write("#pattern " + i); 
                    bufferedWriter.newLine();
                    bufferedWriter.write("VRML	Wrl/" + Functions.listOfSelectedPlayers.get(i).name + ".dat"); 
                    bufferedWriter.newLine();
                    bufferedWriter.write("Data/patt." + Functions.listOfSelectedPlayers.get(i).name); 
                    bufferedWriter.newLine();
                    bufferedWriter.write("80.0"); 
                    bufferedWriter.newLine();
                    bufferedWriter.write("0.0 0.0"); 
                    bufferedWriter.newLine();
                    bufferedWriter.newLine();
                }
                
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + "object_data_vrml" + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        
        
    }
    
}
