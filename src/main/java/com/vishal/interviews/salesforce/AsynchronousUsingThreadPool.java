package com.vishal.interviews.salesforce;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class AsynchronousUsingThreadPool {

	public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(3);

	public List<Item> searchByName(String name) {

		List<Item> res = new ArrayList<>();

		return res;
	}

	public List<Item> searchByCategory(String category) {

		List<Item> res = new ArrayList<>();

		return res;
	}

	public List<Item> searchSynchronous(String name, String category) {

		List<Item> res = new ArrayList<>();

		List<Item> res1 = searchByName(name);

		List<Item> res2 = searchByCategory(category);

		res.addAll(res1);
		res.addAll(res2);

		return res;
	}

	public List<Item> searchASynchronous(String name, String category)
			throws ExecutionException, InterruptedException, TimeoutException {

		List<Item> res = new ArrayList<>();

		// Create Thread and call 1st API inside the thread
		final Callable<List<Item>> callableSearchByName = new Callable<List<Item>>() {
			@Override
			public List<Item> call() {
				return searchByName(name);
			}
		};

		// Add the thread to a thread pool executor and we get the Future object
		Future<List<Item>> futureSearchByName = EXECUTOR_SERVICE.submit(callableSearchByName);

		// Create Thread and call 2nd API inside the thread
		final Callable<List<Item>> callableSearchByCategory = new Callable<List<Item>>() {
			@Override
			public List<Item> call() {
				return searchByCategory(name);
			}
		};

		// Add the thread to a thread pool executor and we get the Future object
		Future<List<Item>> futureSearchByCategory = EXECUTOR_SERVICE.submit(callableSearchByCategory);

		// Retrieve results from the future objects and this will timeout in 2
		// secs if the API does not respond in 2secs
		List<Item> res1 = futureSearchByName.get(2000, TimeUnit.MILLISECONDS);

		// Retrieve results from the future objects and this will timeout in 3
		// secs if the API does not respond in 3secs
		List<Item> res2 = futureSearchByCategory.get(3000, TimeUnit.MILLISECONDS);

		res.addAll(res1);
		res.addAll(res2);

		return res;
	}
}

class Item {

}