package com.amit.model;

public class Link {

	private String url;
	private String rel;
	
	/**
	 * Default constructor
	 */
	public Link() {
		super();
	}
	/**
	 * @param link
	 * @param rel
	 */
	public Link(String url, String rel) {
		super();
		this.url = url;
		this.rel = rel;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return url;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String url) {
		this.url = url;
	}
	/**
	 * @return the rel
	 */
	public String getRel() {
		return rel;
	}
	/**
	 * @param rel the rel to set
	 */
	public void setRel(String rel) {
		this.rel = rel;
	}
}
