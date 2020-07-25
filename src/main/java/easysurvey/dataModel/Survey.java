package easysurvey.dataModel;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Survey
{
    private long surveyId;
    private String description;
    private String surveyLink;
    private String editLink;
    private Date startDate;
    private Date endDate;
    private boolean isOpen;

    private Set<Question> questions = new HashSet<>();
    private Set<Interviewee> interviewees = new HashSet<>();

    public void addQuestion(Question question){
        questions.add(question);
    }

    public void removeQuestion(Question question){
        questions.remove(question);
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

    public boolean isOpen()
    {
        return isOpen;
    }

    public void setOpen(boolean open)
    {
        isOpen = open;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Survey survey = (Survey) o;

        return surveyId == survey.surveyId;
    }

    @Override
    public int hashCode()
    {
        return (int) (surveyId ^ (surveyId >>> 32));
    }
}
