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
    private long intervieweeId;

    private String nickName;



    @ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="Survey_Interviewee",
            joinColumns=@JoinColumn(name="intervieweeId"),
            inverseJoinColumns=@JoinColumn(name="surveyId")
    )
    private Set<Survey> surveys = new HashSet<>();


    //private Set<Answer> answers = new HashSet<>();


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void addSurvey(Survey survey) {
        surveys.add(survey);
    }

    public void removeSurvey(Survey survey) {
        surveys.remove(survey);
    }


//
//    public void addAnswer(Answer answer)
//    {
//        answers.add(answer);
//    }
//
//    public void removeAnswer(Answer answer)
//    {
//       answers.remove(answer);
//    }

    public long getIntervieweeId()
    {
        return intervieweeId;
    }

    public void setIntervieweeId(long intervieweeId)
    {
        this.intervieweeId = intervieweeId;
    }
}
