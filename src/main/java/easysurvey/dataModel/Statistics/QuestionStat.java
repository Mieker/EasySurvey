package easysurvey.dataModel.Statistics;

import java.util.ArrayList;

public class QuestionStat {

    private ArrayList<AnswerStat> answerStats = new ArrayList<>();
    private long questionId;
    private String questionText;
    private long numberOfMetricAnswers;

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

    public long getNumberOfMetricAnswers() {
        return numberOfMetricAnswers;
    }

    public void setNumberOfMetricAnswers(long numberOfMetricAnswers) {
        this.numberOfMetricAnswers = numberOfMetricAnswers;
    }

    public void contNumberOfMetricAnswers(){

        long count=0;
        for (AnswerStat answerStat: answerStats ) {
            count = count + (long) answerStat.getNumberOfAnswers();
        }
        setNumberOfMetricAnswers(count);

    }
}
