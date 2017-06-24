package com.vishal.design.facebook;

public class SuggestedFriend {

	Person p;
	Person suggestedFriend;
	int mutualFriends;

	public boolean equals(Object o){
		if(o instanceof SuggestedFriend){
			SuggestedFriend s = (SuggestedFriend)o;
			return s.p.id.equals(this.p.id);
		}
		
		return false;
	}
}
