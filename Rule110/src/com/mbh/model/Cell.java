/**
 * 
 */
package com.mbh.model;

/**
 * Class Cell: a cell has a state, it's either dead or alive
 * 
 * @author amineboufatah
 *
 */
public class Cell {

  private State state;

  public Cell(State state) {
    this.state = state;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }
}
