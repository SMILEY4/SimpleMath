package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationElastic implements IInterpolation {

	
	private float value;
	private int power;
	private int bounces;
	private float scale;


	
	
	protected InterpolationElastic(float value, int power, int bounces, float scale) {
		this.value = value;
		this.power = power;
		this.bounces = bounces;
		this.scale = scale;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.elastic(a, value, power, bounces, scale);
	}
	
	
	

	@Override
	public float interpolate(float start, float end, float a) {
		return start + (end - start) * interpolate(a);
	}

	
}
