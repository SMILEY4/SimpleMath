package com.ruegnerlukas.simplemath.geometry.shapes.polygon;

import java.util.ArrayList;
import java.util.List;

import com.ruegnerlukas.simplemath.geometry.Intersector;
import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.geometry.shapes.circle.ICircle;
import com.ruegnerlukas.simplemath.geometry.shapes.line.ILine;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.IRectangle;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.Rectanglef;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2f;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;


public class Polygonf implements IPolygon {

	
	

	public float[] vertices;
	
	public String name;
	
	
	
	
	/**
	 * Creates a polygon with 1 vertex at (0,0)
	 * */
	public Polygonf() {
		this(1);
	}

	
	/**
	 * Creates a polygon with n-vertices vertex at (0,0)
	 * */
	public Polygonf(int n) {
		if(n <= 2) {
			throw new IllegalArgumentException("Number of vertices must be > 2");
		} else {
			this.vertices = new float[n*2];
		}
	}
	
	
	/**
	 * Creates a polygon with the given vertices
	 * */
	public Polygonf(float... vertices) {
		if(vertices == null || vertices.length < 3*2) {
			throw new IllegalArgumentException("Number of values must be >= 6");
		} else {
			this.vertices = vertices;
		}
	}
	
	
	/**
	 * Creates a polygon with the given vertices
	 * */
	public Polygonf(IVector2... vertices) {
		if(vertices == null || vertices.length < 3) {
			throw new IllegalArgumentException("Number of vertices must be >= 3");
		} else {
			this.vertices = new float[vertices.length*2];
			for(int i=0, j=0, n=vertices.length; i<n; i++) {
				this.vertices[j++] = vertices[i].getFloatX();
				this.vertices[j++] = vertices[i].getFloatY();
			}
		}
	}
	
	
	/**
	 * Creates a polygon with the given vertices
	 * */
	public Polygonf(List<IVector2> vertices) {
		if(vertices == null || vertices.size() < 3) {
			throw new IllegalArgumentException("Number of vertices must be >= 3");
		} else {
			this.vertices = new float[vertices.size()*2];
			for(int i=0, j=0, n=vertices.size(); i<n; i++) {
				this.vertices[j++] = vertices.get(i).getFloatX();
				this.vertices[j++] = vertices.get(i).getFloatY();
			}
		}
	}
	
	
	/**
	 * Creates a polygon from the given shape
	 * */
	public Polygonf(IShape shape) {
		int i=0;
		
		if(shape instanceof IRectangle) {
			IRectangle rect = (IRectangle) shape;
			vertices = new float[8];
			vertices[i++] = rect.getXFloat();
			vertices[i++] = rect.getYFloat();
			vertices[i++] = rect.getXFloat()+rect.getWidthFloat();
			vertices[i++] = rect.getYFloat();
			vertices[i++] = rect.getXFloat()+rect.getWidthFloat();
			vertices[i++] = rect.getYFloat()+rect.getHeightFloat();
			vertices[i++] = rect.getXFloat();
			vertices[i++] = rect.getYFloat()+rect.getHeightFloat();

		} else if(shape instanceof IPolygon) {
			IPolygon poly = (IPolygon) shape;
			vertices = new float[poly.getVerticesGen().length];
			for(int j=0,n=vertices.length; j<n; j+=2) {
				vertices[j] = poly.getVerticesGen()[j].floatValue();
				vertices[j+1] = poly.getVerticesGen()[j+1].floatValue();
			}
			
		} else {
			// TODO other shapes
			throw new IllegalArgumentException("Unsupported shape: " + shape);
		}
	}
	
	
	
	
	@Override
	public int getMinXInt() {
		return (int) getMinXFloat();
	}




	@Override
	public float getMinXFloat() {
		float min = vertices[0];
		for(int i=0; i<vertices.length; i+=2) {
			min = Math.min(min, vertices[i]);
		}
		return min;
	}




	@Override
	public double getMinXDouble() {
		return (double) getMinXFloat();
	}




	@Override
	public int getMinYInt() {
		return (int) getMinYFloat();
	}




	@Override
	public float getMinYFloat() {
		float min = vertices[1];
		for(int i=0; i<vertices.length; i+=2) {
			min = Math.min(min, vertices[i]);
		}
		return min;
	}




	@Override
	public double getMinYDouble() {
		return (double) getMinYFloat();
	}




