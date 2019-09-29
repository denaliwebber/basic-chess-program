public class Knight extends Piece
{
	public Knight(int newX, int newY)
	{
		super(newX, newY);
	}

	public void move(Piece [][] board, int m, int n) throws Exception
	{
		int x = getX();
		int y = getY();
		System.out.println("KNIGHT: ("+x+", "+y+") ("+m+", "+n+")");

		if (!(m<8 && n<8 &&m>=0 && n>=0))
		{
			throw new OutOfBoardException("Coordinates are not on the board!");
		}

		int hDiff = m-x;
		int vDiff = n-y;
		if (hDiff==1 || hDiff==-1)
		{
			if (!(vDiff==2 || vDiff==-2))
				throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
		}
		else if (hDiff==2 || hDiff==-2)
		{
			if (!(vDiff==1 || vDiff==-1))
				throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
		}
		else
			throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
		if (!(board[7-n][m].type().equals("empty")))
			throw new PathwayException("There is a piece in the way!");

		//move
		Knight k = new Knight(m, n);
		board[7-n][m]=k;
		Empty e = new Empty(x, y);
		board[7-y][x]=e;
		System.out.println("Moved! ("+x+", "+y+") ("+m+", "+n+")");
	}

	public String type()
	{
		return "knight";
	}

	public String toString()
	{
		return "-h-";
	}
}