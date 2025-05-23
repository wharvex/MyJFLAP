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
import org.wharvex.jflap.gui.grammar.parse.UserControlParsePane;


import java.awt.event.ActionEvent;

/**
 * Action for User Controlling Parsing
 *
 * @author Kyung Min (Jason) Lee
 */
public class UserControlParseAction extends GrammarAction {


  /**
   * The grammar environment.
   */
  private GrammarEnvironment environment;

  /**
   * The frame for the grammar environment.
   */
  private EnvironmentFrame frame;

  /**
   * Instantiates a new <CODE>BruteParseAction</CODE>.
   *
   * @param environment the grammar environment
   */
  public UserControlParseAction(GrammarEnvironment environment) {
    super("User Control Parse", null);
    this.environment = environment;
    this.frame = Universe.frameForEnvironment(environment);
  }

  public static boolean isApplicable(Object object) {
    return object instanceof Grammar;
  }

  /**
   * Performs the action.
   */
  public void actionPerformed(ActionEvent e) {
    Grammar g = environment.getGrammar(UnrestrictedGrammar.class);
    if (g == null)
      return;
    UserControlParsePane userPane = new UserControlParsePane(environment, g);
    environment.add(userPane, "User Control Parser", new CriticalTag() {
    });
    environment.setActive(userPane);
  }
}
