/**
 * 
 */
package com.mbh.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.mbh.model.Cell;
import com.mbh.model.Generation;
import com.mbh.model.State;

/**
 * Class RuleOneHundredTen
 * 
 * @author amineboufatah
 *
 */
public class RuleOneHundredTen {

  /** All generations **/
  private List<Generation> generations = new ArrayList<>();

  /** Map containing all 110 rules **/
  private static Map<String, State> rules = new HashMap<String, State>();

  private static final String TRANS_ALIVE_STATE = "1";

  private static final String TRANS_DEAD_STATE = "0";

  static {
    rules.put("000", State.DEAD);
    rules.put("001", State.ALIVE);
    rules.put("010", State.ALIVE);
    rules.put("011", State.ALIVE);
    rules.put("100", State.DEAD);
    rules.put("101", State.ALIVE);
    rules.put("110", State.ALIVE);
    rules.put("111", State.DEAD);
  }

  /**
   * This method determines the next cell's state
   * 
   * @param cells
   * @param position
   * @return State: next state based on current state and neighbours' state
   */
  public State determineNextState(Cell[] cells, int position) {
    int borderLeft = 0;
    int borderRight = cells.length - 1;
    StringBuilder state = new StringBuilder();
    // Left neighbour
    if (position - 1 < borderLeft) {
      state.append(TRANS_ALIVE_STATE);
    } else {
      state.append(getStateAsBinary(cells[position - 1].getState()));
    }
    // Current cell
    state.append(getStateAsBinary(cells[position].getState()));

    // Right neighbour
    if (position + 1 > borderRight) {
      state.append(TRANS_ALIVE_STATE);
    } else {
      state.append(getStateAsBinary(cells[position + 1].getState()));
    }

    return getState(state.toString());
  }

  /**
   * Method that returns the state based on the key.
   * 
   * @param key
   * @return State
   */
  public State getState(String key) {
    return rules.get(key);
  }

  /**
   * Method returns '1' if the cell is alive, '0' if the cell is dead
   * 
   * @param state
   * @return 1 if state is alive and 0 otherwise
   */
  public String getStateAsBinary(State state) {
    if (state == State.ALIVE) {
      return TRANS_ALIVE_STATE;
    }
    return TRANS_DEAD_STATE;
  }

  /**
   * This method returns the last generation generated. It'll be used for generating the next
   * generation
   * 
   * @return Generation: the last generation in the list
   */
  public Generation getLastGeneration() {
    return this.getGenerations().get(this.getGenerations().size() - 1);
  }

  /**
   * Getter generations
   * 
   * @return List<Generation>
   */
  public List<Generation> getGenerations() {
    return generations;
  }

  /**
   * Setter generations
   * 
   * @param generations
   */
  public void setGenerations(List<Generation> generations) {
    this.generations = generations;
  }
}
