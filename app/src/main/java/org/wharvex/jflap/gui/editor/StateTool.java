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


package org.wharvex.jflap.gui.editor;

import org.wharvex.jflap.App;
import org.wharvex.jflap.automata.State;
import org.wharvex.jflap.gui.environment.AutomatonEnvironment;
import org.wharvex.jflap.gui.viewer.AutomatonDrawer;
import org.wharvex.jflap.gui.viewer.AutomatonPane;

import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

/**
 * A tool that handles the creation of states.
 *
 * @author Thomas Finley
 */

public class StateTool extends Tool {
  /**
   * Instantiates a new state tool.
   */
  public StateTool(AutomatonPane view, AutomatonDrawer drawer) {
    super(view, drawer);
  }

  /**
   * Gets the tool tip for this tool.
   *
   * @return the tool tip for this tool
   */
  public String getToolTip() {
    return "State Creator";
  }

  /**
   * Returns the tool icon.
   *
   * @return the state tool icon
   */
  protected Icon getIcon() {
    return new ImageIcon(App.getBasePackageDir() + "ICON/state.gif");
  }

  /**
   * When the user clicks, one creates a state.
   *
   * @param event the mouse event
   */
  public void mousePressed(MouseEvent event) {
    if (getDrawer().getAutomaton().getEnvironmentFrame() != null)
      ((AutomatonEnvironment) getDrawer().getAutomaton()
          .getEnvironmentFrame().getEnvironment()).saveStatus();
    state = getAutomaton().createState(event.getPoint());
    getView().repaint();
  }

  /**
   * When the user drags, one moves the created state.
   *
   * @param event the mouse event
   */
  public void mouseDragged(MouseEvent event) {
    state.setPoint(event.getPoint());
    getView().repaint();
  }

  /**
   * Returns the keystroke to switch to this tool, S.
   *
   * @return the keystroke for this tool
   */
  public KeyStroke getKey() {
    return KeyStroke.getKeyStroke('s');
  }

  /**
   * The state that was created.
   */
  State state = null;
}
