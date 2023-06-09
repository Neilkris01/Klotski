import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
public class LogFile
{
    ArrayList<ArrayList<int[]>> queque = new ArrayList<>();
    int maxDeep;

    public void logWrite(Piece[] pieces, Board board)
    {
        try {
            // Create file
            FileWriter fileName = new FileWriter("./Logs/out.txt", true);
            BufferedWriter out = new BufferedWriter(fileName);
            for (int i = 0; i < 10; i++) {
                out.write("P" + i + ": ");
                out.write(pieces[i].getDims()[0] + " ");
                out.write(pieces[i].getDims()[1] + "\n");
            }
            out.write("\n");
            out.write("---------- \n \n");
            if (board.checkWin()) {
                out.write("\n \n");
                out.write("----- !!! WIN !!! -----");
            }
            out.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setMoveDeep(int n) {
        maxDeep = n;
    }

    public int getMoveDeep() {
        return maxDeep;
    }

    public ArrayList<ArrayList<int[]>> read(String fileName) {
        try {
            File file = new File(fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            int moveN = 0;
            int x1;
            int y1;
            while ((line = br.readLine()) != null) {
                line = line.trim();

                if (line.contains("----------")) {
                    moveN++;
                    continue;
                }

                if (line.isEmpty()) {
                    continue;
                }

                x1 = Character.getNumericValue(line.charAt(4));
                y1 = Character.getNumericValue(line.charAt(6));
                int[] coordinate = { x1, y1 };

                if (moveN >= queque.size()) {
                    queque.add(new ArrayList<>());
                }
                queque.get(moveN).add(coordinate);
            }
            br.close();
            setMoveDeep(queque.size());
        } catch (FileNotFoundException e) {
            System.err.println("File non trovato");
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file");
        }
        return queque;
    }

    public ArrayList<ArrayList<int[]>> logRead() {
        String fileName = "./Logs/out.txt";
        queque = read(fileName);
        return queque;
    }

    public void LogRewrite(String filePath) {
        int lineCount = 0;
        try {
            File outFile = new File("./Logs/out.txt");
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String Line;

            while ((Line = reader.readLine()) != null) {
                lineCount++;
            }

            reader.close();
            reader = new BufferedReader(new FileReader(inputFile));

            while ((Line = reader.readLine()) != null && (lineCount) != 0) {
                writer.write(Line);
                writer.newLine();
                lineCount--;
            }

            writer.close();
            reader.close();

            if (outFile.delete()) {
                if (!tempFile.renameTo(outFile)) {
                    throw new IOException("Impossibile rinominare il file temporaneo");
                }
            } else {
                throw new IOException("Impossibile eliminare il file originale");
            }
            // inputFile.delete();
            // ?????????????????????????????????????????????????????????????????????????????????
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void fileOutDelater() {
        File outFile = new File("./Logs/out.txt");
        outFile.delete();
    }

    public void removeLastLines() {
        String filePath = "./Logs/out.txt";
        int linesToRemove = 13;
        int lineCount = 0;
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("temp.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String Line;

            while ((Line = reader.readLine()) != null) {
                lineCount++;
            }

            reader.close();
            reader = new BufferedReader(new FileReader(inputFile));

            while ((Line = reader.readLine()) != null && (lineCount - linesToRemove) != 0) {
                writer.write(Line);
                writer.newLine();
                lineCount--;
            }

            writer.close();
            reader.close();

            if (inputFile.delete()) {
                if (!tempFile.renameTo(inputFile)) {
                    throw new IOException("Impossibile rinominare il file temporaneo");
                }
            } else {
                throw new IOException("Impossibile eliminare il file originale");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void undo(Piece[] pieces, Board board) {
        ArrayList<ArrayList<int[]>> q = logRead();
        ArrayList<int[]> pI = q.get(board.movesCounter - 1);

        int cX = 0;
        int cY = 0;
        for (int j = 0; j < 10; j++) {
            cX = pI.get(j)[0];
            cY = pI.get(j)[1];
            pieces[j].setPos(cX, cY);
        }
        board.movesCounter--;
        removeLastLines();
    }

    public void renameFile(String nuovoNomeFile) {

        String nomeFileOriginale = "./Logs/out.txt";
        File fileOriginale = new File(nomeFileOriginale);
        File fileRinominato = new File("./Logs/" + nuovoNomeFile);

        fileOriginale.renameTo(fileRinominato);
    }

    public void deleteFile() {
        File file = new File("./Logs/out.txt");
        try {
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("Il file " + file.getAbsolutePath() + " è stato eliminato con successo.");
                } else {
                    System.out.println("Impossibile eliminare il file " + file.getAbsolutePath());
                }
            } else {
                System.out.println("Il file " + file.getAbsolutePath() + " non esiste.");
            }
        } catch (Exception e) {
            System.err.println("Si è verificato un errore durante l'eliminazione del file: " + e.getMessage());
        }
    }
    
}
