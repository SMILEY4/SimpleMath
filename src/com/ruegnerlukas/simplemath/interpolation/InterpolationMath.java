package com.ruegnerlukas.simplemath.interpolation;

import com.ruegnerlukas.simplemath.MathUtils;

public class InterpolationMath {

	
	
	
	
	//--------------//
	//    LINEAR    //
	//--------------//
	
	public static InterpolationLinear createLinear() {
		return new InterpolationLinear();
	}
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float linear(float a) {
		return a;
	}
	
	
	
	
	
	//------------//
	//    FADE    //
	//------------//
	
	public static InterpolationFade createFade() {
		return new InterpolationFade();
	}
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float fade(float a) {
		return MathUtils.clamp( a*a*a * (a * (a*6-15) + 10), 0, 1);
	}
	
	
	
	
	
	//------------//
	//    SINE    //
	//------------//
	
	public static InterpolationSine createSine() {
		return new InterpolationSine();
	}
	
	public static InterpolationSineIn createSineIn() {
		return new InterpolationSineIn();
	}
	
	public static InterpolationSineOut createSineOut() {
		return new InterpolationSineOut();
	}
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float sine(float a) {
		return (1f - (float)Math.cos(a * Math.PI)) / 2f;
	}
	
	
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float sineIn(float a) {
		return 1f - (float)Math.cos(a * Math.PI / 2f);
	}
	
	
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float sineOut(float a) {
		return (float)Math.sin(a * Math.PI / 2f);
	}
	
	
	
	
	
	//--------------//
	//    CIRCLE    //
	//--------------//
	
	public static InterpolationCircle createCircle() {
		return new InterpolationCircle();
	}
	
	public static InterpolationCircleIn createCircleIn() {
		return new InterpolationCircleIn();
	}
	
	public static InterpolationCircleOut createCircleOut() {
		return new InterpolationCircleOut();
	}
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float circle(float a) {
		if (a <= 0.5f) {
			return (1f - (float)Math.sqrt(1f - (a*2f) * (a*2f))) / 2f;
		}
		return ((float)Math.sqrt(1f - ((a-1f)*2f) * ((a-1f)*2f)) + 1f) / 2f;
	}
	
	
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float circleIn(float a) {
		return (float)(1f - Math.sqrt(1 - a*a));
	}
	
	
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float circleOut(float a) {
		return (float)(1f - Math.sqrt(1 - (a-1f)*(a-1f)));
	}
	
	
	
	
	
	//-------------//
	//    POWER    //
	//-------------//
	
	public static InterpolationPower createPower(int power) {
		return new InterpolationPower(power);
	}
	
	public static InterpolationPower createPower2() {
		return new InterpolationPower(2);
	}
	
	
	public static InterpolationPowerIn createPowerIn(int power) {
		return new InterpolationPowerIn(power);
	}
	
	public static InterpolationPowerIn createPowerIn2() {
		return new InterpolationPowerIn(2);
	}
	
	
	public static InterpolationPowerOut createPowerOut(int power) {
		return new InterpolationPowerOut(power);
	}
	
	public static InterpolationPowerOut createPowerOut2() {
		return new InterpolationPowerOut(2);
	}
	
	

