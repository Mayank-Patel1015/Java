public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;

    private static int accounts;
    private static double totalMoney; // refers to the sum of all bank account checking and savings balances
	
    // GETTERS and SETTERS
    // for checking, savings, accounts, and totalMoney
    public double getCheckingBalance() {
		return checkingBalance;
	}
	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	public static int getAccounts() {
		return accounts;
	}
	public static void setAccounts(int accounts) {
		BankAccount.accounts = accounts;
	}
	public static double getTotalMoney() {
		return totalMoney;
	}
	public static void setTotalMoney(double totalMoney) {
		BankAccount.totalMoney = totalMoney;
	}

    // CONSTRUCTOR
    // Be sure to increment the number of accounts
	public BankAccount() {
		accounts++;
	}
	public BankAccount(double checkingBalance, double savingsBalance) {
		this.checkingBalance = checkingBalance;
		this.savingsBalance = savingsBalance;
		totalMoney += checkingBalance + savingsBalance;
		accounts++;
	}

    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
	// - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
	public void depositChecking(double amount) {
		this.checkingBalance += amount;
		totalMoney += amount;
	}
	public void depositSavings(double amount) {
		this.savingsBalance += amount;
		totalMoney += amount;
	}
	
    // withdraw 
	public void withdrawChecking(double amount) {
		if(amount <= checkingBalance) { 
			this.checkingBalance -= amount;
			totalMoney -= amount;
		}
	}
	public void withdrawSavings(double amount) {
		if(amount <= savingsBalance) { 
			this.savingsBalance -= amount;
			totalMoney -= amount;
		}
	}
   
    // getBalance
    // - display total balance for checking and savings of a particular bank account
	public void printCheckingBalance() {
		System.out.println(this.checkingBalance);
	}
	public void printSavingsBalnace() {
		System.out.println(this.savingsBalance);
	}
}