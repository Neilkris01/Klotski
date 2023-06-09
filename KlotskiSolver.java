import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

class Move
{
	int x;
	int y;
	Block block;
	
	public Move(int x, int y, Block block)
	{
		this.x = x;
		this.y = y;
		this.block = block;
	}
}

//----------------------

/**
 * @author Alex Salerno
 * @version 0.1
 *
 */
public class Block
{
	String name;
	int id;
	int area;
	int height;
	int width;
	Type type;
	
	public enum Type
	{
		SINGLE,DOUBLE_WIDE,DOUBLE_TALL,QUAD
	}
	
	public Block(int i, int h, int w, String n)
	{
		this.name = n;
		this.height = h;
		this.width = w;
		this.area = h * w;
		this.id = i;
	}
	
	@Override public String toString(){
		return "{ name: " + this.name + " Size:(" + this.width + "," + this.height + ") area: " + this.area + " }";
	}
}

//-------------------------

public class KlotskiPuzzle
{
	static final String EMPTY = "0";		//an empty space in the grid
	static final String SOLVED_CHAR = "J";	//Block name that meets victory condition
	static final int GRID_WIDTH = 5;
	static final int GRID_HEIGHT = 4;
	static final String[] BLOCK_NAMES = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
	
	//static final String DEFAULT_CONFIG = "AJJCAJJCBEEDBGHDF00I";	//116 moves to win
	static final String DEFAULT_CONFIG = "HEEGA0C0AFCIBDJJBDJJ";	//7 moves to win
	//static final String DEFAULT_CONFIG = "0B0CABDCAHDFJJEEJJIG";	//9 moves to win
	//static final String DEFAULT_CONFIG = "0AB0DABCDJJCIJJFHEEG";	//25 moves to win
	
	String[][] grid = new String[GRID_WIDTH][GRID_HEIGHT];
	Map<String, Block> blocks = new Hashtable<String, Block>();
	
	//Track grid configurations of each move
	Stack<String> grids = new Stack<String>();						
	//Track each move up until current configuration
	Stack<Move> moves = new Stack<Move>();
	
	//CONSTRUCTOR
	public KlotskiPuzzle()
	{init(DEFAULT_CONFIG);}
	
	public KlotskiPuzzle(String code)
	{init(code);}
	
	private void init(String code)
	{
		initBlocks();
		codeToGrid(code);
		grids.push(getGridCode());
	}
	
	/*
	 * @param x - x-coord to move to
	 * @param y - y-coord to move to
	 * @param b - Block being moved
	 */
	public Boolean move(int x, int y, String block)
	{
		if(block.isEmpty() || !blocks.containsKey(block)) return false;
		Block b = blocks.get(block);
		if(!isValidMove(x,y,b)) return false;
		else
		{
			replaceBlock(b.name,EMPTY);
			insertBlock(x,y,b);
			grids.push(getGridCode());
			moves.push(new Move(x,y,b));
		}
		return true;
	}
	
	public Boolean isSolved()
	{
		if(grid[4][1].equals(SOLVED_CHAR) && grid[4][2].equals(SOLVED_CHAR))
		{
			return true;
		}
		return false;
	}
	
	//Prints out the puzzles current state
	public void printPuzzle()
	{
		System.out.println("    0 1 2 3 4 ");
		System.out.println("   -----------");
		for(int j=0; j<GRID_HEIGHT;j++)
		{
			System.out.print(j + " | ");
			for(int i=0; i<GRID_WIDTH;i++)
			{
				System.out.print(grid[i][j] + " ");
			}
			if(j==1 || j==2) System.out.print("+");
			else System.out.print("|");
			System.out.println();
		}
		System.out.println("   -----------");
	}
	
	public String getGrid(int x, int y)
	{
		if(x < 0 || x >= GRID_WIDTH) return "";
		if(y < 0 || y >= GRID_HEIGHT) return "";
		return grid[x][y];
	}
	
