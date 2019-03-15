package com.skilldistillery.tudorjpa.data;

import com.skilldistillery.tudorjpa.entities.LearnableSkill;

public class DisplayLearnable {
	
	private LearnableSkill learnableSkill;
	private String url;
	private int matchTSId;
	
	public DisplayLearnable(LearnableSkill learnableSkill, String url, int matchTSId) {
		this.learnableSkill = learnableSkill;
		this.url = url;
		this.matchTSId = matchTSId;
	}
	
	public DisplayLearnable(LearnableSkill learnableSkill, int matchTSId) {
		this.learnableSkill = learnableSkill;
		this.matchTSId = matchTSId;
		this.url = "";
	}
			
	public DisplayLearnable(LearnableSkill learnableSkill, String url) {
		this.learnableSkill = learnableSkill;
		this.url = url;
		this.matchTSId = 0;
	}
	
	public DisplayLearnable(LearnableSkill learnableSkill) {
		this.learnableSkill = learnableSkill;
		this.url = "";
		this.matchTSId = 0;
	}
	
	
	public int getMatchTSId() {
		return matchTSId;
	}

	public void setMatchTSId(int matchTSId) {
		this.matchTSId = matchTSId;
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
		return "DisplayLearnable [learnableSkill=" + learnableSkill + ", url=" + url + ", matchTSId=" + matchTSId + "]";
	}
	
	

}
