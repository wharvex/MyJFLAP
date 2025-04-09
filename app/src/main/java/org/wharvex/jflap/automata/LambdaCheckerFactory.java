/*
 *  JFLAP - Formal Languages and Automata Package
 *
 *
 *  Susan H. Rodger
 *  Computer Science Department
 *  Duke University
 *  August 27, 2009

 *  Copyright (c) 2002-2009
 *  All rights reserved.

 *  JFLAP is open source software. Please see the LICENSE for terms.
 *
 */


package org.wharvex.jflap.automata;

import org.wharvex.jflap.automata.fsa.FSALambdaTransitionChecker;
import org.wharvex.jflap.automata.fsa.FiniteStateAutomaton;
import org.wharvex.jflap.automata.mealy.MealyLambdaTransitionChecker;
import org.wharvex.jflap.automata.mealy.MealyMachine;
import org.wharvex.jflap.automata.pda.PDALambdaTransitionChecker;
import org.wharvex.jflap.automata.pda.PushdownAutomaton;
import org.wharvex.jflap.automata.turing.TMLambdaTransitionChecker;
import org.wharvex.jflap.automata.turing.TuringMachine;

/**
 * This lambda checker factory returns a lambda transition checker for the type
 * of automaton passed in.
 *
 * @author Ryan Cavalcante
 */

public class LambdaCheckerFactory {
  /**
   * Returns the lambda transition checker for the type of automaton that
   * <CODE>automaton</CODE> is.
   *
   * @param automaton the automaton to get the checker for
   * @return the lambda transition checker for the type of automaton that
   * <CODE>automaton</CODE> is or <CODE>null</CODE> if there is no
   * lambda transition checker for this type of automaton
   */
  public static LambdaTransitionChecker getLambdaChecker(
      Automaton automaton) {
    if (automaton instanceof FiniteStateAutomaton)
      return new FSALambdaTransitionChecker();
    else if (automaton instanceof PushdownAutomaton)
      return new PDALambdaTransitionChecker();
    else if (automaton instanceof TuringMachine)
      return new TMLambdaTransitionChecker();
    else if (automaton instanceof MealyMachine)
      return new MealyLambdaTransitionChecker();
    return null;
  }

}
