package com.vishal.interviews.google.easy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 359
 * 
 * Design a logger system that receive stream of messages along with its
 * timestamps, each message should be printed if and only if it is not printed
 * in the last 10 seconds.
 * 
 * Given a message and a timestamp (in seconds granularity), return true if the
 * message should be printed in the given timestamp, otherwise returns false.
 * 
 * It is possible that several messages arrive roughly at the same time.
 * 
 * 
 * 
 * Example:
 * 
 * Logger logger = new Logger();
 * 
 * // logging string "foo" at timestamp 1 logger.shouldPrintMessage(1, "foo");
 * returns true;
 * 
 * // logging string "bar" at timestamp 2 logger.shouldPrintMessage(2,"bar");
 * returns true;
 * 
 * // logging string "foo" at timestamp 3 logger.shouldPrintMessage(3,"foo");
 * returns false;
 * 
 * // logging string "bar" at timestamp 8 logger.shouldPrintMessage(8,"bar");
 * returns false;
 * 
 * // logging string "foo" at timestamp 10 logger.shouldPrintMessage(10,"foo");
 * returns false;
 * 
 * // logging string "foo" at timestamp 11 logger.shouldPrintMessage(11,"foo");
 * returns true;
 *
 */
public class LoggerRateLimiter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 * Solution1
 * 
 * @author vkotha
 *
 */
class LoggerSol1 {

	private Map<String, Integer> ok = new HashMap<>();

	public boolean shouldPrintMessage(int timestamp, String message) {
		if (timestamp < ok.getOrDefault(message, 0))
			return false;
		ok.put(message, timestamp + 10);
		return true;
	}
}

/**
 * Solution2
 * 
 * @author vkotha
 *
 */
class Log {
	int timestamp;
	String message;

	public Log(int aTimestamp, String aMessage) {
		timestamp = aTimestamp;
		message = aMessage;
	}
}

class LoggerSolution2 {
	PriorityQueue<Log> recentLogs;
	Set<String> recentMessages;

	/** Initialize your data structure here. */
	LoggerSolution2() {
		recentLogs = new PriorityQueue<Log>(10, new Comparator<Log>() {
			public int compare(Log l1, Log l2) {
				return l1.timestamp - l2.timestamp;
			}
		});

		recentMessages = new HashSet<String>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. If this method returns false, the message will
	 * not be printed. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		while (recentLogs.size() > 0) {
			Log log = recentLogs.peek();
			// discard the logs older than 10 minutes
			if (timestamp - log.timestamp >= 10) {
				recentLogs.poll();
				recentMessages.remove(log.message);
			} else
				break;
		}
		boolean res = !recentMessages.contains(message);
		if (res) {
			recentLogs.add(new Log(timestamp, message));
			recentMessages.add(message);
		}
		return res;
	}
}
/**
 * Your Logger object will be instantiated and called as such: Logger obj = new
 * Logger(); boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

/**
 * Solution3
 */

class LoggerSolution3 {
	HashMap<String, Integer> map;

	/** Initialize your data structure here. */
	public LoggerSolution3() {
		map = new HashMap<>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		// update timestamp of the message if the message is coming in for the
		// first time,or the last coming time is earlier than 10 seconds from now
		if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
			map.put(message, timestamp);
			return true;
		}
		return false;
	}
}

/**
 * Solution 4 using concurrent hashmap
 */

class LoggerSolution4 {
	ConcurrentHashMap<String, Integer> lastPrintTime;

	/** Initialize your data structure here. */
	public LoggerSolution4() {
		lastPrintTime = new ConcurrentHashMap<String, Integer>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		Integer last = lastPrintTime.get(message);

		return last == null && lastPrintTime.putIfAbsent(message, timestamp) == null
				|| last != null && timestamp - last >= 10 && lastPrintTime.replace(message, last, timestamp);

	}
}

/**
 * Solution 5 easy using Java HashMap
 */
class LoggerSolution5 {
	private Map<String, Integer> map;

	/** Initialize your data structure here. */
	public LoggerSolution5() {
		map = new HashMap<>();
	}

	/**
	 * Returns true if the message should be printed in the given timestamp,
	 * otherwise returns false. The timestamp is in seconds granularity.
	 */
	public boolean shouldPrintMessage(int timestamp, String message) {
		if (map.containsKey(message) && (timestamp - map.get(message)) < 10) {
			return false;
		}
		map.put(message, timestamp);
		return true;
	}
}