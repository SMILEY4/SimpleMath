package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationSwingOut implements IInterpolation {

	
	private float scale;


	
	
	
	
	protected InterpolationSwingOut(float scale) {
		this.scale = scale;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.swingOut(a, scale);
	}

	
}
