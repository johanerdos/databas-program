package controller;

import dal.Task3Dal;

public class Controller_3 {
	
	static Task3Dal dal = new Task3Dal();
	
	public static void openFile(String name) throws Exception {
		dal.openFile(name);
	}
}
