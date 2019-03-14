package com.skilldistillery.tudorjpa.data;

import com.skilldistillery.tudorjpa.entities.LearnableSkill;

public class DisplayLearnable {
	
	private LearnableSkill learnableSkill;
	private String url;
			
	public DisplayLearnable(LearnableSkill learnableSkill, String url) {
		this.learnableSkill = learnableSkill;
		this.url = url;
	}
	public LearnableSkill getLearnableSkill() {
		return learnableSkill;
	}
	public void setLearnableSkill(LearnableSkill learnableSkill) {
		this.learnableSkill = learnableSkill;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "DisplayLearnable [learnableSkill=" + learnableSkill + ", url=" + url + "]";
	}
	
	

}
