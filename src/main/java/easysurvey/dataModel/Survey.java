package easysurvey.dataModel;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Surveys")
public class Survey implements java.io.Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String description;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="survey_id")
    private Set<Question> questions = new HashSet<>();

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="survey_id")
    private Set<Metric> metrics = new HashSet<>();

    @OneToMany(mappedBy = "survey",cascade = CascadeType.PERSIST)
    private Set<Answer> answers = new HashSet<>();


    public Survey() {
    }

    public Survey(String description) {
        this.description = description;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public Set<Metric> getMetrics() {
        return metrics;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }
}
