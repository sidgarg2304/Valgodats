package com.vishal.interviews.google.easy;

/**
 * 551. Student Attendance Record I
 * 
 * You are given a string representing an attendance record for a student. The record only contains the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

You need to return whether the student could be rewarded according to his attendance record.

Example 1:
Input: "PPALLP"
Output: True
Example 2:
Input: "PPALLL"
Output: False
 *
 */
public class StudentAttendanceRecordI {

	public static void main(String[] args) {

		System.out.println(checkRecord("ALLAPPL"));
	}

	public static boolean checkRecord(String s) {
		

		int a = 0;
		int l = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == 'A') {
				a++;
				l = 0;
			} else if (c == 'L') {
				l++;				
			} else {				
				l = 0;
			}

			if (l > 2 || a > 1) {
				return false;
			}

		}

		return true;
	}

}
