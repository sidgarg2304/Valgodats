package com.vishal.interviews.linkedin.careercup;


/**
 * Given a matrix of following between N LinkedIn users (with ids from 0 to
 * N-1): followingMatrix[i][j] == true iff user i is following user j thus
 * followingMatrix[i][j] doesn't imply followingMatrix[j][i]. Let's also agree
 * that followingMatrix[i][i] == false
 * 
 * Influencer is a user who is: - followed by everyone else and - not following
 * anyone himself
 * 
 * This method should find an Influencer by a given matrix of following, or
 * return -1 if there is no Influencer in this group.
 */
public class InfluenceFinder {

	public static void main(String[] args) {

	}

	int getInfluencer(boolean[][] followingMatrix) {

		for (int i = 0; i < followingMatrix.length; i++) {
			boolean isInf = true;
			for (int j = 0; j < followingMatrix[0].length; j++) {
				if (i == j) {
					continue;
				}
				if (followingMatrix[i][j] || !followingMatrix[j][j]) {
					isInf = false;
					break;
				}
			}
			if (isInf) {
				return i;
			}
		}

		return -1;
	}
}
