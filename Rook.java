public class Rook extends Piece
{
	public Rook(int newX, int newY)
	{
		super(newX, newY);
	}

	public void move(Piece [][] board, int m, int n) throws Exception
	{
		int x = getX();
		int y = getY();
		System.out.println("ROOK: ("+x+", "+y+") ("+m+", "+n+")");
		if (!(m<8 && n<8 &&m>=0 && n>=0))
		{
			throw new OutOfBoardException("Coordinates are not on the board!");
		}
		
		if (y==n)
		{
			//horizontal move
			int hDiff=m-x;
			if (hDiff>0)
			{
				//right move, check for pathway obstructions
				for (int i=x+1; i<=m; i++)
				{
					if (!(board[7-y][i].type().equals("empty")))
						throw new PathwayException("There is a piece in the way!");
				}
			}
			else
			{
				for (int i=x-1; i>=m; i--)
				{
					if (!(board[7-y][i].type().equals("empty")))
						throw new PathwayException("There is a piece in the way!");
				}
			}
		}
		else if (x==m)
		{
			//vertical move
			int vDiff = n-y;
			if (vDiff>0)
			{
				//up, check pathway
				for (int i=y+1; i<=n; i++)
					if (!(board[7-i][x].type().equals("empty")))
						throw new PathwayException("There is a piece in the way!");
			}
			else
			{
				//down
				for (int i=y-1; i>=n; i--)
					if (!(board[7-i][x].type().equals("empty")))
						throw new PathwayException("There is a piece in the way!");
			}
		}
		else
		{
			//must be diagonal, throw exception
			throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
		}
		//move
		Rook r = new Rook(m, n);
		board[7-n][m]=r;
		Empty e = new Empty(x, y);
		board[7-y][x]=e;
		System.out.println("Moved! ("+x+", "+y+") ("+m+", "+n+")");
	}

	public String type()
	{
		return "rook";
	}


	public String toString()
	{
		return "-r-";
	}
}