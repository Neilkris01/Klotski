package com.example;

import java.io.*;
import java.util.ArrayList;
public class LogFile
{
    ArrayList<ArrayList<int[]>> queque = new ArrayList<>();
    int maxDeep;

    //write the log file
    public void logWrite(Piece[] pieces, Board board)
    {
        try
        {
            //Create file
            FileWriter fileName = new FileWriter("./Logs/out.txt", true);
            BufferedWriter out = new BufferedWriter(fileName);

            //Write piece dimensions for each piece
            for (int i = 0; i < 10; i++)
            {
                out.write("P" + i + ": ");
                out.write(pieces[i].getDims()[0] + " ");
                out.write(pieces[i].getDims()[1] + "\n");
            }
            out.write("\n");
            out.write("---------- \n \n");
            
            //Check if the board has a win condition
            if (board.checkWin())
            {
                out.write("\n \n");
                out.write("----- !!! WIN !!! -----");
            }
            out.close();
        }
        catch (Exception e)
        {System.err.println("Error: " + e.getMessage());}
    }

    //setter and getter of moveDeep
    public void setMoveDeep(int n)
    {maxDeep = n;}
    public int getMoveDeep()
    {return maxDeep;}

    //Read log file and store coordinates in the queue
    public ArrayList<ArrayList<int[]>> read(String fileName)
    {
        try
        {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int moveN = 0;
            int x1;
            int y1;
            while ((line = br.readLine()) != null)
            {
                line = line.trim();

                if (line.contains("----------"))
                {
                    moveN++;
                    continue;
                }

                if (line.isEmpty())
                {continue;}

                x1 = Character.getNumericValue(line.charAt(4));
                y1 = Character.getNumericValue(line.charAt(6));
                int[] coordinate = { x1, y1 };

                if (moveN >= queque.size())
                {queque.add(new ArrayList<int[]>());}
                queque.get(moveN).add(coordinate);
            }
            br.close();
            setMoveDeep(queque.size());
        }
        catch (FileNotFoundException e)
        {System.err.println("File not found");}
        catch (IOException e)
        {System.err.println("Error reading file");}
        return queque;
    }

    //Read log file and return the queue of coordinates
    public ArrayList<ArrayList<int[]>> logRead()
    {
        String fileName = "/Users/alvisestella/Desktop/KlotskiProject/src/main/java/com/klotski/Logs/outTest.txt";
        queque = read(fileName);
        return queque;
    }

    public ArrayList<ArrayList<int[]>> logReadForSolve()
    {
        String fileName = "./Logs/Config1database.txt";
        queque = read(fileName);
        return queque;
    }

    //Rewrite the log file with contents from another file
    public void LogRewrite(String filePath)
    {
        int lineCount = 0;
        try
        {
            File outFile = new File("./Logs/out.txt");
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String Line;

            while ((Line = reader.readLine()) != null)
            {lineCount++;}

            reader.close();
            reader = new BufferedReader(new FileReader(inputFile));

            while ((Line = reader.readLine()) != null && (lineCount) != 0)
            {
                writer.write(Line);
                writer.newLine();
                lineCount--;
            }

            writer.close();
            reader.close();

            if (outFile.delete())
            {
                if (!tempFile.renameTo(outFile))
                {throw new IOException("Unable to rename temporary file");}
            }
            else
            {throw new IOException("Unable to delete the original file");}
            //inputFile.delete();
        }
        catch (IOException e)
        { e.printStackTrace();}
    }

    //Delete the temp log file (out)
    public void fileOutDelater()
    {
        File outFile = new File("./Logs/out.txt");
        outFile.delete();
    }

    //Remove the last lines from the log file
    public void removeLastLines()
    {
        String filePath = "./Logs/out.txt";
        int linesToRemove = 13;
        int lineCount = 0;
        try
        {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String Line;

            while ((Line = reader.readLine()) != null)
            {lineCount++;}

            reader.close();
            reader = new BufferedReader(new FileReader(inputFile));

            while ((Line = reader.readLine()) != null && (lineCount - linesToRemove) != 0)
            {
                writer.write(Line);
                writer.newLine();
                lineCount--;
            }

            writer.close();
            reader.close();

            if (inputFile.delete())
            {
                if (!tempFile.renameTo(inputFile))
                {
                    throw new IOException("Unable to rename temporary file");
                }
            }
            else
            {throw new IOException("Unable to delete the original file");}
        }
        catch (IOException e)
        {e.printStackTrace();}
    }

    //Undo the last move by restoring piece positions and removing last lines from the log file
    public void undo(Piece[] pieces, Board board)
    {
        ArrayList<ArrayList<int[]>> q = logRead();
        ArrayList<int[]> pI = q.get(board.movesCounter - 1);

        int cX = 0;
        int cY = 0;
        for (int j = 0; j < 10; j++)
        {
            cX = pI.get(j)[0];
            cY = pI.get(j)[1];
            pieces[j].setPos(cX, cY);
        }
        board.movesCounter--;
        removeLastLines();
    }

    //Rename the log file
    public void renameFile(String nuovoNomeFile)
    {

        String nomeFileOriginale = "./Logs/out.txt";
        File fileOriginale = new File(nomeFileOriginale);
        File fileRinominato = new File("./Logs/" + nuovoNomeFile);

        fileOriginale.renameTo(fileRinominato);
    }

    //Delete the log file
    public void deleteFile() 
    {
        File file = new File("./Logs/out.txt");
        try
        {
            if (file.exists())
            {
                if (file.delete())
                {System.out.println("The file '" + file.getAbsolutePath() + "' has been successfully deleted.");}
                else
                {System.out.println("Unable to delete file '" + file.getAbsolutePath() + "'");}
            }
            else
            {System.out.println("The file '" + file.getAbsolutePath() + "' does not exist.");}
        }
        catch (Exception e)
        { System.err.println("An error occurred while deleting the file '" + e.getMessage() + "'");}
    }

    public ArrayList<ArrayList<int[]>> getQ()
    {return queque;}
}
