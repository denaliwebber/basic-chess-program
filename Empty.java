public class Empty extends Piece
{
	public Empty(int newX, int newY)
	{
		super(newX, newY);
	}

	public void move(Piece [][] board, int m, int n) throws Exception
	{
		System.out.print("");
	}

	public String type()
	{
		return "empty";
	}

	public String toString()
	{
		return "---";
	}
}