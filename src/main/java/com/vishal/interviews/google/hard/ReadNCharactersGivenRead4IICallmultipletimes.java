package com.vishal.interviews.google.hard;

/**
 * 158. Read N Characters Given Read4 II - Call multiple times
 * 
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function may be called multiple times.
 */
public class ReadNCharactersGivenRead4IICallmultipletimes {

	public static void main(String[] args) {

	}
}

/**
 * I used buffer pointer (buffPtr) and buffer Counter (buffCnt) to store the data received in previous calls. In the while loop, if buffPtr reaches current buffCnt, it will be set as zero to be ready to read new data.
 *
 */
class ReadNCharactersGivenRead4IICallmultipletimesSimple extends Reader4 {

	private int buffPtr = 0;
	private int buffCnt = 0;
	private char[] buff = new char[4];

	public int read(char[] buf, int n) {
	        int ptr = 0;
	        while (ptr < n) {
	            if (buffPtr == 0) {
	                buffCnt = read4(buff);
	            }
	            if (buffCnt == 0) break;
	            while (ptr < n && buffPtr < buffCnt) {
	                buf[ptr++] = buff[buffPtr++];
	            }
	            if (buffPtr >= buffCnt) buffPtr = 0;
	        }
	        return ptr;
	    }
}

/**
 * Just keep copying as long as more is both desired and available (read more on the fly when needed).

It's also fast, 2 ms for Java and 0 ms for C++, there are no faster ones.
 *
 */
class ReadNCharactersGivenRead4IICallmultipletimesShort extends Reader4 {
   public int read(char[] buf, int n) {
       int i = 0;
       while (i < n && (i4 < n4 || (i4 = 0) < (n4 = read4(buf4))))
           buf[i++] = buf4[i4++];
       return i;
   }
   char[] buf4 = new char[4];
   int i4 = 0, n4 = 0;
}

/**
 * Clean accepted java solution The key is to store memorized variable in the
 * class level and remember offset position and remaining number of elements.
 *
 */
class SolutionAccepted extends Reader4 {

	private int offSet = 0;
	private int remaining = 0;
	private boolean isEndOfFile = false;
	private char[] buffer = new char[4];

	/**
	 * @param buf
	 *           Destination buffer
	 * @param n
	 *           Maximum number of characters to read
	 * @return The number of characters read
	 */
	public int read(char[] buf, int n) {
		int readBytes = 0;
		while (readBytes < n && (remaining != 0 || !isEndOfFile)) {
			int readSize = 0;
			if (remaining != 0) {
				readSize = remaining;
			} else {
				offSet = 0;
				readSize = read4(buffer);
				if (readSize != 4) {
					isEndOfFile = true;
				}
			}
			int length = Math.min(n - readBytes, readSize);
			for (int i = offSet; i < offSet + length; i++) {
				buf[readBytes++] = buffer[i];
			}
			remaining = readSize - length;
			if (remaining != 0) {
				offSet += length;
			}
		}
		return readBytes;
	}
}

/**
 * may be java provided class. research later
 *
 */
class Reader4{
	int read4(char[] buf4){
		return 0;
	}
}