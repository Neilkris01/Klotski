import java.util.List;

//import javax.crypto.spec.PSource.PSpecified;

public class Board
{
	Piece[] pieces;
	Piece selected;
	int width;
	int height;
	int movesCounter;
	int configuration;
	boolean hasWon;
	int i;
	
	/**
	 * Basic constructor. Initializes height and width to standard klotski size.
	 * Initializes pieces to configuration 1
	 */
	public Board()
	{
		this.pieces = new Piece[10];
		this.configuration = 1;
		
		// initialize all pieces to configuration 1, set moves to 0, set
		// selectedPiece to null, and set hasWon to false
		reset();
		
		this.width = 4;
		this.height = 5;
	}
	
	public void setConfig(int number) {this.configuration = number;}
	public void setCounter(int count) {this.movesCounter = count;}
	public boolean checkWin() { return hasWon; }
	public int getCounter() { return movesCounter; }
	public Piece getSelectedPiece() { return selected; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public Piece[] getPieces() { return pieces; }
	
	public boolean setPieces(List<String> lines)
	{
		int i;
		String[] tokens;
		if (lines.size() < 1 || lines.size() > this.width * this.height)
		{
			throw new IllegalArgumentException("Error");
		}
		this.movesCounter = Integer.parseInt(lines.get(0).trim());
		pieces = new Piece[lines.size() - 1];
		for (i = 1; i < lines.size(); ++i)
		{
			tokens = lines.get(i).trim().split("\\s+");
			pieces[i - 1] = new Piece(Integer.parseInt(tokens[0]),
					Integer.parseInt(tokens[1]),
					Integer.parseInt(tokens[2]),
					Integer.parseInt(tokens[3]));
		}
		return true;
	}
	
	public void selectPiece(Piece p)
	{
		selected = p;
	}
	
	public boolean isOccupied(int x, int y)
	{
		for (i=9; i<10; i++)//cambiare se aggiungi i pezzi
		{
			if ((pieces[i] != selected) && ((pieces[i].getDims()[0]) == x) && ((pieces[i].getDims()[1]) == y))
			{return true;}
		}
		return false;
	}
	
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
			System.out.println("HAI VINTO!!!!");
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

			for(int j =0; j<(selected.getDims()[2]); j++)
			{
				x = x + j;
				for(int j1 =0; j1<(selected.getDims()[3]); j1++)
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
		
		// if we've gotten here it means we're clear to move the selected piece
		selected.move(direction);
		++movesCounter;
		return true;
	}

	public void reset()
	{
		pieces = new Piece[10];
		if (configuration == 1)
		{
			pieces[0] = new Piece(0, 0, 1, 2);
			pieces[1] = new Piece(3, 0, 1, 2);
			pieces[2] = new Piece(0, 2, 1, 2);
			pieces[3] = new Piece(3, 2, 1, 2);
			pieces[4] = new Piece(1, 2, 2, 1);
			pieces[5] = new Piece(0, 4, 1, 1);
			pieces[6] = new Piece(3, 4, 1, 1);
			pieces[7] = new Piece(1, 3, 1, 1);
			pieces[8] = new Piece(2, 3, 1, 1);
			pieces[9] = new Piece(1, 0, 2, 2);
		}
		else if (configuration == 2)
		{
			pieces[0] = new Piece(0, 0, 1, 2);
			pieces[1] = new Piece(3, 0, 1, 2);
			pieces[2] = new Piece(0, 2, 1, 2);
			pieces[3] = new Piece(3, 2, 1, 2);
			pieces[4] = new Piece(1, 4, 2, 1);
			pieces[5] = new Piece(1, 2, 1, 1);
			pieces[6] = new Piece(2, 2, 1, 1);
			pieces[7] = new Piece(1, 3, 1, 1);
			pieces[8] = new Piece(2, 3, 1, 1);
			pieces[9] = new Piece(1, 0, 2, 2);
		}
		else if (configuration == 3)
		{
			pieces[0] = new Piece(0, 1, 1, 2);
			pieces[1] = new Piece(3, 1, 1, 2);
			pieces[2] = new Piece(1, 2, 1, 2);
			pieces[3] = new Piece(2, 2, 1, 2);
			pieces[4] = new Piece(2, 4, 2, 1);
			pieces[5] = new Piece(0, 0, 1, 1);
			pieces[6] = new Piece(3, 0, 1, 1);
			pieces[7] = new Piece(0, 3, 1, 1);
			pieces[8] = new Piece(3, 3, 1, 1);
			pieces[9] = new Piece(1, 0, 2, 2);
		}
		
		movesCounter = 0;
		selected = pieces[9];
		hasWon = false;
	}
	
	public String toString()
	{
		String out = Integer.toString(movesCounter) + "\n";
		for (Piece p : pieces)
		{
			out = out.concat(p.toString() + "\n");
		}
		return out;
	}
}
