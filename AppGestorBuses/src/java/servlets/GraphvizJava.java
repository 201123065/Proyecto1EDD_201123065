/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author marcosmayen
 */
public class GraphvizJava {
    
    public GraphvizJava(String direccionDot,String direccionPng ){
	try {
      
            String fileInputPath = System.getProperty("user.dir")+"/"+direccionDot;
            String fileOutputPath = System.getProperty("user.dir")+"/"+direccionPng;
            String cmd = "open "+fileInputPath+" -a Graphviz";
            Runtime rt = Runtime.getRuntime();
            rt.getRuntime().exec(cmd);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}