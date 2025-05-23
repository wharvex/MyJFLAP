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


package org.wharvex.jflap.gui.sim;

import org.wharvex.jflap.automata.Configuration;
import org.wharvex.jflap.automata.fsa.FSAConfiguration;
import org.wharvex.jflap.automata.pda.PDAConfiguration;
import org.wharvex.jflap.automata.turing.TMConfiguration;

/**
 * This is a configuration icon factory. Given a configuration, it returns the
 * appropriate icon.
 *
 * @author Thomas Finley
 */

public class ConfigurationIconFactory {
  /**
   * Returns an instance of an appropriate subclass of the configuration icon
   * for this sort of configuration.
   *
   * @param configuration the configuration to return the icon for
   * @return some instance of a subclass of <CODE>ConfigurationIcon</CODE>,
   * or <CODE>null</CODE> if this factory is not set up to handle
   * this sort of configuration
   */
  public static ConfigurationIcon iconForConfiguration(
      Configuration configuration) {
    if (configuration instanceof FSAConfiguration)
      return new FSAConfigurationIcon(configuration);
    else if (configuration instanceof PDAConfiguration)
      return new PDAConfigurationIcon(configuration);
    else if (configuration instanceof TMConfiguration)
      return new TMConfigurationIcon(configuration);
    else if (configuration instanceof org.wharvex.jflap.automata.mealy.MealyConfiguration)
      return new MealyConfigurationIcon(configuration);
    return null;
  }
}
