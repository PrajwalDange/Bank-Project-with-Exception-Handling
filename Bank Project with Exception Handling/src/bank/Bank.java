package bank;
import java.util.*;

public class Bank {
	static boolean flag=true;
	//Factory Method 
	public static ReserveBankOfIndia check(int n)
	{
		if(n==1)
		{
			System.out.println("\n---------------------WELLCOME To SBI BANK---------------------");
			flag=true;
			return new SbiBank();
		}
		else 
		{
			System.out.println("\n\n---------------------WELLCOME To CANARA BANK---------------------");
			flag=false;
			return new CanaraBank();
		}
	}
	public static void main(String[] arg)
	{
		Scanner sc=new Scanner(System.in);
		int count=0;
		while(count<3) {
		System.out.println("\n\n----------------MAIN MENU----------------\n\nAuthentication Page:-\n---------------------\n\nPress 1: Login to Existing Bank Account\nPress 2: Create an Account");
		int in=sc.nextInt();
		if(in==1)
		{
			int k=0;
			while(k<3) {
				System.out.println("\n\nChoose Bank:-\nPress 1: SBI Bank\nPress 2: Canara Bank\nPress 3: Main Menu\nPress 4: Exit");
				int i=sc.nextInt();
				if (i==4)
				{
					System.out.println("--------------------------------THANK YOU------------------------------------");
					System.exit(0);
				}
				else if(i==1 || i==2)
				{
					ReserveBankOfIndia obj = check(i); //inside if block...to avoid NullPointerException
					obj.login(sc);
					break;
					
				}
				else if(i==3)
				{
					break;
				}
				else {
					System.out.println("You Have Entered Wrong Input... "+(2-k)+" Trials Left...");
					k++;
				}
				if(k==3)
				{
					System.out.println("\nInvalid Input...\n");
					System.out.println("\n\n--------------------------------THANK YOU------------------------------------");
					System.exit(0);
				}
				
			}
		}
		else if(in==2)
		{
			int count1=0;
			while(true) {	
			System.out.println("\n\nChoose Bank:-\nPress 1: SBI Bank\nPress 2: Canara Bank\nPress 3: Main Menu\nPress 4: Exit");
			int k=sc.nextInt();
			if (k==4)
			{
				System.out.println("--------------------------------THANK YOU------------------------------------");
				System.exit(0);
			}
			if(k==1 || k==2)
			{
				ReserveBankOfIndia obj = check(k);
				obj.createAccount(sc);
				//sbiObj.operations(sc);
				if(flag==true)
				{
					SbiBank SbiObj= (SbiBank)obj;
					SbiBank.SbiData.add(SbiObj);
				}
				else
				{
					CanaraBank CanaraObj = (CanaraBank) obj;
					CanaraBank.CanaraData.add(CanaraObj);
				}
				System.out.println("Account Created Successfully...\n--------------------------------------------------");
				break;
			}
			else if(k==3)
			{
				break;
			}
			else {
				System.out.println("You Have Entered Wrong Input... "+(2-count1)+" Trials Left...");
				count1++;
			  }
			if(count1==3)
			{
				System.out.println("\nInvalid Input...\n");
				break;
			}
			}
		}
		else
		{
			System.out.println("You Have Entered Wrong Input..."+(2-count)+" Trials Left...");
			count++;
		}
		if(count==3)
		{
			System.out.println("\n\n--------------------------------THANK YOU------------------------------------");
			System.exit(0);
		}
		}
	}
}
