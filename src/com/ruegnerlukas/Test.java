package com.ruegnerlukas;

import java.util.Random;

import com.ruegnerlukas.simplemath.matrix.Matrix4f;
import com.ruegnerlukas.simplemath.matrix.Matrixf;
import com.ruegnerlukas.simplemath.vectors.Quaternion;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;

public class Test {

	
	
	public static void main(String[] args) {
		
		float degrees = 40;
		float radians = (float)Math.toRadians(degrees);
		float axisX = 1f;
		float axisY = -0.7f;
		float axisZ = 0.4f;
		long seed = 3425;
			

//		System.out.println();
//		System.out.println("LWJGL");
//		org.lwjgl.util.vector.Quaternion lwjglQuat = new org.lwjgl.util.vector.Quaternion();
//		fillRandom(lwjglQuat, seed);
//		
//		
//		
//		System.out.println(lwjglQuat);
		
		
		System.out.println();
		System.out.println("GDX");
		com.badlogic.gdx.math.Matrix4 gdxMat = fillRandom(new com.badlogic.gdx.math.Matrix4(), seed);
		com.badlogic.gdx.math.Quaternion gdxQuat = new com.badlogic.gdx.math.Quaternion();
		fillRandom(gdxQuat, seed);
		
		float[] gdxRotMat = new float[4*4];
		gdxQuat.nor();
		gdxQuat.toMatrix(gdxRotMat);
		System.out.println(new com.badlogic.gdx.math.Matrix4(gdxRotMat));
		
		System.out.println(gdxQuat);
		
		
		
		
		System.out.println();
		System.out.println("SIMPLE MATH");
//		Matrix4f smMat = fillRandom(new Matrix4f(), seed);
		Quaternion smQuat = new Quaternion();
		fillRandom(smQuat, seed);
		
		System.out.println(smQuat.normalize().toRotationMatrix().getSubmatrix(0, 0, 3, 3).toFormattedString());
		
		System.out.println(smQuat);
		
		
		
		
//		System.out.println();
//		System.out.println("BASE");
//		System.out.println(fillRandom(new Matrix4f(), seed).toFormattedString());
//		
//		
//		
//		
//		System.out.println();
//		System.out.println("LWJGL");
//		org.lwjgl.util.vector.Matrix4f lwjglMat = org.lwjgl.util.vector.Matrix4f.setIdentity(new org.lwjgl.util.vector.Matrix4f());
//		fillRandom(lwjglMat, seed);
//		System.out.println(toStringLWJGL(lwjglMat));
//
//		System.out.println(org.lwjgl.util.vector.Matrix4f.transform(lwjglMat, new org.lwjgl.util.vector.Vector4f(1f, 0f, 0f, 0f), null));
//		
//		
//		
//		
//		System.out.println();
//		System.out.println("SIMPLE MATH");
//		Matrix4f smMat = (Matrix4f)Matrixf.createIdentity(4);
//		fillRandom(smMat, seed);
//		System.out.println(smMat.toFormattedString());
//		System.out.println(smMat.transformVector(new Vector4f(1f, 0f, 0f, 0f)));
//		
//		
//		
//		System.out.println();
//		System.out.println("DIFFERENCE");
//		System.out.println(difference(lwjglMat, smMat).toFormattedString());
	}

	
	
	
	private static Quaternion fillRandom(Quaternion smQuat, long seed) {
		Random random = new Random(seed);
		smQuat.x = random.nextInt(20)-10;
		smQuat.y = random.nextInt(20)-10;
		smQuat.z = random.nextInt(20)-10;
		smQuat.w = random.nextInt(20)-10;
		return smQuat;
	}
	
	
	
	private static org.lwjgl.util.vector.Quaternion fillRandom(org.lwjgl.util.vector.Quaternion lwjglQuat, long seed) {
		Random random = new Random(seed);
		lwjglQuat.x = random.nextInt(20)-10;
		lwjglQuat.y = random.nextInt(20)-10;
		lwjglQuat.z = random.nextInt(20)-10;
		lwjglQuat.w = random.nextInt(20)-10;
		return lwjglQuat;
	}
	
	
	
	private static com.badlogic.gdx.math.Quaternion fillRandom(com.badlogic.gdx.math.Quaternion gdxQuat, long seed) {
		Random random = new Random(seed);
		gdxQuat.x = random.nextInt(20)-10;
		gdxQuat.y = random.nextInt(20)-10;
		gdxQuat.z = random.nextInt(20)-10;
		gdxQuat.w = random.nextInt(20)-10;
		return gdxQuat;
	}
	
	
	
