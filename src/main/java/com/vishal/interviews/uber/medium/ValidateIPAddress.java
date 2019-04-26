package com.vishal.interviews.uber.medium;

public class ValidateIPAddress {

	public static void main(String[] args) {

	}

	public String validIPAddress(String IP) {

		if(validIPV4Address(IP)) {
			return "IPv4";
		} else if(validIPV6Address(IP)) {
			return "IPv6";
		} else {
			return "Neither";
		}
	}

	boolean validIPV4Address(String ip) {

		if (ip == null || ip.length() == 0) {
			return false;
		}
		String[] arr = ip.split("\\.", -1);
		if (arr.length < 4) {
			return false;
		}

		for (int i = 0; i < 4; i++) {
			try {
				int val = Integer.parseInt(arr[i]);
				if (val < 0 || val > (1 << 8) - 1) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}

			if (arr[i].length() > 1 && arr[i].charAt(0) == '0') {
				return false;
			}

			if (arr[i].charAt(0) == '+' || arr[i].charAt(0) == '-') {
				return false;
			}
		}
		return true;

	}

	boolean validIPV6Address(String ip) {

		if (ip == null || ip.length() == 0) {
			return false;
		}
		String[] arr = ip.split(":", -1);
		if (arr.length < 8) {
			return false;
		}

		for (int i = 0; i < 8; i++) {
			try {
				int val = Integer.parseInt(arr[i]);
				if (val < 0 || val > (1 << 16) - 1) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}

			if (arr[i].length() > 4) {
				return false;
			}

			if (arr[i].charAt(0) == '+' || arr[i].charAt(0) == '-') {
				return false;
			}
		}
		return true;

	}

}
