package easysurvey.dataModel;

import java.util.HashSet;
import java.util.Set;

public class Question
{
    private long questionId;
    private String questionText;
    private Set<OfferedAnswer> offeredAnswers = new HashSet<>();

    public long getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(long questionId)
    {
        this.questionId = questionId;
    }

    public String getQuestionText()
    {
        return questionText;
    }

    public void setQuestionText(String questionText)
    {
        this.questionText = questionText;
    }

    public void addOfferedAnswer(OfferedAnswer offeredAnswer){
        offeredAnswers.add(offeredAnswer);
    }

    public void removeOfferedAnswer(OfferedAnswer offeredAnswer){
        offeredAnswers.remove(offeredAnswer);
    }

}
