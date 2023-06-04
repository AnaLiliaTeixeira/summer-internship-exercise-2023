package com.premiumminds.internship.snail;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  // last index of the array with the order of values that represent a snail shell pattern
  private int orderIndex = 0;

  // index of the current row being persued
  private int actualRow = 0;

  // index of the current column being persued
  private int actualColumn = 0;

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {

    // Verifies if the matrix has no elements
    if (matrix.length == 0 && matrix[0].length == 0) { // returns [] in case matrix = [[]]
      return CompletableFuture.completedFuture(new int[0]);
    }

    int[] order = new int[matrix.length * matrix[0].length]; // the array with the order to be returned
    boolean[][] already_persued = new boolean[matrix.length][matrix[0].length]; // true => already persued; false otherwise
    char direction = 'r'; // the direction to traverse the elements (right, down, left or up)

    while (orderIndex < order.length) {
      switch (direction) {
        case 'r': // right
          for (int j = 0; j < matrix[0].length; j++) {
            traverseRowElements(matrix, already_persued, order, j);
          }
          direction = 'd';
          break;
        case 'd': // down
          for (int i = 0; i < matrix.length; i++) {
            traverseColumnElements(matrix, already_persued, order, i);
          }
          direction = 'l';
          break;
        case 'l': // left
          for (int j = matrix[0].length - 1; j >= 0; j--) {
            traverseRowElements(matrix, already_persued, order, j);
          }
          direction = 'u';
          break;
        case 'u': // up
          for (int i = matrix.length - 1; i >= 0; i--) {
            traverseColumnElements(matrix, already_persued, order, i);
          }
          direction = 'r';
          break;
      }
    }
    return CompletableFuture.completedFuture(order);
  };

  /**
   * Method to traverse the elements of a row 
   * 
   * @param matrix matrix of numbers to go through
   * @param already_persued boolean matrix that indicates whether the element was persued or not
   * @param order the array with all the elements persued
   * @param index current column index of the row being traversed
   */
  private void traverseRowElements(int[][] matrix, boolean[][] already_persued, int[] order, int columnIndex) {
    if (!already_persued[actualRow][columnIndex]) { // while the elements of the actual row have not been persued
      order[orderIndex] = matrix[actualRow][columnIndex];
      already_persued[actualRow][columnIndex] = true;
      this.actualColumn = columnIndex; // changes the index of the actual column to the column's index of the last element persued
      orderIndex++;
    }
  }

  /**
   * Method to traverse the elements of a column 
   * 
   * @param matrix matrix of numbers to go through
   * @param already_persued boolean matrix that indicates whether the element was persued or not
   * @param order the array with all the elements persued
   * @param index current row index of the column being traversed
   */
  private void traverseColumnElements(int[][] matrix, boolean[][] already_persued, int[] order, int rowIndex) {
    if (!already_persued[rowIndex][actualColumn]) { // while the elements of the actual column have not been persued
      order[orderIndex] = matrix[rowIndex][actualColumn];
      already_persued[rowIndex][actualColumn] = true;
      this.actualRow = rowIndex; // changes the index of the actual row to the row's index of the last element persued
      orderIndex++;
    }
  }
}
