package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationSine implements IInterpolation {

	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.sine(a);
	}

	
}
