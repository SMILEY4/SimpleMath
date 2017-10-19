package com.ruegnerlukas;

import com.ruegnerlukas.simplemath.vecmath.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vecmath.vec3.Vector3f;

public class Test {

	
	
	public static void main(String[] args) {
		
		Vector3f a = new Vector3f(1, 1, 0);
		Vector3f b = new Vector3f(0, 1, 0);
//		System.out.println(a.length());
//		System.out.println(b.length());
		
		float angle = a.angleRad(b);
		
		System.out.println(angle);
		System.out.println(Math.toDegrees(angle));
		
	}
	
	
	
}
