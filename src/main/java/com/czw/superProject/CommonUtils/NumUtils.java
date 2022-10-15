package com.czw.superProject.CommonUtils;

import java.util.Random;

public class NumUtils {
	public static int randomNum() {
		int min = 1;
		int max = 10;
		Random random = new Random();
		int value = random.nextInt(max + min) + min;
		return value;
	}
}