	private static Matrix4f fillRandom(Matrix4f smMat, long seed) {
		Random random = new Random(seed);
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				smMat.set(i, j, random.nextInt(20)-10);
			}
		}
		return smMat;
	}
	
	
	private static void fillRandom(org.lwjgl.util.vector.Matrix4f lwjglMat, long seed) {
		Random random = new Random(seed);
		lwjglMat.m00 = random.nextInt(20)-10;
		lwjglMat.m01 = random.nextInt(20)-10;
		lwjglMat.m02 = random.nextInt(20)-10;
		lwjglMat.m03 = random.nextInt(20)-10;
		lwjglMat.m10 = random.nextInt(20)-10;
		lwjglMat.m11 = random.nextInt(20)-10;
		lwjglMat.m12 = random.nextInt(20)-10;
		lwjglMat.m13 = random.nextInt(20)-10;
		lwjglMat.m20 = random.nextInt(20)-10;
		lwjglMat.m21 = random.nextInt(20)-10;
		lwjglMat.m22 = random.nextInt(20)-10;
		lwjglMat.m23 = random.nextInt(20)-10;
		lwjglMat.m30 = random.nextInt(20)-10;
		lwjglMat.m31 = random.nextInt(20)-10;
		lwjglMat.m32 = random.nextInt(20)-10;
		lwjglMat.m33 = random.nextInt(20)-10;
	}
	
	
	private static com.badlogic.gdx.math.Matrix4 fillRandom(com.badlogic.gdx.math.Matrix4 gdxMat, long seed) {
		Random random = new Random(seed);
		float[] values = new float[16];
		for(int i=0; i<16; i++) {
			values[i] = random.nextInt(20)-10;
		}
		gdxMat.set(values);
		return gdxMat;
	}
	
	
	private static String toStringLWJGL(org.lwjgl.util.vector.Matrix4f lwjglMat) {
		StringBuilder sb = new StringBuilder();
		
		
		sb.append("[")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m00))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m10))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m20))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m30))).append("]")
		.append(System.lineSeparator());

		sb.append("[")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m01))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m11))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m21))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m31))).append("]")
		.append(System.lineSeparator());
		
		sb.append("[")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m02))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m12))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m22))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m32))).append("]")
		.append(System.lineSeparator());
		
		sb.append("[")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m03))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m13))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m23))).append(", ")
		.append(String.format("%1$10s", String.format("%.4f", lwjglMat.m33))).append("]")
		.append(System.lineSeparator());
		
		return sb.toString();
	}

	
	
	private static Matrix4f difference(org.lwjgl.util.vector.Matrix4f lwjglMat, Matrix4f smMat) {
		float[][] diff = new float[4][4];
		
		diff[0][0] = lwjglMat.m00 - smMat.getData(0, 0); 
		diff[0][1] = lwjglMat.m01 - smMat.getData(0, 1); 
		diff[0][2] = lwjglMat.m02 - smMat.getData(0, 2); 
		diff[0][3] = lwjglMat.m03 - smMat.getData(0, 3); 

		diff[1][0] = lwjglMat.m10 - smMat.getData(1, 0); 
		diff[1][1] = lwjglMat.m11 - smMat.getData(1, 1); 
		diff[1][2] = lwjglMat.m12 - smMat.getData(1, 2); 
		diff[1][3] = lwjglMat.m13 - smMat.getData(1, 3); 
		
		diff[2][0] = lwjglMat.m20 - smMat.getData(2, 0); 
		diff[2][1] = lwjglMat.m21 - smMat.getData(2, 1); 
		diff[2][2] = lwjglMat.m22 - smMat.getData(2, 2); 
		diff[2][3] = lwjglMat.m23 - smMat.getData(2, 3); 
		
		diff[3][0] = lwjglMat.m30 - smMat.getData(3, 0); 
		diff[3][1] = lwjglMat.m31 - smMat.getData(3, 1); 
		diff[3][2] = lwjglMat.m32 - smMat.getData(3, 2); 
		diff[3][3] = lwjglMat.m33 - smMat.getData(3, 3); 
		
		return new Matrix4f(diff);
	}
	
}






