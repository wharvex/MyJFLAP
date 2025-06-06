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
import org.wharvex.jflap.gui.grammar.transform.ChomskyPane;

import java.awt.event.ActionEvent;

/**
 * This is a simple test action for grammars.
 *
 * @author Thomas Finley
 */

public class GrammarTestAction extends GrammarAction {
  /**
   * Instantiates a new <CODE>GrammarOutputAction</CODE>.
   *
   * @param environment the grammar environment
   */
  public GrammarTestAction(GrammarEnvironment environment) {
    super("Grammar Test", null);
    this.environment = environment;
    this.frame = Universe.frameForEnvironment(environment);
  }

  /**
   * Performs the action.
   */
  public void actionPerformed(ActionEvent e) {
    Grammar g = environment.getGrammar(UnrestrictedGrammar.class);
    if (g == null)
      return;
    ChomskyPane cp = new ChomskyPane(environment, g);
    environment.add(cp, "Test", new CriticalTag() {
    });
    environment.setActive(cp);
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
