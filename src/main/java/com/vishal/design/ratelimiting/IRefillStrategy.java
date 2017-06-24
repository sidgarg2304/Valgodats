package com.vishal.design.ratelimiting;

public interface IRefillStrategy {

	public long refill();

	public long getIntervalInMilliSeconds();
}
