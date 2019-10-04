package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationLinear implements IInterpolation {

	
	

	@Override
	public float interpolate(float a) {
		return InterpolationMath.linear(a);
	}
	
	
	

	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}
	
	
	
}
