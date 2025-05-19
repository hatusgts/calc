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
        Scanner scanner = new Scanner(System.in);
        Derivadas deriva = new Derivadas();
        
        System.out.println("""
                           Qual calculadora você deseja usar?
                           1 - Derivada Simples
                           2 - Derivada de Segunda Ordem
                           3 - Derivada Implícita
                           """);
        int escolha = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Digite a expressao: ");
        String expressao = scanner.nextLine();
        
        System.out.println("Digite a variavel: ");
        String variavel = scanner.nextLine();

        
        if(escolha == 1){
            System.out.println("Derivada Simples");
            System.out.println(deriva.calculaDerivada(expressao, variavel));
        }else if(escolha == 2){
            System.out.println("Derivada de Segunda Ordem");
            System.out.println(deriva.calculaDerivadaSegunda(expressao, variavel));
        }else{
            System.out.println("Derivada Implícita");
            System.out.println("Digite o valor da igualdade ex: equação = igualdade: ");
            String igualdade = scanner.nextLine();
            System.out.println(deriva.derivadaImplicita(expressao, igualdade));
        }
    }
}
