package com.vishal.interviews.netflix.medium;

/**
 * http://tutorials.jenkov.com/java-concurrency/read-write-locks.html
 *
 * read - we should make sure all writes are done write - we should make sure
 * all read and writes are done.
 */
public class ReadWriteLock {

	public static void main(String[] args) {

	}

	int readers = 0;
	int writers = 0;
	int writeRequests = 0;

	/**
	 * We need to check for writeRequest too because we want to make sure someone
	 * is about to write and we should block someone from reading wrong as they
	 * might get old data
	 * 
	 * @throws InterruptedException
	 */
	public synchronized void lockRead() throws InterruptedException {

		while (writeRequests > 0 || writers > 0) {
			wait();
		}
		readers++;
	}

	public synchronized void unlockRead() throws InterruptedException {

		readers--;
		notifyAll();
	}

	public synchronized void lockWrite() throws InterruptedException {

		writeRequests++;

		while (readers > 0 || writers > 0) {
			wait();
		}

		writeRequests--;
		writers++;
	}

	public synchronized void unlockWrite() throws InterruptedException {

		writers--;
		notifyAll();
	}

}
