package com.ruegnerlukas;

import com.ruegnerlukas.simplemath.vectors.vec2.ConstVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;

public class Test {

	
	public static void main(String[] args) {
		
		
		Vector2f vec = new Vector2f(5,3);
		
		ConstVector2<Vector2f> constVec = vec.toConstVector();
		
		System.out.println("vec:   " + vec);
		System.out.println("const: " + constVec);
		
		vec.x = 9;
		
		System.out.println("vec:   " + vec);
		System.out.println("const: " + constVec);
	}
	
	

	
	
}