	@Override
	public int getMaxXInt() {
		return (int) getMaxXFloat();
	}




	@Override
	public float getMaxXFloat() {
		float max = vertices[0];
		for(int i=0; i<vertices.length; i+=2) {
			max = Math.max(max, vertices[i]);
		}
		return max;
	}




	@Override
	public double getMaxXDouble() {
		return (double) getMaxXFloat();
	}




	@Override
	public int getMaxYInt() {
		return (int) getMaxYFloat();
	}




	@Override
	public float getMaxYFloat() {
		float max = vertices[1];
		for(int i=0; i<vertices.length; i+=2) {
			max = Math.max(max, vertices[i]);
		}
		return max;
	}




	@Override
	public double getMaxYDouble() {
		return (double) getMaxYFloat();
	}




	@Override
	public IVector2 getMin() {
		return getMin(null);
	}




	@Override
	public IVector2 getMin(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getMinXFloat(), getMinYFloat());
	}




	@Override
	public IVector2 getMax() {
		return getMax(null);
	}




	@Override
	public IVector2 getMax(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getMaxXFloat(), getMaxYFloat());
	}




	@Override
	public IRectangle getBounds() {
		return getBounds(null);
	}




	@Override
	public IRectangle getBounds(IRectangle dest) {
		if(dest == null) {
			dest = new Rectanglef();
		}
		return dest.setPosition(getMinXFloat(), getMinYFloat()).setMax(getMaxXFloat(), getMaxYFloat());
	}




	@Override
	public IVector4 getBoundsVec() {
		return getBoundsVec(null);
	}




	@Override
	public IVector4 getBoundsVec(IVector4 dest) {
		if(dest == null) {
			dest = new Vector4f();
		}
		return dest.set(getMinXFloat(), getMinYFloat(), getMaxXFloat(), getMaxYFloat());
	}




	@Override
	public int getRadiusInt() {
		return (int) getRadiusFloat();
	}




	@Override
	public float getRadiusFloat() {
		final float minX = getMinXFloat();
		final float minY = getMinYFloat();
		final float maxX = getMaxXFloat();
		final float maxY = getMaxYFloat();
		return (float) (Math.sqrt( (minX-maxX)*(minX-maxX) + (minY-maxY)*(minY-maxY) ) / 2f);
	}




	@Override
	public double getRadiusDouble() {
		return (double) getRadiusFloat();
	}




	@Override
	public boolean intersects(IShape other) {
		
		if(other instanceof IRectangle) {
			IRectangle rect = (IRectangle) other;
			return Intersector.intersectsRectanglePolygon(rect.getXFloat(), rect.getYFloat(), rect.getWidthFloat(), rect.getHeightFloat(), vertices, null);
		
		} else if(other instanceof ICircle) {
			ICircle circle = (ICircle) other;
			return Intersector.intersectsCirclePolygon(circle.getCenterXFloat(), circle.getCenterYFloat(), circle.getRadiusFloat(), vertices);
			
		} else if(other instanceof ILine) {
			ILine line = (ILine) other;
			return Intersector.intersectsLinePolygon(line.getStartXFloat(), line.getStartYFloat(), line.getEndXFloat(), line.getEndYFloat(), vertices);
			
		} else if(other instanceof Polygonf) {
			Polygonf poly = (Polygonf) other;
			return Intersector.intersectsPolygonPolygon(poly.getVertices(), vertices);
			
		} else if(other instanceof IPolygon) {
			IPolygon poly = (IPolygon) other;
			float[] polyVert = new float[poly.getVerticesGen().length];
			for(int i=0, n=polyVert.length; i<n; i++) {
				polyVert[i] = poly.getVerticesGen()[i].floatValue();
			}
			return Intersector.intersectsPolygonPolygon(polyVert, vertices);
			
		} else {
			// TODO other shapes
		}
		return false;
	}




	@Override
	public Polygonf copy() {
		return new Polygonf(this);
	}
	
	
	
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<vertices.length; ) {
			sb.append('(').append(vertices[i++]).append(',').append(vertices[i++]).append(')');
			if(i<vertices.length-1) {
				sb.append(", ");
			}
		}
		return name + ": Polygonf." + this.hashCode() + "( " + sb.toString() + " )";
	}




	@Override
	public int getNumberVertices() {
		return this.vertices.length/2;
	}
	
	
	
	
	@Override
	public int getXInt(int index) {
		return (int) getXFloat(index);
	}




	@Override
	public int getYInt(int index) {
		return (int) getYFloat(index);
	}




	@Override
	public float getXFloat(int index) {
		return vertices[index*2];
	}




	@Override
	public float getYFloat(int index) {
		return vertices[index*2+1];
	}




	@Override
	public double getXDouble(int index) {
		return (double) getXFloat(index);
	}




	@Override
	public double getYDouble(int index) {
		return (double) getYFloat(index);
	}




	@Override
	public IVector2 getVertex(int index) {
		return getVertex(index, null);
	}




	@Override
	public IVector2 getVertex(int index, IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getXFloat(index), getYFloat(index));
	}




	@Override
	public Number getCenterXGen() {
		return getCenterX();
	}
	
	
	
	
	/**
	 * @return the x-position of this center
	 * */
	public float getCenterX() {
		float sum = 0;
		for(int i=0; i<vertices.length; i+=2) {
			sum += vertices[i];
		}
		return sum / (vertices.length/2);
	}

	


	@Override
	public Number getCenterYGen() {
		return getCenterY();
	}
	
	
	
	
	/**
	 * @return the y-position of this center
	 * */
	public float getCenterY() {
		float sum = 0;
		for(int i=1; i<vertices.length; i+=2) {
			sum += vertices[i];
		}
		return sum / (vertices.length/2);
	}




	@Override
	public IVector2 getCenter() {
		return getCenter(null);
	}




	@Override
	public IVector2 getCenter(IVector2 dest) {
		if(dest == null) {
			dest = new Vector2f();
		}
		return dest.set(getCenterX(), getCenterY());
	}




	@Override
	public Number[] getVerticesGen() {
		return getVerticesGen(null);
	}
	
	
	
	
	/**
	 * @return the vertices of this polygon as an array {x0,y0,x1,...,xn,yn}
	 * */
	public float[] getVertices() {
		return vertices;
	}




	@Override
	public Number[] getVerticesGen(Number[] dest) {
		if(dest == null || dest.length != vertices.length) {
			dest = new Number[vertices.length];
		}
		for(int i=0; i<dest.length; i++) {
			dest[i] = vertices[i];
		}
		return dest;
	}
	
	
	
	
	/**
	 * @param the destination array for the vertex data {x0,y0,x1,...,xn,yn} or null
	 * @return the destination array with the vertex data
	 * */
	public float[] getVertices(float[] dest) {
		if(dest == null || dest.length != vertices.length) {
			dest = new float[vertices.length];
		}
		for(int i=0; i<dest.length; i++) {
			dest[i] = vertices[i];
		}
		return dest;
	}




	@Override
	public IVector2[] getVerticesVec() {
		return getVerticesVec(null);
	}




	@Override
	public IVector2[] getVerticesVec(IVector2[] dest) {
		if(dest == null || dest.length*2 != vertices.length) {
			dest = new IVector2[vertices.length/2];
		}
		for(int i=0,j=0; i<vertices.length; ) {
			dest[j++] = new Vector2f(vertices[i++], vertices[i++]);
		}
		return dest;
	}




	@Override
	public List<IVector2> getVerticesVecList() {
		return getVerticesVecList(null);
	}




	@Override
	public List<IVector2> getVerticesVecList(List<IVector2> dest) {
		if(dest == null) {
			dest = new ArrayList<IVector2>(vertices.length/2);
		}
		for(int i=0; i<vertices.length; ) {
			dest.add(new Vector2f(vertices[i++], vertices[i++]));
		}
		return dest;
	}




	@Override
	public Polygonf setVertexX(Number x, int index) {
		return this.setVertexX(x.floatValue(), index);
	}
	
	
	
	
	/**
	 * Sets the x position of the vertex at the given index
	 * @param x the new x position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public Polygonf setVertexX(float x, int index) {
		vertices[index*2] = x;
		return this;
	}




	@Override
	public Polygonf setVertexY(Number y, int index) {
		return this.setVertexY(y.floatValue(), index);

	}
	
	
	
	
	/**
	 * Sets the y position of the vertex at the given index
	 * @param y the new y position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public Polygonf setVertexY(float y, int index) {
		vertices[index*2+1] = y;
		return this;
	}




	@Override
	public Polygonf setVertex(Number x, Number y, int index) {
		return this.setVertex(x.floatValue(), y.floatValue(), index);
	}
	
	
	
	
	/**
	 * Sets the position of the vertex at the given index
	 * @param x the new x position
	 * @param y the new y position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public Polygonf setVertex(float x, float y, int index) {
		vertices[index*2] = x;
		vertices[index*2+1] = y;
		return this;
	}




	@Override
	public Polygonf setVertex(IVector2 v, int index) {
		return this.setVertex(v.getFloatX(), v.getFloatY(), index);
	}




	@Override
	public Polygonf set(Number[] vertices) {
		if(vertices.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid size of the input array: " + vertices.length);
		}
		if(vertices.length != this.vertices.length) {
			this.vertices = new float[vertices.length];
		}
		for(int i=0; i<vertices.length; i++) {
			this.vertices[i] = vertices[i].floatValue();
		}
		return this;
	}
	
	
	
	
	/**
	 * Sets the vertices of this polygon.
	 * @param vertices the new vertices of this polyon as an array {x0,y0,x1,...,xn,yn}
	 * @return this polygon for chaining
	 * */
	public Polygonf set(float[] vertices) {
		if(vertices.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid size of the input array: " + vertices.length);
		}
		this.vertices = vertices;
		return this;
	}




	@Override
	public Polygonf set(IVector2[] vertices) {
		if(vertices.length != this.vertices.length*2) {
			this.vertices = new float[vertices.length];
		}
		for(int i=0,j=0; i<this.vertices.length; ) {
			this.vertices[i++] = vertices[j].getFloatX();
			this.vertices[i++] = vertices[j].getFloatY();
			j++;
		}
		return this;
	}




	@Override
	public Polygonf set(List<IVector2> vertices) {
		if(vertices.size() != this.vertices.length*2) {
			this.vertices = new float[vertices.size()];
		}
		for(int i=0,j=0; i<this.vertices.length; ) {
			this.vertices[i++] = vertices.get(j).getFloatX();
			this.vertices[i++] = vertices.get(j).getFloatY();
			j++;
		}
		return this;
	}




	@Override
	public Polygonf translate(Number dx, Number dy) {
		return this.translate(dx.floatValue(), dy.floatValue());
	}

	
	
	
	/**
	 * Moves this polygon by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this polygon for chaining
	 * */
	public Polygonf translate(float dx, float dy) {
		for(int i=0; i<vertices.length; ) {
			vertices[i++] += dx;
			vertices[i++] += dy;
		}
		return this;
	}

	


	@Override
	public Polygonf translate(IVector2 dir) {
		return this.translate(dir.getFloatX(), dir.getFloatY());
	}




	@Override
	public Polygonf scale(Number s, Number ox, Number oy) {
		return this.scale(s.floatValue(), ox.floatValue(), oy.floatValue());
	}
	
	
	
	
	/**
	 * Scales this polygon. The position of the given origin does not change.
	 * @param s the scaling factor
	 * @param ox the x position of the origin
	 * @param oy the y position of the origin
	 * @return this polygon for chaining
	 * */
	public Polygonf scale(float s, float ox, float oy) {
		return this.scale(s, s, ox, oy);
	}




	@Override
	public Polygonf scale(Number sx, Number sy, Number ox, Number oy) {
		return this.scale(sx.floatValue(), sy.floatValue(), ox.floatValue(), oy.floatValue());
	}
	
	
	
	
	private final Vector2f tmpVec = new Vector2f();
	
	/**
	 * Scales this polygon. The position of the given origin does not change.
	 * @param x the scaling in x direction
	 * @param y the scaling in y direction
	 * @param ox the x position of the origin
	 * @param oy the y position of the origin
	 * @return this polygon for chaining
	 * */
	public Polygonf scale(float sx, float sy, float ox, float oy) {
		for(int i=0; i<vertices.length; ) {
			float x = vertices[i++];
			float y = vertices[i++];
			tmpVec.set(x, y).sub(ox, oy).mul(sx, sy);
			vertices[i-2] = tmpVec.x;
			vertices[i-1] = tmpVec.y;
		}
		
		return this;
	}




	@Override
	public Polygonf scale(IVector2 scaling, Number ox, Number oy) {
		return this.scale(scaling.getFloatX(),  scaling.getFloatY(), ox.floatValue(), oy.floatValue());
	}
	
	
	
	
	/**
	 * Scales this polygon. The position of the given origin does not change.
	 * @param scaling the vector representing the scaling in x and y direction
	 * @param ox the x position of the origin
	 * @param oy the y position of the origin
	 * @return this polygon for chaining
	 * */
	public Polygonf scale(IVector2 scaling, float ox, float oy) {
		return this.scale(scaling.getFloatX(),  scaling.getFloatY(), ox, oy);
	}

	
	
	
	private boolean turnTest(float x1, float y1, float x2, float y2, float x3, float y3) {
		return (x2-x1)*(y3-y2) - (x3-x2)*(y2-y1) > 0;
	}
	
	

	
	@Override
	public boolean isConvex() {
		
		final int n = this.getNumberVertices();
		if(n == 3) {
			return true;
		}
		
		float prevX = this.getXFloat(n-2);
		float prevY = this.getYFloat(n-2);

		float currX = this.getXFloat(n-1);
		float currY = this.getYFloat(n-1);
		
		float nextX = this.getXFloat(0);
		float nextY = this.getYFloat(0);
		
		boolean isCCW = turnTest(prevX, prevY, currX, currY, nextX, nextY);
		
		for(int i=1; i<n; i++) {
			
			prevX = currX;
			prevY = currY;
			currX = nextX;
			currY = nextY;
			nextX = this.getXFloat(i);
			nextY = this.getYFloat(i);

			if(turnTest(prevX, prevY, currX, currY, nextX, nextY) != isCCW) {
				return false;
			}
			
		}
		
		return true;
	}
	
	
	
	
	private int orientation(float px, float py, float qx, float qy, float rx, float ry) {
		float val = (qy-py)*(rx-qx) - (qx-px)*(ry-qy);
		if(val == 0) {
			return 0;
		}
		return (val > 0) ? 1 : 2;
	}

	
	@Override
	public Polygonf makeConvex() {
		
		if(isConvex()) {
			return this;
		}
		
		final int n = this.getNumberVertices();
		if(n < 3) {
			return this;
		}

		
		int l = 0;
		for(int i=1; i<n; i++) {
			if(vertices[i] < vertices[l]) {
				l = i;
			}
		}
		
		
		int p = l;
		int q;
		
		ArrayList<Float> hullX = new ArrayList<Float>();
		ArrayList<Float> hullY = new ArrayList<Float>();

		do {
			
			hullX.add(getXFloat(p));
			hullY.add(getYFloat(p));

			q = (p+1) % n;
			
			for(int i=0; i<n; i++) {
				if(orientation(getXFloat(p), getYFloat(p), getXFloat(i), getYFloat(i), getXFloat(q), getYFloat(q)) == 2) {
					q = i;
				}
			}
			
			p = q;
			
		} while(p != l);
		
		
		float[] verticesConvex = new float[hullX.size()*2];
		for(int i=0, j=0; i<hullX.size(); i++) {
			verticesConvex[j++] = hullX.get(i);
			verticesConvex[j++] = hullY.get(i);
		}
		this.vertices = verticesConvex;
		
		return this;
	}


	
	
	@Override
	public boolean isCCW() {
		
		final int n = this.getNumberVertices();
		
		float minY = this.getYFloat(0);
		int minIndex = 0;
		
		for(int i=1; i<n; i++) {
			final float y = this.getYFloat(i);
			if(y < minY) {
				minY = y;
				minIndex = i;
			}
		}
		

		final int indexPrev = (minIndex - 1 + n) % n;
		final int indexNext = (minIndex + 1) % n;

		return this.turnTest(getXFloat(indexPrev), getYFloat(indexPrev), getXFloat(minIndex), getYFloat(minIndex), getXFloat(indexNext), getYFloat(indexNext));
	}


	
	
	@Override
	public Polygonf makeCCW() {

		if(!isCCW()) {
			
			float[] verticesCCW = new float[this.vertices.length];
			
			for(int i=this.getNumberVertices()-1, j=0; i>=0; i--) {
				float x = getXFloat(i);
				float y = getYFloat(i);
				verticesCCW[j++] = x;
				verticesCCW[j++] = y;
			}
			
			this.vertices = verticesCCW;
			
		}
		
		return this;
	}


	
	
	@Override
	public List<IPolygon> triangulate() {
		List<IPolygon> triangles = new ArrayList<IPolygon>();
		triangulate(triangles);
		return triangles;
	}

	
	
	
	@Override
	public void triangulate(List<IPolygon> trianglesOut) {
		
		final int n = this.getNumberVertices();
		if(n < 3) {
			return;
		}
		if(n == 3) {
			trianglesOut.add(this.copy());
		}
		
		if(this.isConvex()) {
			
			float ox = getXFloat(0);
			float oy = getYFloat(0);

			float ax = getXFloat(1);
			float ay = getYFloat(1);

			float bx = getXFloat(2);
			float by = getYFloat(2);
			
			for(int i=3; i<n; i++) {
				Polygonf tri = new Polygonf(ox, oy, ax, ay, bx, by);
				trianglesOut.add(tri);
				ax = bx;
				ay = by;
				bx = getXFloat(i);
				by = getYFloat(i);
			}
			
			Polygonf tri = new Polygonf(ox, oy, ax, ay, bx, by);
			trianglesOut.add(tri);
			
			
		} else {
			
			// ear-clipping-algorithm
			Polygonf poly = isCCW() ? this : this.copy().makeCCW();
			
			List<IVector2> listVertices = poly.getVerticesVecList();
			
			int p = 0;
			while(listVertices.size() > 3) {
				
				IVector2 v0 = getVertexWrapped(listVertices, p-1);
				IVector2 v1 = getVertexWrapped(listVertices, p  );
				IVector2 v2 = getVertexWrapped(listVertices, p+1);

				if( isEar(listVertices, v0, v1, v2) ) {
					trianglesOut.add(new Polygonf(v0.getFloatX(), v0.getFloatY(), v1.getFloatX(), v1.getFloatY(), v2.getFloatX(), v2.getFloatY()));
					listVertices.remove(p);
					p = 0;
				} else {
					p++;
				}
				
			}
			
			trianglesOut.add(new Polygonf(listVertices.get(0), listVertices.get(1), listVertices.get(2)));
		}
		
	}
	
	
	private IVector2 getVertexWrapped(List<IVector2> vertices, int index) {
		if(index >= vertices.size()) {
			return vertices.get(index%vertices.size());
		}
		if(index < 0) {
			return getVertexWrapped(vertices, index+vertices.size());
		}
		return vertices.get(index);
	}
	
	
	private boolean isEar(List<IVector2> vertices, IVector2 a, IVector2 b, IVector2 c) {
		final float x1 = a.getFloatX();
		final float y1 = a.getFloatY();
		final float x2 = b.getFloatX();
		final float y2 = b.getFloatY();
		final float x3 = c.getFloatX();
		final float y3 = c.getFloatY();
		
		float l = (x2-x1)*(y3-y2) - (x3-x2)*(y2-y1);

		if(l > 0) {
			
			boolean inside = false;
			for(int i=0; i<vertices.size(); i++) {
				IVector2 p = vertices.get(i);
				if(p == a || p == b || p == c) {
					continue;
				}
				if(Intersector.pointInTriangle(x1, y1, x2, y2, x3, y3, p.getFloatX(), p.getFloatY())) {
					inside = true;
					break;
				}
			}
			
			return !inside;
			
		}
		
		return false;
	}
	
	
	
	
	@Override
	public Polygonf setName(String name) {
		this.name = name;
		return this;
	}

	
	

	@Override
	public String getName() {
		return this.name;
	}

	
	

	@Override
	public Vector2f getRandomPoint() {
		for(int i=0; i<512; i++) {
			float x = getMinXFloat() + (float)((getMaxXFloat()-getMinXFloat())*Math.random());
			float y = getMinYFloat() + (float)((getMaxYFloat()-getMinYFloat())*Math.random());
			if(Intersector.pointInPolygon(vertices, x, y)) {
				return new Vector2f(x, y);
			}
		}
		return null;
	}

	
	

	@Override
	public Polygonf getRandomPoint(IVector2 dst) {
		for(int i=0; i<512; i++) {
			float x = getMinXFloat() + (float)((getMaxXFloat()-getMinXFloat())*Math.random());
			float y = getMinYFloat() + (float)((getMaxYFloat()-getMinYFloat())*Math.random());
			if(Intersector.pointInPolygon(vertices, x, y)) {
				dst.set(x, y);
				break;
			}
		}
		return this;
	}

	
	
}
















