package easysurvey.dataModel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Interviewees")
public class Interviewee implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String nickName;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="interwivee_id")
    private Set<QuestionAnswer> questionAnswers = new HashSet<>();

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="interwivee_id")
    private Set<MetricAnswer> metricAnswers = new HashSet<>();


    public Interviewee() {
    }

    public Interviewee(String nickName) {
        //this.setNickName(nickName);
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    //	@Override
//	public int compareTo(Interviewee arg0) {
//		if (this.getId() < arg0.getId()) {
//			return -1;
//		} else if (this.getId() > arg0.getId()) {
//			return 1;
//		} else {
//			return 0;
//		}
//	}


    @Override
    public String toString() {
        return "Interviewee{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
