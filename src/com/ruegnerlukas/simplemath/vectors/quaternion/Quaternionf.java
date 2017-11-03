package com.ruegnerlukas.simplemath.vectors.quaternion;

import com.ruegnerlukas.simplemath.MathUtils;
import com.ruegnerlukas.simplemath.matrix.IMatrix;
import com.ruegnerlukas.simplemath.matrix.matrix4.Matrix4f;
import com.ruegnerlukas.simplemath.vectors.vec3.IVector3;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3f;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;

public class Quaternionf extends Vector4f implements IQuaternion {

	
	
	
	public Quaternionf() {
		super();
	}
	
	
	public Quaternionf(IVector4 vec) {
		super(vec);
	}
	
	
	public Quaternionf(Quaternionf q) {
		super(q.x, q.y, q.z, q.w);
	}
	
	
	public Quaternionf(float x, float y, float z, float w) {
		super(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternionf set(int index, Number value) {
		return (Quaternionf) super.set(index, value);
	}
	
	
	
	
	@Override
	public Quaternionf negate() {
		return (Quaternionf) super.negate();
	}
	
	
	
	
	@Override
	public Quaternionf normalize() {
		return (Quaternionf) super.normalize();
	}
	
	
	
	
	@Override
	public Quaternionf copy() {
		return (Quaternionf) super.copy();
	}
	
	
	
	
	@Override
	public Quaternionf set(IQuaternion q) {
		return this.set(q.getFloatX(), q.getFloatY(), q.getFloatZ(), q.getFloatW());
	}
	
	
	
	
	@Override
	public Quaternionf set(IVector4 v) {
		return (Quaternionf) super.set(v);
	}
	
	
	
	
	@Override
	public Quaternionf set(Number x, Number y, Number z, Number w) {
		return (Quaternionf) super.set(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternionf set(Number xyzw) {
		return (Quaternionf) super.set(xyzw);
	}
	
	
	
	
	@Override
	public Quaternionf set(float xyzw) {
		return (Quaternionf) super.set(xyzw);
	}
	
	
	
	
	@Override
	public Quaternionf set(float x, float y, float z, float w) {
		return (Quaternionf) super.set(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternionf add(IVector4 vec) {
		return (Quaternionf) super.add(vec);
	}
	
	
	
	
	@Override
	public Quaternionf add(Number x, Number y, Number z, Number w) {
		return (Quaternionf) super.add(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternionf add(Number xyzw) {
		return (Quaternionf) super.add(xyzw);
	}
	
	
	
	
	@Override
	public Quaternionf add(float xyzw) {
		return (Quaternionf) super.add(xyzw);
	}
	
	

	
	@Override
	public Quaternionf add(float x, float y, float z, float w) {
		return (Quaternionf) super.add(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternionf sub(IVector4 vec) {
		return (Quaternionf) super.sub(vec);
	}
	
	

	
	@Override
	public Quaternionf sub(Number x, Number y, Number z, Number w) {
		return (Quaternionf) super.sub(x, y, z, w);
	}

	
	
	
	@Override
	public Quaternionf sub(Number xyzw) {
		return (Quaternionf) super.sub(xyzw);
	}
	
	
	
	
	@Override
	public Quaternionf sub(float xyzw) {
		return (Quaternionf) super.sub(xyzw);
	}
	
	
	
	
	@Override
	public Quaternionf sub(float x, float y, float z, float w) {
		return (Quaternionf) super.sub(x, y, z, w);
	}
	
	
	
	
	@Override
	public Quaternionf mul(IVector4 vec) {
		return (Quaternionf) super.mul(vec);
	}
	
	
	
	
	@Override
	public Quaternionf mul(Number x, Number y, Number z, Number w) {
		return (Quaternionf) super.mul(x, y, z, w);
	}

	
	
	
	@Override
	public Quaternionf scale(Number xyzw) {
		return (Quaternionf) super.scale(xyzw);
	}
	
	
	
	
	@Override
	public Quaternionf scale(float xyzw) {
		return (Quaternionf) super.scale(xyzw);
	}
	
	
	

	@Override
	public Quaternionf mul(float x, float y, float z, float w) {
		return (Quaternionf) super.mul(x, y, z, w);
	}
	
	
	

	@Override
	public Quaternionf div(IVector4 vec) {
		return (Quaternionf) super.div(vec);
	}

	
	
	
	@Override
	public Quaternionf div(Number x, Number y, Number z, Number w) {
		return (Quaternionf) super.div(x, y, z, w);
	}

	
	
	
	@Override
	public Quaternionf div(Number xyzw) {
		return (Quaternionf) super.div(xyzw);
	}

	
	

	@Override
	public Quaternionf div(float xyzw) {
		return (Quaternionf) super.div(xyzw);
	}
	
	
	
	
	@Override
	public Quaternionf div(float x, float y, float z, float w) {
		return (Quaternionf) super.div(x, y, z, w);
	}
	
	
	
	
	@Override
	public String toString() {
		return "Quaternion." + this.hashCode() + " (" + this.x + ", " + this.y + ", " + this.z + ", " + this.w + ")";
	}
	
	
	
	
	@Override
	public Quaternionf setToIdentity() {
		this.set(0, 0, 0, 1);
		return this;
	}
	
	
	
	
	@Override
	public Quaternionf mul(IQuaternion q) {
		final float newX = this.w * q.getFloatX() + this.x * q.getFloatW() + this.y * q.getFloatZ() - this.z * q.getFloatY();
		final float newY = this.w * q.getFloatY() + this.y * q.getFloatW() + this.z * q.getFloatX() - this.x * q.getFloatZ();
		final float newZ = this.w * q.getFloatZ() + this.z * q.getFloatW() + this.x * q.getFloatY() - this.y * q.getFloatX();
		final float newW = this.w * q.getFloatW() - this.x * q.getFloatX() - this.y * q.getFloatY() - this.z * q.getFloatZ();
		return (Quaternionf) this.set(newX, newY, newZ, newW);
	}
	
	
	
	
	@Override
	public Quaternionf mulLeft(IQuaternion q) {
		final float newX = q.getFloatW() * this.x + q.getFloatX() * this.w + q.getFloatY() * this.z - q.getFloatZ() * this.y;
		final float newY = q.getFloatW() * this.y + q.getFloatY() * this.w + q.getFloatZ() * this.x - q.getFloatX() * this.z;
		final float newZ = q.getFloatW() * this.z + q.getFloatZ() * this.w + q.getFloatX() * this.y - q.getFloatY() * this.x;
		final float newW = q.getFloatW() * this.w - q.getFloatX() * this.x - q.getFloatY() * this.y - q.getFloatZ() * this.z;
		return (Quaternionf) this.set(newX, newY, newZ, newW);
	}
	
	
	
	
	
	@Override
	public Quaternionf setFromAxisAngleDeg(IVector4 vec) {
		return this.setFromAxisAngleRad(vec.getFloatX(), vec.getFloatY(), vec.getFloatZ(), (float)Math.toRadians(vec.getFloatW()));
	}
	
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param ax	the x-component of the axis
	 * @param ay	the y-component of the axis
	 * @param az	the z-component of the axis
	 * @param angle	the angle in degrees
	 * @return this quaternion for chaining
	 * */
	public Quaternionf setFromAxisAngleDeg(float ax, float ay, float az, float angle) {
		return this.setFromAxisAngleRad(ax, ay, az, (float)Math.toRadians(angle));
	}
	
	
	@Override
	public Quaternionf setFromAxisAngleRad(IVector4 vec) {
		return this.setFromAxisAngleRad(vec.getFloatX(), vec.getFloatY(), vec.getFloatZ(), vec.getFloatW());
	}
	
	
	
	/**
	 * Sets this value of this quaternion to the to the equivalent rotation of the Axis-Angle argument.
	 * @param ax	the x-component of the axis
	 * @param ay	the y-component of the axis
	 * @param az	the z-component of the axis
	 * @param angle	the angle in radians
	 * @return this quaternion for chaining
	 * */
	public Quaternionf setFromAxisAngleRad(float ax, float ay, float az, float angle) {
		
		float d = (float) Math.sqrt(ax * ax + ay * ay + az * az);
		
		if (d == 0f)
			return this.setToIdentity();
		d = 1f / d;

		double PI2 = (Math.PI*2);
		double l_ang = angle < 0 ? PI2 - (-angle % PI2) : angle % PI2;
		float l_sin = (float) Math.sin(l_ang / 2);
		float l_cos = (float) Math.cos(l_ang / 2);
		
		return this.set(d * ax * l_sin, d * ay * l_sin, d * az * l_sin, l_cos).normalize();
	}
	
	
	
	
	@Override
	public Quaternionf setFromMatrix(IMatrix mat) {
		if(mat.getNumberColumns() >= 3 && mat.getNumberRows() >= 3) {
		
			boolean wasUnsafe = mat.isUnsafe();
			mat.setUnsafe(true);
			setFromMatrix(	mat.getFloat(0, 0), mat.getFloat(0, 1), mat.getFloat(0, 2),
							mat.getFloat(1, 0), mat.getFloat(1, 1), mat.getFloat(1, 2),
							mat.getFloat(2, 0), mat.getFloat(2, 1), mat.getFloat(2, 2) );
			mat.setUnsafe(wasUnsafe);
			return this;
		} else {
			throw new IllegalArgumentException("matrix must be at least 3x3.");
		}
	}
	
	
	
	
	/**
	 * Sets the component of this quaternion from the given matrix
	 * @param mat the (rotation) matrix
	 * @return this quaternion for chaining
	 * */
	public Quaternionf setFromMatrix(Matrix4f mat) {
		return setFromMatrix(mat.getData()[0][0], mat.getData()[0][1], mat.getData()[0][2],
							 mat.getData()[1][0], mat.getData()[1][1], mat.getData()[1][2],
							 mat.getData()[2][0], mat.getData()[2][1], mat.getData()[2][2] );
	}
	
	
	
	
	/**
	 * Sets the component of this quaternion from the given matrix
	 * @return this quaternion for chaining
	 * */
	public Quaternionf setFromMatrix(float m00, float m01, float m02,
									 float m10, float m11, float m12,
									 float m20, float m21, float m22) {
		
		float trace = m00 + m11 + m22;
	
		if(trace >= 0.0) {
			float s = (float) Math.sqrt(trace + 1f);
			this.w = s * 0.5f;
			s = 0.5f / s;
			this.x = (m21 - m12) * s;
			this.y = (m02 - m20) * s;
			this.z = (m10 - m01) * s;
			
		} else {
			
			float max = Math.max(Math.max(m00, m11), m22);
			
			if(max == m00) {
				float s = (float) Math.sqrt(m00 - (m11+m22) + 1f);
				this.x = s * 0.5f;
				s = 0.5f / s;
				this.y = (m01 + m10) * s;
				this.z = (m20 + m02) * s;
				this.w = (m21 - m12) * s;
				
			} else if(max == m11) {
				float s = (float) Math.sqrt(m11 - (m22+m00) + 1f);
				this.y = s * 0.5f;
				s = 0.5f / s;
				this.z = (m12 + m21) * s;
				this.x = (m01 + m10) * s;
				this.w = (m02 - m20) * s;
				
			} else if(max == m22) {
				float s = (float) Math.sqrt(m22 - (m00+m11) + 1f);
				this.z = s * 0.5f;
				s = 0.5f / s;
				this.x = (m20 + m02) * s;
				this.y = (m12 + m21) * s;
				this.w = (m10 - m01) * s;
			}
			
		}
		
		return this;
	} 
	
	
	
	
	@Override
	public Quaternionf setFromEulerDeg(IVector3 angles) {
		return this.setFromEulerDeg(angles.getFloatX(), angles.getFloatY(), angles.getFloatZ());
	}
	
	
	@Override
	public Quaternionf setFromEulerRad(IVector3 angles) {
		return this.setFromEulerRad(angles.getFloatX(), angles.getFloatY(), angles.getFloatZ());
	}
	
	
	/**
	 * Sets this quaternion from the given euler angles
	 * @param yaw	the yaw angle in degrees
	 * @param pitch	the pitch angle in degrees
	 * @param roll	the roll angle in degrees
	 * @return this quaternion for chaining
	 * */
	public Quaternionf setFromEulerDeg(float yaw, float pitch , float roll) {
		return this.setFromEulerRad((float)Math.toRadians(yaw), (float)Math.toRadians(pitch), (float)Math.toRadians(roll));
	}

	
	/**
	 * Sets this quaternion from the given euler angles
	 * @param yaw	the yaw angle in radians
	 * @param pitch	the pitch angle in radians
	 * @param roll	the roll angle in radians
	 * @return this quaternion for chaining
	 * */
	public Quaternionf setFromEulerRad(float yaw, float pitch , float roll) {
		
		final float hr = roll * 0.5f;
		final float shr = (float) Math.sin(hr);
		final float chr = (float) Math.cos(hr);

		final float hp = pitch * 0.5f;
		final float shp = (float) Math.sin(hp);
		final float chp = (float) Math.cos(hp);
		
		final float hy = yaw * 0.5f;
		final float shy = (float) Math.sin(hy);
		final float chy = (float) Math.cos(hy);
		
		final float chy_shp = chy * shp;
		final float shy_chp = shy * chp;
		final float chy_chp = chy * chp;
		final float shy_shp = shy * shp;

		this.x = (chy_shp * chr) + (shy_chp * shr);
		this.y = (shy_chp * chr) - (chy_shp * shr);
		this.z = (chy_chp * shr) - (shy_shp * chr);
		this.w = (chy_chp * chr) + (shy_shp * shr);
		
		return this;
	}
	
	
	
	
	@Override
	public Vector3f getXAxis() {
		return (Vector3f) getXAxis(null);
	}
	
	
	@Override
	public IVector3 getXAxis(IVector3 dest) {
		if(dest == null) {
			dest = new Vector3f();
		}
		
		final float ty = 2f * y;
		final float tz = 2f * z;
		
		final float twy = ty * w;
		final float twz = tz * w;
		
		final float txy = ty * x;
		final float txz = tz * x;
		final float tyy = ty * y;
		final float tzz = tz * z;
	
		final float ax = 1f - (tyy+tzz);
		final float ay = txy + twz;
		final float az = txz - twy;
		
		dest.set(ax, ay, az);
		return dest;
	}
	
	
	
	
	@Override
	public Vector3f getYAxis() {
		return (Vector3f) getYAxis(null);
	}
	
	
	@Override
	public IVector3 getYAxis(IVector3 dest) {
		if(dest == null) {
			dest = new Vector3f();
		}
		
		final float tx = 2f * x;
		final float ty = 2f * y;
		final float tz = 2f * z;
		
		final float twx = tx * w;
		final float twz = tz * w;
		
		final float txx = tx * x;
		final float txy = ty * x;
		final float tyz = tz * y;
		final float tzz = tz * z;
	
		final float ax = txy - twz;
		final float ay = 1f - (txx+tzz);
		final float az = tyz + twx;
		
		dest.set(ax, ay, az);
		return dest;
	}
	
	
	
	
	@Override
	public Vector3f getZAxis() {
		return (Vector3f) getYAxis(null);
	}
	
	@Override
	public IVector3 getZAxis(IVector3 dest) {
		if(dest == null) {
			dest = new Vector3f();
		}
		
		final float tx = 2f * x;
		final float ty = 2f * y;
		final float tz = 2f * z;
		
		final float twx = tx * w;
		final float twy = ty * w;
		
		final float txx = tx * x;
		final float txz = tz * x;
		final float tyy = ty * y;
		final float tyz = tz * y;
	
		final float ax = txz+twy;
		final float ay = tyz-twx;
		final float az = 1f - (txx+tyy);
		
		dest.set(ax, ay, az);
		return dest;
	}
	
	
	
	
	@Override
	public int getGimbalPole() {
		final float t = y*x + z*w;
		return t > 0.499f ? 1 : (t < -0.499f ? -1 : 0);
	}
	
	
	
	
	/**
	 * Gets the pitch angle. This quaternion must be normalized.
	 * @return the pitch angle in degreees
	 * */
	public float getRotationXDeg() {
		return (float) Math.toDegrees(this.getRotationXRad());
	}
	
	
	/**
	 * Gets the pitch angle. This quaternion must be normalized.
	 * @return the pitch angle in radians
	 * */
	public float getRotationXRad() {
		final int pole = getGimbalPole();
		if(pole == 0) {
			return (float) Math.asin(MathUtils.clamp(2f*(w*x-z*y), -1, 1));
		} else {
			return (float) (pole * Math.PI * 0.5f);
		}
	}
	
	
	
	
	/**
	 * Gets the yaw angle. This quaternion must be normalized.
	 * @return the yaw angle in degreees
	 * */
	public float getRotationYDeg() {
		return (float) Math.toDegrees(this.getRotationYRad());
	}
	
	
	/**
	 * Gets the yaw angle. This quaternion must be normalized.
	 * @return the yaw angle in radians
	 * */
	public float getRotationYRad() {
		final int pole = getGimbalPole();
		if(pole == 0) {
			return (float) Math.atan2(2f*(y*w+x*z), 1f-2.0*(x*x+y*y));
		} else {
			return 0;
		}
	}
	
	
	
	
	/**
	 * Gets the roll angle. This quaternion must be normalized.
	 * @return the roll angle in degreees
	 * */
	public float getRotationZDeg() {
		return (float) Math.toDegrees(this.getRotationZRad());
	}
	
	
	/**
	 * Gets the roll angle. This quaternion must be normalized.
	 * @return the roll angle in radians
	 * */
	public float getRotationZRad() {
		final int pole = getGimbalPole();
		if(pole == 0) {
			return (float) Math.atan2(2f*(w*z+y*x), 1f-2f*(x*x+z*z));
		} else {
			return (float) (pole * 2f * Math.atan2(y, w));
		}
	}
	
	
	@Override
	public Vector3f getRotationDeg() {
		return new Vector3f(this.getRotationXDeg(), this.getRotationYDeg(), this.getRotationZDeg());
	}
	
	
	@Override
	public Vector3f getRotationRad() {
		return new Vector3f(this.getRotationXRad(), this.getRotationYRad(), this.getRotationZRad());
	}
	
	
	
	
	@Override
	public Matrix4f toRotationMatrix() {
		return toRotationMatrix(null);
	}
	
	
	/**
	 * Sets the given matrix to represent this quaternion. This quaternion must be normalized.
	 * @param dest the destination matrix
	 * @return the destination matrix representing this quaternion.
	 * */
	public Matrix4f toRotationMatrix(Matrix4f dest) {
		if(dest == null) {
			dest = new Matrix4f();
		}

		final float xx = x * x;
		final float xy = x * y;
		final float xz = x * z;
		final float xw = x * w;
		final float yy = y * y;
		final float yz = y * z;
		final float yw = y * w;
		final float zz = z * z;
		final float zw = z * w;

		dest.getData()[0][0] = 1f - 2f*(yy+zz);
		dest.getData()[1][0] = 2f * (xy-zw);
		dest.getData()[2][0] = 2f * (xz + yw);
		dest.getData()[3][0] = 0;

		dest.getData()[0][1] = 2f * (xy + zw);
		dest.getData()[1][1] = 1f - 2f*(xx+zz);
		dest.getData()[2][1] = 2f * (yz - xw);
		dest.getData()[3][1] = 0;

		dest.getData()[0][2] = 2f * (xz - yw);
		dest.getData()[1][2] = 2f * (yz + zw);
		dest.getData()[2][2] = 1f - 2f*(xx+yy);
		dest.getData()[3][2] = 0;

		dest.getData()[0][3] = 0;
		dest.getData()[1][3] = 0;
		dest.getData()[2][3] = 0;
		dest.getData()[3][3] = 1;
		
		return dest;
	}
	
}

