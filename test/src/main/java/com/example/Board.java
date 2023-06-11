package com.example;

public class Board
{
	//inizialize the variables
	Piece[] pieces;
	Piece selected;
	int width;
	int height;
	int movesCounter;
	int configuration;
	boolean hasWon;
	int i;
	int start = 0;
	String fileName;
	LogFile log = new LogFile();
	
	//board constructor
	public Board()
	{
		this.pieces = new Piece[10];
		this.configuration = 1;
		
		reset(configuration);
		
		this.width = 4;
		this.height = 5;
	}
	
	//setter and getter
	public void setConfig(int number) {this.configuration = number;}
	public void setCounter(int count) {this.movesCounter = count;}
	public boolean checkWin() { return hasWon; }
	public int getConfig() {return configuration;}
	public int getCounter() { return movesCounter; }
	public Piece getSelectedPiece() { return selected; }
	public int getWidth() { return width; }
	public int getHeight() { return height; }
	public Piece[] getPieces() { return pieces; }
	public LogFile getLog() { return log; }
	
	//select the piece
	public void selectPiece(Piece p)
	{
		selected = p;
	}

	//check if the piece pointed is the selected one
	public boolean isSelect(Piece p)
	{
		if(selected != null)
		{
			if((p.getDims()[0] == selected.getDims()[0]) && (p.getDims()[1] == selected.getDims()[1]))
			{
				return true;
			}
		}
		return false;
	}
	
	//check the collision of rectangles with the board and other rectangles
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
	
	//move the selected piece and check if the move is a winning move
	public boolean movePiece(Board board, int direction)
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

		log.logWrite(pieces, board);
		return true;
	}

	//reset the game and reinizialize the game with the chosen configuration
	public void reset(int config)
	{
		configuration = config;
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
		else if (configuration == 4)
		{
			pieces[0] = new Piece(3, 1, 1, 2);
			pieces[1] = new Piece(3, 3, 1, 2);
			pieces[2] = new Piece(1, 1, 1, 2);
			pieces[3] = new Piece(2, 3, 1, 2);
			pieces[4] = new Piece(1, 0, 2, 1);
			pieces[5] = new Piece(2, 2, 1, 1);
			pieces[6] = new Piece(0, 0, 1, 1);
			pieces[7] = new Piece(3, 0, 1, 1);
			pieces[8] = new Piece(0, 2, 1, 1);
			pieces[9] = new Piece(0, 3, 2, 2);
		}
		selected = null;
		setCounter(0);
	}
}
