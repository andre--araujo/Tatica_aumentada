// Gerará os arquivos pro programa ARToolkit
//lembrar de por os if windows/linux

package tatica_aumentada;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static tatica_aumentada.Functions.listOfPlayers;

public class VRML {
    
    static void generateObject_data_VRML(){
       try {            
            FileWriter fileWriter = new FileWriter("ARToolKit\\bin\\Data\\object_data_vrml");            
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
                    bufferedWriter.write("Data/patt.tag" + Functions.listOfSelectedPlayers.get(i).card); 
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
    
    static void generateDat(){
        
        try {       
             for (int i = 0; i < Functions.listOfSelectedPlayers.size(); i++){
            FileWriter fileWriter = new FileWriter("ARToolKit\\bin\\Wrl\\" + Functions.listOfSelectedPlayers.get(i).name + ".dat");          
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);          
                                
                    bufferedWriter.write( Functions.listOfSelectedPlayers.get(i).name + ".wrl\n" +
"0.0 0.0 180.0		# Translation\n" +
"90.0 1.0 0.0 0.0		# Rotation\n" +
"400.0 400.0 400.0		# Scale"); 
                   
            bufferedWriter.close();}
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + "dat" + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    
    // gera o o bonquinho em 3d vrml
    static void generateWRL(){
        try {  
            for (int i = 0; i < Functions.listOfSelectedPlayers.size(); i++){
            FileWriter fileWriter = new FileWriter("ARToolKit\\bin\\Wrl\\" + Functions.listOfSelectedPlayers.get(i).name + ".wrl");            
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);          
           
            bufferedWriter.write("#VRML V2.0 utf8  \n" +
"\n" +
"# -------------------------------------------------------------\n" +
"# Desenho do corpo de uma pessoa\n" +
"# -------------------------------------------------------------\n" +
"\n" +
"Transform {\n" +
"	scale " + Functions.getScale(Functions.listOfSelectedPlayers.get(i))  + "\n" +
"\n" +
"    children [\n" +
"# Cabeca\n" +
"Transform { \n" +
"    translation 0 11.5 0     \n" +
"    children [  # As transformações pode ter um ou mais \"filhos\" \n" +
"        Shape {  # Estes \"filhos\" são Shapes ou outras transformações\n" +
"	appearance Appearance {\n" +
"		material Material { diffuseColor " + Functions.listOfSelectedPlayers.get(i).color + " }\n" +
"	}\n" +
"	geometry Sphere {radius 1.0 }\n" +
"      }\n" +
"    ]\n" +
"}\n" +
"\n" +
"# Tronco\n" +
"Transform { \n" +
"    translation 0 7 0 \n" +
"    #rotation 0 0 1 0.7853  # eixo e ângulo (em radianos) (1.57 = 90 graus)\n" +
"    #scale 1 1 2 \n" +
"    children [  # As transformações pode ter um ou mais \"filhos\" \n" +
"        Shape {  # Estes \"filhos\" são Shapes ou outras transformações\n" +
"	appearance Appearance {\n" +
"		material Material { diffuseColor " + Functions.listOfSelectedPlayers.get(i).color + " }\n" +
"	}\n" +
"	geometry Box { size 3 7 1 }\n" +
"      }\n" +
"    ]\n" +
"}\n" +
"\n" +
"# Perna direita\n" +
"Transform {\n" +
"    translation 0.9 0 0     \n" +
"    children [  # As transformações pode ter um ou mais \"filhos\" \n" +
"        Shape {  # Estes \"filhos\" são Shapes ou outras transformações\n" +
"	appearance Appearance {\n" +
"		material Material { diffuseColor " + Functions.listOfSelectedPlayers.get(i).color + " }\n" +
"	}\n" +
"	geometry Cylinder {\n" +
"                radius .7\n" +
"                height 7.\n" +
"            }\n" +
"      }\n" +
"    ]\n" +
"}\n" +
"\n" +
"# Perna esquerda\n" +
"Transform {\n" +
"    translation -0.9 0 0     \n" +
"    children [  # As transformações pode ter um ou mais \"filhos\" \n" +
"        Shape {  # Estes \"filhos\" são Shapes ou outras transformações\n" +
"	appearance Appearance {\n" +
"		material Material { diffuseColor " + Functions.listOfSelectedPlayers.get(i).color + " }\n" +
"	}\n" +
"	geometry Cylinder {\n" +
"                radius .7\n" +
"                height 7.\n" +
"            }\n" +
"      }\n" +
"    ]\n" +
"}	\n" +
" ] \n" +
"} ");
            
                
                
            bufferedWriter.close();
            }
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + "algumJogador.wrl" + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
    
    // chama o artoolkit em terminal 
    static void runARtoolkit(){ 
        try {
        //chama o programa do artoolkit gerar a RV
        Process process = Runtime.getRuntime().exec("cmd /c start ARToolKit\\bin\\RA.bat"); //ARToolKit\\bin\\simpleVRML.exe");
        } catch (IOException ex) {
            Logger.getLogger(Functions.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
