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
        if ((mode == 1 && matrix1.getRows() == matrix2.getRows() && matrix1.getColums() == matrix2.getColums()) || (mode == 2 && matrix1.getColums() == matrix2.getRows())) {
            return true;
        }
        return false;
    }

}