	//TODO make more efficient, use Huffman encoding
	public String getGridCode()
	{
		String code = "";
		for(int i=0;i<GRID_WIDTH;i++){
			for(int j=0;j<GRID_HEIGHT;j++)
			{
				code += grid[i][j];
			}
		}
		return code;
	}
	
	public Stack<Move> getMoves()
	{return moves;}
	
	public Block getBlock(String block)
	{
		if(!blocks.containsKey(block)) return null;
		return blocks.get(block);
	}
	
	public Boolean undo()
	{
		if(grids.size() < 2) return false;
		grids.pop();
		moves.pop();
		codeToGrid(grids.peek());
		return true;
	}
	
	public void codeToGrid(String code)
	{
		int s = 0;
		int max = GRID_WIDTH * GRID_HEIGHT;
		for(int i=0;i<GRID_WIDTH;i++)
		{
			for(int j=0;j<GRID_HEIGHT;j++)
			{
				if(s>code.length() || s>=max) break;
				grid[i][j] = Character.toString(code.charAt(s));
				s++;
			}
		}
	}
	
	public void printMoves()
	{
		while(!moves.isEmpty())
		{
			Move m = moves.pop();
			System.out.println("Move " + m.block.name + " to (" + m.x + "," + m.y + ")");
		}
	}
	
	/*	=================================================
	 * 	Private Functions
	 *  =================================================
	 */ 
	
	//Initializes blocks to default sizes
	private void initBlocks(){
		//new Block(Height,Width,Name)
		blocks.put("A",new Block(1,1,2,"A"));
		blocks.put("B",new Block(2,1,2,"B"));
		blocks.put("C",new Block(3,1,2,"C"));
		blocks.put("D",new Block(4,1,2,"D"));
		blocks.put("E",new Block(5,2,1,"E"));
		blocks.put("F",new Block(6,1,1,"F"));
		blocks.put("G",new Block(7,1,1,"G"));
		blocks.put("H",new Block(8,1,1,"H"));
		blocks.put("I",new Block(9,1,1,"I"));
		blocks.put("J",new Block(10,2,2,"J"));
	}
	
	/* If block b will collide with any block return true, else false
	 * @param x - x-coord to move to
	 * @param y - y-coord to move to
	 * @param b - Block being moved
	 */
	private Boolean isCollision(int x, int y, Block b)
	{
		if(grid[x][y].equals(EMPTY) || grid[x][y].equals(b.name))
		{
			//check for width collision
			for(int i=1;i<b.width;i++)
			{
				if(!grid[x+i][y].equals(EMPTY) && !grid[x+i][y].equals(b.name))
				{
					return true;
				}
			}
			//check for height collision
			for(int i=1;i<b.height;i++)
			{
				if(!grid[x][y+i].equals(EMPTY) && !grid[x][y+i].equals(b.name))
				{
					return true;
				}
			}
			//check for inner
			for(int i=1;i<b.width;i++)
			{
				for(int j=1;j<b.height;j++)
				{
					if(!grid[x+i][y+j].equals(EMPTY) && !grid[x+i][y+j].equals(b.name))
					{
						return true;
					}
				}
			}
			return false;
		}
		return true;
	}
	
	private Boolean isValidMove(int x, int y, Block b)
	{
		Move c = getBlockPos(b);
		if(x+(b.width-1) >= GRID_WIDTH || y+(b.height-1) >= GRID_HEIGHT) return false;
		if(isCollision(x,y,b)) return false;
		if(x != c.x && y != c.y) return false;
		if(Math.abs(x-c.x) > 1 || Math.abs(y-c.y) > 1) return false;
		return true; 
	}
	
	//returns move object with current position of block b
	public Move getBlockPos(Block b)
	{
		if(b != null && blocks.containsKey(b.name))
		{
			Move c = new Move(0,0,b);
			for(int i=0;i<GRID_WIDTH;i++)
			{
				for(int j=0;j<GRID_HEIGHT;j++)
				{
					if(grid[i][j].equals(b.name))
					{
						c.x = i;
						c.y = j;
						return c;
					}
				}
			}
		}
		return null;
	}
	
