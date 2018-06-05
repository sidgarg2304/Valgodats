package com.vishal.threads;

import java.util.*;

public class CustomThreadPoolExecutor {

	int size;

	CustomBlockingQueue<Runnable> queue;

	CustomThreadPoolExecutor(int size) {
		this.size = size;
		queue = new CustomBlockingQueue<>(size);
		for (int i = 0; i < size; i++) {
			TaskExecutor task = new TaskExecutor(queue);
			Thread t = new Thread(task);
			t.setName("Thread " + i);
			t.start();

		}
	}

	void submitTask(Runnable r) throws InterruptedException {
		queue.offer(r);
	}

}

class TaskExecutor implements Runnable {

	CustomBlockingQueue<Runnable> queue;

	TaskExecutor(CustomBlockingQueue<Runnable> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {

		try {
			while (true) {
				Runnable r = queue.poll();
				r.run();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class CustomBlockingQueue<T> {

	private Queue<T> queue;
	int maxSize = -1;

	CustomBlockingQueue(int size) {
		this.maxSize = size;
		queue = new LinkedList<>();
	}

	public synchronized T poll() throws InterruptedException {
		while (queue.isEmpty()) {
			this.wait();
		}

		if (queue.size() == maxSize) {
			notifyAll();
		}
		return queue.poll();
	}

	public synchronized void offer(T e) throws InterruptedException {
		while (queue.size() == maxSize) {
			wait();
		}

		if (queue.isEmpty()) {
			notifyAll();
		}
		queue.offer(e);
	}

}
