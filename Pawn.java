public class Pawn extends Piece
{
	private int firstX;
	private int firstY;

	public Pawn(int newX, int newY)
	{
		super(newX, newY);
		firstY=0;
		firstX=0;
	}

	public void move(Piece [][] board, int m, int n) throws Exception
	{
		int x = getX();
		int y = getY();
		System.out.println("PAWN: ("+x+", "+y+") ("+m+", "+n+")");
		if (!(m<8 && n<8 &&m>=0 && n>=0))
		{
			throw new OutOfBoardException("Coordinates are not on the board!");
		}

		if (x!=m)
			throw new IllegalChessMoveException("That is an illegal chess move for that piece!");

		if (y!=firstY)
		{
			//can only move one space
			if (!(y==n-1))
				throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
			else
				if (!(board[7-n][m].type().equals("empty")))
					throw new PathwayException("There is a piece in the way!");
		}

		else if (y==firstY)
		{
			//can move one or two spaces
			if (!(y==n-1 || y==n-2))
				throw new IllegalChessMoveException("That is an illegal chess move for that piece!");
			else
			{
				if (!(board[7-n][m].type().equals("empty")))
					throw new PathwayException("There is a piece in the way!");
			}
		}

		//move
		Pawn p = new Pawn(m, n);
		board[7-n][m]=p;
		Empty e = new Empty(x, y);
		board[7-y][x]=e;
		System.out.println("Moved! ("+x+", "+y+") ("+m+", "+n+")");
	}

	public String type()
	{
		return "pawn";
	}

	public String toString()
	{
		return "-p-";
	}

	public void setFirstX(int nX)
	{
		firstX=nX;
	}

	public void setFirstY(int nY)
	{
		firstY=nY;
	}
}