package model;

import controller.Validation;

public class Matrix {

    private int[][] data;

    public Matrix() {
    }

    public Matrix(int[][] data) {
        this.data = data;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public Validation getI() {
        return i;
    }

    public void setI(Validation i) {
        this.i = i;
    }

    private Validation i = new Validation();

    public void additionMatrix(Matrix matrix) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = data[i][j] + matrix.getData()[i][j];
            }
        }
    }

    public void subtractionMatrix(Matrix matrix) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                data[i][j] = data[i][j] - matrix.getData()[i][j];
            }
        }
    }

    public int[][] multiplicationMatrix(Matrix matrix) {
        int res[][] = new int[data.length][matrix.getData()[0].length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < matrix.getData()[0].length; j++) {
                res[i][j] = 0;
                for (int k = 0; k < data[0].length; k++) {
                    res[i][j] += data[i][k] * matrix.getData()[k][j];
                }
            }
        }
        return res;
    }

    public void inputMatrix(String msg) {
        Validation v = new Validation();
        int rows = v.getInt("Enter Row Matrix" + msg + ": ", 1, Integer.MAX_VALUE);
        int colums = v.getInt("Enter Colum Matrix" + msg + ": ", 1, Integer.MAX_VALUE);
        data = new int[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                data[i][j] = v.getInt("Enter matrix1[" + (i + 1) + "][" + (j + 1) + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                System.out.print("[" + data[i][j] + "]");
            }
            System.out.println("");
        }
    }

}
