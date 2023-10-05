package org.csystem.app.factory;

import java.util.List;
import java.util.Random;

public class NameFactory {
    private final Random m_random = new Random();
    private final List<String> m_nameList;

    public NameFactory()
    {
        m_nameList = List.of("Bartu Çankaya", "Baturhan Şahin", "Eylül Rojin Yılmaz", "Ezgi Akat", "İbrahim Yalçın",
                "Samet Çomaklı", "Sinan Reis Korkmaz", "Ümit Yasin Çoban");
    }

    public List<String> getNames()
    {
        return m_nameList;
    }
}
