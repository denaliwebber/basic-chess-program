public abstract class Piece 
{
	private int x;
	private int y;

	public Piece(int x, int y)
	{
		this.x=x;
		this.y=y;
	}

	public abstract void move(Piece [][] board, int m, int n) throws Exception;
	public abstract String type();

	public void setX(int newX)
	{
		x=newX;
	}

	public void setY(int newY)
	{
		y=newY;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public String toString()
	{
		return "piece";
	}
}