public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
    	BankAccount account1 = new BankAccount(100.00, 200.00);
    	BankAccount account2 = new BankAccount(300.00, 500.00);
    	BankAccount account3 = new BankAccount(130.00, 32200.00);
    	account1.printCheckingBalance();
        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
    	System.out.println(BankAccount.getTotalMoney());
    	account1.depositChecking(100.00);
    	account1.printCheckingBalance();
    	account1.depositSavings(100.00);
    	account1.printSavingsBalnace();
    	System.out.println(BankAccount.getTotalMoney());

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney
    	account1.withdrawChecking(100.00);
    	account1.printCheckingBalance();
    	account1.withdrawSavings(100.00);
    	account1.printSavingsBalnace();
    	System.out.println(BankAccount.getTotalMoney());

        // Static Test (print the number of bank accounts and the totalMoney)
    	System.out.println(BankAccount.getAccounts() + " " + BankAccount.getTotalMoney());

    }
}