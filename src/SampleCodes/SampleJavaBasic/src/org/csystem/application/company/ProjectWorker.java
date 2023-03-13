package org.csystem.application.company;

public class ProjectWorker extends Worker {
    private String m_projectName;
    private double m_extra;

    //...

    public String getProjectName()
    {
        return m_projectName;
    }

    public void setProjectName(String projectName)
    {
        //...
        m_projectName = projectName;
    }

    public double getExtra()
    {
        return m_extra;
    }

    public void setExtra(double extra)
    {
        //...
        m_extra = extra;
    }

    public double calculateInsurancePayment()
    {
        return super.calculateInsurancePayment() + m_extra;
    }
}
