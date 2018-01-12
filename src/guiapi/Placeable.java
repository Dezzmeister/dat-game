package guiapi;

import guiapi.Global;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;

public class Placeable {
	PApplet parent;
	
	/**
	 * Displayed on the PApplet.
	 */
	public PGraphics img;
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	
	protected boolean focusOnClick = false;
	
	/**
	 * 
	 * @param parent the PApplet to draw to
	 * @see PApplet
	 */
	public Placeable(PApplet parent) {
		this.parent = parent;
	}
	
	public Placeable() {
		
	}
	
	/**
	 * Sets the coordinates of a Placeable by defining the upper left corner x and y values.
	 * Returns a Placeable as part of the Fluent Interface.
	 * If chaining this method at initialization, place it after all subclass chain methods.
	 * 
	 * @param x	upper left corner x coordinate of the Placeable
	 * @param y upper left corner y coordinate of the Placeable
	 * @return an instance of this with updated x and y
	 */
	public Placeable placeAt(int x, int y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	/**
	 * Sets the coordinates of a Placeable by defining the center x and y values.
	 * Returns a Placeable as part of the Fluent Interface.
	 * If chaining this method at initialization, place it after all subclass chain methods.
	 * 
	 * @param x	center x coordinate of the Placeable
	 * @param y center y coordinate of the Placeable
	 * @return an instance of this with updated x and y
	 */
	public Placeable placeAtCenter(int x, int y) {
		this.x = x - (width/2);
		this.y = y - (height/2);
		return this;
	}
	
	/**
	 * Standard method to draw an image to a screen.
	 * Should be overridden in subclasses.
	 * 
	 */
	public void draw() {	//Override this method
		
	}
	
	/**
	 * Default draw method. 
	 * Should only be called in subclasses.
	 */
	protected void defaultDraw() {
		parent.imageMode(PConstants.CORNER);
		parent.image(img, x, y);
	}
	
	/**
	 * 
	 * @return height of this component
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * 
	 * @param height height of this component
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * 
	 * @return width of this component
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * 
	 * @param width width of this component
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * 
	 * @return upper left x value of this component
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * 
	 * @param x upper left x value of this component
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return upper left y value of this component
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * 
	 * @param y upper left y value of this component
	 */
	public void setY(int y) {
		this.y = y;
	}
	/**
	 * Obtain focus for this component.
	 * Should not be called by user under normal circumstances.
	 */
	public void getFocus() {
		//Simple focus system: Global.focused is an Object, and it will point to whatever has focus
		Global.focused = this;
	}
	
	/**
	 * Check if this component has focus.
	 * Should not be called by the user under normal circumstances.
	 * 
	 * @return true if this component has focus
	 */
	public boolean hasFocus() {
		return Global.focused==this;
	}
	
	/**
	 * Enables or disables focus system for this component.
	 * Returns a Placeable as part of the Fluent Interface.
	 * If chaining this method at initialization, place it after all subclass chain methods.
	 * 
	 * @param focus true if the focus system will be enabled for this component
	 * @return updated instance of this component
	 */
	public Placeable setFocus(boolean focus) {
		focusOnClick = focus;
		return this;
	}
}
