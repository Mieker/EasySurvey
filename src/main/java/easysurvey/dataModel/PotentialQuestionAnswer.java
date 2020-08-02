package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="PotentialQuestionAnswer")
public class PotentialQuestionAnswer
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long Id;

    @Column
    private String text;

    @OneToMany(mappedBy = "questionAnswer",cascade = CascadeType.PERSIST)
    private Set<Answer> answers = new HashSet<>();

    public PotentialQuestionAnswer() {
    }

    public PotentialQuestionAnswer(String text) {
        this.text = text;
    }
}
