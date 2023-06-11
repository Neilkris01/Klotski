package com.example;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class LogFileTest {

    @Test
    public void testLogWrite() {
        // Create a test instance of Piece[] and Board
        Piece[] pieces = new Piece[10];
        Board board = new Board();

        // Initialize pieces and board

        LogFile logFile = new LogFile();
        logFile.logWrite(pieces, board);

        // Add assertions to check the expected contents of the log file
    }

    @Test
    public void testRead() {
        LogFile logFile = new LogFile();
        ArrayList<ArrayList<int[]>> queue = logFile.read("./Logs/out.txt");

        // Add assertions to check the expected contents of the queue
        assertEquals(1, queue.size());

        ArrayList<int[]> move1 = queue.get(0);
        assertEquals(10, move1.size());
        assertArrayEquals(new int[]{2, 3}, move1.get(0));
        assertArrayEquals(new int[]{5, 6}, move1.get(9));

        ArrayList<int[]> move2 = queue.get(1);
        assertEquals(10, move2.size());
        assertArrayEquals(new int[]{1, 2}, move2.get(0));
        assertArrayEquals(new int[]{4, 5}, move2.get(9));
    }

    @Test
    public void testLogRead() {
               LogFile logFile = new LogFile();
        ArrayList<ArrayList<int[]>> queue = logFile.logRead();

        // Add assertions to check the expected contents of the queue
        assertEquals(2, queue.size());

        ArrayList<int[]> move1 = queue.get(0);
        assertEquals(10, move1.size());
        assertArrayEquals(new int[]{2, 3}, move1.get(0));
        assertArrayEquals(new int[]{5, 6}, move1.get(9));

        ArrayList<int[]> move2 = queue.get(1);
        assertEquals(10, move2.size());
        assertArrayEquals(new int[]{1, 2}, move2.get(0));
        assertArrayEquals(new int[]{4, 5}, move2.get(9));

    }

    @Test
    public void testLogReadForSolve() {
        LogFile logFile = new LogFile();
        ArrayList<ArrayList<int[]>> queue = logFile.logReadForSolve();

        // Add assertions to check the expected contents of the queue
    }

    @Test
    public void testLogRewrite() {
        LogFile logFile = new LogFile();
        logFile.LogRewrite("input.txt");

        // Add assertions to check the expected contents of the log file after rewriting
    }

    @Test
    public void testFileOutDeleter() {
        LogFile logFile = new LogFile();
        logFile.fileOutDelater();

        // Add assertions to check if the log file is deleted
    }

    @Test
    public void testRemoveLastLines() {
        LogFile logFile = new LogFile();
        logFile.removeLastLines();

        // Add assertions to check the expected contents of the log file after removing last lines
    }

    @Test
    public void testUndo() {
        // Create a test instance of Piece[] and Board
        Piece[] pieces = new Piece[10];
        Board board = new Board();

        // Initialize pieces and board

        LogFile logFile = new LogFile();
        logFile.undo(pieces, board);

        // Add assertions to check the expected state of pieces and board after undoing the last move
    }

    @Test
    public void testRenameFile() {
        LogFile logFile = new LogFile();
        logFile.renameFile("newfile.txt");

        // Add assertions to check if the log file is successfully renamed
    }

    @Test
    public void testDeleteFile() {
        LogFile logFile = new LogFile();
        logFile.deleteFile();

        // Add assertions to check if the log file is successfully deleted
    }

    @Test
    public void testGetQ() {
        LogFile logFile = new LogFile();
        ArrayList<ArrayList<int[]>> queue = logFile.getQ();

        // Add assertions to check the expected contents of the queue
    }
}
