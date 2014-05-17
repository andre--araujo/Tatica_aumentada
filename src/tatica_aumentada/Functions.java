//Conjunto de funcoes e variaveis estaticas para serem usadas por todo o codigo.

package tatica_aumentada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

public class Functions {    
    static ArrayList<Player> listOfPlayers = new ArrayList<>(); //guarda todos os jogadores já cadastrados
    static ArrayList<Player> listOfSelectedPlayers = new ArrayList<>();  //guarda os jogadores selecionados para a RA    
    static DefaultListModel model_listOfPlayers = new DefaultListModel(); //lista na interface grafica com os jogadores disponiveis
    static DefaultListModel model_listOfSelectedPlayers = new DefaultListModel(); //lista na interface grafica com os jogadores escolhidos

    
    static String getColor(int selectedColor){
           if (selectedColor == 0){ //azul
               return "0.0 0.0 1.0";
           }
           
           if (selectedColor == 1){ //verde
               return "0.0 1.0 0.0";
           }
           
           if (selectedColor == 2){ //vermelho
               return "1.0 0.0 0.0";
           }
           
           if (selectedColor == 3){ //amarelo
               return "1.0 1.0 0.0";
           }
           else {return " 0.0 0.0 0.0";} //preto se der errado
    }
    
    //retorna a scale correta da figura baseandos nas proporcoes do jogador (altura, cintura..)
    static String getScale(Player myPlayer){
        
        return  myPlayer.waist/(3*100) +" " + myPlayer.height/(14*100) + " " + myPlayer.waist/(2*100)   ;
    }
    static void readPlayers(){ // le o arquivo Players.txt contendo todos os jogadores ja criados anteriormente e carrega seus dados
        
        String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader("Players.txt");
            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                String[] parts = line.split("/");
                Functions.listOfPlayers.add(new Player(parts[2], parts[3], Float.parseFloat(parts[4]), Float.parseFloat(parts[1]), Float.parseFloat(parts[5]), parts[0]));
            }	

            // Always close files.
            bufferedReader.close();			
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                "Players.txt" + "'");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + "Players.txt" + "'");					
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
    }
    
    static void writePlayers(){ // roda array listofplayers e salva todos os dados em um txt.
        try {
            // Assume default encoding.
            FileWriter fileWriter = new FileWriter("Players.txt");
            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            // Note that write() does not automatically
            // append a newline character.
            for (int i = 0; i < listOfPlayers.size(); i++){ // escrevo todas info de cada jogador em uma linha separando os dados com "/"
                bufferedWriter.write(listOfPlayers.get(i).color + "/" + 
                                     listOfPlayers.get(i).height + "/" + 
                                     listOfPlayers.get(i).name + "/" + 
                                     listOfPlayers.get(i).picture + "/" + 
                                     listOfPlayers.get(i).shoulders + "/" + 
                                     listOfPlayers.get(i).waist);
                bufferedWriter.newLine();
            }            
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + "Players.txt" + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
    }
        
}
