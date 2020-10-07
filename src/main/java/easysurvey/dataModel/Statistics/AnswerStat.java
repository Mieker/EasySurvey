package easysurvey.dataModel.Statistics;

import easysurvey.dataModel.PotentialQuestionAnswer;

import java.math.BigInteger;

public class AnswerStat {

    private PotentialQuestionAnswer potentialQuestionAnswer;
    private double answerPercentage;
    private long numberOfAnswers;


    public double getAnswerPercentage() {
        return answerPercentage;
    }

    public void setAnswerPercentage(double answerPercentage) {
        this.answerPercentage = answerPercentage;
    }

    public double getNumberOfAnswers() {
        return numberOfAnswers;
    }

    public void setNumberOfAnswers(long numberOfAnswers) {
        this.numberOfAnswers = numberOfAnswers;
    }

    public PotentialQuestionAnswer getPotentialQuestionAnswer() {
        return potentialQuestionAnswer;
    }

    public void setPotentialQuestionAnswer(PotentialQuestionAnswer potentialQuestionAnswer) {
        this.potentialQuestionAnswer = potentialQuestionAnswer;
    }


}
