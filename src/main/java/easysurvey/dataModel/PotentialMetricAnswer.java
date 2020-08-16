package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="PotentialMetricAnswer")
public class PotentialMetricAnswer implements Comparable<PotentialMetricAnswer>
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String text;

    @OneToMany(mappedBy = "metricAnswer",cascade = CascadeType.PERSIST)
    private Set<MetricAnswer> metricAnswers = new HashSet<>();

    public PotentialMetricAnswer() {
    }

    public PotentialMetricAnswer(String text) {
        this.text = text;
    }
    
    @Override
	public int compareTo(PotentialMetricAnswer arg0) {
		if (this.getId() < arg0.getId()) {
			return -1;
		} else if (this.getId() > arg0.getId()) {
			return 1;
		} else {
			return 0;
		}
	}

	public long getId() {
		return id;
	}
}