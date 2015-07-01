package com.skrill.interns.threading.Matrix;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MatrixManipulator {
    private static ExecutorService executor = Executors.newFixedThreadPool(500);

    public Matrix multiply(BigDecimal[][] leftMatrix, BigDecimal[][] rightMatrix) {
        List<ThreadingMultiply> threads = new ArrayList<ThreadingMultiply>();
        List<Future<BigDecimal>> results = null;
        BigDecimal[][] resultMatrix = new BigDecimal[leftMatrix.length][leftMatrix.length];
        for (int i = 0; i < leftMatrix.length; i++) {
            for (int j = 0; j < leftMatrix.length; j++) {
                ThreadingMultiply threadMultyplicator = new ThreadingMultiply(i, j, leftMatrix, rightMatrix);
                threads.add(threadMultyplicator);
            }
        }
        try {
            results = executor.invokeAll(threads);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 0;
        int j = 0;
        Iterator<Future<BigDecimal>> iterator = results.iterator();
        while (iterator.hasNext()) {
            Future<BigDecimal> resulting = iterator.next();
            try {
                BigDecimal result = resulting.get();
                resultMatrix[i][j] = result;
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            j++;
            if (j == leftMatrix.length) {
                i++;
                j = 0;
            }
        }
        return new Matrix(resultMatrix);
    }

    public BigDecimal[] sum(Matrix a) {
        BigDecimal[] result = new BigDecimal[a.getSize()];
        List<ThreadSum> threads = new ArrayList<ThreadSum>();
        for (int i = 0; i < a.getSize(); i++) {
            ThreadSum threadSumator = new ThreadSum(a.getCol(i));
            threads.add(threadSumator);
        }
        int row = 0;
        List<Future<BigDecimal>> futures = null;
        try {
            futures = executor.invokeAll(threads);
            for (Iterator<Future<BigDecimal>> iterator = futures.iterator(); iterator
                    .hasNext();) {
                Future<BigDecimal> future = iterator.next();
                result[row] = future.get();
                row++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void shutdownThreadPool() {
        executor.shutdown();
    }
}
