package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationFade implements IInterpolation {

	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.fade(a);
	}
	
	
	

	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}


}
