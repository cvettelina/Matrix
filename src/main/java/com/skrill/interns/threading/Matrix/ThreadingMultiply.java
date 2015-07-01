package com.skrill.interns.threading.Matrix;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class ThreadingMultiply implements Callable<BigDecimal> {
    private final BigDecimal[][] matrix1;
    private final BigDecimal[][] matrix2;
    private final int index;
    private final int index2;

    public ThreadingMultiply(int index, int index2, BigDecimal[][] m1, BigDecimal[][] m2) {
        this.matrix1 = m1;
        this.matrix2 = m2;
        this.index = index;
        this.index2 = index2;
    }

    public BigDecimal call() throws Exception {
        BigDecimal multiplyResult = BigDecimal.ZERO;
        for (int i = 0; i < matrix1.length; i++) {
            multiplyResult = multiplyResult.add(matrix1[index][i].multiply(matrix2[i][index2]));

        }
        return multiplyResult;
    }
}