	/*
	 * Replaces Block B1 with B2
	 */
	private void replaceBlock(String b1, String b2)
	{
		for(int i=0;i<GRID_WIDTH;i++){
			for(int j=0;j<GRID_HEIGHT;j++)
			{
				if(grid[i][j].equals(b1))
				{
					grid[i][j] = b2;
				}
			}
		}
	}
	
	private void insertBlock(int x, int y, Block b)
	{
		for(int i=x;i<x+b.width;i++)
		{
			for(int j=y;j<y+b.height;j++)
			{
				grid[i][j] = b.name;
			}
		}
	}
}

//--------------------------

public class KlotskiSolver
{
	String[][] grid = new String[4][5]; // board girata di 90gradi
	public void boardToGrid(Piece[] pieces)
	{
		for(int i=0;i<10;i++)
		{
			int x1 = pieces[i].getDims()[0];
			int y1 = pieces[i].getDims()[1];
			if(pieces[i].getDims()[2]==2 && pieces[i].getDims()[3]==2) //pezzo 2x2
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
				int x2 = 0, y2 = 0;
				for (int j = 0; j < (pieces[i].getDims()[2]); j++) {
					x2 = x1 + j;
					for (int j1 = 0; j1 < (pieces[i].getDims()[3]); j1++)
					{
						y2 = y1 + j1;
					
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
	}

	KlotskiPuzzle puzzle;
	Map<String, String> tree = new Hashtable<String, String>();
	
	public KlotskiSolver(KlotskiPuzzle puzzle)
	{this.puzzle = puzzle;}
	
	public void solve()
	{solve(false);}
	
	public String solve(Boolean verbose)
	{
    	//long start = Calendar.getInstance().getTimeInMillis();
    	
		//System.out.println("Solving puzzle...");
		
		//compute solution
		String solution = findValidPath(puzzle.getGridCode(),verbose); //QUESTO è L'OUTPUT!!!!!!!!!!!!!!
        return solution;
		//System.out.println(solution);
		//KlotskiPuzzle a = new KlotskiPuzzle(solution);
		//System.out.println(a.blocks.get("A").toString());
		//printSolution(solution);
		
		//calculate duration to solve
		//long end = Calendar.getInstance().getTimeInMillis();
		//long duration = (end - start)/1000;
		//long durationExt = (end - start)%1000;
		
		//System.out.println("Duration: " + duration + "." + durationExt + "s");
	}
	
	//Root is the grids gridCode
	private String findValidPath(String rootCode, Boolean verbose)
	{
		Queue<String> grids = new LinkedList<String>();
		Set<String> pastGrid = new HashSet<String>();
		int moveCount = 0;
		String current = "";
		
		grids.add(rootCode);
		pastGrid.add(rootCode);
		tree.put(rootCode, "");
		
		//while(!grids.isEmpty()){
		for(int i = 0; i < 2;i++)
		{
			current = grids.remove();
			
			if(isSolved(current))
			{
				if(verbose) System.out.println("Solution found in " + moveCount + " tries!");
				//break;
			}
			String[] nextGrid = findAllMoves(current, verbose);
			for(String g : nextGrid)
			{
				if(pastGrid.contains(g)) continue;
				if(verbose) System.out.println(moveCount + "\tAdding grid " + g + " to queue. ");
				//add nodes to current, set each node parent to current node
				grids.add(g);
				pastGrid.add(g);
				tree.put(g,current);
			}
			moveCount++;
		}
		return current;
	}
	
	private String[] findAllMoves(String gridCode,Boolean verbose)
	{
		if(verbose) System.out.println("\tFinding all moves for " + gridCode);
		//String[] blocks = KlotskiPuzzle.BLOCK_NAMES;
		List<String> results = new ArrayList<String>();
		KlotskiPuzzle p = new KlotskiPuzzle(gridCode);
		
		//Iterate through each column
		for(int i=0; i<KlotskiPuzzle.GRID_WIDTH;i++)
		{
			for(int j=0;j<KlotskiPuzzle.GRID_HEIGHT;j++)
			{
				if(p.getGrid(i,j).equals(KlotskiPuzzle.EMPTY))
				{
					String moveBlock = "";
					Move blockPos = null;
					
					//look up, check if you can move it down
					moveBlock = p.getGrid(i, j-1);
					blockPos = p.getBlockPos(p.getBlock(moveBlock));
					if(blockPos != null && p.move(blockPos.x, blockPos.y+1,moveBlock))
					{
						results.add(p.getGridCode());
						p = new KlotskiPuzzle(gridCode);
					}
					
					//look left, check if you can move it right
					moveBlock = p.getGrid(i-1, j);
					blockPos = p.getBlockPos(p.getBlock(moveBlock));
					if(blockPos != null && p.move(blockPos.x+1, blockPos.y,moveBlock))
					{
						results.add(p.getGridCode());
						p = new KlotskiPuzzle(gridCode);
					}
					
					//look right, check if you can move it left
					moveBlock = p.getGrid(i+1, j);
					blockPos = p.getBlockPos(p.getBlock(moveBlock));
					if(blockPos != null && p.move(blockPos.x-1, blockPos.y,moveBlock))
					{
						results.add(p.getGridCode());
						p = new KlotskiPuzzle(gridCode);
					}
					
					//look down, check if you can move it up
					moveBlock = p.getGrid(i, j+1);
					blockPos = p.getBlockPos(p.getBlock(moveBlock));
					if(blockPos != null && p.move(blockPos.x, blockPos.y-1,moveBlock))
					{
						results.add(p.getGridCode());
						p = new KlotskiPuzzle(gridCode);
					}
				}
			}
		}
		
		String[] resultsArray = new String[ results.size() ];
		return results.toArray(resultsArray);
	}
	
	private Boolean isSolved(String gridCode)
	{
		KlotskiPuzzle p = new KlotskiPuzzle(gridCode);
		return p.isSolved();
	}
	
	private void printSolution(String solution)
	{
		Stack<String> reverse = new Stack<String>();
		KlotskiPuzzle puzzle;
		int moves = 0;
		
		reverse.push(solution);
		String current = tree.get(solution);
		
		while(!current.isEmpty()){
			reverse.push(current);
			current = tree.get(current);
		}
		while(!reverse.isEmpty()){
			System.out.println("Move:" + moves++);
			puzzle = new KlotskiPuzzle(reverse.pop());
			puzzle.printPuzzle();
		}
		System.out.println("Solution in " + (moves-1) + " moves!");
	}
}

//---------------------
/* 
public class Main {

	public static void main(String[] args) {
//		KlotskiSolver solver = new KlotskiSolver(new KlotskiPuzzle());
//		solver.solve(true);
		
		KlotskiPuzzle puzzle = new KlotskiPuzzle();
		KlotskiSolver answer = new KlotskiSolver(puzzle);
		
		
		//example, delete or comment out if you want
//		puzzle.printPuzzle();
//		puzzle.move(4, 1, "F");
//		puzzle.move(3, 0, "B");
//		puzzle.move(2, 0, "E");
//		puzzle.move(2, 2, "H");
//		puzzle.move(3, 2, "D");	//illegal move
//		puzzle.move(4, 2, "I");
//		puzzle.move(4, 3, "D");	//illegal move
//		puzzle.move(3, 3, "D");
//		puzzle.undo();
//		puzzle.undo();
//		puzzle.printPuzzle();
//		System.out.println(puzzle.isSolved());
//		System.out.println(puzzle.getGridCode());
		answer.solve(false);
		//puzzle.printPuzzle();
		
	}
}
per far andare il codice quando schiacci bottone: (hai la tua Board board)
String config = boardToGrid(pieces); //trasformo la matrice in stringa
KlotskiPuzzle puzzle = new KlotskiPuzzle(config); // creo il puzzle da risolvere con la config attuale
KlotskiSolver answer = new KlotskiSolver(puzzle); //risolvo il mio puzzle
String solution = answer.solve(false); //una volta risolto ricevo la configurazione in stringa
board.funzioneDiOutputGallo(solution); //ora Gallo usa la configurazione per muovere il pezzo
*/