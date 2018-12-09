package com.ruegnerlukas.simplemath.geometry.shapes.polygon;

import java.util.ArrayList;
import java.util.List;

import com.ruegnerlukas.simplemath.geometry.IntersectorInt;
import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.geometry.shapes.circle.ICircle;
import com.ruegnerlukas.simplemath.geometry.shapes.line.ILine;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.IRectangle;
import com.ruegnerlukas.simplemath.geometry.shapes.rectangle.Rectanglef;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec2.Vector2i;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3i;
import com.ruegnerlukas.simplemath.vectors.vec4.IVector4;
import com.ruegnerlukas.simplemath.vectors.vec4.Vector4f;


public class Polygoni implements IPolygon {


	public int[] vertices;
	
	public String name;
	
	
	
	
	/**
	 * Creates a polygon with 1 vertex at (0,0)
	 * */
	public Polygoni() {
		this(1);
	}

	
	/**
	 * Creates a polygon with n-vertices vertex at (0,0)
	 * */
	public Polygoni(int n) {
		if(n <= 2) {
			throw new IllegalArgumentException("Number of vertices must be > 2");
		} else {
			this.vertices = new int[n*2];
		}
	}
	
	
	/**
	 * Creates a polygon with the given vertices
	 * */
	public Polygoni(int... vertices) {
		if(vertices == null || vertices.length < 3*2) {
			throw new IllegalArgumentException("Number of values must be >= 6");
		} else {
			this.vertices = vertices;
		}
	}
	
	
	/**
	 * Creates a polygon with the given vertices
	 * */
	public Polygoni(IVector2... vertices) {
		if(vertices == null || vertices.length < 3) {
			throw new IllegalArgumentException("Number of vertices must be >= 3");
		} else {
			this.vertices = new int[vertices.length*2];
			for(int i=0, j=0, n=vertices.length; i<n; i++) {
				this.vertices[j++] = vertices[i].getIntX();
				this.vertices[j++] = vertices[i].getIntY();
			}
		}
	}
	
	
	/**
	 * Creates a polygon with the given vertices
	 * */
	public Polygoni(List<IVector2> vertices) {
		if(vertices == null || vertices.size() < 3) {
			throw new IllegalArgumentException("Number of vertices must be >= 3");
		} else {
			this.vertices = new int[vertices.size()*2];
			for(int i=0, j=0, n=vertices.size(); i<n; i++) {
				this.vertices[j++] = vertices.get(i).getIntX();
				this.vertices[j++] = vertices.get(i).getIntY();
			}
		}
	}
	
	
	/**
	 * Creates a polygon from the given shape
	 * */
	public Polygoni(IShape shape) {
		int i=0;
		
		if(shape instanceof IRectangle) {
			IRectangle rect = (IRectangle) shape;
			vertices = new int[8];
			vertices[i++] = rect.getXInt();
			vertices[i++] = rect.getYInt();
			vertices[i++] = rect.getXInt()+rect.getWidthInt();
			vertices[i++] = rect.getYInt();
			vertices[i++] = rect.getXInt()+rect.getWidthInt();
			vertices[i++] = rect.getYInt()+rect.getHeightInt();
			vertices[i++] = rect.getXInt();
			vertices[i++] = rect.getYInt()+rect.getHeightInt();

		} else if(shape instanceof IPolygon) {
			IPolygon poly = (IPolygon) shape;
			vertices = new int[poly.getVerticesGen().length];
			for(int j=0,n=vertices.length; j<n; j+=2) {
				vertices[j] = poly.getVerticesGen()[j].intValue();
				vertices[j+1] = poly.getVerticesGen()[j+1].intValue();
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
		int min = vertices[0];
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
		int min = vertices[1];
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
		int max = vertices[0];
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
		int max = vertices[1];
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
			dest = new Vector2i();
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
			dest = new Vector2i();
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
			return IntersectorInt.intersectsRectanglePolygon(rect.getXInt(), rect.getYInt(), rect.getWidthInt(), rect.getHeightInt(), vertices, null);
		
		} else if(other instanceof ICircle) {
			ICircle circle = (ICircle) other;
			return IntersectorInt.intersectsCirclePolygon(circle.getCenterXInt(), circle.getCenterYInt(), circle.getRadiusInt(), vertices);
			
		} else if(other instanceof ILine) {
			ILine line = (ILine) other;
			return IntersectorInt.intersectsLinePolygon(line.getStartXInt(), line.getStartYInt(), line.getEndXInt(), line.getEndYInt(), vertices);
			
		} else if(other instanceof Polygoni) {
			Polygoni poly = (Polygoni) other;
			return IntersectorInt.intersectsPolygonPolygon(poly.getVertices(), vertices);
			
		} else if(other instanceof IPolygon) {
			IPolygon poly = (IPolygon) other;
			int[] polyVert = new int[poly.getVerticesGen().length];
			for(int i=0, n=polyVert.length; i<n; i++) {
				polyVert[i] = poly.getVerticesGen()[i].intValue();
			}
			return IntersectorInt.intersectsPolygonPolygon(polyVert, vertices);
			
		} else {
			// TODO other shapes
		}
		return false;
	}




	@Override
	public Polygoni copy() {
		return new Polygoni(this);
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
		return (name!=null?name+": ":"") + "Polygoni." + this.hashCode() + "( " + sb.toString() + " )";
	}




	@Override
	public int getNumberVertices() {
		return this.vertices.length/2;
	}
	
	
	
	
	@Override
	public int getXInt(int index) {
		return vertices[index*2];
	}




	@Override
	public int getYInt(int index) {
		return vertices[index*2+1];
	}




	@Override
	public float getXFloat(int index) {
		return (float) getXInt(index);
	}




	@Override
	public float getYFloat(int index) {
		return (float) getYInt(index);
	}




	@Override
	public double getXDouble(int index) {
		return (double) getXInt(index);
	}




	@Override
	public double getYDouble(int index) {
		return (double) getYInt(index);
	}




	@Override
	public IVector2 getVertex(int index) {
		return getVertex(index, null);
	}




	@Override
	public IVector2 getVertex(int index, IVector2 dest) {
		if(dest == null) {
			dest = new Vector2i();
		}
		return dest.set((Integer)getXInt(index), (Integer)getYInt(index));
	}




	@Override
	public Number getCenterXGen() {
		return getCenterX();
	}
	
	
	
	
	/**
	 * @return the x-position of this center
	 * */
	public int getCenterX() {
		int sum = 0;
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
	public int getCenterY() {
		int sum = 0;
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
			dest = new Vector2i();
		}
		return dest.set((Integer)getCenterX(), (Integer)getCenterY());
	}




	@Override
	public Number[] getVerticesGen() {
		return getVerticesGen(null);
	}
	
	
	
	
	/**
	 * @return the vertices of this polygon as an array {x0,y0,x1,...,xn,yn}
	 * */
	public int[] getVertices() {
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
	public int[] getVertices(int[] dest) {
		if(dest == null || dest.length != vertices.length) {
			dest = new int[vertices.length];
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
			dest[j++] = new Vector2i(vertices[i++], vertices[i++]);
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
			dest.add(new Vector2i(vertices[i++], vertices[i++]));
		}
		return dest;
	}




	@Override
	public Polygoni setVertexX(Number x, int index) {
		return this.setVertexX(x.intValue(), index);
	}
	
	
	
	
	/**
	 * Sets the x position of the vertex at the given index
	 * @param x the new x position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public Polygoni setVertexX(int x, int index) {
		vertices[index*2] = x;
		return this;
	}




	@Override
	public Polygoni setVertexY(Number y, int index) {
		return this.setVertexY(y.intValue(), index);

	}
	
	
	
	
	/**
	 * Sets the y position of the vertex at the given index
	 * @param y the new y position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public Polygoni setVertexY(int y, int index) {
		vertices[index*2+1] = y;
		return this;
	}




	@Override
	public Polygoni setVertex(Number x, Number y, int index) {
		return this.setVertex(x.intValue(), y.intValue(), index);
	}
	
	
	
	
	/**
	 * Sets the position of the vertex at the given index
	 * @param x the new x position
	 * @param y the new y position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public Polygoni setVertex(int x, int y, int index) {
		vertices[index*2] = x;
		vertices[index*2+1] = y;
		return this;
	}




	@Override
	public Polygoni setVertex(IVector2 v, int index) {
		return this.setVertex(v.getFloatX(), v.getFloatY(), index);
	}




	@Override
	public Polygoni set(Number[] vertices) {
		if(vertices.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid size of the input array: " + vertices.length);
		}
		if(vertices.length != this.vertices.length) {
			this.vertices = new int[vertices.length];
		}
		for(int i=0; i<vertices.length; i++) {
			this.vertices[i] = vertices[i].intValue();
		}
		return this;
	}
	
	
	
	
	/**
	 * Sets the vertices of this polygon.
	 * @param vertices the new vertices of this polyon as an array {x0,y0,x1,...,xn,yn}
	 * @return this polygon for chaining
	 * */
	public Polygoni set(int[] vertices) {
		if(vertices.length % 2 != 0) {
			throw new IllegalArgumentException("Invalid size of the input array: " + vertices.length);
		}
		this.vertices = vertices;
		return this;
	}




	@Override
	public Polygoni set(IVector2[] vertices) {
		if(vertices.length != this.vertices.length*2) {
			this.vertices = new int[vertices.length];
		}
		for(int i=0,j=0; i<this.vertices.length; ) {
			this.vertices[i++] = vertices[j].getIntX();
			this.vertices[i++] = vertices[j].getIntY();
			j++;
		}
		return this;
	}




	@Override
	public Polygoni set(List<IVector2> vertices) {
		if(vertices.size() != this.vertices.length*2) {
			this.vertices = new int[vertices.size()];
		}
		for(int i=0,j=0; i<this.vertices.length; ) {
			this.vertices[i++] = vertices.get(j).getIntX();
			this.vertices[i++] = vertices.get(j).getIntY();
			j++;
		}
		return this;
	}




	@Override
	public Polygoni translate(Number dx, Number dy) {
		return this.translate(dx.intValue(), dy.intValue());
	}

	
	
	
	/**
	 * Moves this polygon by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this polygon for chaining
	 * */
	public Polygoni translate(int dx, int dy) {
		for(int i=0; i<vertices.length; ) {
			vertices[i++] += dx;
			vertices[i++] += dy;
		}
		return this;
	}

	


	@Override
	public Polygoni translate(IVector2 dir) {
		return this.translate(dir.getFloatX(), dir.getFloatY());
	}




	@Override
	public Polygoni scale(Number s, Number ox, Number oy) {
		return this.scale(s.intValue(), ox.intValue(), oy.intValue());
	}
	
	
	
	
	/**
	 * Scales this polygon. The position of the given origin does not change.
	 * @param s the scaling factor
	 * @param ox the x position of the origin
	 * @param oy the y position of the origin
	 * @return this polygon for chaining
	 * */
	public Polygoni scale(int s, int ox, int oy) {
		return this.scale(s, s, ox, oy);
	}




	@Override
	public Polygoni scale(Number sx, Number sy, Number ox, Number oy) {
		return this.scale(sx.intValue(), sy.intValue(), ox.intValue(), oy.intValue());
	}
	
	
	
	
	private final Vector2i tmpVec = new Vector2i();
	
	/**
	 * Scales this polygon. The position of the given origin does not change.
	 * @param x the scaling in x direction
	 * @param y the scaling in y direction
	 * @param ox the x position of the origin
	 * @param oy the y position of the origin
	 * @return this polygon for chaining
	 * */
	public Polygoni scale(int sx, int sy, int ox, int oy) {
		for(int i=0; i<vertices.length; ) {
			int x = vertices[i++];
			int y = vertices[i++];
			tmpVec.set(x, y).sub(ox, oy).mul(sx, sy);
			vertices[i-2] = tmpVec.x;
			vertices[i-1] = tmpVec.y;
		}
		
		return this;
	}




	@Override
	public Polygoni scale(IVector2 scaling, Number ox, Number oy) {
		return this.scale(scaling.getFloatX(),  scaling.getFloatY(), ox.intValue(), oy.intValue());
	}
	
	
	
	
	/**
	 * Scales this polygon. The position of the given origin does not change.
	 * @param scaling the vector representing the scaling in x and y direction
	 * @param ox the x position of the origin
	 * @param oy the y position of the origin
	 * @return this polygon for chaining
	 * */
	public Polygoni scale(IVector2 scaling, int ox, int oy) {
		return this.scale(scaling.getFloatX(),  scaling.getFloatY(), ox, oy);
	}

	
	
	
	private boolean turnTest(int x1, int y1, int x2, int y2, int x3, int y3) {
		return (x2-x1)*(y3-y2) - (x3-x2)*(y2-y1) > 0;
	}
	
	

	
	@Override
	public boolean isConvex() {
		
		final int n = this.getNumberVertices();
		if(n == 3) {
			return true;
		}
		
		int prevX = this.getXInt(n-2);
		int prevY = this.getYInt(n-2);

		int currX = this.getXInt(n-1);
		int currY = this.getYInt(n-1);
		
		int nextX = this.getXInt(0);
		int nextY = this.getYInt(0);
		
		boolean isCCW = turnTest(prevX, prevY, currX, currY, nextX, nextY);
		
		for(int i=1; i<n; i++) {
			
			prevX = currX;
			prevY = currY;
			currX = nextX;
			currY = nextY;
			nextX = this.getXInt(i);
			nextY = this.getYInt(i);

			if(turnTest(prevX, prevY, currX, currY, nextX, nextY) != isCCW) {
				return false;
			}
			
		}
		
		return true;
	}
	
	
	
	
	private int orientation(int px, int py, int qx, int qy, int rx, int ry) {
		int val = (qy-py)*(rx-qx) - (qx-px)*(ry-qy);
		if(val == 0) {
			return 0;
		}
		return (val > 0) ? 1 : 2;
	}

	
	@Override
	public Polygoni makeConvex() {
		
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
		
		ArrayList<Integer> hullX = new ArrayList<Integer>();
		ArrayList<Integer> hullY = new ArrayList<Integer>();

		do {
			
			hullX.add(getXInt(p));
			hullY.add(getYInt(p));

			q = (p+1) % n;
			
			for(int i=0; i<n; i++) {
				if(orientation(getXInt(p), getYInt(p), getXInt(i), getYInt(i), getXInt(q), getYInt(q)) == 2) {
					q = i;
				}
			}
			
			p = q;
			
		} while(p != l);
		
		
		int[] verticesConvex = new int[hullX.size()*2];
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
		
		int minY = this.getYInt(0);
		int minIndex = 0;
		
		for(int i=1; i<n; i++) {
			final int y = this.getYInt(i);
			if(y < minY) {
				minY = y;
				minIndex = i;
			}
		}
		

		final int indexPrev = (minIndex - 1 + n) % n;
		final int indexNext = (minIndex + 1) % n;

		return this.turnTest(getXInt(indexPrev), getYInt(indexPrev), getXInt(minIndex), getYInt(minIndex), getXInt(indexNext), getYInt(indexNext));
	}


	
	
	@Override
	public Polygoni makeCCW() {

		if(!isCCW()) {
			
			int[] verticesCCW = new int[this.vertices.length];
			
			for(int i=this.getNumberVertices()-1, j=0; i>=0; i--) {
				int x = getXInt(i);
				int y = getYInt(i);
				verticesCCW[j++] = x;
				verticesCCW[j++] = y;
			}
			
			this.vertices = verticesCCW;
			
		}
		
		return this;
	}
	
	
	
	
	private List<Integer> transformLUT(int[] lut) {
		
		List<Integer> tLUT = new ArrayList<Integer>();
		
		if(!isCCW()) {
			for(int i=this.getNumberVertices()-1; i>=0; i--) {
				tLUT.add(lut[i]);
			}
			
		} else {
			for(int i=0; i<lut.length; i++) {
				tLUT.add(lut[i]);
			}
		}
		
		return tLUT;
	}
	
	
	
	
	@Override
	public List<Vector3i> triangulateIndices() {
		List<Vector3i> triangles = new ArrayList<Vector3i>();
		triangulateIndices(triangles);
		return triangles;
	}

	
	
	
	@Override
	public void triangulateIndices(List<Vector3i> trianglesOut) {
		
		
		final int n = this.getNumberVertices();
		if(n < 3) {
			return;
		}
		if(n == 3) {
			trianglesOut.add(new Vector3i(0, 1, 2));
		}
		
		if(this.isConvex()) {
			
			int   oi = 0;
			int   ai = 1;
			int   bi = 2;
			
			for(int i=3; i<n; i++) {
				trianglesOut.add(new Vector3i(oi, ai, bi));
				ai = bi;
				bi = i;
			}
			
			trianglesOut.add(new Vector3i(oi, ai, bi));
			
			
		} else {
			
			int[] arrLut = new int[this.getNumberVertices()];
			for(int i=0; i<arrLut.length; i++) {
				arrLut[i] = i;
			}
			List<Integer> lutList = transformLUT(arrLut);

			// ear-clipping-algorithm
			Polygoni poly = isCCW() ? this : this.copy().makeCCW();
			List<IVector2> listVertices = poly.getVerticesVecList();
			
			int p = 0;
			while(listVertices.size() > 3) {

				int i0 = wrapIndex(listVertices, p-1);
				int i1 = wrapIndex(listVertices, p  );
				int i2 = wrapIndex(listVertices, p+1);

				IVector2 v0 = listVertices.get(i0);
				IVector2 v1 = listVertices.get(i1);
				IVector2 v2 = listVertices.get(i2);

				if( isEar(listVertices, v0, v1, v2) ) {
					trianglesOut.add(new Vector3i(lutList.get(i0), lutList.get(i1), lutList.get(i2)));
					listVertices.remove(p);
					lutList.remove(p);
					p = 0;
				} else {
					p++;
				}
				
			}
			
			trianglesOut.add(new Vector3i(lutList.get(0), lutList.get(1), lutList.get(2)));
		}
		
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
			
			int ox = getXInt(0);
			int oy = getYInt(0);

			int ax = getXInt(1);
			int ay = getYInt(1);

			int bx = getXInt(2);
			int by = getYInt(2);
			
			for(int i=3; i<n; i++) {
				Polygoni tri = new Polygoni(ox, oy, ax, ay, bx, by);
				trianglesOut.add(tri);
				ax = bx;
				ay = by;
				bx = getXInt(i);
				by = getYInt(i);
			}
			
			Polygoni tri = new Polygoni(ox, oy, ax, ay, bx, by);
			trianglesOut.add(tri);
			
			
		} else {
			
			// ear-clipping-algorithm
			Polygoni poly = isCCW() ? this : this.copy().makeCCW();
			
			List<IVector2> listVertices = poly.getVerticesVecList();
			
			int p = 0;
			while(listVertices.size() > 3) {
				
				IVector2 v0 = getVertexWrapped(listVertices, p-1);
				IVector2 v1 = getVertexWrapped(listVertices, p  );
				IVector2 v2 = getVertexWrapped(listVertices, p+1);

				if( isEar(listVertices, v0, v1, v2) ) {
					trianglesOut.add(new Polygoni(v0.getIntX(), v0.getIntY(), v1.getIntX(), v1.getIntY(), v2.getIntX(), v2.getIntY()));
					listVertices.remove(p);
					p = 0;
				} else {
					p++;
				}
				
			}
			
			trianglesOut.add(new Polygoni(listVertices.get(0), listVertices.get(1), listVertices.get(2)));
		}
		
	}
	
	
	
	
	private IVector2 getVertexWrapped(List<IVector2> vertices, int index) {
		return vertices.get(wrapIndex(vertices, index));
	}
	
	
	
	
	private int wrapIndex(List<IVector2> vertices, int index) {
		if(index >= vertices.size()) {
			return index%vertices.size();
		}
		if(index < 0) {
			return wrapIndex(vertices, index+vertices.size());
		}
		return index;
	}
	
	
	
	
	private boolean isEar(List<IVector2> vertices, IVector2 a, IVector2 b, IVector2 c) {
		final int x1 = a.getIntX();
		final int y1 = a.getIntY();
		final int x2 = b.getIntX();
		final int y2 = b.getIntY();
		final int x3 = c.getIntX();
		final int y3 = c.getIntY();
		
		int l = (x2-x1)*(y3-y2) - (x3-x2)*(y2-y1);

		if(l > 0) {
			
			boolean inside = false;
			for(int i=0; i<vertices.size(); i++) {
				IVector2 p = vertices.get(i);
				if(p == a || p == b || p == c) {
					continue;
				}
				if(IntersectorInt.pointInTriangle(x1, y1, x2, y2, x3, y3, p.getIntX(), p.getIntY())) {
					inside = true;
					break;
				}
			}
			
			return !inside;
			
		}
		
		return false;
	}
	
	
	
	
	@Override
	public Polygoni setName(String name) {
		this.name = name;
		return this;
	}

	
	

	@Override
	public String getName() {
		return this.name;
	}


	@Override
	public Vector2i getRandomPoint() {
		for(int i=0; i<512; i++) {
			int x = getMinXInt() + (int)((getMaxXFloat()-getMinXFloat())*Math.random());
			int y = getMinYInt() + (int)((getMaxYFloat()-getMinYFloat())*Math.random());
			if(IntersectorInt.pointInPolygon(vertices, x, y)) {
				return new Vector2i(x, y);
			}
		}
		return null;
	}

	
	

	@Override
	public Polygoni getRandomPoint(IVector2 dst) {
		for(int i=0; i<512; i++) {
			int x = getMinXInt() + (int)((getMaxXFloat()-getMinXFloat())*Math.random());
			int y = getMinYInt() + (int)((getMaxYFloat()-getMinYFloat())*Math.random());
			if(IntersectorInt.pointInPolygon(vertices, x, y)) {
				dst.set(x, y);
				break;
			}
		}
		return this;
	}


}
















