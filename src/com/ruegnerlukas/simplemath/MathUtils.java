package com.ruegnerlukas.simplemath;

import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3f;

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
	
	
	
	
	/**
	 * calculates the barycentric coordinates of the given point P and the triangle ABC
	 * @param a the first point of the triangle
	 * @param b the second point of the triangle
	 * @param c the third point of the triangle
	 * @param p	the point
	 * */
	public static Vector3f barycentric(Vector2f a, Vector2f b, Vector2f c, Vector2f p) {
		
		Vector2f v1 = new Vector2f();
		Vector2f v2 = new Vector2f();
		Vector2f  q = new Vector2f();
		
		Vector2f.setVectorAB(a, b, v1);
		Vector2f.setVectorAB(a, c, v2);
		Vector2f.setVectorAB(a, p,  q);
		
		final float c12 = v1.cross(v2);
		
		Vector3f bary = new Vector3f();
		bary.y = q.cross(v2) / c12;
		bary.z = v1.cross(q) / c12;
		bary.x = 1f - bary.y - bary.z;
		
		return bary;
	}
	

	
	
}
