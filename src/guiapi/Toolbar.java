package guiapi;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;

public class Toolbar extends Placeable {
	PFont segoeui15;
	int col = 0;
	private ArrayList<Element> elements = new ArrayList<>();
	private String name;
	
	public Toolbar(PApplet parent, int width, int height) {
		this.parent = parent;
		this.width = width;
		this.height = height;
		segoeui15 = parent.loadFont("src/assets/vlw/SegoeUI-15.vlw");
		col = parent.color(120);
		defaultToolbar();
	}
	
	//Set the background color of the toolbar
	public Toolbar setColor(int col) {
		this.col = col;
		return this;			
	}
	
	@Override	//Only call this method if you haven't added the Toolbar to Global.toolbars, and only call it in drawToolbars()
	public void draw() {
		img.beginDraw();
		img.background(col);
		if (name != null) {
			img.textFont(segoeui15);
			img.textAlign(PConstants.LEFT,PConstants.TOP);
			img.fill(0,100);
			img.noStroke();
			img.rect(0, 0, img.width, 20);
			img.fill(0);
			img.text(name, 5, 5);
		}
		img.endDraw();
		defaultDraw();
		for (Element e : elements) {
			e.draw();
		}
	}
	
	//Set the name displayed at the top of the toolbar
	public Toolbar setName(String name) {
		this.name = name;
		return this;
	}
	
	//Called by the constructor to create the default toolbar
	private void defaultToolbar() {
		//Initialize the default Toolbar
		img = parent.createGraphics(width,height);
		img.beginDraw();
		img.background(col);
		img.endDraw();
	}
	
	//Add an element to the toolbar at a location relative to the toolbar's origin
	public void add(int x, int y, Element e) {
		elements.add((Element) e.placeAt(this.x + x, this.y + y));
	}
	
	public void addCenter(int x, int y, Element e) {
		elements.add((Element) e.placeAtCenter(this.x + x, this.y + y)); 
	}
}
