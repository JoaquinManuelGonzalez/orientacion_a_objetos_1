package ar.edu.unlp.oo1.ejercicio1.impl;

import ar.edu.unlp.oo1.ejercicio1.WallPost;


public class WallPostImpl implements WallPost {

	private String text;
	private int likes;
	private boolean featured;

	public WallPostImpl() {
		this.text = "Undefined post";
		this.likes = 0;
		this.featured = false;
	}
	
	public boolean getFeatured() {
		return this.featured;
	}
	
    @Override
    public String toString() {
        return "WallPost {" +
            "text: " + getText() +
            ", likes: '" + getLikes() + "'" +
            ", featured: '" + isFeatured() + "'" +
            "}";
    }

	@Override
	public String getText() {
		return this.text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int getLikes() {
		return this.likes;
	}

	@Override
	public void like() {
		this.likes++;
	}

	@Override
	public void dislike() {
		if (this.getLikes() > 0) {
			this.likes--;
		} else {
			System.out.println("No es posible realizar la accion.");
		}
	}

	@Override
	public boolean isFeatured() {
		return (this.getFeatured() == true);
	}

	@Override
	public void toggleFeatured() {
		this.featured = !this.getFeatured();
	}

}
