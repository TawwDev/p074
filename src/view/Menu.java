package view;

import controller.Validation;
import model.Matrix;

public class Menu {

    public void dislayResult(String msg) {
        Validation v = new Validation();
        Matrix matrix1 = new Matrix();
        Matrix matrix2 = new Matrix();
        matrix1.inputMatrix("1");
        matrix2.inputMatrix("2");
        System.out.println("-------------Result-------------");
        matrix1.displayMatrix();
        System.out.println(msg);
        matrix2.displayMatrix();
        System.out.println("=");
        if (v.checkMatrix(matrix1, matrix2, 1) && msg.equals("+")) {
            matrix1.additionMatrix(matrix2);
            matrix1.displayMatrix();
        } else if (v.checkMatrix(matrix1, matrix2, 1) && msg.equals("-")) {
            matrix1.subtractionMatrix(matrix2);
            matrix1.displayMatrix();
        } else if (v.checkMatrix(matrix1, matrix2, 2) && msg.equals("*")) {
            Matrix res = new Matrix(matrix1.multiplicationMatrix(matrix2));
            res.displayMatrix();
        } else {
            System.out.println("Invalid operation specified.");
        }
    }

    private void menuChoice() {
        System.out.println("==========Caculator program==========");
        System.out.println("1.Addition Matrix");
        System.out.println("2.Subtraction Matrix");
        System.out.println("3.Multiplication Matrix");
        System.out.println("4.Quit");
    }

    public void menu() {
        Validation i = new Validation();
        Matrix mo = new Matrix();
        int n;

        do {
            menuChoice();
            n = i.getInt("Your choice: ", 1, 4);
            switch (n) {
                case 1:
                    System.out.println("-------------Addition-------------");
                    dislayResult("+");
                    break;
                case 2:
                    System.out.println("-------------Subtraction-------------");
                    dislayResult("-");
                    break;
                case 3:
                    System.out.println("-------------Multiplication-------------");
                    dislayResult("*");
                    break;
                case 4:
                    System.out.println("");
                    break;
            }
        } while (n != 4);
    }
}
