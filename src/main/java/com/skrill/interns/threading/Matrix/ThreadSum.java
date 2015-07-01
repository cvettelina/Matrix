package com.skrill.interns.threading.Matrix;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

public class ThreadSum implements Callable<BigDecimal> {
    private final BigDecimal[] col;


    public ThreadSum(BigDecimal[] col) {
        this.col = col;
    }

    public BigDecimal call() throws Exception {
        BigDecimal sumResult = BigDecimal.ZERO;
        for (int i = 0; i < col.length; i++) {
            sumResult = sumResult.add(col[i]);
        }
        return sumResult;
    }
}
