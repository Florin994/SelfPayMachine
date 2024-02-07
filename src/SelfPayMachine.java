import java.util.Scanner;

public class SelfPayMachine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti valoare bon:");
        double valBon = sc.nextDouble();
        System.out.println("Introduceti bacnota:");
        double bacnotaIntrodusa = sc.nextInt();
        pay(valBon, bacnotaIntrodusa);
    }

    private static void pay(double valeBon, double bacnotaIntrodusa) {
        Scanner sc = new Scanner(System.in);
        selfPay(sc, valeBon, bacnotaIntrodusa);
    }

    private static void selfPay(Scanner sc, double valBon, double bacnotaIntrodusa) {
        double rest = bacnotaIntrodusa - valBon;
        if (bacnotaIntrodusa > valBon) {
            System.out.printf("Restul dumneavostra este: %.2f%n", rest);
            System.out.println("Ai primit urmatoarele bacnote: ");
            rest = getRest(rest, 200);
            rest = getRest(rest, 100);
            rest = getRest(rest, 50);
            rest = getRest(rest, 20);
            rest = getRest(rest, 10);
            rest = getRest(rest, 5);
            rest = getRest(rest, 1);
            while (rest >= 0.5) {
                rest -= 0.5;
                System.out.print("0.5 ");
            }
            while (rest >= 0.10) {
                rest -= 0.10;
                System.out.print("0.10 ");
            }
            while (rest >= 0.05) {
                rest -= 0.05;
                System.out.print("0.05 ");
            }
            while (rest > 0.01) {
                rest -= 0.01;
                System.out.print("0.01 ");
            }
        } else {
            rest *= -1;
            System.out.printf("Fondutri insuficiente, mai aveti de introdus: %.2f lei\n", rest);
            System.out.println("Introduceti bacnota: ");
            double bacnota = sc.nextDouble();
            selfPay(sc, rest, bacnota);
        }
    }

    private static double getRest(double rest, double money) {
        while (rest >= money) {
            rest -= money;
            System.out.printf("%.2f ", money);
        }
        return rest;
    }
}

