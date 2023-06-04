package com.premiumminds.internship.snail;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  private int order_index = 0;
  private int actual_row = 0;
  private int actual_column = 0;

  /**
   * Method to get snailshell pattern
   * 
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {
    
    int[] order = new int[matrix.length * matrix[0].length]; // the result matrix 
    boolean[][] already_persued = new boolean[matrix.length][matrix[0].length]; // true => already persued; false otherwise
    char direction = matrix.length == 1 ? 'd' : 'r'; // r -> right; d -> down; l -> left; u -> up

    if (matrix.length == 0 && matrix[0].length == 0) { // retorna a matrix [] caso a matrix seja vazia
      return CompletableFuture.completedFuture(new int[0]);
    }

    while (order_index < order.length) {
      switch(direction) {
        case 'r':
          order = goThroughRightElements(matrix, already_persued, order);
          direction = 'd';
          break;
        case 'd':
          order = goThroughDownElements(matrix, already_persued, order);
          direction = 'l';
          break;
        case 'l':
          order = goThroughLeftElements(matrix, already_persued, order);
          direction = 'u';
          break;
        case 'u':
          order = goThroughUpElements(matrix, already_persued, order);
          direction = 'r';
          break;
      }
    }
    return CompletableFuture.completedFuture(order);
  };

  private int[] goThroughUpElements(int[][] matrix, boolean[][] already_persued, int[] order) {
    for (int i = matrix.length - 1; i >= 0 ; i--) {
      if (!already_persued[i][actual_column]) { //enquanto os elementos forem falsos (nao tiverem sido percorridos)
        order[order_index] = matrix[i][actual_column];
        already_persued[i][actual_column] = true;
        order_index++;
        this.actual_row = i; //muda o index da linha atual para o index da linha do ultimo elemento a ser percorrido
      }
    }
    return order;
  }

  private int[] goThroughLeftElements(int[][] matrix, boolean[][] already_persued, int[] order) {
    for (int j = matrix[0].length - 1; j >= 0; j--) { // percorre a linha atual da matrix
      if (!already_persued[actual_row][j]) { //enquanto os elementos forem falsos (nao tiverem sido percorridos)
        order[order_index] = matrix[actual_row][j];
        already_persued[actual_row][j] = true;
        order_index++;
        this.actual_column = j; //muda o index da coluna atual para o index da coluna do ultimo elemento a ser percorrido
      }
    }
    return order;
  }

  private int[] goThroughDownElements(int[][] matrix, boolean[][] already_persued, int[] order) {
    for (int i = 0; i < matrix.length; i++) {
      if (!already_persued[i][actual_column]) { //enquanto os elementos forem falsos (nao tiverem sido percorridos)
        order[order_index] = matrix[i][actual_column];
        already_persued[i][actual_column] = true;
        order_index++;
        this.actual_row = i; //muda o index da linha atual para o index da linha do ultimo elemento a ser percorrido
      }
    }
    return order;
  }

  public int[] goThroughRightElements(int[][] matrix, boolean[][] already_persued, int[] order) {
    for (int j = 0; j < matrix[0].length; j++) { // percorre a linha atual da matrix
      if (!already_persued[actual_row][j]) { //enquanto os elementos forem falsos (nao tiverem sido percorridos)
        order[order_index] = matrix[actual_row][j];
        already_persued[actual_row][j] = true;
        order_index++;
        this.actual_column = j; //muda o index da coluna atual para o index da coluna do ultimo elemento a ser percorrido
      }
    }
    return order;
  }
}
