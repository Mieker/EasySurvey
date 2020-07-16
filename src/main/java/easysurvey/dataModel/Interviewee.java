package easysurvey.dataModel;

import java.util.HashSet;
import java.util.Set;

public class Interviewee
{
    private long intervieweeId;
    private Set<Metric> metrics = new HashSet<>();
    private Set<Answer> answers = new HashSet<>();

    public void addMetrics(Metric metric)
    {
        metrics.add(metric);
    }

    public void removeMetrics(Metric metric)
    {
        metrics.remove(metric);
    }

    public void addAnswer(Answer answer)
    {
        answers.add(answer);
    }

    public void removeAnswer(Answer answer)
    {
       answers.remove(answer);
    }

    public long getIntervieweeId()
    {
        return intervieweeId;
    }

    public void setIntervieweeId(long intervieweeId)
    {
        this.intervieweeId = intervieweeId;
    }
}
