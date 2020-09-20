package easysurvey.dataModel;

import java.util.ArrayList;

public class AnsweredSurvey {
	private ArrayList<Long> questionIds;
	private ArrayList<Long> answerIds;
	private ArrayList<Long> metricIds;
	private ArrayList<Long> metricAnswersIds;
	
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

	public ArrayList<Long> getMetricIds() {
		return metricIds;
	}

	public void setMetricIds(ArrayList<Long> metricIds) {
		this.metricIds = metricIds;
	}

	public ArrayList<Long> getMetricAnswersIds() {
		return metricAnswersIds;
	}

	public void setMetricAnswersIds(ArrayList<Long> metricAnswersIds) {
		this.metricAnswersIds = metricAnswersIds;
	}
}
