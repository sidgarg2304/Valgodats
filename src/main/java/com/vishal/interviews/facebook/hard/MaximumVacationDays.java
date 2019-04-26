package com.vishal.interviews.facebook.hard;

import java.util.Arrays;

public class MaximumVacationDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxVacationDays(int[][] flights, int[][] days) {

		int numOfWeeks = days[0].length;
		int numOfCities = flights.length;

		int[] maxVacationInEachCityTillPrevWeek = new int[numOfCities];
		Arrays.fill(maxVacationInEachCityTillPrevWeek, Integer.MIN_VALUE);
		maxVacationInEachCityTillPrevWeek[0] = 0;

		for (int w = 0; w < numOfWeeks; w++) {
			int[] maxVacationInEachCityTillThisWeek = new int[numOfCities];
			Arrays.fill(maxVacationInEachCityTillThisWeek, Integer.MIN_VALUE);
			for (int i = 0; i < numOfCities; i++) {
				for (int j = 0; j < numOfCities; j++) {
					// move to city j
					if (i == j || flights[j][i] == 1) {
						maxVacationInEachCityTillThisWeek[i] = Math.max(maxVacationInEachCityTillThisWeek[i],
								maxVacationInEachCityTillPrevWeek[j] + days[i][w]);
					}
				}
			}
			maxVacationInEachCityTillPrevWeek = maxVacationInEachCityTillThisWeek;
		}

		int res = 0;
		for (int val : maxVacationInEachCityTillPrevWeek) {
			res = Math.max(res, val);
		}
		return res;
	}

}
