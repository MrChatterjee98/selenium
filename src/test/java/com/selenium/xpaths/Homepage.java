package com.selenium.xpaths;

public class Homepage {
	private String  para = "//p[@id='hoverpara']";
	private String searchbox = "//*[@aria-label=\"Search\"]";
	private String searchButton = "/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]";
	public String para() {
		return this.para;
	}
	
	public String searchbox() {
		return this.searchbox;
	}
	
	public String searchButton() {
		return this.searchButton;
	}
}
