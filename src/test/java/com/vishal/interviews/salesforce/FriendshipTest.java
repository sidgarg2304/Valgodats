package com.vishal.interviews.salesforce;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FriendshipTest {

	Friendship f;

	@Before
	public void setUp() {
		f = new Friendship();
		Assert.assertNotNull(f);
	}

	@After
	public void tearDown() {
		f = null;
	}

	@Test
	public void testMakeOneFriend() {
		f.makeFriend("John", "Ted");
		List<String> expected = new ArrayList<>();
		expected.add("Ted");
		assertEquals(expected, f.getDirectFriends("John"));
	}

	@Test
	public void testMakeFriendsEmptyBoth() {
		f.makeFriend("", "");
		List<String> expected = new ArrayList<>();
		assertEquals(expected, f.getDirectFriends(""));
	}

	@Test
	public void testMakeFriendsNullBoth() {
		f.makeFriend(null, null);
		List<String> expected = new ArrayList<>();
		assertEquals(expected, f.getDirectFriends(null));
	}

	@Test
	public void testMakeFriendsEmptyNameKey() {
		f.makeFriend("", "Ted");
		List<String> expected = new ArrayList<>();
		assertEquals(expected, f.getDirectFriends("Ted"));
		assertEquals(expected, f.getDirectFriends(null));
	}

	@Test
	public void testMakeFriendsNullNameKey() {
		f.makeFriend(null, "Ted");
		List<String> expected = new ArrayList<>();
		assertEquals(expected, f.getDirectFriends("Ted"));
		assertEquals(expected, f.getDirectFriends(""));
	}

	@Test
	public void testMakeFriendsEmptyFriend() {
		f.makeFriend("John", "");
		List<String> expected = new ArrayList<>();
		assertEquals(expected, f.getDirectFriends("John"));
	}

	@Test
	public void testMakeFriendsNullFriend() {
		f.makeFriend("John", null);
		List<String> expected = new ArrayList<>();
		assertEquals(expected, f.getDirectFriends("John"));
	}

	@Test
	public void testMakeOneFriendReverse() {
		f.makeFriend("John", "Ted");
		List<String> expected = new ArrayList<>();
		expected.add("John");
		assertEquals(expected, f.getDirectFriends("Ted"));
	}

	@Test
	public void testMakeMultipleFriend() {
		f.makeFriend("John", "Ted");
		f.makeFriend("John", "Aron");
		f.makeFriend("John", "Micheal");
		f.makeFriend("John", "Mat");
		f.makeFriend("John", "George");
		List<String> expected = new ArrayList<>();
		expected.add("Ted");
		expected.add("Aron");
		expected.add("Micheal");
		expected.add("Mat");

		Assert.assertNotSame(expected, f.getDirectFriends("John"));

		expected.add("George");
		assertEquals(expected, f.getDirectFriends("John"));
	}

	void assertEquals(List<String> expected, List<String> actual) {
		Assert.assertNotNull(actual);
		Assert.assertEquals(expected, actual);
	}	
}
