import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculadora {
    // Cálculos
    public static Double calcular(String expresion) {
        int posicionOperador = 0;
        Double resultado = 0.0;

        List<String> operadores = new ArrayList<>(Arrays.asList("+","-","*","/"));
        for (String item : operadores) {
            posicionOperador = expresion.indexOf(item,0);
            if (posicionOperador != -1) {
                System.out.println("posicion: " + posicionOperador);
                break;
            }
        }

        Double numero1 = Double.parseDouble(expresion.substring(0, posicionOperador));
        String operador = expresion.substring(posicionOperador, posicionOperador + 1);
        Double numero2 = Double.parseDouble(expresion.substring(posicionOperador + 1));

        switch (operador) {
            case "+":
                resultado = numero1 + numero2;
                break;

            case "-":
                resultado = numero1 - numero2;
                break;

            case "/":
                resultado = numero1 / numero2;
                break;

            case "*":
                resultado = numero1 * numero2;
                break;
            default:
                break;
        }
        
        return resultado;
    }    
}
