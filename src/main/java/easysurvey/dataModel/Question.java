package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Questions")
public class Question
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long questionId;

    @Column
    private String questionText;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="question_id")
    private Set<PotentialQuestionAnswer> potentialQuestionAnswers = new HashSet<>();

    @OneToMany(mappedBy = "question",cascade = CascadeType.PERSIST)
    private Set<Answer> answers = new HashSet<>();


    public Question() {
    }

    public Question(String questionText) {
        this.questionText = questionText;
    }

    public Set<PotentialQuestionAnswer> getPotentialQuestionAnswers() {
        return potentialQuestionAnswers;
    }


}
