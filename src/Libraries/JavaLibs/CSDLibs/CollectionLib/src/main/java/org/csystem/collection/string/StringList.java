/*----------------------------------------------------------
	FILE			: StringList.java
	AUTHOR			: JavaApp1-Mar-2023 Group
	LAST UPDATE		: 13.07.2023

	StringList class used as a list of collections

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
------------------------------------------------------------*/
package org.csystem.collection.string;

import java.util.ArrayList;

public class StringList {
    private final ArrayList<String> m_list = new ArrayList<>();

    public boolean add(String str)
    {
        return str != null && m_list.add(str);
    }

    public String concat()
    {
        if (m_list.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();

        for (var s : m_list)
            sb.append(s);

        return sb.toString();
    }

    public String concat(char separator)
    {
        return concat(String.valueOf(separator));
    }

    public String concat(String separator)
    {
        if (m_list.isEmpty())
            return "";

        StringBuilder sb = new StringBuilder();

        for (var s : m_list)
            sb.append(s).append(separator);
        return sb.substring(0, sb.length() - separator.length());
    }

    @Override
    public String toString()
    {
        throw new UnsupportedOperationException("Not implemented yet!...");
    }

    //...
}
