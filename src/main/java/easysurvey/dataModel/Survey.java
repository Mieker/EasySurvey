package easysurvey.dataModel;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Surveys")
public class Survey implements java.io.Serializable, Comparable<Survey>
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String title;
    
    @Column
    private String description;

    @Column
    private String surveyLink;

    @Column
    private String editLink;

    @Column
    private LocalDate startDate;

    @Column
    private LocalDate endDate;

    @Column
    private boolean isOpen;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="survey_id")
    private Set<Question> questions = new HashSet<>();

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="survey_id")
    private Set<Metric> metrics = new HashSet<>();

    @OneToMany(mappedBy = "survey",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<QuestionAnswer> questionAnswers = new HashSet<>();

    @OneToMany(mappedBy = "survey",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<MetricAnswer> metricAnswers = new HashSet<>();


    public Survey() {
    }

    public Survey(String description, String surveyLink, String editLink, LocalDate startDate, LocalDate endDate, boolean isOpen) {
        this.setDescription(description);
        this.surveyLink = surveyLink;
        this.editLink = editLink;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isOpen = isOpen;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Set<Metric> getMetrics() {
        return metrics;
    }

    public Set<QuestionAnswer> getQuestionAnswers() {
        return questionAnswers;
    }

    public Set<MetricAnswer> getMetricAnswers() {
        return metricAnswers;
    }

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}
	
	@Override
	public int compareTo(Survey arg0) {
		if (this.getId() < arg0.getId()) {
			return -1;
		} else if (this.getId() > arg0.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
}
