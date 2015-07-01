package com.skrill.interns.threading.Matrix;

import java.math.BigDecimal;

public class Matrix {
    private final BigDecimal[][] matrix;
    private final int size;

    public Matrix(BigDecimal[][] matrix) {
        this.matrix = matrix;
        this.size = matrix.length;
    }

    public int getSize() {
        return size;
    }

    public BigDecimal[] getRow(int index) {
        BigDecimal[] row = new BigDecimal[this.size];
        for (int i = 0; i < this.size; i++) {
            row[i] = matrix[index][i];
        }
        return row;
    }

    public BigDecimal[] getCol(int index) {
        BigDecimal[] row = new BigDecimal[this.size];
        for (int i = 0; i < this.size; i++) {
            row[i] = matrix[i][index];
        }
        return row;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(matrix[i][j].toString());
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
