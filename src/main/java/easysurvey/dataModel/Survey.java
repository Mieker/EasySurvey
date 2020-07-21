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
    private long surveyId;

    @Column
    private String description;

    @Column
    private String surveyLink;

    @Column
    private String editLink;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private boolean isOpen;

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name="Survey_Question",
            joinColumns=@JoinColumn(name="surveyId"),
            inverseJoinColumns=@JoinColumn(name="questionId")
    )
    private Set<Question> questions = new HashSet<>();

    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="survey_id")
//    @JoinColumns({@JoinColumn(name="survey_id"),
//            @JoinColumn(name="intervieweeId")
//    })
    private Set<Metric> metrics = new HashSet<>();

//    @OneToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
//    @JoinTable(
//            name="Survey_Interviewee",
//            joinColumns=@JoinColumn(name="surveyId"),
//            inverseJoinColumns=@JoinColumn(name="intervieweeId")
//    )
    @ManyToMany(mappedBy="surveys", cascade={CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Interviewee> interviewees = new HashSet<>();


    public void addMetrics(Metric metric)
    {
        metrics.add(metric);
    }

    public void removeMetrics(Metric metric)
    {
        metrics.remove(metric);
    }


    public void addInterwiee(Interviewee interviewee){
        interviewees.add(interviewee);
    }

    public void removeInterwiee(Interviewee interviewee){
        interviewees.remove(interviewee);
    }

    public void addQuestion(Question question){
        questions.add(question);
    }

    public void removeQuestion(Question question){
        questions.remove(question);
    }

    public void printQuestions(){
        for (Question question: questions) {
            System.out.println("Question id " + question.getQuestionId() + ": " + question.getQuestionText());
            question.printOfferedAnswers();
        }
    }

    public long getSurveyId()
    {
        return surveyId;
    }

    public void setSurveyId(long surveyId)
    {
        this.surveyId = surveyId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getSurveyLink()
    {
        return surveyLink;
    }

    public void setSurveyLink(String surveyLink)
    {
        this.surveyLink = surveyLink;
    }

    public String getEditLink()
    {
        return editLink;
    }

    public void setEditLink(String editLink)
    {
        this.editLink = editLink;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }

    public boolean getIsOpen()
    {
        return isOpen;
    }

    public void setIsOpen(boolean isOpen)
    {
        this.isOpen = isOpen;
    }
}
