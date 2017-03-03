package com.vishal.interviews.facebook.easy;

/**
 * 157. Read N Characters Given Read4
 * The API: int read4(char *buf) reads 4 characters at a time from a file.
 * The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 * By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 * Note: The read function will only be called once for each test case.
 */
public class ReadNCharactersGivenRead4 extends Reader4{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Another accepted Java solution
	 */
	public int read(char[] buf, int n) {
		  boolean eof = false;      // end of file flag
		  int total = 0;            // total bytes have read
		  char[] tmp = new char[4]; // temp buffer
		  
		  while (!eof && total < n) {
		    int count = read4(tmp);
		    
		    // check if it's the end of the file
		    eof = count < 4;
		    
		    // get the actual count
		    count = Math.min(count, n - total);
		    
		    // copy from temp buffer to buf
		    for (int i = 0; i < count; i++) 
		      buf[total++] = tmp[i];
		  }
		  
		  return total;
		}
	
	
	
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read2(char[] buf, int n) {
        
        char[] buffer = new char[4];
        boolean endOfFile = false;
        int readBytes = 0;
        
        while (readBytes < n && !endOfFile) {
            int currReadBytes = read4(buffer);
            if (currReadBytes !=4) {
                endOfFile = true;
            }
            int length = Math.min(n - readBytes, currReadBytes);
            for (int i=0; i<length; i++) {
                buf[readBytes + i] = buffer[i];
            }
            readBytes += length;
        }
        return readBytes;
    }

}
