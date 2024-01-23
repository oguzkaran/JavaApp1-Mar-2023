/*----------------------------------------------------------
	FILE			: StringList.java
	AUTHOR			: Java-Nov-2022 Group
	LAST UPDATE		: 23.07.2023

	StringList class

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

        for (Object o : m_list) {
            String s = (String)o;

            sb.append(s);
        }

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

        for (Object o : m_list) {
            String s = (String)o;

            sb.append(s).append(separator);
        }

        return sb.substring(0, sb.length() - separator.length());
    }

    //...
}
