public enum Calculadora { SOMA {
    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
},
    SUBTRACAO {
        @Override
        public double calcular(double a, double b) {
            return a - b;
        }
    },
    MULTIPLICACAO {
        @Override
        public double calcular(double a, double b) {
            return a * b;
        }
    },
    DIVISAO {
        @Override
        public double calcular(double a, double b) {
            if (b == 0) {
                throw new ArithmeticException("Divisão por zero!");
            }
            return a / b;
        }
    };

    // Método abstrato implementado por cada operação
    public abstract double calcular(double a, double b);
}

