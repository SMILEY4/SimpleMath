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
	
	
	

	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}

	
}
