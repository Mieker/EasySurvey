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
    private long id;

    @Column
    private String text;

    @OneToMany(mappedBy = "questionAnswer",cascade = CascadeType.PERSIST)
    private Set<QuestionAnswer> questionAnswers = new HashSet<>();

    public PotentialQuestionAnswer() {
    }

    public PotentialQuestionAnswer(String text) {
        this.text = text;
    }

	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}
}
