package com.vishal.design.ratelimiting.slidingwindow;

import java.util.*;

public class RateLimiterSlidingWindow {

	public static void main(String[] args) {
		RateLimiterSlidingWindow r = new RateLimiterSlidingWindow();
		try {
			System.out.println(r.canAccessAPI() + " at " + (new Date(System.currentTimeMillis())).toString());
			Thread.sleep(10000);
			System.out.println(r.canAccessAPI() + " at " + (new Date(System.currentTimeMillis())).toString());
			Thread.sleep(10000);
			System.out.println(r.canAccessAPI() + " at " + (new Date(System.currentTimeMillis())).toString());
			Thread.sleep(10000);
			System.out.println(r.canAccessAPI() + " at " + (new Date(System.currentTimeMillis())).toString());
			Thread.sleep(32000);
			System.out.println(r.canAccessAPI() + " at " + (new Date(System.currentTimeMillis())).toString());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	Value val;
	long MIN_IN_MILLI_SECS = 60 * 1000;

	public boolean canAccessAPI() {
		long curTime = System.currentTimeMillis();
		if (val == null) {
			val = new Value(1, curTime);
			return true;
		}

		System.out.println("cur time diff is " + (curTime - val.startTimeInMilliSeconds));
		if (curTime - val.startTimeInMilliSeconds >= MIN_IN_MILLI_SECS) {
			
			val.startTimeInMilliSeconds = curTime;
			val.count = 1;
			return true;
		} else {
			if (val.count < 3) {
				val.count++;
				System.out.println("count is " + val.count);
				return true;
			} else {
				return false;
			}
		}
	}

	class Value {
		int count;
		long startTimeInMilliSeconds;

		Value(int count, long startTimeInMilliSeconds) {
			this.startTimeInMilliSeconds = startTimeInMilliSeconds;
			this.count = count;
		}
	}
}
