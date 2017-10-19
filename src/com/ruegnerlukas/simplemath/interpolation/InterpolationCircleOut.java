package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationCircleOut implements IInterpolation {

	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.circleOut(a);
	}

	
}