	/**
	 * @param a			alpha value between 0 and 1
	 * @param power		higher value means bigger slope
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float pow(float a, int power) {
		if(a <= 0.5f) {
			return (float)Math.pow(a*2f, power) / 2f;
		}
		return (float)Math.pow((a-1f)*2f, power) / (power % 2 == 0 ? -2 : 2) + 1;
	}
	
	
	
	
	/**
	 * @param a			alpha value between 0 and 17
	 * @param power		higher value means bigger slope
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float powIn(float a, int power) {
		return (float)Math.pow(a, power);
	}
	
	
	
	
	/**
	 * @param a	alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float powOut(float a, int power) {
		return (float)Math.pow(a-1f, power) * (power%2 == 0 ? -1 : 1) + 1;
	}
	
	
	
	
	
	//-------------------//
	//    EXPONENTIAL    //
	//-------------------//
	
	public static InterpolationExponential createExponential(float value, int power) {
		return new InterpolationExponential(value, power);
	}
	
	public static InterpolationExponential createExponential5() {
		return new InterpolationExponential(2, 5);
	}
	
	public static InterpolationExponential createExponential10() {
		return new InterpolationExponential(2, 10);
	}
	
	
	public static InterpolationExponentialIn createExponentialIn(float value, int power) {
		return new InterpolationExponentialIn(value, power);
	}
	
	public static InterpolationExponentialIn createExponentialIn5() {
		return new InterpolationExponentialIn(2, 5);
	}
	
	public static InterpolationExponentialIn createExponentialIn10() {
		return new InterpolationExponentialIn(2, 10);
	}
	
	
	public static InterpolationExponentialOut createExponentialOut(float value, int power) {
		return new InterpolationExponentialOut(value, power);
	}
	
	public static InterpolationExponentialOut createExponentialOut5() {
		return new InterpolationExponentialOut(2, 5);
	}
	
	public static InterpolationExponentialOut createExponentialOut10() {
		return new InterpolationExponentialOut(2, 10);
	}
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @param value		value between 0 and 1. Higher value means more linear interpolation 
	 * @param power		higher value means bigger slope
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float exp(float a, float value, int power) {
		final float min = (float) Math.pow(value, -power);
		final float scale = 1f / (1f-min);
		if (a <= 0.5f) {
			return ((float)Math.pow(value, power * (a * 2 - 1)) - min) * scale / 2;
		}
		return (2 - ((float)Math.pow(value, -power * (a * 2 - 1)) - min) * scale) / 2;
	}
	
	
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @param value		value between 0 and 1. Higher value means more linear interpolation 
	 * @param power		higher value means bigger slope
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float expIn(float a, float value, int power) {
		final float min = (float) Math.pow(value, -power);
		final float scale = 1f / (1f-min);
		return ((float)Math.pow(value, power*(a-1)) - min) * scale;
	}
	
	
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @param value		value between 0 and 1. Higher value means more linear interpolation 
	 * @param power		higher value means bigger slope
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float expOut(float a, float value, int power) {
		final float min = (float) Math.pow(value, -power);
		final float scale = 1f / (1f-min);
		return 1 - ((float)Math.pow(value, -power * a) - min) * scale;
	}
	
	
	
	
	
	//---------------//
	//    ELASTIC    //
	//---------------//
	
	public static InterpolationElastic createElastic(float value, int power, int bounces, float scale) {
		return new InterpolationElastic(value, power, bounces, scale);
	}
	
	public static InterpolationElastic createElastic() {
		return new InterpolationElastic(2, 10, 7, 1);
	}
	
	
	public static InterpolationElasticIn createElasticIn(float value, int power, int bounces, float scale) {
		return new InterpolationElasticIn(value, power, bounces, scale);
	}
	
	public static InterpolationElasticIn createElasticIn() {
		return new InterpolationElasticIn(2, 10, 6, 1);
	}
	
	
	public static InterpolationElasticOut createElasticOut(float value, int power, int bounces, float scale) {
		return new InterpolationElasticOut(value, power, bounces, scale);
	}
	
	public static InterpolationElasticOut createElasticOut() {
		return new InterpolationElasticOut(2, 10, 7, 1);
	}
	
	
	/**
	 * @param a			alpha value between 0 and 1
	 * @param value		value between 0 and 1. Higher value means more linear interpolation 
	 * @param power		higher value means bigger slope	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float elastic(float a, float value, int power, int bounces, float scale) {
		final float bouncesF = bounces * (float)Math.PI * (bounces % 2 == 0 ? 1 : -1);
		if (a <= 0.5f) {
			return (float)Math.pow(value, power * ((a*2f) - 1)) * (float)Math.sin((a*2f) * bouncesF) * scale / 2;
		}
		return 1 - (float)Math.pow(value, power * (((1f-a)*2f) - 1)) * (float)Math.sin((((1f-a)*2f)) * bouncesF) * scale / 2;
	}
	
	
	
	
	/**
	 * @param a	alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float elasticIn(float a, float value, int power, int bounces, float scale) {
		final float bouncesF = bounces * (float)Math.PI * (bounces % 2 == 0 ? 1 : -1);
		if(a >= 0.99f) {
			return 1f;
		}
		return (float)Math.pow(value, power*(a-1f)) * (float)Math.sin(a*bouncesF) * scale;
	}
	
	
	
	
	/**
	 * @param a	alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float elasticOut(float a, float value, int power, int bounces, float scale) {
		final float bouncesF = bounces * (float)Math.PI * (bounces % 2 == 0 ? 1 : -1);
		return (1f - (float)Math.pow(value, power * ((1f-a)-1f))) * (float)Math.sin(a * bouncesF) * scale;
	}
	
	
	
	
	
	//---------------//
	//    SWING    //
	//---------------//
	
	public static InterpolationSwing createSwing(float scale) {
		return new InterpolationSwing(scale);
	}
	
	public static InterpolationSwing createSwing() {
		return new InterpolationSwing(1.5f);
	}
	
	
	public static InterpolationSwingIn createSwingIn(float scale) {
		return new InterpolationSwingIn(scale);
	}
	
	public static InterpolationSwingIn createSwingIn() {
		return new InterpolationSwingIn(2f);
	}
	
	
	public static InterpolationSwingOut createSwingOut(float scale) {
		return new InterpolationSwingOut(scale);
	}
	
	public static InterpolationSwingOut createSwingOut() {
		return new InterpolationSwingOut(2f);
	}
	
	
	/**
	 * @param a	alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float swing(float a, float scale) {
		if(a <= 0.5f) {
			return (a*2f) * (a*2f) * ((scale+1f) * (a*2) - scale) / 2f;
		}
		
		return ((a-1f)*2f) * ((a-1f)*2f) * ((scale+1f) * ((a-1f)*2f) - scale) / 2f + 1f;
	}
	
	
	
	
	/**
	 * @param a	alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float swingOut(float a, float scale) {
		return (a-1f) * (a-1f) * ((scale+1f) * (a-1f) - scale) + 1f;
	}
	
	
	
	
	/**
	 * @param a	alpha value between 0 and 1
	 * @returns the interpolated value (mostly between 0 and 1)
	 * */
	public static float swingIn(float a, float scale) {
		return a * a * ((scale+1f) * a - scale);
	}
	
	
}
