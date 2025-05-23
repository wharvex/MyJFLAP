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





package org.wharvex.jflap.automata.event;

import java.util.EventListener;

/**
 * An interface that those interested in changes in states in automata should
 * listen to.
 * 
 * @see automata.event.AutomataStateEvent
 * @see automata.Automaton#addStateListener
 */

public interface AutomataStateListener extends EventListener {
	/**
	 * Registers with the listener that an event has occurred.
	 * 
	 * @param event
	 *            the event
	 */
	public void automataStateChange(AutomataStateEvent event);
}
