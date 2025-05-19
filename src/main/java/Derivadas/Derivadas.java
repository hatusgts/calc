/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Derivadas;
import java.util.concurrent.TimeUnit;
import org.matheclipse.core.eval.ExprEvaluator;
/**
 *
 * @author danie
 */
public class Derivadas {
    //Calcula Derivadas Simples e Derivadas Compostas (Regra da Cadeia)
    public String calculaDerivada(String expressao, String variavel){
        ExprEvaluator derivada = new ExprEvaluator();
        String entrada = "D(" + expressao + ", " + variavel + ")";
        return derivada.evaluate(entrada).toString();
    }
    
    public String calculaDerivadaSegunda(String expressao, String variavel){
        ExprEvaluator segundaOrdem = new ExprEvaluator();
        String entrada = "D(" + expressao + ", " +"{" +variavel + ", 2})";
        return segundaOrdem.evaluate(entrada).toString();
    }
    
    public String derivadaImplicita(String expressao, String igualdade){
        //Cria a expressão da biblioteca pra calcular a derivada
        ExprEvaluator derivadaImplicita = new ExprEvaluator();
        String equacaox = "D(" + expressao + ", x)";
        String resultado = derivadaImplicita.evaluate(equacaox).toString();
        String equacaoy = "D("+expressao + ", y)";
        String resultadoy = derivadaImplicita.evaluate(equacaoy).toString();
        String solveImplicita = "Solve(" + resultado + ", "+igualdade+")";
        return derivadaImplicita.evaluate(resultadoy).toString();
    }
    
    
//    public String derivadaImplicita(String expressao, String igualdade){
//        ExprEvaluator derivadaImplicita = new ExprEvaluator();
//        
//        // Deriva ambos os lados diretamente na equação e resolve para D(y,x)
//        String solveImplicita = "Solve(D(" + expressao + ", x) == D(" + igualdade + ", x), D(y,x))";
//        
//        return derivadaImplicita.evaluate(solveImplicita).toString();
//    }
}
