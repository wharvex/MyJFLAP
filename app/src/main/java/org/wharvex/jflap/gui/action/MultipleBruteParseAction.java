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


package org.wharvex.jflap.gui.action;

import org.wharvex.jflap.grammar.Grammar;
import org.wharvex.jflap.grammar.UnrestrictedGrammar;
import org.wharvex.jflap.gui.environment.EnvironmentFrame;
import org.wharvex.jflap.gui.environment.GrammarEnvironment;
import org.wharvex.jflap.gui.environment.Universe;
import org.wharvex.jflap.gui.environment.tag.CriticalTag;
import org.wharvex.jflap.gui.grammar.parse.BruteParsePane;

import java.awt.Component;
import java.awt.event.ActionEvent;

/**
 * This action creates a new brute force parser for the grammar.
 *
 * @author Thomas Finley
 */

public class MultipleBruteParseAction extends GrammarAction {
  /**
   * Instantiates a new <CODE>BruteParseAction</CODE>.
   *
   * @param environment the grammar environment
   */
  public MultipleBruteParseAction(GrammarEnvironment environment) {
    super("Multiple Brute Force Parse", null);
    this.environment = environment;
    this.frame = Universe.frameForEnvironment(environment);
  }

  /**
   * Performs the action.
   */
  public void actionPerformed(ActionEvent e) {
    performAction((Component) e.getSource());
  }

  public void performAction(Component source) {
    Grammar g = environment.getGrammar(UnrestrictedGrammar.class);
    if (g == null)
      return;
    MultipleSimulateAction mult = new MultipleSimulateAction(g, environment);
    mult.performAction(source);
  }

  /**
   * The grammar environment.
   */
  private GrammarEnvironment environment;

  /**
   * The frame for the grammar environment.
   */
  private EnvironmentFrame frame;
}
