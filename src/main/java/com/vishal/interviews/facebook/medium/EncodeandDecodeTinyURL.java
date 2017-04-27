package com.vishal.interviews.facebook.medium;

import java.util.*;
public class EncodeandDecodeTinyURL {

	public static void main(String[] args) {

	}
	
	List<String> indexes = new ArrayList<>();
// Encodes a URL to a shortened URL.
   public String encode(String longUrl) {
       
   	StringBuilder tinyUrl = new StringBuilder();
   	tinyUrl.append("https://tiny.com/");
   	indexes.add(longUrl);
   	tinyUrl.append(indexes.size()-1);
   	return tinyUrl.toString();
   }

   // Decodes a shortened URL to its original URL.
   public String decode(String shortUrl) {
       Integer index = Integer.parseInt(shortUrl.substring(17));
       
       if(index < indexes.size()){
      	 return indexes.get(index);
       }else{
      	 return "";
       }
   }

}
