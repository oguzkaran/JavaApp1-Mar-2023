package org.csystem.application.company;

public class CompanyApp {
    private static Manager getManager()
    {
        Manager m = new Manager();

        m.setName("Ali");
        m.setCitizenId("12345678912");
        m.setAddress("İstanbul");
        m.setSalary(40000);
        m.setDepartment("Yazılım");

        return m;
    }

    private static SalesManager getSalesManager()
    {
        SalesManager sm = new SalesManager();

        sm.setName("Veli");
        sm.setCitizenId("12345678916");
        sm.setAddress("İzmir");
        sm.setSalary(30000);
        sm.setDepartment("Pazarlama");
        sm.setExtra(10000);

        return sm;
    }

    private static Worker getWorker()
    {
        Worker w = new Worker();

        w.setName("Selami");
        w.setCitizenId("12345678918");
        w.setAddress("Ankara");
        w.setFeePerHour(100);
        w.setHourPerDay(6);

        return w;
    }

    private static ProjectWorker getProjectWorker()
    {
        ProjectWorker pw = new ProjectWorker();

        pw.setName("Secati");
        pw.setCitizenId("12345678910");
        pw.setAddress("Ankara");
        pw.setFeePerHour(120);
        pw.setHourPerDay(5);
        pw.setExtra(3000);
        pw.setProjectName("Weather Sensor Web Service");

        return pw;
    }

    public static void run()
    {
        HumanResources humanResources = new HumanResources();
        Manager m = getManager();
        Worker w = getWorker();
        SalesManager sm = getSalesManager();
        ProjectWorker pw = getProjectWorker();

        //...

        humanResources.payInsurance(m);
        humanResources.payInsurance(w);
        humanResources.payInsurance(sm);
        humanResources.payInsurance(pw);
    }
}
