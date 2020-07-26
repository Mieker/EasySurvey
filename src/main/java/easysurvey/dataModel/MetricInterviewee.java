package easysurvey.dataModel;


import javax.persistence.*;

@Entity
@Table(name = "Metric_Interviewee")
public class MetricInterviewee
{
//    @Id
//    private long metricIntervieweeId;

    @Id
    private int intervieweeId;


    @Column
    private int fieldId;


    @Column
    private int enableValueId;

//    public long getMetricIntervieweeId()
//    {
//        return metricIntervieweeId;
//    }
//
//    public void setMetricIntervieweeId(long metricIntervieweeId)
//    {
//        this.metricIntervieweeId = metricIntervieweeId;
//    }

    public int getIntervieweeId()
    {
        return intervieweeId;
    }

    public void setIntervieweeId(int intervieweeId)
    {
        this.intervieweeId = intervieweeId;
    }

    public int getFieldId()
    {
        return fieldId;
    }

    public void setFieldId(int fieldId)
    {
        this.fieldId = fieldId;
    }

    public int getEnableValueId()
    {
        return enableValueId;
    }

    public void setEnableValueId(int enableValueId)
    {
        this.enableValueId = enableValueId;
    }
}
