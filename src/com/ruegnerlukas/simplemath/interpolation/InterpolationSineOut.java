package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationSineOut implements IInterpolation {

	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.sineOut(a);
	}


}
