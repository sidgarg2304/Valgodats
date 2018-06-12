package com.vishal.interviews.salesforce;

import java.util.*;

public class ProductDetailsConstructionFromUrl {

	public static void main(String[] args) {
		printProductDetails("www.amazon.in/pid=1234");
	}

	static void printProductDetails(String url) {

		String prodName = getProductName(url);
		String prodPrice = getProductPrice(url);
		List<String> relatedproductNames = getRelatedProducts(url);

		ProductDetails p = new ProductDetails(prodName, prodPrice, relatedproductNames);
		System.out.println(p);

	}

	static String getProductName(String url) {
		return "prod:" + url.substring(19);
	}

	static String getProductPrice(String url) {
		return url.substring(19);
	}

	static List<String> getRelatedProducts(String url) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			res.add("rel:" + url.substring(19));
		}
		return res;
	}
}

class ProductDetails {

	private String name;

	private String price;

	private List<String> relatedProductNames;

	ProductDetails(String name, String price, List<String> relatedProductNames) {
		this.name = name;
		this.price = price;
		this.relatedProductNames = relatedProductNames;
	}

	public String toString() {
		return "name = " + name + "\n" + "price = " + price + "\n" + "Related Product Names = " + relatedProductNames;
	}
}
