/**
 * 
 */
package com.mbh.application;

import com.mbh.controller.RuleGeneratorController;
import com.mbh.model.Cell;
import com.mbh.model.Generation;
import com.mbh.model.State;

/**
 * @author amineboufatah
 *
 */
public class Application {

  /**
   * Best example (Wikipedia): **_*____*__*___*_____*______** the stars are considered to be the
   * alive cells, underscore mean that the cell is dead.
   * 
   * If you enter other characters other than '*' or '_' the character will be taken as a dead cell
   * 
   * @param args
   */
  public static void main(String[] args) {
    String line = args.length > 0 ? args[0] : "**_*____*__*___*_____*______**";
    String[] lineSplitted = line.split("|_|\\*|");
    Generation firstGeneration = new Generation(lineSplitted.length);
    int position = 0;
    for (String val : lineSplitted) {
      firstGeneration.getCells()[position] =
          val.equals("*") ? new Cell(State.ALIVE) : new Cell(State.DEAD);
      position++;
    }

    RuleGeneratorController ruleController = new RuleGeneratorController();
    ruleController.generateGenerations(firstGeneration, 150, lineSplitted.length);
  }

}
