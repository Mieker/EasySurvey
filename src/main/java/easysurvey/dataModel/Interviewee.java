package easysurvey.dataModel;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Interviewees")
public class Interviewee
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private String nickName;

    @OneToMany
    @JoinColumn(name="interwivee_id")
    private Set<Answer> answers = new HashSet<>();


    public Interviewee() {
    }

    public Interviewee(String nickName) {
        this.nickName = nickName;
    }

    public Set<Answer> getAnswers() {
        return answers;
    }


}
