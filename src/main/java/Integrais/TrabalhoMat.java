package Integrais;

import java.util.Scanner;
import org.matheclipse.core.eval.ExprEvaluator;

public class TrabalhoMat {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ExprEvaluator util = new ExprEvaluator();
        
        while (true) {
            //Somente expoente
            System.out.print("Insira o valor desejado (ou -1 para sair): ");
            int valor = ler.nextInt();
            
            //Finalzar os teste
            if (valor == -1) {
                System.out.println("Encerrando...");
                break;
            }

            // Cria expressão para integrar x^valor
            String expressao = "Integrate[x^" + valor + ", x]";
            System.out.println("Expressão: " + expressao);
            System.out.println("Resultado: " + util.evaluate(expressao));
            System.out.println();
        }

        ler.close();
    }
}
