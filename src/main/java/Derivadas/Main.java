/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Derivadas;
import java.util.Scanner;
/**
 *
 * @author danie
 */
public class Main {
    public static void main(String[] args){
        Derivadas derivada = new Derivadas();
        
        System.out.println(derivada.derivadaImplicita("x^2+y^2-25", "x", "y"));
    }
}
