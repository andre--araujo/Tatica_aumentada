//Conjunto de funcoes e variaveis estaticas para serem usadas por todo o codigo.

package tatica_aumentada;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

public class Functions {
    //static Player[] listOfPlayers = new Player[10];
    static ArrayList<Player> listOfPlayers = new ArrayList<>(); //guarda todos os jogadores já cadastrados
    static ArrayList<Player> listOfSelectedPlayers = new ArrayList<>();  //guarda os jogadores selecionados para a RA
    static int red = 0; //Cores..
    static int blue = 1;
    static int green = 2;
    static int white = 3;
    static int black = 4;
    static DefaultListModel model_listOfPlayers = new DefaultListModel(); //lista na interface grafica com os jogadores disponiveis
    static DefaultListModel model_listOfSelectedPlayers = new DefaultListModel(); //lista na interface grafica com os jogadores escolhidos
    
//    static Player findPlayer(String playerName){
//        for (int i = 0; i < listOfPlayers.size(); i++){
//            if (listOfPlayers.get(i).name.equals(playerName)){
//                return listOfPlayers.get(i);
//            }            
//        }
//        //return 0
//    }
    
    
    
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
                Functions.listOfPlayers.add(new Player(parts[2], parts[3], Float.parseFloat(parts[4]), Float.parseFloat(parts[1]), Float.parseFloat(parts[5]), Integer.parseInt(parts[0])));
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
