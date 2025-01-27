package bank;
import com.NaveenExceptions.*;

public class Demo {
	static void walk() throws InsufficientFunds
	{
		throw new InsufficientFunds();
	}
	public static void main(String[] args)
	{
		try {
			walk();
		}
		catch(InsufficientFunds i)
		{
			System.out.println(i.getMessage());
		}
	}
}
