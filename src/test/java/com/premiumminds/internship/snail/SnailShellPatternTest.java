package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void TestMatrix4x4()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 1}, { 4, 5, 6, 4}, { 7, 8, 9, 7}, {7, 8, 9, 7} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 1, 4, 7, 7, 9, 8, 7, 7, 4, 5, 6, 9, 8};
    assertArrayEquals(result, expected);
  }

  @Test
  public void TestMatrix6x6()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 }, { 1, 2, 3, 4, 5, 6 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 6, 6, 6, 6, 6, 5, 4, 3, 2, 1, 1, 1, 1, 1, 2, 3, 4, 5, 5, 5, 5, 4, 3, 2, 2, 2, 3, 4, 4, 3 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void TestMatrix1000x1000()
      throws InterruptedException, ExecutionException, TimeoutException {
    int n = 1000;
    int[][] matrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        matrix[i][j] = 2;
      }
    }
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = new int[n * n];
    for (int i = 0; i < expected.length; i++) {
      expected[i] = 2;
    }
    assertArrayEquals(result, expected);
  }

  @Test
  public void TestMatrix2x3()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2 }, { 4, 5 }, { 6, 7 }};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 5, 7, 6, 4 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void TestMatrix4x2()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 8, 7, 6, 5 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void TestMatrixWith1Column()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1 }, { 4 }, { 6 }};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 4, 6 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void TestMatrixWith1Row()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1 , 2, 3 }};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3 };
    assertArrayEquals(result, expected);
  }

  @Test
  public void TestEmptyMatrix()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { };
    assertArrayEquals(result, expected);
  }

  @Test
  public void Test1ElementMatrix()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1 };
    assertArrayEquals(result, expected);
  }
}