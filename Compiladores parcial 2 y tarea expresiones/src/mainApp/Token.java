/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainApp;

/**
 *
 * @author mr_pu
 */
public class Token {
    public int id_token;
    public String lexema;
    public String tipo_lexema;
    public int fila;
    public int columna;
    
    public Token(int id_Token, String lexema, String tipo_lexema, int fila, int columna ){
    
        this.id_token = id_token;
        this.lexema = lexema;
        this.tipo_lexema = tipo_lexema;
        this.columna = columna;
        this.fila = fila;
       
    }
    
}


