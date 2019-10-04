package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationSine implements IInterpolation {

	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.sine(a);
	}
	
	
	

	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}

	
}
