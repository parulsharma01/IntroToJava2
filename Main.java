
class Main{
	public static void main(String ar[]){
		Customer cust1 = new Customer("Parul Sharma", "Delhi", "9123562525");
		Bank bank1 = new SBI(Bank.type.CURRENT);
		Account acc1 = new Account(cust1, bank1, 10000);
		acc1.addMoney(500);
		try {
			acc1.withdrawMoney(300);
			acc1.withdrawMoney(1600);
		}catch (Exception e){
			e.printStackTrace();
		}
		acc1.printAccountDetails();

		Customer cust2 = new Customer("Govind Arya", "Delhi", "9123562455");
		Bank bank2 = new ICICI(Bank.type.SAVINGS);
		Account acc2 = new Account(cust2, bank2, 5000);
		acc2.addMoney(5000);
		try {
			acc2.withdrawMoney(5000);
			acc2.withdrawMoney(200);
		}catch (Exception e){
			e.printStackTrace();
		}
		acc2.printAccountDetails();

	}
}
/*

Implement a banking system using java.

* Create 3 sub class of Bank : SBI,BOI,ICICI

* All 4 should have following methods:

- getDetails which provide their specific details like rateofinterest etc
- printDetails of every bank.
- Every bank account should have a type (enum): SAVINGS, CURRENT

* Implement a feature to deduct amount from account. Throw InsufficientAmountException if amount being deducted is less than the current balance.
* Every banking transaction should be saved in a file of each bank's transaction log which would have all details of the transaction like (time of transaction,account number,amount withdrawn, amount before deduction, amount after deduction,transaction status (can also be enum), failure reason if any)
 

*/
