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


package org.wharvex.jflap.gui.environment;

import org.wharvex.jflap.grammar.Grammar;
import org.wharvex.jflap.grammar.UnboundGrammar;
import org.wharvex.jflap.gui.grammar.GrammarInputPane;

import java.io.Serializable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 * The <CODE>GrammarEnvironment</CODE> is an environment for holding a
 * grammar. Owing to certain eccentricities of the way that the grammar is set
 * up as a non-editable object, what is passed into the environment is a <CODE>GrammarInputPane</CODE>
 * which is then used to retrieve the current grammar.
 * <p>
 * Unlike other environments, the object returned by the <CODE>Grammar</CODE>
 * returned by the <CODE>.getObject</CODE> method will not point to the same
 * object throughout the environment's execution.
 *
 * @author Thomas Finley
 * @see grammar.Grammar
 * @see gui.grammar.GrammarInputPane
 */

public class GrammarEnvironment extends Environment {
  /**
   * Instantiates a new <CODE>GrammarEnvironment</CODE> with the given
   * <CODE>GrammarInputPane</CODE>.
   *
   * @param input the <CODE>GrammarInputPane</CODE>
   */
  public GrammarEnvironment(GrammarInputPane input) {
    super(null);
    this.input = input;
    input.getTable().getModel().addTableModelListener(
        new TableModelListener() {
          public void tableChanged(TableModelEvent event) {
            setDirty();
          }
        });
  }

  /**
   * Returns the grammar of this <CODE>GrammarEnvironment</CODE>, which is
   * retrieved from the <CODE>GrammarInputPane</CODE>'s <CODE>.getGrammar</CODE>
   * method.
   *
   * @return the <CODE>Grammar</CODE> for this environment
   * @see gui.grammar.GrammarInputPane#getGrammar
   */
  public Serializable getObject() {
    return getGrammar(UnboundGrammar.class);
  }

  /**
   * Returns the context free grammar.
   *
   * @return the <CODE>ContextFreeGrammar</CODE> for this environment
   * @see gui.grammar.GrammarInputPane#getGrammar()
   */
  public Grammar getGrammar() {
    return input.getGrammar();
  }

  /**
   * Returns the grammar of the specified type.
   *
   * @param grammarClass specification of the type of grammar which should be returned
   * @return the <CODE>Grammar</CODE> for this environment of the specified
   * type
   * @see gui.grammar.GrammarInputPane#getGrammar(Class)
   */
  public Grammar getGrammar(Class grammarClass) {
    return input.getGrammar(grammarClass);
  }

  /**
   * The grammar input pane.
   */
  private GrammarInputPane input = null;
}
