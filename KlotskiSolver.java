import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;



public class KlotskiSolver {
	
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
					MoveSolver blockPos = null;
					
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

	public void puzzleTranslateOutput(String kSolverOutput, Piece[] pieces)
	{
		char[] caratteri = kSolverOutput.toCharArray();
		int aC = 0, bC = 0, cC = 0, dC = 0, eC = 0, jC = 0, countx = 3, county = 0, j = 0;

		for (county = 0; county < 5; county++) {
			for (countx = 3; countx >= 0; countx--) {
				if (caratteri[j] == 'A' && aC == 0) {
					pieces[0].setPos(countx, county);
					j++;
					aC++;
				} else if (caratteri[j] == 'A' && aC == 1) {
					j++;
				} else if (caratteri[j] == 'B' && bC == 0) {
					pieces[1].setPos(countx, county);
					j++;
					bC++;
				} else if (caratteri[j] == 'B' && bC == 1) {
					j++;
				} else if (caratteri[j] == 'C' && cC == 0) {

					pieces[2].setPos(countx, county);
					j++;
					cC++;
				} else if (caratteri[j] == 'C' && cC == 1) {
					j++;
				} else if (caratteri[j] == 'D' && dC == 0) {
					pieces[3].setPos(countx, county);
					j++;
					dC++;
				} else if (caratteri[j] == 'D' && dC == 1) {
					j++;
				} else if (caratteri[j] == 'E' && eC == 1) {
					pieces[4].setPos(countx, county);
					j++;
				} else if (caratteri[j] == 'E' && eC == 0) {
					eC++;
					j++;
				} else if (caratteri[j] == 'F') {
					pieces[5].setPos(countx, county);
					j++;
				} else if (caratteri[j] == 'G') {
					pieces[6].setPos(countx, county);
					j++;
				} else if (caratteri[j] == 'H') {
					pieces[7].setPos(countx, county);
					j++;
				} else if (caratteri[j] == 'I') {
					pieces[8].setPos(countx, county);
					j++;
				} else if (caratteri[j] == 'J' && jC == 1) {
					pieces[9].setPos(countx, county);
					jC++;
				} else if (caratteri[j] == 'J' && jC == 0) {
					j++;
					jC++;
				} else if (caratteri[j] == '0') {
					j++;
				}
			}
		}
	}
}
	/*private void printSolution(String solution){
	/*private void printSolution(String solution){
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