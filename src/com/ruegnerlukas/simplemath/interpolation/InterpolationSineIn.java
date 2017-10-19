package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationSineIn implements IInterpolation {

	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.sineIn(a);
	}


}
