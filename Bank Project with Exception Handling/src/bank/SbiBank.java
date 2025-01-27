package bank;
import java.util.ArrayList;
import java.util.Scanner;

public class SbiBank extends GenericImplementation implements ReserveBankOfIndia{
	int InterestRate;
	static ArrayList<SbiBank> SbiData = new ArrayList<>();
	public double calculateInterest(Scanner sc)
	{
		System.out.println("Enter Rate of Interest: ");
		double n=sc.nextDouble();
		return (this.balance)*(n/100);
	}
	
	@Override
	public void operations(Scanner sc)
	{
		int count=0;
		while(true) {
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("\t\t\t--- STATE BANK OF INDIA ---\n\nAccount Holder Name: "+this.name+"\t\t\tAccount Number: "+this.accountNumber);
			System.out.println("\nEnter Valid Input:-\n\nPress 1: Balance Inqiry \tPress 5: Generate Recipt\nPress 2: Deposite Amount\tPress 6: Transfer Funds to Beneficiary Account\nPress 3: Withdraw Amount\tPress 7: Back to Main Menu\nPress 4: Count Interest \tPress 8: Exit");
			System.out.println("------------------------------------------------------------------------------\n");
			int k=sc.nextInt();
			switch(k)
			{
			case 1:
				this.getBalance();
				break;
			case 2:
				this.deposit(sc);
				break;
			case 3:
				this.withdraw(sc);
				break;
			case 4:
				double l=this.calculateInterest(sc);
				System.out.println("Interest: "+l+" Rs.");
				break;
			case 5:
				this.recipt();
				break;	
			case 6:
				this.transferFunds(sc);
				break;
			case 7:
				return;
			case 8:
				System.out.println("--------------------------------THANK YOU------------------------------------");
				System.exit(0);
			default:
				System.out.println("\nInvalid Input....\n");
			}
			}
		}
	@Override
	public void transferFunds(Scanner sc)
	{
		int count=0;
		boolean found=false;
		while(count<3) {
		System.out.println("\nEnter Beneficiary Account Number:");
		int acc=sc.nextInt();
		for(int i=0;i<SbiData.size();i++)
		{
			
			int old=SbiData.get(i).accountNumber;
			if(old==acc)
			{
				found=true;
				System.out.println("Please Enter Amount to be Transferred:");
				int amt=sc.nextInt();
				if(amt>this.balance)
				{
					System.out.println("\nOops...Insufficient Funds...\n");
				}
				else
				{
					SbiData.get(i).balance+=amt;
					this.balance-=amt;
					System.out.println("\n\nAmount Transfered Successfully....\n\n");
					this.balanceCheck(sc);
					count=3;
				}
			}
		}
		if(found==false) {
			System.out.println("Account Number You Entered May be Incorrect...Please try again.. "+(2-count)+" Trails Left..");
			count++;
			}
		}
	}
	
	@Override
	public void login(Scanner sc)
	{
		SbiBank b;
		int terms=0;
		while (terms<3) {
			System.out.println("Enter Account Number:");
			int a=sc.nextInt();
			for(int i=0;i<SbiData.size();i++)
			{
				b=SbiData.get(i);
				if(b.accountNumber==a)
				{
					int count=0;
					while(count<3)
					{
						System.out.println("\nPlease Enter Pin For Further Transactions:");
						int p=sc.nextInt();
						if(p==b.getPin())
						{
							b.operations(sc);
							return;
						}
						else {
							System.out.println("You Have Entered Wrong Pin... "+(count-2)+" trials left...");
							count++;
						}
						if(count == 3)
						{
							System.out.println("Invalid Pin...");
							return;
						}
					}
				}
			}
			System.out.println("The Provided Account Number Does Not Match with Records... "+(terms-2)+" Trails Left..");
			terms++;
			if(terms==3)
			{
				System.out.println("\n\nInvalid Account Number...");
				return;
			}
		}
	}
	@Override
	public void recipt()
	{
		System.out.println("\nRecipt:-\n");
		System.out.println("----------------State Bank Of India-----------------\n");
		System.out.println("Date: DD-MM-YYYY \t\t\tTime:HH-MM-SS");
		System.out.println("-----------------------------------------------------\n");
		System.out.println("Account Holder Name:\t\t\t"+this.name);
		System.out.println("Account Number:\t\t\t\t"+this.accountNumber);
		System.out.println("Transaction Id:\t\t\t\t"+transactionId);
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Service Charges:\t\t\t-"+0.0);
		System.out.println("Balance Amount:\t\t\t\t"+this.balance);
		System.out.println("-----------------------------------------------------");
		System.out.println("\t   THANK YOU FOR BANKING WITH US\n\t     visit us at www.sbi.co.in\n\n");	
	}
	
	@Override
	public void balanceCheck(Scanner sc)
	{
		System.out.println("View Balance:-\nPress 1: Generate Recipt\nPress 2: Skip Recipt Generation\nPress 3: Cancel");
		int k=sc.nextInt();
		if(k==1)
		{
			this.recipt();
		}
		else if (k==2)
		{
			System.out.println("Balance Amount: "+this.balance);
		}
		else if(k==3)
		{
			System.out.println("Balance Inqiry Cancelled...");
			return;
		}
		else
		{
			System.out.println("Oopss..You Have Entered Wrong Input");
		}
	}
	
	
}
