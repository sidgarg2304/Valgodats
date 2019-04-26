package com.vishal.interviews.google.easy;

/**
 * 800. Similar RGB Color
 * 
 * 
 * In the following, every capital letter represents some hexadecimal digit from 0 to f.

The red-green-blue color "#AABBCC" can be written as "#ABC" in shorthand.  For example, "#15c" is shorthand for the color "#1155cc".

Now, say the similarity between two colors "#ABCDEF" and "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.

Given the color "#ABCDEF", return a 7 character color that is most similar to #ABCDEF, and has a shorthand (that is, it can be represented as some "#XYZ"

Example 1:
Input: color = "#09f166"
Output: "#11ee66"
Explanation:  
The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
This is the highest among any shorthand color.
Note:

color is a string of length 7.
color is a valid RGB color: for i > 0, color[i] is a hexadecimal digit from 0 to f
Any answer which has the same (highest) similarity as the best answer will be accepted.
All inputs and outputs should use lowercase letters, and the output is 7 characters.
 *
 */
public class SimilarRGBColor {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Brute Force [Accepted]
Intuition

For each possible shorthand-RGB color from "#000" to "#fff", let's find it's similarity to the given color. We'll take the best one.

Algorithm

This problem is straightforward, but there are a few tricky implementation details.

To iterate over each shorthand color, we'll use an integer based approach, (though other ones exist.) Each digit in the shorthand "#RGB" could be from 0 to 15. This leads to a color of 17 * R * (1 << 16) + 17 * G * (1 << 8) + 17 * B. The reason for the 17 is because a hexadecimal value of 0x22 is equal to 2 * 16 + 2 * 1 which is 2 * (17). The other values for red and green work similarly, just shifted up by 8 or 16 bits.

To determine the similarity between two colors represented as integers, we'll sum the similarity of each of their colored components separately. For a color like hex1, it has 3 colored components r1 = (hex1 >> 16) % 256, g1 = (hex1 >> 8) % 256, b1 = (hex1 >> 0) % 256. Then, the first addend in the similarity is -(r1 - r2) * (r1 - r2), etc.

To convert an integer back to a hex string, we'll use String.format. The 06 refers to a zero padded string of length 6, while x refers to lowercase hexadecimal.

Finally, it should be noted that the answer is always unique. Indeed, for two numbers that differ by 17, every integer is closer to one than the other. For example, with 0 and 17, 8 is closer to 0 and 9 is closer to 17 - there is no number that is tied in closeness.

Complexity Analysis

Time and Space Complexity: O(1)O(1).
	 */
	public String similarRGBNaive(String color) {
      int hex1 = Integer.parseInt(color.substring(1), 16);
      int ans = 0;
      for (int r = 0; r < 16; ++r)
          for (int g = 0; g < 16; ++g)
              for (int b = 0; b < 16; ++b) {
                  int hex2 = 17 * r * (1 << 16) + 17 * g * (1 << 8) + 17 * b;
                  if (similarity(hex1, hex2) > similarity(hex1, ans))
                      ans = hex2;
              }

      return String.format("#%06x", ans);
  }

  public int similarity(int hex1, int hex2) {
      int ans = 0;
      for (int shift = 16; shift >= 0; shift -= 8) {
          int col1 = (hex1 >> shift) % 256;
          int col2 = (hex2 >> shift) % 256;
          ans -= (col1 - col2) * (col1 - col2);
      }
      return ans;
  }
  
  /**
   * Approach #2: Rounding By Component [Accepted]
Intuition and Algorithm

Because color similarity is a sum of the similarity of individual color components, we can treat each colored component separately and combine the answer.

As in the previous approach, we want the colored component to be the closest to a multiple of 17. We can just round it to the closest such value.

Complexity Analysis

Time and Space Complexity: O(1)O(1).
   */
  public String similarRGB(String color) {
     return "#" + f(color.substring(1, 3)) + f(color.substring(3, 5)) + f(color.substring(5));
 }

 public String f(String comp) {
     int q = Integer.parseInt(comp, 16);
     q = q / 17 + (q % 17 > 8 ? 1 : 0);
     return String.format("%02x", 17 * q);
 }

}
