package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationPowerOut implements IInterpolation {

	
	private int power;


	
	
	
	
	protected InterpolationPowerOut(int power) {
		this.power = power;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.powOut(a, power);
	}
	
	
	

	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}

	
}
