package easysurvey.dataModel;


import javax.persistence.*;

@Entity
@Table(name="MetricAnswers")
public class MetricAnswer
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="survey_id")
    private Survey survey;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="metric_id")
    private Metric metric;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    @JoinColumn(name="metric_answer_id")
    private PotentialMetricAnswer metricAnswer;

    public MetricAnswer() {
    }

    public MetricAnswer(Survey survey, Metric metric, PotentialMetricAnswer metricAnswer) {
        this.survey = survey;
        this.metric = metric;
        this.metricAnswer = metricAnswer;
    }

    public void setMetricAnswer(PotentialMetricAnswer metricAnswer) {
        this.metricAnswer = metricAnswer;
    }
}
