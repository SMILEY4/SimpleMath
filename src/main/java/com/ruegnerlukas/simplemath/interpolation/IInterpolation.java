package com.ruegnerlukas.simplemath.interpolation;

public interface IInterpolation {

	
	/**
	 * @param a	alpha value between 0 and 1
	 * @return the interpolated value (mostly between 0 and 1)
	 * */
	public float interpolate(float a);
	
	
	/**
	 * @param a	alpha value between 0 and 1
	 * @return the interpolated value (between start and end)
	 * */
	public float interpolate(float start, float end, float a);
	
	
}
