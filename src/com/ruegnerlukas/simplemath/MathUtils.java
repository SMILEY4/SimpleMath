package com.ruegnerlukas.simplemath;



public class MathUtils {

	
	private static final float EPSILON = 0.000001f;

	
	
	
	private MathUtils() {
	}
	
	
	
	
	
	public static boolean isNearlyEqual(float a, float b) {
		return isNearlyEqual(a, b, false);
	}
	
	
	public static boolean isNearlyEqual(float a, float b, boolean dynamicEpsilon) {
		if(dynamicEpsilon) {
			return isNearlyEqual(a, b, Math.max(Math.ulp(a), Math.ulp(b)));
		} else {
			return isNearlyEqual(a, b, EPSILON);
		}
	}
	
	
	public static boolean isNearlyEqual(float a, float b, float epsilon) {
		return Math.abs(a-b) < epsilon;
	}
	
	
	
	
	public static boolean isNearlyEqual(double a, double b) {
		return isNearlyEqual(a, b, false);
	}
	
	
	public static boolean isNearlyEqual(double a, double b, boolean dynamicEpsilon) {
		if(dynamicEpsilon) {
			return isNearlyEqual(a, b, Math.max(Math.ulp(a), Math.ulp(b)));
		} else {
			return isNearlyEqual(a, b, EPSILON);
		}
	}
	
	
	public static boolean isNearlyEqual(double a, double b, double epsilon) {
		return Math.abs(a-b) < epsilon;
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
