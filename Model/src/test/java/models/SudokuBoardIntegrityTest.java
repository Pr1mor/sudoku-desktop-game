package models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sudoku.model.models.SudokuBoard;
import sudoku.model.solver.BacktrackingSudokuSolver;

public class SudokuBoardIntegrityTest {

    @Test
    void testFieldObjectSharing() {
        SudokuBoard board = new SudokuBoard(new BacktrackingSudokuSolver());

        // We'll target the top-left corner (0,0), which is also in Box 0.
        int rowIdx = 0;
        int colIdx = 0;
        int boxIdx = 0;
        int testValue = 7;

        // Update the field through the board's main setter
        board.setField(colIdx, rowIdx, testValue);

        // Verify the Row reflects the change
        assertEquals(testValue, board.getRow(rowIdx).getFields()[colIdx].getValue());

        // Verify the Column reflects the change
        assertEquals(testValue, board.getColumn(colIdx).getFields()[rowIdx].getValue());

        // Verify the Box reflects the change (index 0 is the top-left of the box)
        assertEquals(testValue, board.getBox(boxIdx).getFields()[0].getValue());

        // If this fails, the UI might update a row but leave the column or box with old data.
        assertSame(board.getRow(rowIdx).getFields()[colIdx],
                board.getColumn(colIdx).getFields()[rowIdx],
                "Row and Column must share the same Field object.");

        assertSame(board.getRow(rowIdx).getFields()[colIdx],
                board.getBox(boxIdx).getFields()[0],
                "Row and Box must share the same Field object.");
    }
}