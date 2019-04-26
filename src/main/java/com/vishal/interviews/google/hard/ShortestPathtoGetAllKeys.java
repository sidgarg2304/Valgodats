package com.vishal.interviews.google.hard;

import java.util.*;

import com.vishal.interviews.util.Point;

/**
 * 865. Shortest Path to Get All Keys

We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.

We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.

For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.

Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.

 

Example 1:

Input: ["@.a.#","###.#","b.A.B"]
Output: 8
Example 2:

Input: ["@..aA","..B#.","....b"]
Output: 6
 

Note:

1 <= grid.length <= 30
1 <= grid[0].length <= 30
grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
The number of keys is in [1, 6].  Each key has a different letter and opens exactly one lock.
 *
 */
public class ShortestPathtoGetAllKeys {

	public static void main(String[] args) {


	}

	/**
	 * 
	 * Approach 1: Brute Force + Permutations
Intuition and Algorithm

We have to pick up the keys KK in some order, say K_{\sigma_i}K
​σ
​i
​​ 
​​ .

For each ordering, let's do a breadth first search to find the distance to the next key.

For example, if the keys are 'abcdef', then for each ordering such as 'bafedc', we will try to calculate the candidate distance from '@' -> 'b' -> 'a' -> 'f' -> 'e' -> 'd' -> 'c'.

Between each segment of our path (and corresponding breadth-first search), we should remember what keys we've picked up. Keys that are picked up become part of a mask that helps us identify what locks we are allowed to walk through during the next breadth-first search.

Each part of the algorithm is relatively straightforward, but the implementation in total can be quite challenging. See the comments for more details.

	 * Complexity Analysis

Time Complexity: O(R * C * \mathcal{A} * \mathcal{A}!)O(R∗C∗A∗A!), where R, CR,C are the dimensions of the grid, and \mathcal{A}A is the maximum number of keys (\mathcal{A}A because it is the "size of the alphabet".) Each bfs is performed up to \mathcal{A} * \mathcal{A}!A∗A! times.

Space Complexity: O(R * C + \mathcal{A}!)O(R∗C+A!), the space for the bfs and to store the candidate key permutations.
	 */
	int INF = Integer.MAX_VALUE;
   String[] grid;
   int R, C;
   Map<Character, Point> location;
   int[] dr = new int[]{-1, 0, 1, 0};
   int[] dc = new int[]{0, -1, 0, 1};

   public int shortestPathAllKeys(String[] grid) {
       this.grid = grid;
       R = grid.length;
       C = grid[0].length();

       //location['a'] = the coordinates of 'a' on the grid, etc.
       location = new HashMap();
       for (int r = 0; r < R; ++r)
           for (int c = 0; c < C; ++c) {
               char v = grid[r].charAt(c);
               if (v != '.' && v != '#')
                   location.put(v, new Point(r, c));
           }

       int ans = INF;
       int num_keys = location.size() / 2;
       String[] alphabet = new String[num_keys];
       for (int i = 0; i < num_keys; ++i)
           alphabet[i] = Character.toString((char)('a' + i));
       //alphabet = ["a", "b", "c"], if there were 3 keys

       search: for (String cand: permutations(alphabet, 0, num_keys)) {
           //bns : the built candidate answer, consisting of the sum
           //of distances of the segments from '@' to cand[0] to cand[1] etc.
           int bns = 0;
           for (int i = 0; i < num_keys; ++i) {
               char source = i > 0 ? cand.charAt(i-1) : '@';
               char target = cand.charAt(i);

               //keymask : an integer with the 0-th bit set if we picked up
               // key 'a', the 1-th bit set if we picked up key 'b', etc.
               int keymask = 0;
               for (int j = 0; j < i; ++j)
                   keymask |= 1 << (cand.charAt(j) - 'a');
               int d = bfs(source, target, keymask);
               if (d == INF) continue search;
               bns += d;
               if (bns >= ans) continue search;
           }
           ans = bns;
       }

       return ans < INF ? ans : -1;
   }

   public int bfs(char source, char target, int keymask) {
       int sr = location.get(source).x;
       int sc = location.get(source).y;
       int tr = location.get(target).x;
       int tc = location.get(target).y;
       boolean[][] seen = new boolean[R][C];
       seen[sr][sc] = true;
       int curDepth = 0;
       Queue<Point> queue = new LinkedList();
       queue.offer(new Point(sr, sc));
       queue.offer(null);

       while (!queue.isEmpty()) {
           Point p = queue.poll();
           if (p == null) {
               curDepth++;
               if (!queue.isEmpty())
                   queue.offer(null);
               continue;
           }
           int r = p.x, c = p.y;
           if (r == tr && c == tc) return curDepth;
           for (int i = 0; i < 4; ++i) {
               int cr = r + dr[i];
               int cc = c + dc[i];
               if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                   char cur = grid[cr].charAt(cc);
                   if (cur != '#') {
                       if (Character.isUpperCase(cur) && (((1 << (cur - 'A')) & keymask) <= 0))
                           continue; // at lock and don't have key

                       queue.offer(new Point(cr, cc));
                       seen[cr][cc] = true;
                   }
               }
           }
       }

