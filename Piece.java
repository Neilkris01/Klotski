/**
 * a class that represents a single klotski piece
 */
public class Piece {
	int x;
	int y;
	int w;
	int h;
	
	public Piece(int x, int y, int w, int h)
	{
		if (x < 0 || y < 0 || w < 1 || h < 1)
			throw new IllegalArgumentException("Invalid Position");
		this.x = x;
		this.y = y;
		this.w = w;
		this.h= h;
	}

	public boolean containsPoint(int x, int y)
	{
		if (x >= this.x && y >= this.y && x < (this.x + this.w) && y < (this.y + this.h))
		{return true;}
		else
		{return false;}
	}

	public void move(int mov)
	{
		if (mov == 0) // up
			this.y--;
		else if (mov == 2) // down
			this.y++;
		else if (mov == 3) // left
			this.x--;
		else if (mov == 1) // right
			this.x++;
		else
			throw new IllegalArgumentException("Invalid Direction");
	}

	public int[] getDims() {
		return new int[] {this.x, this.y, this.w, this.h};
	}
	
	public String toString() {
		String out = "";
		out = out.concat(Integer.toString(x) + " ")
				.concat(Integer.toString(y) + " ")
				.concat(Integer.toString(w) + " ")
				.concat(Integer.toString(h));
		return out;
	}
}
