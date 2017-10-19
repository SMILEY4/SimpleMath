package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationExponentialOut implements IInterpolation {

	
	private float value;
	private int power;

	
	
	
	
	protected InterpolationExponentialOut(float value, int power) {
		this.value = value;
		this.power = power;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.expOut(a, value, power);
	}

	
}
