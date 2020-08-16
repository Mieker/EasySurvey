package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="PotentialQuestionAnswer")
public class PotentialQuestionAnswer implements Comparable<PotentialQuestionAnswer>
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
	
	@Override
	public int compareTo(PotentialQuestionAnswer arg0) {
		if (this.getId() < arg0.getId()) {
			return -1;
		} else if (this.getId() > arg0.getId()) {
			return 1;
		} else {
			return 0;
		}
	}
}
