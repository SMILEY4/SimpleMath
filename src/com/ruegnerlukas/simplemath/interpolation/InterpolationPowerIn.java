package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationPowerIn implements IInterpolation {

	
	private int power;


	
	
	
	
	protected InterpolationPowerIn(int power) {
		this.power = power;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.powIn(a, power);
	}

	
}
