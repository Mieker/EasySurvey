package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Interviewees")
public class Interviewee implements Comparable<Interviewee>
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String nickName;

    @OneToMany
    @JoinColumn(name="interwivee_id")
    private Set<QuestionAnswer> questionAnswers = new HashSet<>();

    @OneToMany
    @JoinColumn(name="interwivee_id")
    private Set<MetricAnswer> metricAnswers = new HashSet<>();


    public Interviewee() {
    }

    public Interviewee(String nickName) {
        this.nickName = nickName;
    }

    public Set<QuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    public Set<MetricAnswer> getMetricAnswers() {
        return metricAnswers;
    }

	public long getId() {
		return id;
	}
	
	@Override
	public int compareTo(Interviewee arg0) {
		if (this.getId() < arg0.getId()) {
			return -1;
		} else if (this.getId() > arg0.getId()) {
			return 1;
		} else {
			return 0;
		}
	}

}
