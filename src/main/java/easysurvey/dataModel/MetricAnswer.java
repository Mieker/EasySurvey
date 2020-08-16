package easysurvey.dataModel;


import javax.persistence.*;

@Entity
@Table(name="MetricAnswers")
public class MetricAnswer implements Comparable<MetricAnswer>
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

	public long getId() {
		return id;
	}
	
	@Override
	public int compareTo(MetricAnswer arg0) {
		if (this.getId() < arg0.getId()) {
			return -1;
		} else if (this.getId() > arg0.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
}
