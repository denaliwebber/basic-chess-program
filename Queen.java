public class Queen extends Piece
{
	public Queen(int newX, int newY)
	{
		super(newX, newY);
	}

	public void move(Piece [][] board, int m, int n) throws Exception
	{
		int x = getX();
		int y = getY();
		System.out.println("Queen: ("+x+", "+y+") ("+m+", "+n+")");
		if (!(m<8 && n<8 &&m>=0 && n>=0))
		{
			throw new OutOfBoardException("Coordinates are not on the board!");
		}

		int hDiff = m-x;
		int vDiff = n-y;

		if (y==n)
		{
			//horizontal move
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

		else if (hDiff>0 && vDiff>0)
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
		Queen k = new Queen(m, n);
		board[7-n][m]=k;
		Empty e = new Empty(x, y);
		board[7-y][x]=e;
		System.out.println("Moved! ("+x+", "+y+") ("+m+", "+n+")");
	}

	public String type()
	{
		return "queen";
	}


	public String toString()
	{
		return "-q-";
	}
}