/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tatica_aumentada;

/**
 *
 * @author Andre
 */
public class Player {
    
    String name;
    String picture; //nome do arquivo da foto de rosto
    String card; // nome do arquivo do cartão
    float shoulders;  // largura dos ombros
    float height;   //altura
    float waist;    //largura da cintura
    int color;     // cor do bonequino

    public Player(String name, String picture, float shoulders, float height, float waist, int color) {
        this.name = name;
        this.picture = picture;
        //this.card = card;
        this.shoulders = shoulders;
        this.height = height;
        this.waist = waist;
        this.color = color;
    }
    
    
}
