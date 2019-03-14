package com.skilldistillery.tudorjpa.data;

import com.skilldistillery.tudorjpa.entities.TeachableSkill;

public class DisplayTeachable {

	private TeachableSkill teachableSkill;
	private String url;
	
	public DisplayTeachable(TeachableSkill teachableSkill, String url) {
		this.teachableSkill = teachableSkill;
		this.url = url;
	}
	public TeachableSkill getTeachableSkill() {
		return teachableSkill;
	}
	public void setTeachableSkill(TeachableSkill teachableSkill) {
		this.teachableSkill = teachableSkill;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "DisplayTeachable [teachableSkill=" + teachableSkill + ", url=" + url + "]";
	}
	
	
}
