import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
//import javax.crypto.spec.PSource.PSpecified;

public class Board
{
	Piece[] pieces;
	Piece selected;
	String[][] grid = new String[4][5]; //board girata di 90gradi
	int width;
	int height;
	int movesCounter;
	int configuration;
	boolean hasWon;
	int i;
	int start = 0;
	String fileName;
	ArrayList<ArrayList<int[]>> queque = new ArrayList<>();
	int maxDeep;
	
	public Board()
	{
		this.pieces = new Piece[10];
		this.configuration = 1;
		
		reset(configuration);
		
		this.width = 4;
		this.height = 5;
	}
	
	public void setConfig(int number) {this.configuration = number;}
	public void setCounter(int count) {this.movesCounter = count;}
	public boolean checkWin() { return hasWon; }
	public int getConfig() {return configuration;}
	public int getCounter() { return movesCounter; }
	public Piece getSelectedPiece() { return selected; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public Piece[] getPieces() { return pieces; }
	
	public void selectPiece(Piece p)
	{
		selected = p;
	}

	public boolean isSelect(Piece p)
	{
		if((p.getDims()[0] == selected.getDims()[0]) && (p.getDims()[1] == selected.getDims()[1]))
		{
			return true;
		}
		return false;
	}
	
	public boolean isOccupied(int x, int y)
	{
		for (i=0; i<10; i++)
		{
			int x1 = pieces[i].getDims()[0];
			int y1 = pieces[i].getDims()[1];
			for (int j = 0; j < (pieces[i].getDims()[2]); j++)
			{
				x1 = x1 + j;
				y1 = pieces[i].getDims()[1];
				for (int j1 = 0; j1 < (pieces[i].getDims()[3]); j1++)
				{
					y1 = y1 + j1;
					if (pieces[i] != selected)
					{
						if((x1 == x) && (y1 == y))
						{
							return true;
						}
					}
					
				}
			}
		}
		return false;
	}

	/*public boolean boardToGrid()
	{
		for(i=0;i<10;i++)
		{
			int x1 = pieces[i].getDims()[0];
			int y1 = pieces[i].getDims()[1];
			if(pieces[i].getDims()[2]==2 && pieces[i].getDims()[3]==2) //pezzi 2x2
			{ 
				int x2 = x1;
				int y2 = y1++;
				int x3 = x1++;
				int y3 = y1;
				int x4 = x1++;
				int y4 = y1++;
				grid[3-y1][x1] = pieces[i].getName();
				grid[3-y2][x2] = pieces[i].getName();
				grid[3-y3][x3] = pieces[i].getName();
				grid[3-y4][x4] = pieces[i].getName();
			}
			else if(pieces[i].getDims()[2]==2 || pieces[i].getDims()[3]==2) // pezzi 1x2 o 2x1
			{ 
				for (int j = 0; j < (pieces[i].getDims()[2]); j++) {
					int x2 = x1 + j;
					for (int j1 = 0; j1 < (pieces[i].getDims()[3]); j1++)
					{
						int y2 = y1 + j1;
					
					}
				}
				grid[3-y1][x1] = pieces[i].getName();
				grid[3-y2][x2] = pieces[i].getName();
			}
			else if(pieces[i].getDims()[2]==1 && pieces[i].getDims()[3]==1)
			{
				grid[3-y1][x1] = pieces[i].getName();
			}
		}
	}*/
	
	
	public boolean movePiece(int direction)
	{
		//caso 1: nessuna selezione
		if (selected == null)
		{
			return false;
		}
		
		//caso 2: vittoria
		if (selected == pieces[9] && selected.x == 1 && selected.y == 3 && direction == 2)
		{
			hasWon = true;
			return true;
		}
		
		// caso 3: valido
		if (direction == 0)
		{
			// up
			if (selected.getDims()[1] == 0)
			{return false;}
			
			int x = selected.getDims()[0];
			int y = (selected.getDims()[1]) - 1;

			for(int j = 0; j<(selected.getDims()[2]); j++)
			{
				x = x + j;
				y = (selected.getDims()[1]) - 1;
				for(int j1 = 0; j1<(selected.getDims()[3]); j1++)
				{
					y = y + j1;
					if (isOccupied(x, y))
					{return false;}
				}
			}
			
		}
		else if (direction == 1)
		{
			// right
			if ((selected.getDims()[0]) + ((selected.getDims()[2])) == width)
			{return false;}
			
			int x = (selected.getDims()[0]) + 1;
			int y = (selected.getDims()[1]);

			for (int j = 0; j < (selected.getDims()[2]); j++)
			{
				x = x + j;
				y = (selected.getDims()[1]);
				for (int j1 = 0; j1 < (selected.getDims()[3]); j1++)
				{
					y = y + j1;
					if (isOccupied(x, y))
					{return false;}
				}
			}
		}
		else if (direction == 2)
		{
			// down
			if ((selected.getDims()[1]) + selected.getDims()[3] == height)
			{return false;}

			int x = selected.getDims()[0];
			int y = (selected.getDims()[1]) + 1;

			for (int j = 0; j < (selected.getDims()[2]); j++)
			{
				x = x + j;
				y = (selected.getDims()[1]) + 1;
				for (int j1 = 0; j1 < (selected.getDims()[3]); j1++)
				{
					y = y + j1;
					if (isOccupied(x, y))
					{return false;}
				}
			}
		}
		else if (direction == 3)
		{
			// left
			if ((selected.getDims()[0]) == 0)
			{return false;}

			int x = (selected.getDims()[0]) - 1;
			int y = (selected.getDims()[1]);

			for (int j = 0; j < (selected.getDims()[2]); j++)
			{
				x = x + j;
				y = (selected.getDims()[1]);
				for (int j1 = 0; j1 < (selected.getDims()[3]); j1++)
				{
					y = y + j1;
					if (isOccupied(x, y))
					{return false;}
				}
			}
		}
		else
		{
			throw new IllegalArgumentException("direction must be 0..3");
		}
		
		selected.move(direction);
		++movesCounter;

		logWrite();
		return true;
	}

	public void reset(int config)
	{
		configuration = config;
		pieces = new Piece[10];
		if (configuration == 1)
		{
			pieces[0] = new Piece(0, 0, 1, 2, "A");
			pieces[1] = new Piece(3, 0, 1, 2, "B");
			pieces[2] = new Piece(0, 2, 1, 2, "C");
			pieces[3] = new Piece(3, 2, 1, 2, "D");
			pieces[4] = new Piece(1, 2, 2, 1, "E");
			pieces[5] = new Piece(0, 4, 1, 1, "F");
			pieces[6] = new Piece(3, 4, 1, 1, "G");
			pieces[7] = new Piece(1, 3, 1, 1, "H");
			pieces[8] = new Piece(2, 3, 1, 1, "I");
			pieces[9] = new Piece(1, 0, 2, 2, "J");
		}
		else if (configuration == 2)
		{
			pieces[0] = new Piece(0, 0, 1, 2, "A");
			pieces[1] = new Piece(3, 0, 1, 2, "B");
			pieces[2] = new Piece(0, 2, 1, 2, "C");
			pieces[3] = new Piece(3, 2, 1, 2, "D");
			pieces[4] = new Piece(1, 4, 2, 1, "E");
			pieces[5] = new Piece(1, 2, 1, 1, "F");
			pieces[6] = new Piece(2, 2, 1, 1, "G");
			pieces[7] = new Piece(1, 3, 1, 1, "H");
			pieces[8] = new Piece(2, 3, 1, 1, "I");
			pieces[9] = new Piece(1, 0, 2, 2, "J");
		}
		else if (configuration == 3)
		{
			pieces[0] = new Piece(0, 1, 1, 2, "A");
			pieces[1] = new Piece(3, 1, 1, 2, "B");
			pieces[2] = new Piece(1, 2, 1, 2, "C");
			pieces[3] = new Piece(2, 2, 1, 2, "D");
			pieces[4] = new Piece(2, 4, 2, 1, "E");
			pieces[5] = new Piece(0, 0, 1, 1, "F");
			pieces[6] = new Piece(3, 0, 1, 1, "G");
			pieces[7] = new Piece(0, 3, 1, 1, "H");
			pieces[8] = new Piece(3, 3, 1, 1, "I");
			pieces[9] = new Piece(1, 0, 2, 2, "J");
		}
		else if (configuration == 4)
		{
			pieces[0] = new Piece(3, 1, 1, 2, "A");
			pieces[1] = new Piece(3, 3, 1, 2, "B");
			pieces[2] = new Piece(1, 1, 1, 2, "C");
			pieces[3] = new Piece(2, 3, 1, 2, "D");
			pieces[4] = new Piece(1, 0, 2, 1, "E");
			pieces[5] = new Piece(2, 2, 1, 1, "F");
			pieces[6] = new Piece(0, 0, 1, 1, "G");
			pieces[7] = new Piece(3, 0, 1, 1, "H");
			pieces[8] = new Piece(0, 2, 1, 1, "I");
			pieces[9] = new Piece(0, 3, 2, 2, "J");
		}
		selected = pieces[9];
		setCounter(0);
	}
	
	public void logWrite()
	{
		try {
			// Create file
			FileWriter fileName = new FileWriter("./Logs/out.txt", true);
			BufferedWriter out = new BufferedWriter(fileName);
			for(int i = 0; i<10; i++)
			{
				out.write("P" + i + ": ");
				out.write(pieces[i].getDims()[0] + " ");
				out.write(pieces[i].getDims()[1] + "\n");
			}
			out.write("\n");
			out.write("---------- \n \n");
			if(checkWin())
			{
				out.write("\n \n");
				out.write("----- !!! WIN !!! -----");
			}
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}

	public void setMoveDeep(int n)
	{maxDeep = n;}

	public int getMoveDeep()
	{return maxDeep;}

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
				{
					continue;
				}

				x1 = Character.getNumericValue(line.charAt(4));
				y1 = Character.getNumericValue(line.charAt(6));
				int[] coordinate = { x1, y1 };

				if (moveN >= queque.size())
				{
					queque.add(new ArrayList<>());
				}
				queque.get(moveN).add(coordinate);
			}
			br.close();
			setMoveDeep(queque.size());
		}
		catch (FileNotFoundException e)
		{System.err.println("File non trovato");}
		catch (IOException e)
		{System.err.println("Errore durante la lettura del file");}
		return queque;
	}

	public ArrayList<ArrayList<int[]>> logRead()
	{
		String fileName = "./Logs/out.txt";
		queque = read(fileName);
		return queque;
	}

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
			{
				lineCount++;
			}

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
				{throw new IOException("Impossibile rinominare il file temporaneo");}
			}
			else 
			{throw new IOException("Impossibile eliminare il file originale");}
			//inputFile.delete(); ?????????????????????????????????????????????????????????????????????????????????
		}
		catch (IOException e)
		{e.printStackTrace();}
	}

	public void fileOutDelater()
	{
		File outFile = new File("./Logs/out.txt");
		outFile.delete();
	}

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
			{
				lineCount++;
			}

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
				{throw new IOException("Impossibile rinominare il file temporaneo");}
			}
			else
			{throw new IOException("Impossibile eliminare il file originale");}
		}
		catch (IOException e)
		{e.printStackTrace();}
	}

	public void undo()
	{
		ArrayList<ArrayList<int[]>> q = logRead();
		ArrayList<int[]> pI = q.get(movesCounter - 1);

		int cX = 0;
		int cY = 0;
		for(int j = 0; j<10; j++)
		{
			cX = pI.get(j)[0];
			cY = pI.get(j)[1];
			pieces[j].setPos(cX, cY);
		}
		movesCounter--;
		removeLastLines();
	}

	public void renameFile(String nuovoNomeFile)
	{

		String nomeFileOriginale = "./Logs/out.txt";
		File fileOriginale = new File(nomeFileOriginale);
		File fileRinominato = new File("./Logs/" + nuovoNomeFile);

		fileOriginale.renameTo(fileRinominato);
	}

	public void deleteFile()
	{
		File file = new File("./Logs/out.txt");
		try
		{
			if (file.exists())
			{
				if (file.delete())
				{
					System.out.println("Il file " + file.getAbsolutePath() + " è stato eliminato con successo.");
				}
				else
				{
					System.out.println("Impossibile eliminare il file " + file.getAbsolutePath());
				}
			}
			else
			{
				System.out.println("Il file " + file.getAbsolutePath() + " non esiste.");
			}
		}
		catch (Exception e)
		{
			System.err.println("Si è verificato un errore durante l'eliminazione del file: " + e.getMessage());
		}
	}

	public void puzzleTranslate(String kSolverOutput)
	{
		char[] caratteri = kSolverOutput.toCharArray();
		int aC = 0, bC = 0, cC = 0, dC = 0, eC = 0, jC = 0, countx = 3, county = 0, j = 0;

		pieces[0].setPos(100, 100);
		pieces[1].setPos(100, 100);
		pieces[2].setPos(100, 100);
		pieces[3].setPos(100, 100);
		pieces[4].setPos(100, 100);
		pieces[5].setPos(100, 100);
		pieces[6].setPos(100, 100);
		pieces[7].setPos(100, 100);
		pieces[8].setPos(100, 100);
		pieces[9].setPos(100, 100);

		//for(j=0; j<20; j++)
		//{
			System.out.println("j= " + j);
			for (county = 0; county < 5; county++)
			{
				for (countx = 3; countx >= 0; countx--)
				{
					if(caratteri[j] == 'A' && aC == 0)
					{
						System.out.println("A");
						pieces[0].setPos(countx, county);
						j++;
						aC++;
					}
					else if (caratteri[j] == 'A' && aC == 1)
					{
						j++;
					}
					else
					if (caratteri[j] == 'B' && bC == 0)
					{
						System.out.println("B");
						pieces[1].setPos(countx, county);
						j++;
						bC++;
					}
					else if (caratteri[j] == 'B' && bC == 1)
					{
						j++;
					}
					else
					if (caratteri[j] == 'C' && cC == 0)
					{
						System.out.println("C");
						pieces[2].setPos(countx, county);
						j++;
						cC++;
					} else if (caratteri[j] == 'C' && cC == 1) 
					{
						j++;
					}
					else
					if (caratteri[j] == 'D' && dC == 0)
					{
						System.out.println("D");
						pieces[3].setPos(countx, county);
						j++;
						dC++;
					}
					else if (caratteri[j] == 'D' && dC == 1)
					{
						j++;
					}
					else
					if (caratteri[j] == 'E' && eC == 1)
					{
						System.out.println("E");
						pieces[4].setPos(countx, county);
						j++;
					}
					else if(caratteri[j] == 'E' && eC == 0)
					{
						eC++;
						j++;
					}
					else
					if (caratteri[j] == 'F')
					{
						System.out.println("F");
						pieces[5].setPos(countx, county);
						j++;
					}
					else
					if (caratteri[j] == 'G')
					{
						System.out.println("G");
						pieces[6].setPos(countx, county);
						j++;
					}
					else
					if (caratteri[j] == 'H')
					{
						System.out.println("H");
						pieces[7].setPos(countx, county);
						j++;
					}
					else
					if (caratteri[j] == 'I')
					{
						System.out.println("I");
						pieces[8].setPos(countx, county);
						j++;
					}
					else
					if (caratteri[j] == 'J' && jC == 1)
					{
						System.out.println("J");
						pieces[9].setPos(countx, county);
						jC++;
					}
					else if(caratteri[j] == 'J' && jC == 0)
					{
						j++;
						jC++;
					}
					else
					if (caratteri[j] == '0')
					{
						j++;
					}
				}
			}
		//}
	}
}

// if (j % 4 != 0){countx--;}