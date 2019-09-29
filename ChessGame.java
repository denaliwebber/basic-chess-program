import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ChessGame
{
	public static void main(String[] args) throws Exception
	{
		Piece board[][] = new Piece[8][8];
    	for(int i=0; i<8; i++)
    	{
    		for (int j=0; j<8; j++)
    		{
    			Empty e = new Empty(i, j);
    			board[i][j]=e;
    		}
    	}

		Scanner scan = new Scanner(new File("input.txt"));
		String line;
		String[] lineSegment;

		while(scan.hasNextLine())
		{
    		line = scan.nextLine();
 	  		lineSegment = line.split(" ");

 	  		int initialX = Integer.parseInt(lineSegment[1]);
 	  		int initialY = Integer.parseInt(lineSegment[2]);

 	  		if (lineSegment[0].equals("move"))
 	  		{
 	  			int m = Integer.parseInt(lineSegment[3]);
 	  			int n = Integer.parseInt(lineSegment[4]);
 				try
 				{
 					board[7-initialY][initialX].move(board, m,n);
 				}
 				catch (OutOfBoardException ex)
 				{
 					System.out.println("Coordinates are not on the board!");
 				}
 				catch (IllegalChessMoveException ex)
 				{
 					System.out.println("That is an illegal chess move for that piece!");
 				}
 				catch (PathwayException ex)
 				{
 					System.out.println("There is a piece in the way!");
 				}
 			}

 	  		else
 	  		{
 	  			switch (lineSegment[0])
 	  			{
 	  				case "pawn":
 	  					Pawn p = new Pawn(initialX, initialY);
 	  					p.setFirstX(initialX);
 	  					p.setFirstY(initialY);
 	  					board[7-initialY][initialX]=p;
 	  					break;
 	  				case "rook":
 	  					Rook r = new Rook(initialX, initialY);
 	  					board[7-initialY][initialX]=r;
 	  					break;
 	  				case "knight":
 	  					Knight h = new Knight(initialX, initialY);
 	  					board[7-initialY][initialX]=h;
 	  					break;
 	  				case "bishop":
 	  					Bishop b = new Bishop(initialX, initialY);
 	  					board[7-initialY][initialX]=b;
 	  					break;
 	  				case "king":
 	  					King k = new King(initialX, initialY);
 	  					board[7-initialY][initialX]=k;
 	  					break;
 	  				case "queen":
 	  					Queen q = new Queen (initialX, initialY);
 	  					board[7-initialY][initialX]=q;
 	  					break;
 	  			}
 	  		}
    	}

    	//print board
        int counter=7;
    	for (int i=0; i<8; i++)
    	{
            System.out.print("="+counter+"= ");
            counter--;
    		for (int j=0; j<8; j++)
            {
    			System.out.print(board[i][j]+" ");
            }
    		System.out.println();
    	}
        System.out.print("=== ");
        for (int i=0; i<8; i++)
        {
            System.out.print("="+i+"= ");
        }
        System.out.println();
	}
}
