package model;

import controller.Validation;

public class Matrix {

    private int rows;
    private int colums;
    private int[][] data;

    public Matrix() {
    }

    public Matrix(int rows, int colums, int[][] data) {
        this.rows = rows;
        this.colums = colums;
        this.data = data;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColums() {
        return colums;
    }

    public void setColums(int colums) {
        this.colums = colums;
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

    public Matrix additionMatrix(Matrix matrix) {
        int row = rows;
        int col = colums;
        int res[][] = new int[rows][colums];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = data[i][j] + matrix.getData()[i][j];
            }
        }
        Matrix matrix3 = new Matrix(row, col, res);
        return matrix3;
    }

    public Matrix subtractionMatrix(Matrix matrix) {
        int row = rows;
        int col = colums;
        int res[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = data[i][j] - matrix.getData()[i][j];
            }
        }
        Matrix matrxRes = new Matrix(row, col, res);
        return matrxRes;

    }

    public Matrix multiplicationMatrix(Matrix matrix) {
        int row1 = rows;
        int col1 = colums;
        int col2 = matrix.getColums();
        int res[][] = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                res[i][j] = 0;
                for (int k = 0; k < col1; k++) {
                    res[i][j] += data[i][k] * matrix.getData()[k][j];
                }
            }
        }
        Matrix matrix3 = new Matrix(row1, col2, res);
        return matrix3;
    }

    public void inputMatrix(String msg) {
        Validation v = new Validation();
        rows = v.getInt("Enter Row Matrix" + msg + ": ", 1, Integer.MAX_VALUE);
        colums = v.getInt("Enter Colum Matrix" + msg + ": ", 1, Integer.MAX_VALUE);
        data = new int[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                data[i][j] = v.getInt("Enter matrix1[" + (i + 1) + "][" + (j + 1) + "]: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
    }

    public void displayMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                System.out.print("[" + data[i][j] + "]");
            }
            System.out.println("");
        }
    }

}
