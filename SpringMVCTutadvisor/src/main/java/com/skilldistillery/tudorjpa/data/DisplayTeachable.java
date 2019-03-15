package com.skilldistillery.tudorjpa.data;

import com.skilldistillery.tudorjpa.entities.TeachableSkill;

public class DisplayTeachable {

	private TeachableSkill teachableSkill;
	private String url;
	private int matchLSId;
	
	public DisplayTeachable(TeachableSkill teachableSkill, String url, int matchLSId) {
		this.teachableSkill = teachableSkill;
		this.url = url;
		this.matchLSId = matchLSId;
	}
	
	public DisplayTeachable(TeachableSkill teachableSkill, int matchLSId) {
		this.teachableSkill = teachableSkill;
		this.matchLSId = matchLSId;
		this.url = "";
	}
	
	public DisplayTeachable(TeachableSkill teachableSkill, String url) {
		this.teachableSkill = teachableSkill;
		this.url = url;
		this.matchLSId = 0;
	}
	
	public DisplayTeachable(TeachableSkill teachableSkill) {
		this.teachableSkill = teachableSkill;
		this.url = "";
		this.matchLSId = 0;
	}
	
	
	public int getMatchLSId() {
		return matchLSId;
	}

	public void setMatchLSId(int matchLSId) {
		this.matchLSId = matchLSId;
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
