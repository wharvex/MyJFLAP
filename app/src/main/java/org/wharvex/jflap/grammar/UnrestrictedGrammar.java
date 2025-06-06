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





package org.wharvex.jflap.grammar;

/**
 * The unrestricted grammar is a grammar that can have any production added to
 * it, save for the initial production, which must be restricted since the first
 * production specifies the initial variable in JFLAP.
 * 
 * @author Thomas Finley
 */

public class UnrestrictedGrammar extends Grammar {

	private boolean myTuringBool=false;
	/**
	 * Every production is all right except those with lambda in the left hand
	 * side of the production.
	 * 
	 * @param production
	 *            the production to check
	 * @throws IllegalArgumentException
	 *             if the production is lambda on the left hand side
	 */
	public void checkProduction(Production production) {
		if (production.getLHS().length() == 0) {
			throw new IllegalArgumentException(
					"The left hand side cannot be empty.");
		}
	}

	/**
	 * This adds a production to the grammar.
	 * 
	 * @param production
	 *            the production to add
	 * @throws IllegalArgumentException
	 *             if the first production added is unrestricted on the left
	 *             hand side
	 */
	public void addProduction(Production production) {
		if (myProductions.size() == 0
				&& !ProductionChecker.isRestrictedOnLHS(production))
			throw new IllegalArgumentException(
					"The first production must be restricted.");
		super.addProduction(production);
	}

	@Override
	public boolean isConverted() {
		// TODO Auto-generated method stub
		return false;
	}
}
