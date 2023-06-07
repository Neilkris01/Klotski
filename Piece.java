
public class Piece
{
	int x;
	int y;
	int w;
	int h;
	String lecter;
	
	public Piece(int x, int y, int w, int h, String l)
	{
		if (x < 0 || y < 0 || w < 1 || h < 1)
			throw new IllegalArgumentException("Invalid Position");
		this.x = x;
		this.y = y;
		this.w = w;
		this.h= h;
		this.lecter = l;
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
	}

	public void setDims(int x1, int y1)
	{
		this.x = x1;
		this.y = y1;
	}

	public void setName(String l1)
	{this.lecter = l1;}

	public int[] getDims()
	{return new int[] {this.x, this.y, this.w, this.h};}
	public String getName()
	{return lecter;}
}
