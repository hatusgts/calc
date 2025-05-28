/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Derivadas;
import org.matheclipse.core.interfaces.IExpr;
import org.matheclipse.core.eval.ExprEvaluator;
/**
 *
 * @author danie
 */
public class Derivadas {
    private ExprEvaluator derivaFuncao = new ExprEvaluator();
    
    //Calcula Derivadas Simples, Explicitas e Derivadas Compostas (Regra da Cadeia) //Funciona
    public String calculaDerivada(String expressao, String variavel){
        String entrada = "D(" + expressao + ", " + variavel + ")";
        return derivaFuncao.evaluate(entrada).toString();
    }
    
    //Derivada de Segunda Ordem
    public String calculaDerivadaSegunda(String expressao, String variavel){ //Funcionando
        String entrada = "D(" + expressao + ", " +"{" +variavel + ", 2})";
        return derivaFuncao.evaluate(entrada).toString();
    }
    
    //Derivada Implicita
    public String derivadaImplicita(String equacao, String variavelX, String variavelY) { //Funcionando
        String X = derivaFuncao.evaluate("D(" + equacao + ", "+ variavelX +")").toString();
        String Y = derivaFuncao.evaluate("D(" + equacao + ", "+ variavelY +")").toString();
        return derivaFuncao.evaluate("Simplify[-(" + X + ")/(" + Y + ")]").toString();
    }
    
    //Calcula derivada Implicita de Segunda Ordem
    public String segundaDerivadaImplicita(String equacao, String variavelX, String variavelY){ //Funcionando
        //Calculando as derivadas de primeira Ordem
        String Fx = derivaFuncao.evaluate("D(" + equacao + ", "+ variavelX +")").toString();
        String Fy = derivaFuncao.evaluate("D(" + equacao + ", "+ variavelY +")").toString();
        
        //Calcula derivada de Segunda Ordem
        String Fxx = derivaFuncao.evaluate("D(D(" + equacao + ", "+ variavelX +"), "+ variavelX +")").toString();
        String Fxy = derivaFuncao.evaluate("D(D(" + equacao + ", "+ variavelX +"), "+ variavelY +")").toString();
        String Fyy = derivaFuncao.evaluate("D(D(" + equacao + ", "+ variavelY +"), "+ variavelY +")").toString();
        
        String primeiraOrdem = "(-(" + Fx + ")/("+ Fy +"))";
        
        //Formula de Derivação de Segunda Ordem Implícita
        String numerador = "-(" + Fxx + " + 2*(" + Fxy + ")*" + primeiraOrdem + " + (" + Fyy + ")*(" + primeiraOrdem + ")^2)";
        String denominador = Fy;
        
        String derivadaDeSegundaOrdem = "Simplify[("+ numerador +")/("+ denominador +")]";
        return derivaFuncao.evaluate(derivadaDeSegundaOrdem).toString();
    }
    
    //Para calcular na interface, deve passar a variavel que quer derivar em relação a função
    public String derivadaParcial(String expressao, String variavel){//Funcionando
        IExpr derivadaParcial = derivaFuncao.eval("D("+ expressao +", "+ variavel +")");
        return derivadaParcial.toString();
    }
     //Derivada Parcial de segunda Ordem
    public String derivadaParcialSegunda(String expressao, String variavel){//Funcionando
        IExpr derivadaParcial = derivaFuncao.eval("Simplify(D(" + expressao + ", " +"{" +variavel + ", 2}))");
        return derivadaParcial.toString();
    }
}
