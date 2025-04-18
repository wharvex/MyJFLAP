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

import org.wharvex.jflap.automata.*;
import org.wharvex.jflap.automata.fsa.FiniteStateAutomaton;
import org.wharvex.jflap.automata.graph.*;
import org.wharvex.jflap.automata.graph.layout.GEMLayoutAlgorithm;
import org.wharvex.jflap.grammar.Production;
import org.wharvex.jflap.grammar.reg.RightLinearGrammar;
import org.wharvex.jflap.grammar.reg.RightLinearGrammarToFSAConverter;
import org.wharvex.jflap.gui.environment.GrammarEnvironment;
import org.wharvex.jflap.gui.environment.Universe;
import org.wharvex.jflap.gui.environment.tag.CriticalTag;
import org.wharvex.jflap.gui.grammar.convert.ConvertPane;

import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * This is the action that initiates the conversion of right linear grammar to
 * an FSA.
 *
 * @author Thomas Finley
 * @see gui.grammar.convert.ConvertPane
 * @see grammar.reg.RightLinearGrammarToFSAConverter
 */

public class ConvertRegularGrammarToFSA extends GrammarAction {
  /**
   * Instantiates a new <CODE>GrammarOutputAction</CODE>.
   *
   * @param environment the grammar environment
   */
  public ConvertRegularGrammarToFSA(GrammarEnvironment environment) {
    super("Convert Right-Linear Grammar to FA", null);
    this.environment = environment;
  }

  /**
   * Performs the action.
   */
  public void actionPerformed(ActionEvent e) {
    // Construct the regular grammar.
    RightLinearGrammar grammar = (RightLinearGrammar) environment
        .getGrammar(RightLinearGrammar.class);
    if (grammar == null)
      return;
    if (grammar.getProductions().length == 0) {
      JOptionPane.showMessageDialog(Universe
              .frameForEnvironment(environment),
          "The grammar should exist.");
      return;
    }

    // Create the initial automaton.
    FiniteStateAutomaton fsa = new FiniteStateAutomaton();
    RightLinearGrammarToFSAConverter convert =
        new RightLinearGrammarToFSAConverter();
    convert.createStatesForConversion(grammar, fsa);
    AutomatonGraph graph = new AutomatonGraph(fsa);
    // Create the map of productions to transitions.
    HashMap ptot = new HashMap();
    Production[] prods = grammar.getProductions();
    for (int i = 0; i < prods.length; i++) {
      Transition t = convert.getTransitionForProduction(prods[i]);
      graph.addEdge(t.getFromState(), t.getToState());
      ptot.put(prods[i], t);
    }
    // Add the view to the environment.
    final ConvertPane cp = new ConvertPane(grammar, fsa, ptot, environment);
    environment.add(cp, "Convert to FA", new CriticalTag() {
    });
    Rectangle r = cp.getEditorPane().getAutomatonPane().getVisibleRect();
    LayoutAlgorithm layout = new GEMLayoutAlgorithm();
    layout.layout(graph, null);
    graph.moveAutomatonStates();
    environment.setActive(cp);
    environment.validate();
    cp.getEditorPane().getAutomatonPane().fitToBounds(20);
  }

  /**
   * The grammar environment.
   */
  private GrammarEnvironment environment;
}
