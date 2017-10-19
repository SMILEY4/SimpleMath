package com.ruegnerlukas.simplemath;



public class MathUtils {

	
	
	
	private MathUtils() {
	}
	
	
	
	
	
	
	public static short clamp(short v, short min, short max) {
		return (short) Math.min(Math.max(v, min), max);
	}
	
	
	
	
	public static int clamp(int v, int min, int max) {
		return Math.min(Math.max(v, min), max);
	}
	
	
	
	
	public static long clamp(long v, long min, long max) {
		return Math.min(Math.max(v, min), max);
	}
	
	
	
	
	public static float clamp(float v, float min, float max) {
		return Math.min(Math.max(v, min), max);
	}
	
	
	
	
	public static double clamp(double v, double min, double max) {
		return Math.min(Math.max(v, min), max);
	}
	

	
	
}
