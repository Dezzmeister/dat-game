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
	
	public Cursor(PApplet parent) {
		this.parent = parent;
	}
	
	public Cursor loadImage(String imgpath) {
		image = parent.loadImage(imgpath);
		img = parent.createGraphics(image.width, image.height);
		img.beginDraw();
		img.background(0,0);
		img.image(image,0,0);
		img.endDraw();
		
		return this;
	}
	
	public Cursor loadImage(PGraphics img) {
		this.img = img;
		return this;
	}
	
	public void drawCode(DrawnImage drawn) {
		this.drawn = drawn;
	}
	
	public void draw() {
		if (img != null) {
			img.beginDraw();
			img.background(0,0);
			img.image(image,0,0);
			img.endDraw();
			
			parent.imageMode(PConstants.CENTER);
			parent.image(img, parent.mouseX, parent.mouseY);
		} else {
			drawn.drawImage();
		}
	}
}
