package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationLinear implements IInterpolation {

	
	

	@Override
	public float interpolate(float a) {
		return InterpolationMath.linear(a);
	}

	
}
