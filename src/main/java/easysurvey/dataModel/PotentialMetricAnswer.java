package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="PotentialMetricAnswer")
public class PotentialMetricAnswer
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;

    @Column
    private String text;

    @OneToMany(mappedBy = "metricAnswer",cascade = CascadeType.PERSIST)
    private Set<Answer> answers = new HashSet<>();

    public PotentialMetricAnswer() {
    }

    public PotentialMetricAnswer(String text) {
        this.text = text;
    }
}