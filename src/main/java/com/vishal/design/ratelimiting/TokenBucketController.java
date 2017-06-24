package com.vishal.design.ratelimiting;

public class TokenBucketController {

	static final long FIFTEEN_MINUTES_IN_MILLI_SECONDS = 900000;

	TokenBucket newFixedIntervalTokenBucket(long capacity, long refillTokensCount) {
		IRefillStrategy refillStrategy = new FixedIntervalRefillStrategy(refillTokensCount,
				FIFTEEN_MINUTES_IN_MILLI_SECONDS);
		return new TokenBucket(capacity, refillStrategy);
	}
}
