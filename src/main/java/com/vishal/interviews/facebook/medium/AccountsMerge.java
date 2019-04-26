package com.vishal.interviews.facebook.medium;

import java.util.*;

/**
 * 721. Accounts Merge
 * 
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.

Example 1:
Input: 
accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
Explanation: 
The first and third John's are the same person as they have the common email "johnsmith@mail.com".
The second John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], 
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 *
 */
public class AccountsMerge {

	public static void main(String[] args) {

	}
	
	/**
	 * Approach #1: Depth-First Search [Accepted]
Intuition

Draw an edge between two emails if they occur in the same account. The problem comes down to finding connected components of this graph.

Algorithm

For each account, draw the edge from the first email to all other emails. Additionally, we'll remember a map from emails to names on the side. After finding each connected component using a depth-first search, we'll add that to our answer.

Complexity Analysis

Time Complexity: O(\sum a_i \log a_i)O(∑a
​i
​​ loga
​i
​​ ), where a_ia
​i
​​  is the length of accounts[i]. Without the log factor, this is the complexity to build the graph and search for each component. The log factor is for sorting each component at the end.

Space Complexity: O(\sum a_i)O(∑a
​i
​​ ), the space used by our graph and our search.
	 */
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
      Map<String, String> emailToName = new HashMap();
      Map<String, ArrayList<String>> graph = new HashMap();
      for (List<String> account: accounts) {
          String name = "";
          for (String email: account) {
              if (name == "") {
                  name = email;
                  continue;
              }
              graph.computeIfAbsent(email, x-> new ArrayList<String>()).add(account.get(1));
              graph.computeIfAbsent(account.get(1), x-> new ArrayList<String>()).add(email);
              emailToName.put(email, name);
          }
      }

      Set<String> seen = new HashSet();
      List<List<String>> ans = new ArrayList();
      for (String email: graph.keySet()) {
          if (!seen.contains(email)) {
              seen.add(email);
              Stack<String> stack = new Stack();
              stack.push(email);
              List<String> component = new ArrayList();
              while (!stack.empty()) {
                  String node = stack.pop();
                  component.add(node);
                  for (String nei: graph.get(node)) {
                      if (!seen.contains(nei)) {
                          seen.add(nei);
                          stack.push(nei);
                      }
                  }
              }
              Collections.sort(component);
              component.add(0, emailToName.get(email));
              ans.add(component);
          }
      }
      return ans;
  }
	
	/**
	 * Approach #2: Union-Find [Accepted]
Intuition

As in Approach #1, our problem comes down to finding the connected components of a graph. This is a natural fit for a Disjoint Set Union (DSU) structure.

Algorithm

As in Approach #1, draw edges between emails if they occur in the same account. For easier interoperability between our DSU template, we will map each email to some integer index by using emailToID. Then, dsu.find(email) will tell us a unique id representing what component that email is in.

For more information on DSU, please look at Approach #2 in the article here. For brevity, the solutions showcased below do not use union-by-rank.

Complexity Analysis

Time Complexity: O(A \log A)O(AlogA), where A = \sum a_iA=∑a
​i
​​ , and a_ia
​i
​​  is the length of accounts[i]. If we used union-by-rank, this complexity improves to O(A \alpha(A)) \approx O(A)O(Aα(A))≈O(A), where \alphaα is the Inverse-Ackermann function.

Space Complexity: O(A)O(A), the space used by our DSU structure.
	 * @param accounts
	 * @return
	 */
	public List<List<String>> accountsMergeUnionFind(List<List<String>> accounts) {
      DSU dsu = new DSU();
      Map<String, String> emailToName = new HashMap();
      Map<String, Integer> emailToID = new HashMap();
      int id = 0;
      for (List<String> account: accounts) {
          String name = "";
          for (String email: account) {
              if (name == "") {
                  name = email;
                  continue;
              }
              emailToName.put(email, name);
              if (!emailToID.containsKey(email)) {
                  emailToID.put(email, id++);
              }
              dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
          }
      }

      Map<Integer, List<String>> ans = new HashMap();
      for (String email: emailToName.keySet()) {
          int index = dsu.find(emailToID.get(email));
          ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
      }
      for (List<String> component: ans.values()) {
          Collections.sort(component);
          component.add(0, emailToName.get(component.get(0)));
      }
      return new ArrayList(ans.values());
  }

}

class DSU {
   int[] parent;
   public DSU() {
       parent = new int[10001];
       for (int i = 0; i <= 10000; ++i)
           parent[i] = i;
   }
   public int find(int x) {
       if (parent[x] != x) parent[x] = find(parent[x]);
       return parent[x];
   }
   public void union(int x, int y) {
       parent[find(x)] = find(y);
   }
}