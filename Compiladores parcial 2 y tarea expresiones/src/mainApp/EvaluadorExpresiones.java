/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainApp;

/**
 *
 * @author hillm
 */
import java.util.Scanner;
import java.util.Stack;

public class EvaluadorExpresiones {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese una expresion aritmetica: ");
        String expresion = scanner.nextLine();

        try {
            int resultado = evaluarExpresion(expresion);
            System.out.println("Resultado: " + resultado);
        } catch (Exception e) {
            System.out.println("Expresion no valida.");
        }

        scanner.close();
    }

    public static int evaluarExpresion(String expresion) throws Exception {
        Stack<Integer> numeros = new Stack<>();
        Stack<Character> operadores = new Stack<>();

        for (char c : expresion.toCharArray()) {
            if (Character.isDigit(c)) {
                int numero = Character.getNumericValue(c);
                numeros.push(numero);
            } else if (esOperadorValido(c)) {
                while (!operadores.isEmpty() && tienePrecedencia(c, operadores.peek())) {
                    char operadorAnterior = operadores.pop();
                    int num2 = numeros.pop();
                    int num1 = numeros.pop();
                    int resultado = aplicarOperador(num1, num2, operadorAnterior);
                    numeros.push(resultado);
                }
                operadores.push(c);
            } else if (!Character.isWhitespace(c)) {
                throw new Exception("Expresion no valida.");
            }
        }

        while (!operadores.isEmpty()) {
            char operador = operadores.pop();
            int num2 = numeros.pop();
            int num1 = numeros.pop();
            int resultado = aplicarOperador(num1, num2, operador);
            numeros.push(resultado);
        }

        if (numeros.size() != 1 || !operadores.isEmpty()) {
            throw new Exception("Expresion no valida.");
        }

        return numeros.pop();
    }

    public static boolean esOperadorValido(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static boolean tienePrecedencia(char operador1, char operador2) {
        if ((operador1 == '*' || operador1 == '/') && (operador2 == '+' || operador2 == '-')) {
            return true;
        }
        return false;
    }

    public static int aplicarOperador(int num1, int num2, char operador) {
        switch (operador) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                if (num2 == 0) {
                    throw new ArithmeticException("Division por cero.");
                }
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Operador no valido: " + operador);
        }
    }
}
