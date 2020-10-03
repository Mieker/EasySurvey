package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Metrics")
public class Metric implements Comparable<Metric>
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String metricText;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="metric_id")
    private Set<PotentialMetricAnswer> potentialMetricAnswers = new HashSet<>();

    @OneToMany(mappedBy = "metric",cascade = CascadeType.PERSIST)
    private Set<MetricAnswer> metricAnswers = new HashSet<>();

    public Metric() {
    }

    public Metric(String metricText) {
        this.metricText = metricText;
    }

    public void setMetricText(String metricText) {
        this.metricText = metricText;
    }

    public Set<PotentialMetricAnswer> getPotentialMetricAnswers() {
        return potentialMetricAnswers;
    }

	public long getId() {
		return id;
	}

    public String getMetricText() {
        return metricText;
    }

    @Override
	public int compareTo(Metric arg0) {
		if (this.getId() < arg0.getId()) {
			return -1;
		} else if (this.getId() > arg0.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
}
