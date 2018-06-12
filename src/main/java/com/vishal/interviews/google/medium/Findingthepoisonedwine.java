package com.vishal.interviews.google.medium;

/**
 * 
 * You have 1000 wine bottles, one of which is poisoned. You want to determine
 * which bottle is poisoned by feeding the wine to the rats. The poisoned wine
 * takes one hour to work. How many rats are necessary to find the poisoned
 * bottle in one hour?
 * 
 * B Rat1 Rat0
 * 0   0   0 
 * 1   0   1
 * 2   1   0
 * 3   1   1
 * 
 * if both rats did not die -> Poison is in bottle 0 as both rats did not take wine from this bottle.
 * if rat0 die and rat1 did not -> Poison is in bottle 1 as rat1 took poison from this bottle
 * if rat1 die and rat0 did not -> Poison is in bottle 2 as rat1 took poison from this bottle
 * if both rats do not die -> Poison is in bottle 3 as both rats took poison from this bottle
 * 
 */
public class Findingthepoisonedwine {

	public static void main(String[] args) {

		findBottle(4);
	}

	static int findBottle(int numOfBottles) {
		int numOfRats = 0;

		int k = numOfBottles - 1;
		while (k != 0) {
			numOfRats++;
			k >>= 1;
		}

		int res = 0;

		Rat[] rats = new Rat[numOfRats];
		for (int i = 0; i < rats.length; i++) {
			rats[i] = new Rat();
			rats[i].ratNo = i;
		}

		for (int i = 0; i < numOfBottles; i++) {

			int r = 0;
			int b = i;
			while (b != 0) {
				if ((b & 1) == 1) {
					rats[r].feed(b);
					System.out.println("feeding rat " + r + " with bottle " + i);
				}
				r++;
				b >>= 1;
			}
		}

		int val = 1;
		for (int i = 0; i < rats.length; i++) {
			if (rats[i].isDead()) {
				res += val;
			}
			val *= 2;
		}

		System.out.println("bottle " + (res + 1) + " has poison");
		return res + 1;
	}

}

class Rat {

	int ratNo;

	boolean isDead() {
		return ratNo == 1;
	}

	void feed(int b) {

	}

}
