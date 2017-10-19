package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationExponentialIn implements IInterpolation {

	
	private float value;
	private int power;

	
	
	
	
	protected InterpolationExponentialIn(float value, int power) {
		this.value = value;
		this.power = power;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.expIn(a, value, power);
	}

	
}
