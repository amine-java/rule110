/**
 * 
 */
package com.mbh.controller;

import com.mbh.model.Cell;
import com.mbh.model.Generation;
import com.mbh.model.State;
import com.mbh.service.RuleOneHundredTen;
import com.mbh.view.ConsoleView;
import com.mbh.view.GenerationViewer;

/**
 * RuleGeneratorController
 * 
 * @author amineboufatah
 *
 */
public class RuleGeneratorController {

  /** View **/
  private GenerationViewer view = new ConsoleView();

  /** RuleOneHundredTen Service **/
  private RuleOneHundredTen ruleOneHundred = new RuleOneHundredTen();

  /**
   * This method generate (maxSize) generation(s)
   * 
   * @param generation
   * @param maxSize
   * @param size
   */
  public void generateGenerations(Generation generation, int maxSize, int size) {
    view.displayGeneration(generation);
    ruleOneHundred.getGenerations().add(generation);
    int cp = 0;
    while (cp < maxSize) {
      nextGeneration(maxSize, size);
      view.displayGeneration(ruleOneHundred.getLastGeneration());
      cp++;
    }
  }

  /**
   * Generates the next generation.
   * 
   * @param maxSize
   * @param size
   */
  private void nextGeneration(int maxSize, int size) {
    Generation nextGeneration = new Generation(size);
    int position = 0;
    Generation lastGeneration = ruleOneHundred.getLastGeneration();
    while (position <= size - 1) {
      State stateCell = ruleOneHundred.determineNextState(lastGeneration.getCells(), position);
      nextGeneration.getCells()[position] = new Cell(stateCell);
      position++;
    }
    ruleOneHundred.getGenerations().add(nextGeneration);
  }

}
