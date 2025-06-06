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

import org.wharvex.jflap.gui.environment.Environment;
import org.wharvex.jflap.gui.environment.Universe;

import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.Serializable;

import javax.swing.JFileChooser;
import javax.swing.KeyStroke;

/**
 * The <CODE>SaveAsAction</CODE> is an action to save a serializable object
 * contained in an environment to file always using a dialog box.
 *
 * @author Thomas Finley
 */

public class SaveAsAction extends RestrictedAction {
  /**
   * Instantiates a new <CODE>SaveAction</CODE>.
   *
   * @param environment the environment that holds the serializable object
   */
  public SaveAsAction(Environment environment) {
    super("Save As...", null);
    putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S,
        MAIN_MENU_MASK + InputEvent.SHIFT_MASK));
    this.environment = environment;
    this.fileChooser = Universe.CHOOSER;
  }

  /**
   * If a save was attempted, call the methods that handle the saving of the
   * serializable object to a file.
   *
   * @param event the action event
   */
  public void actionPerformed(ActionEvent event) {
    Universe.frameForEnvironment(environment).save(true);
  }

  /**
   * This action is restricted to those objects that are serializable.
   *
   * @param object the object to check for serializable-ness
   * @return <CODE>true</CODE> if the object is an instance of a
   * serializable object, <CODE>false</CODE> otherwise
   */
  public static boolean isApplicable(Object object) {
    return object instanceof Serializable;
  }

  /**
   * The environment that this save action gets it's object from.
   */
  protected Environment environment;

  /**
   * The file chooser.
   */
  private JFileChooser fileChooser;
}
