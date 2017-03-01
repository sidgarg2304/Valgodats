package com.vishal.interviews.google.medium;

/**
 * 200. Number of Islands
 * 
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000
Answer: 1

Example 2:

11000
11000
00100
00011
Answer: 3


 */
public class NumberofIslands {

	public static void main(String[] args) {

	}

}

class NumofIslandsSolutionEasy {
   public int numIslands(char[][] grid) {
       int count = 0;
       
       for (int i = 0; i < grid.length; i++) {
           for (int j = 0; j < grid[i].length; j++) {
               if (grid[i][j] == '1') {
                   count++;
                   clearRestOfLand(grid, i, j);
               }
           }
       }
       return count;
   }
   
   private void clearRestOfLand(char[][] grid, int i, int j) {
       if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;
       
       grid[i][j] = '0';
       clearRestOfLand(grid, i+1, j);
       clearRestOfLand(grid, i-1, j);
       clearRestOfLand(grid, i, j+1);
       clearRestOfLand(grid, i, j-1);
       return;
   }
}

class NumofIslandsSolutionConcise {

	private int n;
	private int m;

	public int numIslands(char[][] grid) {
		int count = 0;
		n = grid.length;
		if (n == 0)
			return 0;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (grid[i][j] == '1') {
					DFSMarking(grid, i, j);
					++count;
				}
		}
		return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
			return;
		grid[i][j] = '0';
		DFSMarking(grid, i + 1, j);
		DFSMarking(grid, i - 1, j);
		DFSMarking(grid, i, j + 1);
		DFSMarking(grid, i, j - 1);
	}
}

class NumberofIslandsSimple {
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	public static int numIslands(char[][] grid) {
		if(grid==null || grid.length==0) return 0;
		int islands = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j]=='1') {
					explore(grid,i,j);
					islands++;
				}
			}
		}
		return islands;
	}
	public static void explore(char[][] grid, int i, int j) {
		grid[i][j]='x';
		for(int d=0;d<dx.length;d++) {
			if(i+dy[d]<grid.length && i+dy[d]>=0 && j+dx[d]<grid[0].length && j+dx[d]>=0 && grid[i+dy[d]][j+dx[d]]=='1') {
				explore(grid,i+dy[d],j+dx[d]);
			}
		}
	}
}

/**
 * Java Union Find Solution
 */
class UF {

	public int count = 0;
	public int[] id = null;

	public UF(int m, int n, char[][] grid) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1')
					count++;
			}
		}
		id = new int[m * n];
		for (int i = 0; i < m * n; i++) {
			id[i] = i;
		}
	}

	public int find(int p) {
		while (p != id[p]) {
			id[p] = id[id[p]];
			p = id[p];
		}
		return p;
	}

	public boolean isConnected(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot != qRoot)
			return false;
		else
			return true;
	}

	public void union(int p, int q) {
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return;
		id[pRoot] = qRoot;
		count--;
	}

	public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;
		int m = grid.length, n = grid[0].length;
		UF uf = new UF(m, n, grid);

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '0')
					continue;
				int p = i * n + j;
				int q;
				if (i > 0 && grid[i - 1][j] == '1') {
					q = p - n;
					uf.union(p, q);
				}
				if (i < m - 1 && grid[i + 1][j] == '1') {
					q = p + n;
					uf.union(p, q);
				}
				if (j > 0 && grid[i][j - 1] == '1') {
					q = p - 1;
					uf.union(p, q);
				}
				if (j < n - 1 && grid[i][j + 1] == '1') {
					q = p + 1;
					uf.union(p, q);
				}
			}
		}
		return uf.count;
	}
}