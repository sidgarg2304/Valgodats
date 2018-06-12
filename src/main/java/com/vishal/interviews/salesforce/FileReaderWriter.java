package com.vishal.interviews.salesforce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

	public static void main(String[] args) {
		 System.out.println(readFile("/Users/vkotha/workplace/development/file1.txt"));

		fileToFileCopy("/Users/vkotha/workplace/development/file1.txt", "/Users/vkotha/workplace/development/file2.txt");
	}

	public static void fileToFileCopy(String readFilePath, String writeFilePath) {
		File readFile = new File(readFilePath);
		File writeFile = new File(writeFilePath);
		try (BufferedReader readBuf = new BufferedReader(new FileReader(readFile));
				BufferedWriter writeBuf = new BufferedWriter(new FileWriter(writeFile))) {
			String st = null;
			while ((st = readBuf.readLine()) != null) {
				writeBuf.append(st);
			}

		} catch (IOException io) {
			System.out.println("error occurred copying from " + readFilePath + " to " + writeFilePath);
			io.printStackTrace();
		}
		System.out.println("finished copying from " + readFilePath + " to " + writeFilePath);
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

	public static void writeToFile(String fileFullPath, String content) {

		String[] arr = content.split("\n");
		File file = new File(fileFullPath);
		try (BufferedWriter br = new BufferedWriter(new FileWriter(file))) {
			for (String s : arr) {
				br.append(s);
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
	}

}
