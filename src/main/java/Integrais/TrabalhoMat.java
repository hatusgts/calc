package Integrais;

import java.util.Scanner;
import org.matheclipse.core.eval.ExprEvaluator;

public class TrabalhoMat {

    public static void main(String[] args) {
        
    }

    public static void integrasDef(){
        String indefinida = "x";
        
        System.out.println("Você está calculando integral definida");
        Scanner ler = new Scanner(System.in);  
        ExprEvaluator util = new ExprEvaluator(false,(short) 100);  // Criação do avaliador simbólico

        System.out.print("Insira a sua expressão(ex: x^2, x^5...): ");//Solicita a expressão
        String expressao = ler.nextLine();
        
        System.out.print("Insira o limite inferior: ");
        String limiteInf = ler.nextLine();
        
        System.out.print("Insira o limite Superior: ");
        String limiteSup = ler.nextLine();
                
        String integral = "Integrate(" + expressao + ", {" + indefinida + ", " + limiteInf + ", " + limiteSup + "})";
        
        try{
           String resultadoSimb = util.evaluate(integral).toString();
            System.out.println("Integral simbólica: " + resultadoSimb); //Faz a representação simbólica
           
        }catch (Exception e){
            System.out.print("Erro ao tentar calcular integral. Verifique a expressão inserida"); //Se houver algum erro 
        }
    }
    
    
    
    public static void integrasIndef() {
        String indefinida = "x";
        
        System.out.println("Você está calculando integral indefinida");
        Scanner ler = new Scanner(System.in);  
        ExprEvaluator util = new ExprEvaluator(false,(short) 100);  // Criação do avaliador simbólico

        System.out.print("Insira a sua expressão(ex: x^2, x^5...): ");//Solicita a expressão
        String expressao = ler.nextLine();
        
        String integral = "Integrate(" +  expressao + "," + indefinida + ")";
        
        try{
           String resultadoSimb = util.evaluate(integral).toString();
            System.out.println("Integral simbólica: " + resultadoSimb); //Faz a representação simbólica
            
            //FAZER UM POPUP PARA PERGUNTAR SE DESEJA COLOCAR UM VALOR PARA A EXPRESSÃO NUMÉRICA
            //COLOCAR NA INTERFACE FRONT
            
            System.out.print("Agore informe o valor de " + indefinida + ": ");//Pede uma inserção de valor para "X"
            String indef = ler.nextLine();
        
            String expressaoNum = resultadoSimb.replace(indefinida, "(" + indef + ")");
            String valorNum = util.evaluate(expressaoNum).toString();//Transforma em expressão numérica
            System.out.println("Sua integral é: " + valorNum);
        }catch (Exception e){
            System.out.print("Erro ao tentar calcular integral. Verifique a expressão inserida"); //Se houver algum erro 
        }
        
        
        
        
        ler.close();
    }
}
