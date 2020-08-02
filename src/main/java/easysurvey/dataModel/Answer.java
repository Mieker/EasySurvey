package easysurvey.dataModel;


import javax.persistence.*;

@Entity
@Table(name="Answers")
public class Answer
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long answerId;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="survey_id")
    private Survey survey;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="question_id")
    private Question question;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="question_answer_id")
    private PotentialQuestionAnswer questionAnswer;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="metric_id")
    private Metric metric;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="metric_answer_id")
    private PotentialMetricAnswer metricAnswer;

    public Answer() {
    }

    public Answer(Survey survey, Question question, PotentialQuestionAnswer questionAnswer) {
        this.survey = survey;
        this.question = question;
        this.questionAnswer = questionAnswer;
    }

    public Answer(Survey survey, Metric metric, PotentialMetricAnswer metricAnswer) {
        this.survey = survey;
        this.metric = metric;
        this.metricAnswer = metricAnswer;
    }

    public void setQuestionAnswer(PotentialQuestionAnswer questionAnswer) {
        this.questionAnswer = questionAnswer;
    }

    public void setMetricAnswer(PotentialMetricAnswer metricAnswer) {
        this.metricAnswer = metricAnswer;
    }
}
