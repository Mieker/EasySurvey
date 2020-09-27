package easysurvey.dataModel.Statistics;

import java.util.ArrayList;

public class QuestionStat {

    private ArrayList<AnswerStat> answerStats = new ArrayList<>();
    private long questionId;
    private String questionText;

    public ArrayList<AnswerStat> getAnswerStats() {
        return answerStats;
    }

    public void setAnswerStats(AnswerStat answerStat) {
        answerStats.add(answerStat);
    }

    public long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(long questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
}
