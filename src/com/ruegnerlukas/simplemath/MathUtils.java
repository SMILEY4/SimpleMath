package com.ruegnerlukas.simplemath;



public class MathUtils {

	
	
	
	private static final float EPSILON = 0.000001f;

	
	
	
	
	
	private MathUtils() {
	}
	
	
	
	
	
	
	/**
	 * @return true, if a is nearly equal to b.
	 * */
	public static boolean isNearlyEqual(float a, float b) {
		return isNearlyEqual(a, b, false);
	}
	
	
	
	
	/**
	 * @return true, if a is nearly equal to b. Set "dynamicEpsilon" to true, to calculate the threshold for each pair of values.
	 * */
	public static boolean isNearlyEqual(float a, float b, boolean dynamicEpsilon) {
		if(dynamicEpsilon) {
			return isNearlyEqual(a, b, Math.max(Math.ulp(a), Math.ulp(b)));
		} else {
			return isNearlyEqual(a, b, EPSILON);
		}
	}
	
	
	
	
	/**
	 * @return true, if a is nearly equal to b. Uses the given epsilon as a threshold
	 * */
	public static boolean isNearlyEqual(float a, float b, float epsilon) {
		return Math.abs(a-b) < epsilon;
	}
	
	
	
	
	/**
	 * @return true, if a is nearly equal to b.
	 * */
	public static boolean isNearlyEqual(double a, double b) {
		return isNearlyEqual(a, b, false);
	}
	
	
	
	
	/**
	 * @return true, if a is nearly equal to b. Set "dynamicEpsilon" to true, to calculate the threshold for each pair of values.
	 * */
	public static boolean isNearlyEqual(double a, double b, boolean dynamicEpsilon) {
		if(dynamicEpsilon) {
			return isNearlyEqual(a, b, Math.max(Math.ulp(a), Math.ulp(b)));
		} else {
			return isNearlyEqual(a, b, EPSILON);
		}
	}
	
	
	
	
	/**
	 * @return true, if a is nearly equal to b. Uses the given epsilon as a threshold
	 * */
	public static boolean isNearlyEqual(double a, double b, double epsilon) {
		return Math.abs(a-b) < epsilon;
	}
	
	
	
	
	/**
	 * limits the given value v to the given minimum / maximum value
	 * */
	public static short clamp(short v, short min, short max) {
		return (short) Math.min(Math.max(v, min), max);
	}
	
	
	
	
	/**
	 * limits the given value v to the given minimum / maximum value
	 * */
	public static int clamp(int v, int min, int max) {
		return Math.min(Math.max(v, min), max);
	}
	
	
	
	
	/**
	 * limits the given value v to the given minimum / maximum value
	 * */
	public static long clamp(long v, long min, long max) {
		return Math.min(Math.max(v, min), max);
	}
	
	
	
	
	/**
	 * limits the given value v to the given minimum / maximum value
	 * */
	public static float clamp(float v, float min, float max) {
		return Math.min(Math.max(v, min), max);
	}
	
	
	
	
	/**
	 * limits the given value v to the given minimum / maximum value
	 * */
	public static double clamp(double v, double min, double max) {
		return Math.min(Math.max(v, min), max);
	}
	

	
	
}
