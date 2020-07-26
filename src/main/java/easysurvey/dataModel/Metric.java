package easysurvey.dataModel;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Metrics")
public class Metric
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long fieldId;

    @Column(name = "survey_id")
    private int surveyId;

    @Column
    private String fieldName;

    @Column
    private String fieldType;

    @OneToMany(cascade={CascadeType.ALL })
    @JoinColumn(name="fieldId")
    private Set<EnableMetricValues> enableMetricValues = new HashSet<>();


    public void addEnableValue(EnableMetricValues enableMetricValue){
        enableMetricValues.add(enableMetricValue);
    }

    public long getFieldId()
    {
        return fieldId;
    }

    public void setFieldId(long fieldId)
    {
        this.fieldId = fieldId;
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
}
