/**
 * 
 */
package com.mbh.model;

/**
 * Class Generation: A generation consists of an array of cells, each cell has a state
 * 
 * @author amineboufatah
 *
 */
public class Generation {

  private Cell[] cells;

  public Generation(int size) {
    cells = new Cell[size];
  }

  public Cell[] getCells() {
    return cells;
  }

  public void setCells(Cell[] cells) {
    this.cells = cells;
  }

}
