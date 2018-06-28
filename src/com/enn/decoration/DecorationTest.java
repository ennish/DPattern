package com.enn.decoration;

public class DecorationTest {

	public static void main(String[] args) {

		EggWithPaper f1 = new EggWithPaper(new BaseMeal());
		System.out.println(f1.cost());
	}
}
