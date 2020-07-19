package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Questions")
public class Question
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long questionId;

    @Column
    private String questionText;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="question_id")
    private Set<OfferedAnswer> offeredAnswers = new HashSet<>();


    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="question_id")
    private Set<Answer> answers = new HashSet<>();


    public void addAnswer(Answer answer){
        answers.add(answer);
    }


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

    public void printOfferedAnswers(){
        for (OfferedAnswer offeredAnswer:offeredAnswers) {
            System.out.println("    possible answer for question id " + questionId +" is: "+ offeredAnswer.getAnswerText());
        }
    }

}
