package easysurvey.dataModel;

import java.util.ArrayList;

public class AnsweredSurvey {
	private ArrayList<Long> questionIds;
	private ArrayList<Long> answerIds;
	
	public ArrayList<Long> getQuestionIds() {
		return questionIds;
	}
	
	public void setQuestionIds(ArrayList<Long> questionIds) {
		this.questionIds = questionIds;
	}
	
	public ArrayList<Long> getAnswerIds() {
		return answerIds;
	}
	
	public void setAnswerIds(ArrayList<Long> answerIds) {
		this.answerIds = answerIds;
	}
}
