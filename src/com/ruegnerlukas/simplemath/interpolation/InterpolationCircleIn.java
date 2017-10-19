package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationCircleIn implements IInterpolation {

	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.circleIn(a);
	}

	
	

	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}
	
}
