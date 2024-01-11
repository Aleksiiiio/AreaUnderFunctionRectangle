
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Program do obliczania pola pod wykresem funkcji - metoda prostokątów
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj stopień wielomianu: ");
        int degree = scanner.nextInt();

        double[] coefficients = getCoefficients(degree);

        for (int i = 0; i < coefficients.length; i++){
            System.out.printf("%.1fx^%.0f +",coefficients[i],(coefficients.length - 1 - i));
        }

        System.out.println("Podaj wartości początku i końca przedziału");
        double start = scanner.nextDouble();
        double end = scanner.nextDouble();
        System.out.println("Podaj liczbe przedziałów iteracji");
        int n = scanner.nextInt();

        double area = calculateArea(coefficients,start,end,n);
        System.out.printf("Pole pod wykresem funkcji w przedziale (%.2f, %.2f) wynosi: %.2f ",start,end,area);

    }

    public static double[] getCoefficients(int degree){
        Scanner scanner = new Scanner(System.in);
        double[] coefficient = new double[degree + 1];
        System.out.println("Proszę podać współczynniki kolejnych potęg");
        for (int i = 0; i < coefficient.length; i++){
            coefficient[i] = scanner.nextDouble();
        }
        return coefficient;
    }

    public static double getValueY(double[] coefficient, double valueX){
        double valueY = 0;
        int size = coefficient.length;
        for (int i = 0; i < size; i++){
            valueY += coefficient[i] * Math.pow(valueX, size - 1 - i);
        }
        return valueY;
    }

    public static double calculateArea(double[] coefficients,double start, double end, int n) {
        double delta = (end - start) / n;
        double area = 0;

        // temp = start + delta * i + delta / 2;

        // f(x) = 2x^2 - 3x + 1
        // area += 2 * Math.pow(temp, 2) -3 * temp + 1;

        // f(x) = x
        // area += temp;
        double temp;
        for (int i = 0; i < n; i++) {
            temp = start + delta * i + delta / 2;
            area += getValueY(coefficients,temp);
        }
        return Math.abs(area * delta);
    }
}