package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationSwing implements IInterpolation {

	
	private float scale;


	
	
	
	
	protected InterpolationSwing(float scale) {
		this.scale = scale;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.swing(a, scale);
	}

	
}
