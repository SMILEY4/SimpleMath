package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationSwingIn implements IInterpolation {

	
	private float scale;


	
	
	
	
	protected InterpolationSwingIn(float scale) {
		this.scale = scale;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.swingIn(a, scale);
	}

	
}