       return INF;
   }

   public List<String> permutations(String[] alphabet, int used, int size) {
       List<String> ans = new ArrayList();
       if (size == 0) {
           ans.add(new String(""));
           return ans;
       }

       for (int b = 0; b < alphabet.length; ++b)
           if (((used >> b) & 1) == 0)
               for (String rest: permutations(alphabet, used | (1 << b), size - 1))
                   ans.add(alphabet[b] + rest);
       return ans;
   }
   
   
   // ---------2nd solution
   
   /**
    * Approach 2: Points of Interest + Dijkstra
Intuition and Algorithm

Clearly, we only really care about walking between points of interest: the keys, locks, and starting position. We can use this insight to speed up our calculation.

Let's make this intuition more formal: any walk can be decomposed into primitive segments, where each segment (between two points of interest) is primitive if and only if it doesn't touch any other point of interest in between.

Then, we can calculate the distance (of a primitive segment) between any two points of interest, using a breadth first search.

Afterwards, we have some graph (where each node refers to at most 1313 places, and at most 2^62
​6
​​  states of keys). We have a starting node (at '@' with no keys) and ending nodes (at anywhere with all keys.) We also know all the costs to go from one node to another - each node has outdegree at most 13. This shortest path problem is now ideal for using Dijkstra's algorithm.

Dijkstra's algorithm uses a priority queue to continually searches the path with the lowest cost to destination, so that when we reach the target, we know it must have been through the lowest cost path. Refer to this link for more detail.

Again, each part of the algorithm is relatively straightforward (for those familiar with BFS and Dijkstra's algorithm), but the implementation in total can be quite challenging.

Complexity Analysis

Time Complexity: O(RC(2\mathcal{A} + 1) + \mathcal{E} \log \mathcal{N})O(RC(2A+1)+ElogN), where R, CR,C are the dimensions of the grid, and \mathcal{A}A is the maximum number of keys, \mathcal{N} = (2\mathcal{A} + 1) * 2^\mathcal{A}N=(2A+1)∗2
​A
​​  is the number of nodes when we perform Dijkstra's, and \mathcal{E} = \mathcal{N} * (2 \mathcal{A} + 1)E=N∗(2A+1) is the maximum number of edges.

Space Complexity: O(\mathcal{N})O(N). 

    */
   public int shortestPathAllKeysDkarta(String[] grid) {
       this.grid = grid;
       R = grid.length;
       C = grid[0].length();

       //location : the points of interest
       location = new HashMap();
       for (int r = 0; r < R; ++r)
           for (int c = 0; c < C; ++c) {
               char v = grid[r].charAt(c);
               if (v != '.' && v != '#')
                   location.put(v, new Point(r, c));
           }

       int targetState = (1 << (location.size() / 2)) - 1;
       Map<Character, Map<Character, Integer>> dists = new HashMap();
       for (char place: location.keySet())
           dists.put(place, bfsFrom(place));

       //Dijkstra
       PriorityQueue<ANode> pq = new PriorityQueue<ANode>((a, b) ->
               Integer.compare(a.dist, b.dist));
       pq.offer(new ANode(new Node('@', 0), 0));
       Map<Node, Integer> finalDist = new HashMap();
       finalDist.put(new Node('@', 0), 0);

       while (!pq.isEmpty()) {
           ANode anode = pq.poll();
           Node node = anode.node;
           int d = anode.dist;
           if (finalDist.getOrDefault(node, INF) < d) continue;
           if (node.state == targetState) return d;

           for (char destination: dists.get(node.place).keySet()) {
               int d2 = dists.get(node.place).get(destination);
               int state2 = node.state;
               if (Character.isLowerCase(destination)) //key
                   state2 |= (1 << (destination - 'a'));
               if (Character.isUpperCase(destination)) //lock
                   if ((node.state & (1 << (destination - 'A'))) == 0) // no key
                       continue;

               if (d + d2 < finalDist.getOrDefault(new Node(destination, state2), INF)) {
                   finalDist.put(new Node(destination, state2), d + d2);
                   pq.offer(new ANode(new Node(destination, state2), d+d2));
               }
           }
       }

       return -1;
   }

   public Map<Character, Integer> bfsFrom(char source) {
       int sr = location.get(source).x;
       int sc = location.get(source).y;
       boolean[][] seen = new boolean[R][C];
       seen[sr][sc] = true;
       int curDepth = 0;
       Queue<Point> queue = new LinkedList();
       queue.offer(new Point(sr, sc));
       queue.offer(null);
       Map<Character, Integer> dist = new HashMap();

       while (!queue.isEmpty()) {
           Point p = queue.poll();
           if (p == null) {
               curDepth++;
               if (!queue.isEmpty())
                   queue.offer(null);
               continue;
           }

           int r = p.x, c = p.y;
           if (grid[r].charAt(c) != source && grid[r].charAt(c) != '.') {
               dist.put(grid[r].charAt(c), curDepth);
               continue; // Stop walking from here if we reach a point of interest
           }

           for (int i = 0; i < 4; ++i) {
               int cr = r + dr[i];
               int cc = c + dc[i];
               if (0 <= cr && cr < R && 0 <= cc && cc < C && !seen[cr][cc]){
                   if (grid[cr].charAt(cc) != '#') {
                       queue.offer(new Point(cr, cc));
                       seen[cr][cc] = true;
                   }
               }
           }
       }

       return dist;
   }


//ANode: Annotated Node
private class ANode {
   Node node;
   int dist;

   ANode(Node n, int d) {
       node = n;
       dist = d;
   }
}

private class Node {
   char place;
   int state;

   Node(char p, int s) {
       place = p;
       state = s;
   }

   @Override
   public boolean equals(Object o) {
       if (this == o) return true;
       if (!(o instanceof Node)) return false;
       Node other = (Node) o;
       return (place == other.place && state == other.state);
   }

   @Override
   public int hashCode() {
       return 256 * state + place;
   }
}
}
