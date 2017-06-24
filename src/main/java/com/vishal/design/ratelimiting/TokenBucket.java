package com.vishal.design.ratelimiting;

import java.util.concurrent.atomic.AtomicLong;

public class TokenBucket {

	IRefillStrategy refillStrategy;

	AtomicLong size;
	long capacity;

	TokenBucket(long capacity, IRefillStrategy refillStrategy) {
		this.capacity = capacity;
		this.refillStrategy = refillStrategy;
	}

	// this is simple version of consume just for understanding logic
	void consumeSimple(int numOfTokens) throws InterruptedException {

		long curSize = size.get();

		long newTokens = Math.max(0, refillStrategy.refill());
		curSize += newTokens;

		while (!Thread.currentThread().isInterrupted()) {
			if (numOfTokens <= curSize) {
				curSize -= numOfTokens;
				break;
			} else {
				// wait until we can refill with more tokens
				Thread.sleep(refillStrategy.getIntervalInMilliSeconds());
				newTokens = Math.max(0, refillStrategy.refill());
			}
		}
	}

	void consume(int numOfTokens) throws InterruptedException {
		if (numOfTokens < 0) {
			throw new RuntimeException("Invalid argument");
		}

		if (numOfTokens >= capacity) {
			throw new RuntimeException("Number of tokens must be less than capacity of the bucket");
		}

		// refillStrategy checks if we are elligible to refill. so we can just
		// call to see if we can get new tokens
		long newTokens = Math.max(0, refillStrategy.refill());
		long existingSize = size.get();

		while (!Thread.currentThread().isInterrupted()) {

			// Add any tokens if we found during refill to size
			long newSize = Math.max(0, Math.min(existingSize + newTokens, capacity));

			if (numOfTokens <= newSize) {
				newSize -= numOfTokens;
				// this make sure that no one has updated size while we are
				// processing.
				// if size is updated by someone else, we should not update size
				if (size.compareAndSet(existingSize, newSize)) {
					// successfully we decremented numOfTokens and updated size with
					// new value, so we finished consume operation
					break;
				}
			} else {
				// wait until we can refill with more tokens
				Thread.sleep(refillStrategy.getIntervalInMilliSeconds());
				newTokens = Math.max(0, refillStrategy.refill());
			}
		}

	}

	// Test case
	public static void main(String[] args) {
		AtomicLong temp = new AtomicLong(100l);
		long e = temp.get();
		long u = 90l;

		if (temp.compareAndSet(e, u)) {
			System.out.println("equal");
		}

		System.out.println("temp value is " + temp.get());
	}
}
