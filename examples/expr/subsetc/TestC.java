package expr.subsetc;

import java.io.IOException;
import java.io.StringReader;
import beaver.Symbol;
import beaver.Parser;

public class TestC
{
	public static void main(String[] args)
	{
	       SubsetScanner input = new SubsetScanner(new StringReader(args[0]));
		try
		{
			Expr result = (Expr) new SubsetParser().parse(input);
			System.out.println("= " + result.val);
		}
		catch (IOException e)
		{
			System.err.println("Failed to read expression: " + e.getMessage());
		}
		catch (Parser.Exception e)
		{
			System.err.println("Invalid expression: " + e.getMessage());
		}
	}
}
