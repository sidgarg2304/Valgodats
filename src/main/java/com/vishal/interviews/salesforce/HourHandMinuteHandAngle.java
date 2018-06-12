package com.vishal.interviews.salesforce;

/**
 * Calculate the angle between hour hand and minute hand
This problem is know as Clock angle problem where we need to find angle between hands of an analog clock at a given time.

Examples:

Input:  h = 12:00, m = 30.00
Output: 165 degree

Input:  h = 3.00, m = 30.00
Output: 75 degree
 *
 */
public class HourHandMinuteHandAngle {

	public static void main(String[] args) {

	}

	public static int calcAngle(double h, double m) {
		// validate the input
		if (h < 0 || m < 0 || h > 12 || m > 60){
			System.out.println("Wrong input");
			return -1;
		}

		if (h == 12)
			h = 0;
		if (m == 60)
			m = 0;

		// Calculate the angles moved by hour and minute hands
		// with reference to 12:00
		int hourAngle = (int) (0.5 * (h * 60 + m));
		int minAngle = (int) (6 * m);

		// Find the difference between two angles
		int angle = Math.abs(hourAngle - minAngle);

		// smaller angle of two possible angles
		angle = Math.min(360 - angle, angle);

		return angle;
	}

}
