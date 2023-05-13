import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PiecesView
{
    void printPiece(Piece[] p, Rectangle[][] squares)
    {
        
        // Set up the initial state of the game
        int p0[] = p[0].getDims();
        Color color = Color.ORANGE;
        for (int y = 0; y < p0[3]; y++)
        {
            for (int x = 0; x < p0[2]; x++)
            {
                squares[p0[1]+y][p0[0]+x].setFill(color);
                squares[p0[1]+y][p0[0]+x].setStroke(color);
            }
        }
        
        int p1[] = p[1].getDims();
        for (int y = 0; y < p1[3]; y++)
        {
            for (int x = 0; x < p1[2]; x++)
            {
                squares[p1[1]+y][p1[0]+x].setFill(Color.BLUE);
                squares[p1[1]+y][p1[0]+x].setStroke(Color.BLUE);
            }
        }

        int p2[] = p[2].getDims();
        for (int y = 0; y < p2[3]; y++)
        {
            for (int x = 0; x < p2[2]; x++)
            {
                squares[p2[1]+y][p2[0]+x].setFill(Color.YELLOW);
                squares[p2[1]+y][p2[0]+x].setStroke(Color.YELLOW);
            }
        }

        int p3[] = p[3].getDims();
        for (int y = 0; y < p3[3]; y++)
        {
            for (int x = 0; x < p3[2]; x++)
            {
                squares[p3[1]+y][p3[0]+x].setFill(Color.GREEN);
                squares[p3[1]+y][p3[0]+x].setStroke(Color.GREEN);
            }
        }

        int p4[] = p[4].getDims();
        for (int y = 0; y < p4[3]; y++)
        {
            for (int x = 0; x < p4[2]; x++)
            {
                squares[p4[1]+y][p4[0]+x].setFill(Color.PINK);
                squares[p4[1]+y][p4[0]+x].setStroke(Color.PINK);
            }
        }

        int p5[] = p[5].getDims();
        for (int y = 0; y < p5[3]; y++)
        {
            for (int x = 0; x < p5[2]; x++)
            {
                squares[p5[1]+y][p5[0]+x].setFill(Color.PINK);
                squares[p5[1]+y][p5[0]+x].setStroke(Color.PINK);
            }
        }

        int p6[] = p[6].getDims();
        for (int y = 0; y < p6[3]; y++)
        {
            for (int x = 0; x < p6[2]; x++)
            {
                squares[p6[1]+y][p6[0]+x].setFill(Color.BROWN);
                squares[p6[1]+y][p6[0]+x].setStroke(Color.BROWN);
            }
        }

        int p7[] = p[7].getDims();
        for (int y = 0; y < p7[3]; y++)
        {
            for (int x = 0; x < p7[2]; x++)
            {
                squares[p7[1]+y][p7[0]+x].setFill(Color.GRAY);
                squares[p7[1]+y][p7[0]+x].setStroke(Color.GRAY);
            }
        }

        int p8[] = p[8].getDims();
        for (int y = 0; y < p8[3]; y++)
        {
            for (int x = 0; x < p8[2]; x++)
            {
                squares[p8[1]+y][p8[0]+x].setFill(Color.BLUE);
                squares[p8[1]+y][p8[0]+x].setStroke(Color.BLUE);
            }
        }

        int p9[] = p[9].getDims();
        for (int y = 0; y < p9[3]; y++)
        {
            for (int x = 0; x < p9[2]; x++)
            {
                squares[p9[1]+y][p9[0]+x].setFill(Color.BLUE);
                squares[p9[1]+y][p9[0]+x].setStroke(Color.BLUE);
            }
        }
    }
}
