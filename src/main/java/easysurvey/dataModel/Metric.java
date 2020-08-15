package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Metrics")
public class Metric
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String metricText;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="metric_id")
    private Set<PotentialMetricAnswer> potentialMetricAnswers = new HashSet<>();

    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
    private Set<QuestionAnswer> questionAnswers = new HashSet<>();

    @OneToMany(mappedBy = "metric",cascade = CascadeType.PERSIST)
    private Set<MetricAnswer> metricAnswers = new HashSet<>();

    public Metric() {
    }

    public Metric(String metricText) {
        this.metricText = metricText;
    }

    public Set<PotentialMetricAnswer> getPotentialMetricAnswers() {
        return potentialMetricAnswers;
    }

	public long getId() {
		return id;
	}
}
