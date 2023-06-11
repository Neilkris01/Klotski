package com.example;

import java.util.ArrayList;
public class Solver
{
	//inizialize the variables
	ArrayList<ArrayList<int[]>> queque;
	int i = 0;
	
	//Read the logFile "Config1Database" into the queue to search if the game is in a possible solve pattern saved
	public void solve(Board board, Piece[] p, ViewPrint view)
	{
		boolean found = false;
		LogFile f = board.getLog();
		queque = f.logReadForSolve();

		for(int c =0; c< queque.size()-1; c++)
		{
			ArrayList<int[]> temp = queque.get(c);
			int cX = 0;
			int cY = 0;
			int k = 0;
			for (int j = 0; j < 10; j++)
			{
				cX = temp.get(j)[0];
				cY = temp.get(j)[1];
				if(cX == p[j].getDims()[0] && cY == p[j].getDims()[1])
				{k++;}
			}
			if(k == 10)
			{
				i = c + 1;
				found = true;
				resolve(board, p);
				c = queque.size()-1;
			}
		}
		if(!found)
		{
			view.solveError();
		}
	}

	//"Database of solution moves"
	public void resolve(Board board, Piece[] p)
	{

		//Solution option for configuration 1
		if (board.getConfig() == 1)
		{
			if(i==1)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 3);
			}
			if(i==2)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 2);
			}
			if(i==3)
			{
				board.selectPiece(p[4]);
				board.movePiece(board, 1);
			}
			if(i==4)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 2);
			}
			if(i==5)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 1);
			}
			if(i==6)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 0);
			}
			if(i==7)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 3);
			}
			if(i==8)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 2);
			}
			if(i==9)
			{
				board.selectPiece(p[4]);
				board.movePiece(board, 3);
			}
			if(i==10)
			{
				board.selectPiece(p[4]);
				board.movePiece(board, 3);
			}
			if(i==11)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 0);
			}
			if(i==12)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 1);
			}
			if(i==13)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 0);
			}
			if(i==14)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 0);
			}
			if(i==15)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 1);
			}
			if(i==16)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 1);
			}
			if(i==17)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 2);
			}
			if(i==18)
			{
				board.selectPiece(p[4]);
				board.movePiece(board, 2);
			}
			if(i==19)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 3);
			}
			if(i==20)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 3);
			}
			if(i==21)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 3);
			}
			if(i==22)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 3);
			}
			if(i==23)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 0);
			}
			if(i==24)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 0);
			}
			if(i==25)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 1);
			}
			if(i==26)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 1);
			}
			if(i==27)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 1);
			}
			if(i==28)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 1);
			}
			if(i==29)
			{
				board.selectPiece(p[4]);
				board.movePiece(board, 2);
			}
			if(i==30)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 2);
			}
			if(i==31)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 3);
			}
			if(i==32)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 3);
			}
			if(i==33)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 3);
			}
			if(i==34)
			{
				board.selectPiece(p[1]);
				board.movePiece(board, 2);
			}
			if(i==35)
			{
				board.selectPiece(p[1]);
				board.movePiece(board, 2);
			}
			if(i==36)
			{
				board.selectPiece(p[9]);
				board.movePiece(board, 1);
			}
			if(i==37)
			{
				board.selectPiece(p[0]);
				board.movePiece(board, 1);
			}
			if(i==38)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 0);
			}
			if(i==39)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 0);
			}
			if(i==40)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 0);
			}
			if(i==41)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 0);
			}
			if(i==42)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 3);
			}
			if(i==43)
			{
				board.selectPiece(p[0]);
				board.movePiece(board, 2);
			}
			if(i==44)
			{
				board.selectPiece(p[0]);
				board.movePiece(board, 2);
			}
			if(i==45)
			{
				board.selectPiece(p[9]);
				board.movePiece(board, 3);
			}
			if(i==46)
			{
				board.selectPiece(p[1]);
				board.movePiece(board, 0);
			}
			if(i==47)
			{
				board.selectPiece(p[1]);
				board.movePiece(board, 0);
			}
			if(i==48)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 1);
			}
			if(i==49)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 0);
			}
			if(i==50)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 0);
			}
			if(i==51)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 3);
			}
			if(i==52)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 0);
			}
			if(i==53)
			{
				board.selectPiece(p[4]);
				board.movePiece(board, 1);
			}
			if(i==54)
			{
				board.selectPiece(p[4]);
				board.movePiece(board, 1);
			}
			if(i==55)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 2);
			}
			if(i==56)
			{
				board.selectPiece(p[0]);
				board.movePiece(board, 2);
			}
			if(i==57)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 3);
			}
			if(i==58)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 3);
			}
			if(i==59)
			{
				board.selectPiece(p[9]);
				board.movePiece(board, 2);
			}
			if(i==60)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 1);
			}
			if(i==61)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 1);
			}
			if(i==62)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 0);
			}
			if(i==63)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 1);
			}
			if(i==64)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 0);
			}
			if(i==65)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 0);
			}
			if(i==66)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 0);
			}
			if(i==67)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 0);
			}
			if(i==68)
			{
				board.selectPiece(p[0]);
				board.movePiece(board, 3);
			}
			if(i==69)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 3);
			}
			if(i==70)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 2);
			}
			if(i==71)
			{
				board.selectPiece(p[9]);
				board.movePiece(board, 2);
			}
			if(i==72)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 2);
			}
			if(i==73)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 3);
			}
			if(i==74)
			{
				board.selectPiece(p[1]);
				board.movePiece(board, 3);
			}
			if(i==75)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 0);
			}
			if(i==76)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 0);
			}
			if(i==77)
			{
				board.selectPiece(p[9]);
				board.movePiece(board, 1);
			}
			if(i==78)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 2);
			}
			if(i==79)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 2);
			}
			if(i==80)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 2);
			}
			if(i==81)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 1);
			}
			if (i==82)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 0);
			}
			if (i==83)
			{
				board.selectPiece(p[0]);
				board.movePiece(board, 0);
			}
			if (i==84)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 3);
			}
			if (i==85)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 2);
			}
			if (i==86)
			{
				board.selectPiece(p[9]);
				board.movePiece(board, 3);
			}
			if (i==87)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 2);
			}
			if (i==88)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 2);
			}
			if (i==89)
			{
				board.selectPiece(p[1]);
				board.movePiece(board, 1);
			}
			if (i==90)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 1);
			}
			if (i==91)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 1);
			}
			if (i==92)
			{
				board.selectPiece(p[2]);
				board.movePiece(board, 1);
			}
			if (i==93)
			{
				board.selectPiece(p[0]);
				board.movePiece(board, 0);
			}
			if (i==94)
			{
				board.selectPiece(p[0]);
				board.movePiece(board, 0);
			}
			if (i==95)
			{
				board.selectPiece(p[9]);
				board.movePiece(board, 3);
			}
			if (i==96)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 2);
			}
			if (i==97)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 2);
			}
			if (i==98)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 2);
			}
			if (i==99)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 2);
			}
			if (i==100)
			{
				board.selectPiece(p[1]);
				board.movePiece(board, 3);
			}
			if (i==101)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 0);
			}
			if (i==102)
			{
				board.selectPiece(p[3]);
				board.movePiece(board, 0);
			}
			if (i==103)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 1);
			}
			if (i==104)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 0);
			}
			if (i==105)
			{
				board.selectPiece(p[4]);
				board.movePiece(board, 0);
			}
			if (i==106)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 1);
			}
			if (i==107)
			{
				board.selectPiece(p[6]);
				board.movePiece(board, 1);
			}
			if (i==108)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 1);
			}
			if (i==109)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 1);
			}
			if (i==110)
			{
				board.selectPiece(p[9]);
				board.movePiece(board, 2);
			}
			if (i==111)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 3);
			}
			if (i == 112)
			{
				board.selectPiece(p[7]);
				board.movePiece(board, 3);
			}
			if (i == 113)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 3);
			}
			if (i == 114)
			{
				board.selectPiece(p[8]);
				board.movePiece(board, 3);
			}
			if (i == 115)
			{
				board.selectPiece(p[4]);
				board.movePiece(board, 0);
			}
			if (i == 116)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 0);
			}
			if (i == 117)
			{
				board.selectPiece(p[5]);
				board.movePiece(board, 1);
			}
			if (i == 118)
			{
				board.selectPiece(p[9]);
				board.movePiece(board, 1);
			}
		}
	}
}