package easysurvey.dataModel;

import javax.persistence.*;


@Entity
@Table(name="OfferedAnswers")
public class OfferedAnswer
{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long offeredAnswerId;

    @Column
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
