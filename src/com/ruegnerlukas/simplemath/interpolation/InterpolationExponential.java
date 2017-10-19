package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationExponential implements IInterpolation {

	
	private float value;
	private int power;

	
	
	
	
	protected InterpolationExponential(float value, int power) {
		this.value = value;
		this.power = power;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.exp(a, value, power);
	}
	
	
	

	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}

	
}
