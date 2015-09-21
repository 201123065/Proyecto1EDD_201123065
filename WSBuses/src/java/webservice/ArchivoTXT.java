/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author marcosmayen
 */
public class ArchivoTXT {
    public void crearTXT(String nombre, String texto){
        File f;
        FileWriter escritor;
        try{
            f=new File(nombre);
            escritor= new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(escritor);
            PrintWriter salida = new PrintWriter(bw);
            salida.write(texto);
            salida.close();
            bw.close();
        }catch(IOException e){
            System.out.println("error");
        }
    }
}
