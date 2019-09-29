public class Bishop extends Piece
{
	public Bishop(int newX, int newY)
	{
		super(newX, newY);
	}

	public void move(Piece [][] board, int m, int n) throws Exception
	{
		int x = getX();
		int y = getY();
		System.out.println("BISHOP: ("+x+", "+y+") ("+m+", "+n+")");
		if (!(m<8 && n<8 &&m>=0 && n>=0))
		{
			throw new OutOfBoardException("Coordinates are not on the board!");
		}

		if (m==x || n==y)
		{
			//must be diagonal
			throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
		}

		int hDiff=m-x;
		int vDiff=n-y;

		if (hDiff>0 && vDiff>0)
		{
			//diagonal right and up, check pathway
			int i=x+1;
			for(int j=y+1;j<=n;j++)
			{
				if (!(board[7-j][i].type().equals("empty")))
					throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
				i++;
			}
		}

		else if (hDiff>0 && vDiff<0)
		{
			//diagonal right and down
			int i=x+1;
			for (int j=y-1; j>=n; j--)
			{
				if (!(board[7-j][i].type().equals("empty")))
					throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
				i++;
			}
		}

		else if (hDiff<0 && vDiff>0)
		{
			//diagonal left and up
			int i=x-1;
			for (int j=y+1; j<=n; j++)
			{
				if (!(board[7-j][i].type().equals("empty")))
					throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
				i--;
			}
		}

		else if (hDiff<0 && vDiff<0)
		{
			//diagonal left and down
			int i=x-1;
			for (int j=y-1; j>=n; j--)
			{
				if (!(board[7-j][i].type().equals("empty")))
					throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
				i--;
			}
		}

		//move
		Bishop b = new Bishop(m, n);
		board[7-n][m]=b;
		Empty e = new Empty(x, y);
		board[7-y][x]=e;
		System.out.println("Moved! ("+x+", "+y+") ("+m+", "+n+")");
	}

	public String type()
	{
		return "bishop";
	}

	public String toString()
	{
		return "-b-";
	}
}