package org.wharvex.jflap.gui.editor;

import org.junit.jupiter.api.Test;
import org.wharvex.jflap.automata.State;
import org.wharvex.jflap.automata.fsa.FiniteStateAutomaton;
import org.wharvex.jflap.gui.viewer.AutomatonPane;

import javax.swing.JTable;
import java.awt.Color;
import java.awt.Point;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for TableTransitionCreator to verify that the transition label
 * input text box has the correct appearance properties.
 */
public class TableTransitionCreatorTest {

    @Test
    public void testTransitionTableAppearance() {
        // Create a finite state automaton
        FiniteStateAutomaton automaton = new FiniteStateAutomaton();
        State from = automaton.createState(new Point(50, 50));
        State to = automaton.createState(new Point(150, 150));

        // Create an AutomatonPane
        AutomatonPane pane = new AutomatonPane(automaton);

        // Create an FSATransitionCreator
        FSATransitionCreator creator = new FSATransitionCreator(pane);

        // Create a transition which will create the table
        creator.createTransition(from, to);

        // Get the editing table
        JTable table = creator.editingTable;

        // Verify that the table is not null (it was created)
        assertNotNull(table, "Editing table should be created");

        // Verify the background color is white
        assertEquals(Color.white, table.getBackground(), 
            "Table background should be white for better visibility");

        // Verify the row height is adequate (at least 25 pixels)
        assertTrue(table.getRowHeight() >= 25, 
            "Row height should be at least 25 pixels for better visibility. Actual: " + table.getRowHeight());
    }
}
