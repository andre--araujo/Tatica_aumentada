package tatica_aumentada;

/**
 *
 * @author Andre
 */
public class Tatica_Aumentada {

   
    public static void main(String[] args) {
        
        Functions.readPlayers();
        MainWindow mainWindow = new MainWindow();  //cria a janela
        mainWindow.setVisible(true); //desenha a janela
    }
    
}
