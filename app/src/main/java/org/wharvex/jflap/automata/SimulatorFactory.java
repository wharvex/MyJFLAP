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

import org.wharvex.jflap.automata.fsa.FSAStepWithClosureSimulator;
import org.wharvex.jflap.automata.fsa.FiniteStateAutomaton;
import org.wharvex.jflap.automata.mealy.MealyMachine;
import org.wharvex.jflap.automata.mealy.MealyStepByStateSimulator;
import org.wharvex.jflap.automata.mealy.MooreMachine;
import org.wharvex.jflap.automata.mealy.MooreStepByStateSimulator;
import org.wharvex.jflap.automata.pda.PDAStepWithClosureSimulator;
import org.wharvex.jflap.automata.pda.PushdownAutomaton;
import org.wharvex.jflap.automata.turing.TMSimulator;
import org.wharvex.jflap.automata.turing.TuringMachine;

/**
 * This simulator factory returns the simulator for the type of automaton passed
 * in.
 *
 * @author Thomas Finley
 */

public class SimulatorFactory {
  /**
   * Returns the automaton simulator for this type of automaton.
   *
   * @param automaton the automaton to get the simulator for
   * @return the appropriate automaton simulator for this automaton, or <CODE>null</CODE>
   * if there is no automaton simulator known for this type of
   * automaton
   */
  public static AutomatonSimulator getSimulator(Automaton automaton) {
    if (automaton instanceof FiniteStateAutomaton)
      return new FSAStepWithClosureSimulator(automaton);
    else if (automaton instanceof PushdownAutomaton)
      return new PDAStepWithClosureSimulator(automaton);
    else if (automaton instanceof TuringMachine)
      return new TMSimulator(automaton);
      /*
       * Check for Moore must take place before check for Mealy because Moore
       * is a subclass of Mealy.
       */
    else if (automaton instanceof MooreMachine)
      return new MooreStepByStateSimulator(automaton);
    else if (automaton instanceof MealyMachine)
      return new MealyStepByStateSimulator(automaton);
    return null;
  }
}
