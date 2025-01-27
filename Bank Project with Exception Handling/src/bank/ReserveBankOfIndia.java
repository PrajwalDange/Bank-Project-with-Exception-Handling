package bank;
import java.util.Scanner;

public interface ReserveBankOfIndia {
	void createAccount(Scanner sc);
	void setPin(int Pin);
	int getPin();
	void operations(Scanner sc);
	void deposit(Scanner sc);
	void withdraw(Scanner sc);
	void getBalance();
	void recipt();
	void transferFunds(Scanner sc);
	void balanceCheck(Scanner sc);
	void login(Scanner sc);
}
