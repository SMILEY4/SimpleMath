package com.ruegnerlukas;

import java.util.Random;

import com.ruegnerlukas.simplemath.matrix.Matrix;
import com.ruegnerlukas.simplemath.vectors.IVector;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vectors.vecN.VectorNf;

public class Test {

	
	
	public static void main(String[] args) {
		
		Random random = new Random(4533);

		
		int size = 3;
		
		float[][] data1 = new float[3][3];
		for(int i=0; i<data1.length; i++) {
			for(int j=0; j<data1[i].length; j++) {
				data1[i][j] = random.nextInt(100)-50;
			}
		}
		Matrix mat1 = new Matrix(data1);
		System.out.println(mat1.toFormattedString());

		
//		float[][] data2 = new float[3][4];
//		for(int i=0; i<data2.length; i++) {
//			for(int j=0; j<data2[i].length; j++) {
//				data2[i][j] = random.nextInt(100)-50;
//			}
//		}
//		Matrix mat2 = new Matrix(data2);
//		System.out.println(mat2.toFormattedString());

		mat1.toUpperTriangle();
		System.out.println(mat1.isUpperTriangular());
		System.out.println(mat1.toFormattedString());
		
	}

	
	public static void printArr(float[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]);
			if(i != arr.length-1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
	
	// 3x3 * 3x3
	// {{34,-45,10},{48,40,29},{-41,-41,-26}}
	// {{-39,-45,27},{42,7,-25},{-32,25,-13}}
	
	// 4x3 * 3x4
	// {{34,-45,10,-39},{48,40,29,42},{-41,-41,-26,-32}}
	// {{-45,-25,46},{7,-13,-22},{35,5,25},{27,27,34}}

	
}
