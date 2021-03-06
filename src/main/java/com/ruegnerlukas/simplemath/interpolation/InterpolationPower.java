package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationPower implements IInterpolation {

	
	private int power;


	
	
	
	
	protected InterpolationPower(int power) {
		this.power = power;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.pow(a, power);
	}
	
	
	

	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}

	
}
