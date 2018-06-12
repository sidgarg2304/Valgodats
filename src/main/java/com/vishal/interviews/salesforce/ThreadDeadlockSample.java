package com.vishal.interviews.salesforce;

public class ThreadDeadlockSample {

	public static void main(String[] args) {

		Account a = new Account("vishal", 1000);
		Account b = new Account("shilpa", 500);

		// potential deadlock if we start 2 transactions between same accounts on
		// each other

		// deposit from account vishal to shilpa
		AccountTransactions depAToB = new AccountTransactions(a, b, 100);
		Thread threadDepAToB = new Thread(depAToB);
		threadDepAToB.setName("deposit from " + a.name + " to " + b.name);
		threadDepAToB.start();

		// deposit from account shilpa to vishal
		AccountTransactions depBToA = new AccountTransactions(b, a, 200);
		Thread threadDepBToA = new Thread(depBToA);
		threadDepBToA.setName("deposit from " + b.name + " to " + a.name);
		threadDepBToA.start();

	}

}

class AccountTransactions implements Runnable {
	Account depFrom;
	Account depTo;
	double amount;

	AccountTransactions(Account depFrom, Account depTo, double amount) {
		this.depFrom = depFrom;
		this.depTo = depTo;
		this.amount = amount;
	}

	public void run() {
		// deadlock can happen here
		synchronized (depFrom) {
			synchronized (depTo) {
				depFrom.balance -= amount;
				depTo.balance += amount;
				System.out.println("\nbalances after " + Thread.currentThread().getName() + " complete ");
				System.out.println(depFrom.name + "'s account balance: " + depFrom.balance);
				System.out.println(depTo.name + "'s account balance: " + depTo.balance);
			}
		}

	}

}
