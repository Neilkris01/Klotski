package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testInitialization() {
        Board board = new Board();
        assertNotNull(board.getPieces());
        assertEquals(10, board.getPieces().length);
        assertEquals(1, board.getConfig());
        assertEquals(0, board.getCounter());
        assertFalse(board.checkWin());
        assertEquals(4, board.getWidth());
        assertEquals(5, board.getHeight());
        assertNull(board.getSelectedPiece());
        assertNotNull(board.getLog());
    }

    @Test
    public void testSelectPiece() {
        Board board = new Board();
        Piece piece = board.getPieces()[0];

        board.selectPiece(piece);

        assertEquals(piece, board.getSelectedPiece());
    }

    @Test
    public void testIsSelect() {
        Board board = new Board();
        Piece piece = board.getPieces()[0];
        board.selectPiece(piece);

        assertTrue(board.isSelect(piece));
    }

    @Test
    public void testIsNotSelect() {
        Board board = new Board();
        Piece piece1 = board.getPieces()[0];
        Piece piece2 = board.getPieces()[1];
        board.selectPiece(piece1);

        assertFalse(board.isSelect(piece2));
    }

    @Test
    public void testIsOccupied() {
        Board board = new Board();
        Piece piece = board.getPieces()[0];

        assertTrue(board.isOccupied(piece.getDims()[0], piece.getDims()[1]));
    }

    @Test
    public void testIsNotOccupied() {
        Board board = new Board();
        Piece piece = board.getPieces()[5];

        assertFalse(board.isOccupied(piece.getDims()[0] + 1, piece.getDims()[1]));
    }

    @Test
    public void testValidMove() {
        Board board = new Board();
        Piece piece = board.getPieces()[5];
        board.selectPiece(piece);

        int initialX = piece.getDims()[0];
        int initialY = piece.getDims()[1];

        assertTrue(board.movePiece(board, 1));

        // Assert that the selected piece is no longer selected
        assertEquals(piece, board.getSelectedPiece());

        // Assert that the previous position of the piece is now unoccupied
        assertFalse(board.isOccupied(initialX, initialY));

        // Assert that the piece is now at the new position
        assertEquals(1,board.getSelectedPiece().getDims()[0]);
        assertEquals(4,board.getSelectedPiece().getDims()[1]);
    }



    @Test
    public void testInvalidMove() {
        Board board = new Board();
        Piece piece = board.getPieces()[0];
        board.selectPiece(piece);

        assertFalse(board.movePiece(board, 1));
        // Add assertions to check the expected state after the invalid move
    }

    @Test
    public void testWinCondition() {
        Board board = new Board();
        Piece piece = board.getPieces()[9];
        board.selectPiece(piece);
        // Move the piece to the winning position
        piece.setPos(1,3);
        assertTrue(board.movePiece(board, 2));
        assertTrue(board.checkWin());
        // Add assertions to check the expected state after winning the game
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDirection() {
        Board board = new Board();
        Piece piece = board.getPieces()[0];
        board.selectPiece(piece);

        // Try to move with an invalid direction
        board.movePiece(board, 4);
    }

    @Test
    public void testReset() {
        Board board = new Board();
        board.setConfig(2);
        board.setCounter(5);
        Piece piece = board.getPieces()[4];
        board.selectPiece(piece);
        // Modify the state of the board

        board.reset(1);

        assertEquals(1, board.getConfig());
        assertEquals(0, board.getCounter());
        assertNull(board.getSelectedPiece());
        // Add assertions to check the expected state after resetting the board
    }
}
