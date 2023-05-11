import java.util.List;

public class Board {
	Piece[] pieces;
	Piece selected;
	int width;
	int height;
	int movesCounter;
	int configuration;
	boolean hasWon;
	
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
	
	/**
	 * Custom constructor that uses a custom array of pieces
	 * @param pieces the custom array of pieces that this board holds
	 */
	public Board(Piece[] pieces)
	{
		this.pieces = pieces;
		this.width = 4;
		this.height = 5;
		this.movesCounter = 0;
		this.configuration = 1;
		this.hasWon = false;
		this.selected = null;
	}
	
	public void setConfig(int number) {this.configuration = number;}
	public boolean checkWin() { return hasWon; }
	public int getMoves() { return movesCounter; }
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
	
	public boolean selectPiece(int x, int y)
	{
		for (Piece p : pieces) {
			if (p.containsPoint(x, y))
			{
				selected = p;
				return true;
			}
		}
		
		selected = null;
		return false;
	}
	
	public boolean isOccupied(int x, int y)
	{
		for (Piece p : pieces) {
			if (p.containsPoint(x, y))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean movePiece(int direction)
	{
		int i;
		
		if (selected == null)
		{
			return false;
		}
		
		if (selected == pieces[0] && selected.x == 1 && selected.y == 3 && direction == 2)
		{
			hasWon = true;
			return true;
		}
		
		if (direction == 0)
		{
			// up
			if (selected.y == 0) return false;
			for (i = selected.x; i < selected.x + selected.w; ++i)
			{
				if (isOccupied(i, selected.y - 1))
				{
					return false;
				}
			}
		}
		else if (direction == 1)
		{
			// right
			if (selected.x + selected.w == width) return false;
			for (i = selected.y; i < selected.y + selected.h; ++i)
			{
				if (isOccupied(selected.x + selected.w, i)) {
					// there's a piece blocking this one
					return false;
				}
			}
		}
		else if (direction == 2)
		{
			// down
			if (selected.y + selected.h == height) return false;
			for (i = selected.x; i < selected.x + selected.w; ++i)
			{
				if (isOccupied(i, selected.y + selected.h))
				{
					// there's a piece blocking this one
					return false;
				}
			}
		}
		else if (direction == 3)
		{
			// left
			if (selected.x == 0) return false;
			for (i = selected.y; i < selected.y + selected.h; ++i)
			{
				if (isOccupied(selected.x - 1, i))
				{
					// there's a piece blocking this one
					return false;
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

	public void reset() {
		pieces = new Piece[10];
		if (configuration == 1)
		{
			pieces[0] = new Piece(1, 0, 2, 2);
			pieces[1] = new Piece(0, 0, 1, 2);
			pieces[2] = new Piece(3, 0, 1, 2);
			pieces[3] = new Piece(0, 2, 1, 2);
			pieces[4] = new Piece(1, 2, 1, 1);
			pieces[5] = new Piece(2, 2, 1, 1);
			pieces[6] = new Piece(3, 2, 1, 2);
			pieces[7] = new Piece(1, 3, 1, 1);
			pieces[8] = new Piece(2, 3, 1, 1);
			pieces[9] = new Piece(1, 4, 2, 1);
		}
		else if (configuration == 2)
		{
			
		}
		else if (configuration == 3)
		{

		}
		
		movesCounter = 0;
		selected = null;
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
