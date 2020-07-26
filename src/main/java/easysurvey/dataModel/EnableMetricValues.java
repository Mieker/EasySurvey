package easysurvey.dataModel;

import javax.persistence.*;

@Entity
@Table(name="EnableMetricValues")
public class EnableMetricValues
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int enableValueId;

    @Column
    private int fieldId;

    @Column
    private String enableMetricValue;

    public int getEnableValueId()
    {
        return enableValueId;
    }

    public void setEnableValueId(int enableValueId)
    {
        this.enableValueId = enableValueId;
    }

    public int getFieldId()
    {
        return fieldId;
    }

    public void setFieldId(int fieldId)
    {
        this.fieldId = fieldId;
    }

    public String getEnableMetricValue()
    {
        return enableMetricValue;
    }

    public void setEnableMetricValue(String enableMetricValue)
    {
        this.enableMetricValue = enableMetricValue;
    }
}
