package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Questions")
public class Question implements Comparable<Question>
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column
    private String questionText;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="question_id")
    private Set<PotentialQuestionAnswer> potentialQuestionAnswers = new HashSet<>();

    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
    private Set<QuestionAnswer> questionAnswers = new HashSet<>();

    public Question() {
    }

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public Set<PotentialQuestionAnswer> getPotentialQuestionAnswers() {
        return potentialQuestionAnswers;
    }

	public String getQuestionText() {
		return questionText;
	}

	public long getId() {
		return id;
	}

	@Override
	public int compareTo(Question arg0) {
		if (this.getId() < arg0.getId()) {
			return -1;
		} else if (this.getId() > arg0.getId()) {
			return 1;
		} else {
			return 0;
		}
	}


}
