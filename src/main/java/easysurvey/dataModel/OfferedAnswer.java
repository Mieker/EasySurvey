package easysurvey.dataModel;

public class OfferedAnswer
{
    private long offeredAnswerId;
    private String answerText;

    public long getOfferedAnswerId()
    {
        return offeredAnswerId;
    }

    public void setOfferedAnswerId(long offeredAnswerId)
    {
        this.offeredAnswerId = offeredAnswerId;
    }

    public String getAnswerText()
    {
        return answerText;
    }

    public void setAnswerText(String answerText)
    {
        this.answerText = answerText;
    }
}
