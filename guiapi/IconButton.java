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
	
	//Define what happens when the button is clicked with clickAction - accepts lambda expressions
	public IconButton(PApplet parent, String imgpath, ClickInterface clickAction) {
		super(parent);
		this.parent = parent;
		this.imgpath = imgpath;
		this.clickAction = clickAction;
		defined = true;
		
		initialize();
	}
	
	//Does not set any clicking action
	public IconButton(PApplet parent, String imgpath) {
		super(parent);
		this.parent = parent;
		this.imgpath = imgpath;
		
		System.out.println("onClick() is undefined for an IconButton!");
		
		initialize();
	}
	
	//Self explanatory. Call at initialization
	public IconButton setToggleable() {
		toggleable = true;
		return this;
	}
	
	//Set the click behavior
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
