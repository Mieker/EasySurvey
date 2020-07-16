package easysurvey.dataModel;

public class Answer
{
    private long surveyId;
    private long intervieweeId;
    private long offeredAnswerId;
    private long questionId;
    private String otherText;

    public long getSurveyId()
    {
        return surveyId;
    }

    public void setSurveyId(long surveyId)
    {
        this.surveyId = surveyId;
    }

    public long getIntervieweeId()
    {
        return intervieweeId;
    }

    public void setIntervieweeId(long intervieweeId)
    {
        this.intervieweeId = intervieweeId;
    }

    public long getOfferedAnswerId()
    {
        return offeredAnswerId;
    }

    public void setOfferedAnswerId(long offeredAnswerId)
    {
        this.offeredAnswerId = offeredAnswerId;
    }

    public long getQuestionId()
    {
        return questionId;
    }

    public void setQuestionId(long questionId)
    {
        this.questionId = questionId;
    }

    public String getOtherText()
    {
        return otherText;
    }

    public void setOtherText(String otherText)
    {
        this.otherText = otherText;
    }
}
