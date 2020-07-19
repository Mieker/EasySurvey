package easysurvey.dataModel;


import javax.persistence.*;

@Entity
@Table(name="Answers")
public class Answer
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long answerId;

    @JoinColumn(name="intervieweeId")
    private long intervieweeId;

    @JoinColumn(name="offeredAnswerId")
    private long offeredAnswerId;

    @JoinColumn(name="questionId")
    private long questionId;


    public long getSurveyId()
    {
        return answerId;
    }

    public void setSurveyId(long surveyId)
    {
        this.answerId = surveyId;
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
}
