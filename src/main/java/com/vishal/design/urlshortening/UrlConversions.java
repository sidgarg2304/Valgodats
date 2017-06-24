package com.vishal.design.urlshortening;

public class UrlConversions {

	public static void main(String[] args) {

		System.out.println((64 == shortUrlToId(idToShortUrl(64))));

		System.out.println((238 == shortUrlToId(idToShortUrl(238))));

		System.out.println((445 == shortUrlToId(idToShortUrl(445))));

		System.out.println((649 == shortUrlToId(idToShortUrl(649))));
				
	}

	public static String idToShortUrl(int id) {
		char[] map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();		

		StringBuilder sb = new StringBuilder();
		while (id > 0) {			
			sb.append(map[id % 62]);
			id /= 62;
		}

		return sb.reverse().toString();
	}

	public static int shortUrlToId(String url) {

		int res = 0;
		int base = 1;
		for (int i = url.length() - 1; i >= 0; i--) {
			char c = url.charAt(i);
			int val = 0;
			if (c >= 'a' && c <= 'z') {
				val = c - 'a';
			} else if (c >= 'A' && c <= 'Z') {
				val = c - 'A' + 26;
			} else if (c >= '0' && c <= '9') {
				val = c - '0' + 52;
			}

			res += val * base;
			base *= 62;
		}

		return res;
	}

	public static int shortUrlToIdGreek(String url) {

		int res = 0;
		for (int i = 0; i < url.length(); i++) {
			char c = url.charAt(i);

			if (c >= 'a' && c <= 'z') {
				res = res * 62 + c - 'a';
			} else if (c >= 'A' && c <= 'Z') {
				res = res * 62 + c - 'A' + 26;
			} else if (c >= '0' && c <= '9') {
				res = res * 62 + c - '0' + 52;
			}

		}

		return res;
	}
}
