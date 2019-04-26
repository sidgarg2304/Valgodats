package com.vishal.interviews.facebook.hard;

import java.util.*;

public class RobotRoomCleaner {

	public static void main(String[] args) {

	}

	public void cleanRoom(Robot robot) {

		Set<String> seen = new HashSet<>();
		seen.add("0-0");
		dfs(robot, seen, 0, 0, 0);

	}

	void dfs(Robot robot, Set<String> seen, int x, int y, int curDir) {
		robot.clean();

		for (int i = 0; i < 4; i++) {
			int newX = x;
			int newY = y;

			switch (curDir) {
				case 0: 
					newY = y + 1;
					break;				
				case 90: 
					newX = x + 1;
					break;				
				case 180: 
					newY = y - 1;
					break;
				
				case 270: 
					newX = x - 1;
					break;
				
			}
			
			if(!seen.contains(newX + "-" + newY) && robot.move()){
				seen.add(newX + "-" + newY);				
				dfs(robot, seen, newX, newY, curDir);
			}
			
			curDir += 90;
			curDir %= 360;
			robot.turnRight();

		}
		
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}
}

class Robot {
	public boolean move() {
		return false;
	}

	public void turnLeft() {

	}

	public void turnRight() {

	}

	// Clean the current cell.
	public void clean() {

	}
}
