// Arquivo: TesteCalculadora.java
public class TesteCalculadora {
    public static void main(String[] args) {
        double x = 10;
        double y = 5;

        System.out.println("Soma: " + Calculadora.SOMA.calcular(x, y));
        System.out.println("Subtração: " + Calculadora.SUBTRACAO.calcular(x, y));
        System.out.println("Multiplicação: " + Calculadora.MULTIPLICACAO.calcular(x, y));
        System.out.println("Divisão: " + Calculadora.DIVISAO.calcular(x, y));
    }
}

