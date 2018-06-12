package com.vishal.interviews.salesforce;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderWriter {

	public static void main(String[] args) {
		System.out.println(Math.floor(1.9));
	}

	public static String readFile(String fileFullPath) {

		File file = new File(fileFullPath);
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {

			String st = null;
			while ((st = br.readLine()) != null) {
				sb.append(st);
			}
		} catch (IOException io) {
			io.printStackTrace();
			return "";
		}
		return sb.toString();
	}

}
