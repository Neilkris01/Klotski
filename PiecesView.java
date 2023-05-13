import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PiecesView
{
    void printPiece(Piece[] p, Rectangle[][] squares)
    {
        /*
        // Set up the initial state of the game
        int p0[] = p[0].getDims();
        for (int y = 0; y < p0[3]; y++)
        {
            for (int x = 0; x < p0[2]; x++)
            {
                squares[p0[1]+y][p0[0]+x].setFill(Color.ORANGE);
            }
        }

        int p1[] = p[1].getDims();
        for (int y = 0; y < p1[3]; y++)
        {
            for (int x = 0; x < p1[2]; x++)
            {
                squares[p1[1]+y][p1[0]+x].setFill(Color.BLUE);
            }
        }

        int p2[] = p[2].getDims();
        for (int y = 0; y < p2[3]; y++)
        {
            for (int x = 0; x < p2[2]; x++)
            {
                squares[p2[1]+y][p2[0]+x].setFill(Color.YELLOW);
            }
        }

        int p3[] = p[3].getDims();
        for (int y = 0; y < p3[3]; y++)
        {
            for (int x = 0; x < p3[2]; x++)
            {
                squares[p3[1]+y][p3[0]+x].setFill(Color.GREEN);
            }
        }

        int p4[] = p[4].getDims();
        for (int y = 0; y < p4[3]; y++)
        {
            for (int x = 0; x < p4[2]; x++)
            {
                squares[p4[1]+y][p4[0]+x].setFill(Color.PINK);
            }
        }

        int p5[] = p[5].getDims();
        squares[p5[1]][p5[0]].setFill(Color.PURPLE);

        int p6[] = p[6].getDims();
        squares[p6[1]][p6[0]].setFill(Color.BROWN);

        int p7[] = p[7].getDims();
        squares[p7[1]][p7[0]].setFill(Color.GRAY);

        int p8[] = p[8].getDims();
        squares[p8[1]][p8[0]].setFill(Color.BLACK);
        */
        int p9[] = p[0].getDims();
        for (int y = 0; y < p9[3]; y++)
        {
            for (int x = 0; x < p9[2]; x++)
            {
                squares[p9[1]+y][p9[0]+x].setFill(Color.RED);
            }
        }
    }
}
