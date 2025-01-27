package bank;
import java.util.*;

public abstract class GenericImplementation implements ReserveBankOfIndia {
	String name;
	static int p=5287;
	private int pin;
	static int a=162347;
	int accountNumber;
	static int transactionId;
	double balance;

	GenericImplementation()
	{
		this.pin=p;
		this.accountNumber=a;
		this.transactionId=647183;
	}
	
	public void createAccount(Scanner sc)
	{
		System.out.println("\nEnter Account Holder Details:-");
		System.out.println("Enter Name: ");
		sc.nextLine();
		this.name=sc.nextLine();
		a+=37;
		p+=27;
		this.pin=p;
		this.accountNumber=a;
		System.out.println("\nAccount Number: "+this.accountNumber);
		System.out.println("OTP for Green Pin: "+this.pin);
		int count=0;
		int c=0;
		while(count<3)
		{
		System.out.println("\nPress 1: Set Green Pin\nPess 2: Use OTP as New Pin");
		int j=sc.nextInt();
		if(j==1)
		{
			while(true)
				{
				System.out.println("Enter OTP:");
				if(sc.nextInt()==this.pin) {
					System.out.println("Enter a New Pin: ");
					this.setPin(sc.nextInt());
					System.out.println("The New Pin has been Successfully Set\n");
					System.out.println("Enter Initial Balance: ");
					this.balance=sc.nextDouble();
					break;
					
				}
				else{
					System.out.println("Oopss.. You have Entered Wrong Input... "+(2-c)+" Trails Left..");
					c++;
				}
				if(c==3)
					{
						System.out.println("Invalid OTP...Please Try Again...!!");
						System.out.println("Unable To Create Account....\n--------------------------------THANK YOU------------------------------------");
						System.exit(0);
					}
				}
			}
		else if(j==2)
		{
				this.setPin(this.pin);
				System.out.println("The New Pin has been Successfully Set\n");
				System.out.println("Enter Initial Balance: ");
				this.balance=sc.nextDouble();
				break;
		}
		else{
			System.out.println("Oopss.. You have Entered Wrong Input... "+(2-count)+" Trails Left..");
			count++;
		}
		if(count==3) {
			System.out.println("Invalid Input...\nUnable To Create Account....\n");
			System.out.println("--------------------------------THANK YOU------------------------------------");
			System.exit(0);
		}
		break;
		}
		
	}
	
	public void setPin(int Pin)
	{
		this.pin=Pin;
	}
	public int getPin()
	{
		return this.pin;
	}
	
	@Override
	public void deposit(Scanner sc)
	{
		int i=0;
		while(true) {
		System.out.println("Enter Account Number: ");
		int r=sc.nextInt();
		if(r==this.accountNumber) {
			System.out.println("Enter the Amount to Deposit: ");
			double amount=sc.nextDouble();
			System.out.print("\nEnter Valid Input:-\nPress 1: Print Recipt\nPress 2: Skip Recipt Generation");
			int y=sc.nextInt();
			if (y==1)
			{
					this.balance+=amount;
					transactionId+=35;
					this.recipt();
					break;
			}
			else if(y==2)
			{
				this.balance+=amount;
				transactionId+=42;
				System.out.println("\nYour Amount Deposited Successfully to the Account: \nAccount Holder Name: "+this.name+ "\nAccount Number: "+this.accountNumber);
				break;
			}
			else {
				System.out.println("Oopss.. Invalid Input!!");
			}
			
		}
		else {
			System.out.println("Account Number Does Not Match "+(2-i)+" Trials Left..");
			i++;
			if(i==3)
			{
				System.out.println("Invalid Account Number... Transaction Cancelled...");
				break;
			}
		}
		}
	}
	
	@Override
	public void withdraw(Scanner sc)
	{
		System.out.println("Enter the Amount to Withdraw: ");
		double amount=sc.nextDouble();
		if(amount>this.balance)
		{
			System.out.println("Insufficient Funds!!!!\nPlease Try Again Later...");
		}
		else {
			System.out.print("\nEnter Valid Input:-\nPress 1: Print Recipt\nPress 2: Skip Recipt Generation");
			int r=sc.nextInt();
			if (r==1)
				{
						this.balance-=amount;
						transactionId+=57;
						this.recipt();
				}
			else if(r==2)
				{
					this.balance-=amount;
					transactionId+=57;
					System.out.println("\nBalance Amount: "+this.balance);
				}
			else {
				System.out.println("Oopss.. Invalid Input");
			}
			}
	}
	
	@Override
	public void getBalance()
	{
		System.out.println("\nBalance Amount:"+this.balance);
	}
}
