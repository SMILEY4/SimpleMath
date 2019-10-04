package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationCircle implements IInterpolation {

	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.circle(a);
	}
	
	
	
	
	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}

	
}
