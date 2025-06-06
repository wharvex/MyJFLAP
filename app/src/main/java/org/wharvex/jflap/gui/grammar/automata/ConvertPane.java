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


package org.wharvex.jflap.gui.grammar.automata;

import org.wharvex.jflap.automata.Automaton;
import org.wharvex.jflap.gui.SplitPaneFactory;
import org.wharvex.jflap.gui.TableTextSizeSlider;
import org.wharvex.jflap.gui.editor.ArrowDisplayOnlyTool;
import org.wharvex.jflap.gui.environment.AutomatonEnvironment;
import org.wharvex.jflap.gui.grammar.GrammarTable;
import org.wharvex.jflap.gui.grammar.GrammarTableModel;
import org.wharvex.jflap.gui.viewer.AutomatonPane;
import org.wharvex.jflap.gui.viewer.SelectionDrawer;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

/**
 * This <CODE>ConvertPane</CODE> exists for the user to convert an automaton
 * to a grammar.
 *
 * @author Thomas Finley
 */

public class ConvertPane extends JPanel {
  /**
   * Instantiates a new <CODE>ConvertPane</CODE>.
   */
  public ConvertPane(AutomatonEnvironment environment, Automaton automaton) {
    super(new BorderLayout());
    drawer = new SelectionDrawer(automaton);
    automatonPane = new AutomatonPane(drawer);
    JSplitPane split = SplitPaneFactory.createSplit(environment, true, 0.6,
        automatonPane, new JScrollPane(table));
    automatonPane.addMouseListener(new ArrowDisplayOnlyTool(automatonPane,
        automatonPane.getDrawer()));
    add(split, BorderLayout.CENTER);
    add(new TableTextSizeSlider(table), BorderLayout.SOUTH);
  }

  /**
   * Returns the <CODE>AutomatonPane</CODE> that does the drawing.
   *
   * @return the <CODE>AutomatonPane</CODE> that does the drawing
   */
  public AutomatonPane getAutomatonPane() {
    return automatonPane;
  }

  /**
   * Returns the <CODE>SelectionDrawer</CODE> for the automaton pane.
   *
   * @return the <CODE>SelectionDrawer</CODE>
   */
  public SelectionDrawer getDrawer() {
    return drawer;
  }

  /**
   * Returns the <CODE>GrammarTable</CODE> where the grammar is being built.
   *
   * @return the <CODE>GrammarTable</CODE>
   */
  public GrammarTable getTable() {
    return table;
  }

  /**
   * The automaton pane.
   */
  private AutomatonPane automatonPane;

  /**
   * The grammar table.
   */
  private GrammarTable table = new GrammarTable(
      new GrammarTableModel() {
        public boolean isCellEditable(int r, int c) {
          return false;
        }
      });

  /**
   * The drawer for the automaton.
   */
  private SelectionDrawer drawer;
}
