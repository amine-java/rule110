/**
 * 
 */
package com.mbh.view;

import com.mbh.model.Cell;
import com.mbh.model.Generation;
import com.mbh.model.State;

/**
 * @author amineboufatah
 *
 */
public class ConsoleView implements GenerationViewer {

  /* (non-Javadoc)
   * @see com.mbh.view.GenerationViewer#displayGeneration(com.mbh.model.Generation)
   */
  @Override
  public void displayGeneration(Generation generation) {
    StringBuilder line = new StringBuilder();
    for (Cell cell : generation.getCells()) {
      line.append("|");
      if (cell.getState() == State.ALIVE) {
        line.append("*");
      } else {
        line.append(" ");
      }
    }
    System.out.println(line.toString());
  }

}
