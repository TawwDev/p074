package controller;

import java.util.Scanner;
import model.Matrix;

public class Validation {

    private Scanner sc = new Scanner(System.in);

    public int getInt(String msg, int min, int max) {
        while (true) {
            try {
                System.out.print(msg);
                int n = Integer.parseInt(sc.nextLine());
                if (n >= min && n <= max) {
                    return n;
                }
                System.err.println("re_input");
            } catch (NumberFormatException nfe) {
                System.err.println("re_input");
            }
        }
    }

    public boolean checkMatrix(Matrix matrix1, Matrix matrix2, int mode) {
        //mode 1: add or sub
        //mode 2: multy
        if ((mode == 1 && matrix1.getData().length == matrix2.getData().length && matrix1.getData()[0].length == matrix2.getData()[0].length)
                || (mode == 2 && matrix1.getData()[0].length == matrix2.getData().length)) {
            return true;
        }
        return false;
    }

}
