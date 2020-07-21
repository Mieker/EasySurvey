package easysurvey.dataModel;


import javax.persistence.*;

@Entity
@Table(name="Answers")
public class Answer
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long answerId;

    @Column
    private long surveyId;

    @Column
    private long offeredAnswerId;

    @Column
    private long questionId;

    public long getSurveyId() {
        return surveyId;
    }

    public void setSurveyId(long surveyId) {
        this.surveyId = surveyId;
    }

    public long getAnswerId()
    {
        return answerId;
    }

    public void setAnswerId(long answerId)
    {
        this.answerId = answerId;
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
