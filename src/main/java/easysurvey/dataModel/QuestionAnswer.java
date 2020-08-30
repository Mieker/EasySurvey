package easysurvey.dataModel;


import javax.persistence.*;

@Entity
@Table(name="QuestionAnswers")
public class QuestionAnswer implements Comparable<QuestionAnswer>
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

	public long getId() {
		return id;
	}

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
	public int compareTo(QuestionAnswer arg0) {
		if (this.getId() < arg0.getId()) {
			return -1;
		} else if (this.getId() > arg0.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
}
