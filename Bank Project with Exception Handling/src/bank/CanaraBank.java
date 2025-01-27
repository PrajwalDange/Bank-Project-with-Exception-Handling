package bank;
import java.util.ArrayList;
import java.util.Scanner;

public class CanaraBank extends GenericImplementation implements ReserveBankOfIndia{
	static double serviceCharge=0;
	static ArrayList<CanaraBank> CanaraData = new ArrayList<>();
	@Override
	public void operations(Scanner sc)
	{
		int count=0;
		while(true) {
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("\t\t\t    --- CANARA BANK ---\n\nAccount Holder Name: "+this.name+"\t\t\tAccount Number: "+this.accountNumber);
			System.out.println("\nEnter Valid Input:-\n\nPress 1: Balance Inqiry\nPress 2: Deposite Amount\nPress 3: Withdraw Amount\nPress 4: Generate Recipt\nPress 5: Transfer Funds to Beneficiary Account\nPress 6: Back to Main Menu\nPress 7: Exit");
			System.out.println("------------------------------------------------------------------------------\n");
			int k=sc.nextInt();
			switch(k)
			{
			case 1:
				CanaraBank.serviceCharge=0;
				this.getBalance();
				break;
			case 2:
				CanaraBank.serviceCharge=17.19;
				this.balance-=CanaraBank.serviceCharge=13.27;
				//Account.balance-=13.27;
				this.deposit(sc);
				System.out.println("Service Charge Deducted: "+CanaraBank.serviceCharge+"Rs.");
				break;
			case 3:
				CanaraBank.serviceCharge=13.27;
				this.balance-=CanaraBank.serviceCharge;
				this.withdraw(sc);
				System.out.println("Service Charge Deducted: "+CanaraBank.serviceCharge+"Rs.");
				break;
			case 4:
				CanaraBank.serviceCharge=0;
				this.recipt();
				break;
			case 5:
				this.transferFunds(sc);
				break;
			case 6:
				return;
			case 7:
				System.out.println("--------------------------------THANK YOU------------------------------------");
				System.exit(0);
			default:
				System.out.println("\nInvalid Input....\n");
				}
		}
	}
	@Override
	public void recipt()
	{
		System.out.println("\nRecipt:-\n");
		System.out.println("--------------------CANARA BANK----------------------\n");
		System.out.println("Date: DD-MM-YYYY \t\t\tTime:HH-MM-SS");
		System.out.println("-----------------------------------------------------\n");
		System.out.println("Account Holder Name:\t\t\t"+this.name);
		System.out.println("Account Number:\t\t\t\t"+this.accountNumber);
		System.out.println("Transaction Id:\t\t\t\t"+transactionId);
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Service Charges:\t\t\t-"+serviceCharge);
		System.out.println("Balance Amount:\t\t\t\t"+this.balance);
		System.out.println("-----------------------------------------------------");
		System.out.println("\t   THANK YOU FOR BANKING WITH US\n\t   visit us at www.canarabank.com\n\n");
	}
	
	@Override
	public void transferFunds(Scanner sc)
	{
		int count=0;
		boolean found=false;
		while(count<3) {
		System.out.println("\nEnter Beneficiary Account Number:");
		int acc=sc.nextInt();
		for(int i=0;i<CanaraData.size();i++)
		{
			int old=CanaraData.get(i).accountNumber;
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
					CanaraData.get(i).balance+=amt;
					this.balance-=amt;
					System.out.println("\nAmount Transfered Successfully....");
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
		CanaraBank b;
		int terms=0;
		while (terms<3) {
			System.out.println("Enter Account Number:");
			int a=sc.nextInt();
			for(int i=0;i<CanaraData.size();i++)
			{
				b=CanaraData.get(i);
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
							System.out.println("You Have Entered Wrong Pin... "+(2-count)+" trials left...");
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
