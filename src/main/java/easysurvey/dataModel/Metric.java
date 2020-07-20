package easysurvey.dataModel;

import javax.persistence.*;


@Entity
@Table(name="Metrics")
public class Metric
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long metricsId;

    @Column
    private String fieldName;

    @Column
    private String fieldType;

    @Column
    private String fieldValue;

    public long getMetricsId()
    {
        return metricsId;
    }

    public void setMetricsId(long metricsId)
    {
        this.metricsId = metricsId;
    }

    public String getFieldName()
    {
        return fieldName;
    }

    public void setFieldName(String fieldName)
    {
        this.fieldName = fieldName;
    }

    public String getFieldType()
    {
        return fieldType;
    }

    public void setFieldType(String fieldType)
    {
        this.fieldType = fieldType;
    }

    public String getFieldValue()
    {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue)
    {
        this.fieldValue = fieldValue;
    }
}
