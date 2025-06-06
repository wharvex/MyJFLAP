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
import org.wharvex.jflap.gui.environment.AutomatonEnvironment;
import org.wharvex.jflap.gui.viewer.AutomatonDrawer;
import org.wharvex.jflap.gui.viewer.AutomatonPane;

import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.KeyStroke;

import org.wharvex.jflap.debug.EDebug;

/**
 * Redo time.
 *
 * @author Henry Qin
 */

public class RedoTool extends Tool {
  /**
   * Instantiates a new redo tool.
   */
  public RedoTool(AutomatonPane view, AutomatonDrawer drawer) {
    super(view, drawer);
  }

  /**
   * Gets the tool tip for this tool.
   *
   * @return the tool tip for this tool
   */
  public String getToolTip() {
    return "Undoer - Click anywhere in the editor pane after clicking me.";
  }

  /**
   * Returns the tool icon.
   *
   * @return the delete tool icon
   */
  protected Icon getIcon() {
    return new javax.swing.ImageIcon(
        App.getBasePackageDir() + "ICON/redo.jpg");
  }

  /**
   * Returns the key stroke to switch to this tool, the D key.
   *
   * @return the key stroke to switch to this tool
   */
  public KeyStroke getKey() {
    return KeyStroke.getKeyStroke('r');
  }

  /**
   * When the user clicks, we delete either the state or, if no state, the
   * transition found at this point. If there's nothing at this point, nothing
   * happens.
   *
   * @param event the mouse event
   */
  public void mouseClicked(MouseEvent event) {
    //do nothing
    ((AutomatonEnvironment) getDrawer().getAutomaton().getEnvironmentFrame()
        .getEnvironment()).redo();
//		getView().repaint();
  }
}
