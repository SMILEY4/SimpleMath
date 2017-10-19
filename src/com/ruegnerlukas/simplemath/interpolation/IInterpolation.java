package com.ruegnerlukas.simplemath.interpolation;

public interface IInterpolation {

	
	/**
	 * @param a	alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public float interpolate(float a);
	
	
}
