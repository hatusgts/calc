package Integrais;

import org.matheclipse.core.eval.ExprEvaluator;

public class Integrais {

    public static String calcularIntegralDefinida(String expressao, String limiteInf, String limiteSup) {
        String indefinida = "x";
        ExprEvaluator util = new ExprEvaluator(false,(short) 100);
        
        String integral = "Integrate(" + expressao + ", {" + indefinida + ", " + limiteInf + ", " + limiteSup + "})";

        try {
            return util.evaluate(integral).toString();
        } catch (Exception e) {
            return "Erro ao tentar calcular integral. Verifique a expressão inserida";
        }
    }

    public static String calcularIntegralIndefinida(String expressao, String valorX) {
        String indefinida = "x";
        ExprEvaluator util = new ExprEvaluator(false,(short) 100);
        
        String integral = "Integrate(" +  expressao + "," + indefinida + ")";
        
        try {
            String resultadoSimb = util.evaluate(integral).toString();

            if (valorX == null || valorX.isEmpty()) {
                return resultadoSimb;
            } else {
                String expressaoNum = resultadoSimb.replace(indefinida, "(" + valorX + ")");
                String valorNum = util.evaluate(expressaoNum).toString();
                return "Integral simbólica: " + resultadoSimb + "\nIntegral numérica em x = " + valorX + ": " + valorNum;
            }
            
        } catch (Exception e) {
            return "Erro ao tentar calcular integral. Verifique a expressão inserida";
        }

    }

}
