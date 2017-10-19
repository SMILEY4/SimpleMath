package com.ruegnerlukas.simplemath.interpolation;

public class InterpolationElasticOut implements IInterpolation {

	
	private float value;
	private int power;
	private int bounces;
	private float scale;


	
	
	
	
	protected InterpolationElasticOut(float value, int power, int bounces, float scale) {
		this.value = value;
		this.power = power;
		this.bounces = bounces;
		this.scale = scale;
	}
	
	
	
	
	
	
	@Override
	public float interpolate(float a) {
		return InterpolationMath.elasticOut(a, value, power, bounces, scale);
	}

	
}
