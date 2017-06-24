package com.vishal.design.ratelimiting;

import java.util.concurrent.atomic.AtomicLong;

public class FixedIntervalRefillStrategy implements IRefillStrategy {

	long intervalInMilliSeconds;

	AtomicLong nextRefillTime;

	long numOfTokens;

	public FixedIntervalRefillStrategy(long numOfTokens, long intervalInMilliSeconds) {
		this.intervalInMilliSeconds = intervalInMilliSeconds;
		this.numOfTokens = numOfTokens;
		this.nextRefillTime = new AtomicLong(-1);
	}

	@Override
	public long refill() {
		long now = System.currentTimeMillis();
		long refillTime = nextRefillTime.get();
		if (now < refillTime) {
			return 0;
		}
		
		return nextRefillTime.compareAndSet(refillTime, now + intervalInMilliSeconds) ? numOfTokens : 0;		
	}

	@Override
	public long getIntervalInMilliSeconds() {
		return intervalInMilliSeconds;
	}

}
