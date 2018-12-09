package com.ruegnerlukas.simplemath.geometry.shapes.polygon;

import java.util.List;

import com.ruegnerlukas.simplemath.geometry.shapes.IShape;
import com.ruegnerlukas.simplemath.vectors.vec2.IVector2;
import com.ruegnerlukas.simplemath.vectors.vec3.Vector3i;

public interface IPolygon extends IShape {

	
	/**
	 * @return the number of vertices of this polygon
	 * */
	public int getNumberVertices();
	
	
	/**
	 * @return the x-position of the vertex at the given index
	 * */
	public int getXInt(int index);
	
	
	/**
	 * @return the y-position of the vertex at the given index
	 * */
	public int getYInt(int index);

	
	/**
	 * @return the x-position of the vertex at the given index
	 * */
	public float getXFloat(int index);
	
	
	/**
	 * @return the y-position of the vertex at the given index
	 * */
	public float getYFloat(int index);
	
	
	/**
	 * @return the x-position of the vertex at the given index
	 * */
	public double getXDouble(int index);
	
	
	/**
	 * @return the y-position of the vertex at the given index
	 * */
	public double getYDouble(int index);
	
	
	/**
	 * @return the vertex at the given index
	 * */
	public IVector2 getVertex(int index);
	
	/**
	 * @param dest the destination vector for the position (or null)
	 * @return the vector containing the vertex at the given index
	 * */
	public IVector2 getVertex(int index, IVector2 dest);
	
	
	/**
	 * @return the x-position of this center as a number
	 * */
	public Number getCenterXGen();
	
	
	/**
	 * @return the y-position of this center as a number
	 * */
	public Number getCenterYGen();
	
	
	/**
	 * @return the position of the center of this polygon
	 * */
	public IVector2 getCenter();
	
	/**
	 * @param dest the destination vector for the position (or null)
	 * @return the vector containing the position of the center of this polygon.
	 * */
	public IVector2 getCenter(IVector2 dest);
	
	
	/**
	 * @return the vertices of this polygon as an array {x0,y0,x1,...,xn,yn}
	 * */
	public Number[] getVerticesGen();
	
	
	/**
	 * @param the destination array for the vertex data {x0,y0,x1,...,xn,yn} or null
	 * @return the destination array with the vertex data
	 * */
	public Number[] getVerticesGen(Number[] dest);
	
	
	/**
	 * @return the vertices of this polygon as an array of vectors
	 * */
	public IVector2[] getVerticesVec();
	
	
	/**
	 * @param the destination array for the vertex data or null
	 * @return the destination array with the vertex data
	 * */
	public IVector2[] getVerticesVec(IVector2[] dest);
	
	
	/**
	 * @return the vertices of this polygon as a list of vectors
	 * */
	public List<IVector2> getVerticesVecList();
	
	
	/**
	 * @param the destination array for the vertex data or null. The vectors get added to the list.
	 * @return the destination array with the vertex data
	 * */
	public List<IVector2> getVerticesVecList(List<IVector2> dest);
	
	
	/**
	 * Sets the x position of the vertex at the given index
	 * @param x the new x position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public IPolygon setVertexX(Number x, int index);
	
	
	/**
	 * Sets the y position of the vertex at the given index
	 * @param y the new y position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public IPolygon setVertexY(Number y, int index);
	
	
	/**
	 * Sets the position of the vertex at the given index
	 * @param x the new x position
	 * @param y the new y position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public IPolygon setVertex(Number x, Number y, int index);
	
	
	/**
	 * Sets the position of the vertex at the given index
	 * @param v the vector with the new position
	 * @param index the index
	 * @return this polygon for chaining
	 * */
	public IPolygon setVertex(IVector2 v, int index);

	
	/**
	 * Sets the vertices of this polygon.
	 * @param vertices the new vertices of this polyon as an array {x0,y0,x1,...,xn,yn}
	 * @return this polygon for chaining
	 * */
	public IPolygon set(Number[] vertices);
	
	
	/**
	 * Sets the vertices of this polygon.
	 * @param vertices the new vertices of this polyon as an array of vectors
	 * @return this polygon for chaining
	 * */
	public IPolygon set(IVector2[] vertices);
	
	
	/**
	 * Sets the vertices of this polygon.
	 * @param vertices the new vertices of this polyon as a list of vectors
	 * @return this polygon for chaining
	 * */
	public IPolygon set(List<IVector2> vertices);
	
	
	/**
	 * Moves this polygon by the given amount.
	 * @param dx the distance in x-direction
	 * @param dy the distance in y-direction
	 * @return this polygon for chaining
	 * */
	public IPolygon translate(Number dx, Number dy);
	
	
	/**
	 * Moves this polygon by the given amount.
	 * @param dir the vector representing the distance in the x- and y-direction
	 * @return this polygon for chaining
	 * */
	public IPolygon translate(IVector2 dir);

	
	/**
	 * Scales this polygon. The position of the given origin does not change.
	 * @param s the scaling factor
	 * @param ox the x position of the origin
	 * @param oy the y position of the origin
	 * @return this polygon for chaining
	 * */
	public IPolygon scale(Number s, Number ox, Number oy);

	
	/**
	 * Scales this polygon. The position of the given origin does not change.
	 * @param x the scaling in x direction
	 * @param y the scaling in y direction
	 * @param ox the x position of the origin
	 * @param oy the y position of the origin
	 * @return this polygon for chaining
	 * */
	public IPolygon scale(Number sx, Number sy, Number ox, Number oy);
	
	
	/**
	 * Scales this polygon. The position of the given origin does not change.
	 * @param scaling the vector representing the scaling in x and y direction
	 * @param ox the x position of the origin
	 * @param oy the y position of the origin
	 * @return this polygon for chaining
	 * */
	public IPolygon scale(IVector2 scaling, Number ox, Number oy);
	
	
	/**
	 * Tests if this polygon is convex
	 * @return true, if polygon is convex
	 * */
	public boolean isConvex();
	
	
	/**
	 * Converts this polygon to a convex polygon
	 * @return this polygon for chaining
	 * */
	public IPolygon makeConvex();
	
	
	/**
	 * Test is this polygon is CounterClockWise
	 * @return true, if polygon is ccw
	 * */
	public boolean isCCW();
	
	
	/**
	 * Convert this polygon to a CounterClockWise-polygon
	 * @return this polygon for chaining
	 * */
	public IPolygon makeCCW();
	
	
	/**
	 * Triangulates this polygon
	 * @return a list of triangles
	 * */
	public List<IPolygon> triangulate();
	
	
	/**
	 * Triangulates this polygon
	 * @return a list of triangles represented by indices in the list of vertices of the original polygon
	 * */
	public List<Vector3i> triangulateIndices();
	
	
	/**
	 * Triangulates this polygon and adds the resulting triangles to trianglesOut
	 * @param trianglesOut the resulting triangles
	 * @return a list of triangles
	 * */
	public void triangulate(List<IPolygon> trianglesOut);
	
	
	/**
	 * Triangulates this polygon and adds the resulting triangles to trianglesOut
	 * @param trianglesOut the resulting triangles
	 * @return a list of triangles represented by indices in the list of vertices of the original polygon
	 * */
	public void triangulateIndices(List<Vector3i> trianglesOut);

	
}
