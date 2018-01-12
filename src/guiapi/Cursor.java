package guiapi;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PImage;

public class Cursor {
	private PImage image;
	private PGraphics img;
	private PApplet parent;
	
	private DrawnImage drawn;
	
	/**
	 * 
	 * @param parent the PApplet to draw to
	 * @see PApplet
	 */
	public Cursor(PApplet parent) {
		this.parent = parent;
	}
	
	/**
	 * Loads an image for the cursor and returns an instance of this
	 * as part of the Fluent Interface.
	 * 
	 * @param imgpath path of the image to load, "src/..."
	 * @return updated instance of this component
	 */
	public Cursor loadImage(String imgpath) {
		image = parent.loadImage(imgpath);
		img = parent.createGraphics(image.width, image.height);
		img.beginDraw();
		img.background(0,0);
		img.image(image,0,0);
		img.endDraw();
		
		return this;
	}
	
	/**
	 * Loads a previously defined PGraphics image for the cursor and returns an instance of this
	 * as part of the Fluent Interface.
	 * 
	 * @param img PGraphics object
	 * @return updated instance of this component
	 */
	public Cursor loadImage(PGraphics img) {
		this.img = img;
		return this;
	}
	
	/**
	 * Accepts code that will be used to draw to a PApplet if no image has been set.
	 * Can accept lambda expressions and method references.
	 * 
	 * @param drawn code that will draw a custom image
	 */
	public void drawCode(DrawnImage drawn) {
		this.drawn = drawn;
	}
	
	/**
	 * Will draw a PGraphics image if it has been defined.
	 * If not, runs code defined in drawCode().
	 * 
	 * @see #drawCode(DrawnImage)
	 * @see #loadImage(PGraphics)
	 * @see #loadImage(String)
	 */
	public void draw() {
		if (img != null) {
			img.beginDraw();
			img.background(0,0);
			img.image(image,0,0);
			img.endDraw();
			
			parent.imageMode(PConstants.CENTER);
			parent.image(img, parent.mouseX, parent.mouseY);
		} else if (drawn != null){
			drawn.drawImage();
		}
	}
}
