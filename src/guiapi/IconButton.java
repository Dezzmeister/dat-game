package guiapi;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

//Inherits Element and Placeable
@SuppressWarnings("unused")
public class IconButton extends Clickable {
	PImage image;
	String imgpath;
	//private boolean grayed = false;
	private boolean active = true;
	private boolean defined = false;
	private boolean toggleable = false;
	private boolean toggled = false;
	int bgCol = 0;
	
	private ClickInterface clickAction;
	
	/**
	 * Creates an IconButton, sets the image and onClick action.
	 * 
	 * @param parent PApplet to be drawn to
	 * @param imgpath path to the IconButton's icon
	 * @param clickAction FunctionalInterface, accepts lambda expressions and method references.
	 */
	public IconButton(PApplet parent, String imgpath, ClickInterface clickAction) {
		super(parent);
		this.parent = parent;
		this.imgpath = imgpath;
		this.clickAction = clickAction;
		defined = true;
		
		initialize();
	}
	
	/**
	 * Creates an IconButton and sets the image.
	 * Will also print a message saying that onClick() is undefined.
	 * 
	 * @param parent PApplet to be drawn to
	 * @param imgpath path to the IconButton's icon
	 * @see #setClickBehavior(ClickInterface)
	 */
	public IconButton(PApplet parent, String imgpath) {
		super(parent);
		this.parent = parent;
		this.imgpath = imgpath;
		
		System.out.println("onClick() is undefined for an IconButton!");
		
		initialize();
	}
	
	/**
	 * Sets the button to toggle.
	 * Returns an instance of this as part of the Fluent Interface.
	 * 
	 * @return updated instance of this component
	 */
	public IconButton setToggleable() {
		toggleable = true;
		return this;
	}
	
	/**
	 * Defines what code is run when the button is clicked.
	 * 
	 * @param clickAction lambda expression or method reference
	 */
	public void setClickBehavior(ClickInterface clickAction) {
		this.clickAction = clickAction;
		defined = true;
	}
	
	//Called by the constructors to set up the button
	private void initialize() {
		bgCol = parent.color(120);
		
		image = parent.loadImage(imgpath);
		img = parent.createGraphics(image.width, image.height);
		img.beginDraw();
		img.background(bgCol);
		img.noFill();
		img.strokeWeight(6);
		img.rect(0, 0, img.width-1, img.height-1);
		img.image(image,0,0);
		img.endDraw();
		width = img.width;
		height = img.height;
	}
	
	/**
	 * Draws the button. Should not be explicitly called by the user.
	 */
	@Override	//Only call this method if you haven't added the IconButton to Global.iconbuttons, and only call it in drawIconButtons(). 
	public void draw() {
		if (active) {
			img.beginDraw();
			img.background(bgCol);
			img.image(image,0,0);
			img.noFill();
			img.strokeWeight(6);
			if (isHovering(x,y,img) || toggled && toggleable) {
				img.noStroke();
			} else {
				img.stroke(0);
			}
			img.rect(0, 0, img.width-1, img.height-1);
			img.endDraw();
			if (wasClicked(x,y,img) && defined) {
				clickAction.onClick();	//onClick should be defined by the user using either an anonymous class or a lambda expression.
				toggled = !toggled;
			}
		}
		defaultDraw();
	}
	
	public void deactivate() {
		active = false;
	}
	
	public void activate() {
		active = true;
	}
	
	public boolean toggled() {
		return toggled;
	}

}
