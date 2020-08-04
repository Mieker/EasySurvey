package easysurvey.dataModel;


import javax.persistence.*;

@Entity
@Table(name="QuestionAnswers")
public class QuestionAnswer
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="survey_id")
    private Survey survey;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="question_id")
    private Question question;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="question_answer_id")
    private PotentialQuestionAnswer questionAnswer;

    public QuestionAnswer() {
    }

    public QuestionAnswer(Survey survey, Question question, PotentialQuestionAnswer questionAnswer) {
        this.survey = survey;
        this.question = question;
        this.questionAnswer = questionAnswer;
    }

    public void setQuestionAnswer(PotentialQuestionAnswer questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

}
