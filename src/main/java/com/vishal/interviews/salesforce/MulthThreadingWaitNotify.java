package com.vishal.interviews.salesforce;

public class MulthThreadingWaitNotify {

	public static void main(String[] args) {

		System.out.println("showing first example when account does not sufficeint balance for both withdrawls");
		makeTransactionsWithoutFullbalance();

		// This sleep is just for testing purpose to show two transactions
		// seperately. For real time, remove sleep and test to see threads of both
		// transactions will run in random order
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("\nshowing second example when account has sufficeint balance for both withdrawls");
		makeTransactionsWithFullbalance();
	}

	/**
	 * Since initially we have only 5000 Rs, shilpa or sekhar has to wait before
	 * vishal deposit is finished and that is guaranteed
	 */
	static void makeTransactionsWithoutFullbalance() {
		Account a = new Account("shilpa", 500);

		// sek withdrawing money at ATM Maredpally
		AccountWithdrawl sekWithdraw = new AccountWithdrawl(a, 500);
		Thread accSekWithThred = new Thread(sekWithdraw);
		accSekWithThred.setName("sekhar at Maredpally");
		accSekWithThred.start();

		// shil withdrawing money at ATM hi-tech city
		AccountWithdrawl shilWithdraw = new AccountWithdrawl(a, 500);
		Thread accShilWithThred = new Thread(shilWithdraw);
		accShilWithThred.setName("shilpa at hi-tech city");
		accShilWithThred.start();

		// This sleep is just for testing purpose to make sure deposit thread
		// starts late
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// vishal depositing at bank
		AccountDeposit accDep = new AccountDeposit(a, 500);
		Thread accDepThred = new Thread(accDep);
		accDepThred.setName("vishal using online banking");
		accDepThred.start();
	}

	/**
	 * Since initially Ashok account has 10000 Rs, Ashok and Nirmala need not
	 * wait for vishal deposit to be finished
	 */
	static void makeTransactionsWithFullbalance() {
		Account a = new Account("Ashok", 1000);

		// ashok withdrawing money at ATM vasavi nagar
		AccountWithdrawl accAshokWithdraw = new AccountWithdrawl(a, 500);
		Thread accAshokshokWithThread = new Thread(accAshokWithdraw);
		accAshokshokWithThread.setName("Ashok at vasavi nagar");
		accAshokshokWithThread.start();

		// nirmala withdrawing money at gvk mall
		AccountWithdrawl nirmalaWithdraw = new AccountWithdrawl(a, 500);
		Thread accNirWithThread = new Thread(nirmalaWithdraw);
		accNirWithThread.setName("Nirmala at gvk mall");
		accNirWithThread.start();

		// This sleep is just for testing purpose to make sure deposit thread
		// starts late
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// vishal depositing at bank
		AccountDeposit accDep = new AccountDeposit(a, 500);
		Thread accDepThred = new Thread(accDep);
		accDepThred.setName("vishal using online banking");
		accDepThred.start();
	}

}

class AccountWithdrawl implements Runnable {

	Account a;
	double amount;

	AccountWithdrawl(Account a, double amount) {
		this.a = a;
		this.amount = amount;

	}

	public void run() {
		synchronized (a) {
			if (a.balance < amount) {
				try {
					a.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			a.balance -= amount;
			System.out.println(amount + " withdrawn from the account " + a.name + " by " + Thread.currentThread().getName()
					+ " and remaining balance is " + a.balance);
		}
	}
}

class AccountDeposit implements Runnable {

	Account a;
	double amount;

	AccountDeposit(Account a, double amount) {
		this.a = a;
		this.amount = amount;

	}

	public void run() {
		synchronized (a) {
			a.balance += amount;
			System.out.println(amount + " deposited to the account " + a.name + " by " + Thread.currentThread().getName()
					+ " and remaining balance is " + a.balance);
			a.notifyAll();
		}
	}
}

class Account {
	String name;
	double balance;

	Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
		System.out.println(name + " account is created with balance " + balance);
	}
}
