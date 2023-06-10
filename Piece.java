
public class Piece
{

	//inizialize the variables
	int x;
	int y;
	int w;
	int h;
	String lecter;
	
	//piece constructor
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

	//change the x, y of the piece based on the move made
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

	//change the x, y of the piece
	public void setPos(int x1, int y1)
	{
		this.x = x1;
		this.y = y1;
	}

	//setter and getter of piece's name
	public void setName(String l1)
	{this.lecter = l1;}
	public String getName()
	{return lecter;}

	//getter of piece's x, y, w, h
	public int[] getDims()
	{return new int[] {this.x, this.y, this.w, this.h};}
}
