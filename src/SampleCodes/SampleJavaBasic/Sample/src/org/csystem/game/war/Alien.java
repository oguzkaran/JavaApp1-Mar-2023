package org.csystem.game.war;

public class Alien {
    private String m_title = "";
    private Color m_color = Color.BLACK;
    //...

    public String getTitle()
    {
        return m_title;
    }

    public Alien setTitle(String title)
    {
        //...
        m_title = title;

        return this;
    }

    public Color getColor()
    {
        return m_color;
    }

    public Alien setColor(Color color)
    {
        //...
        m_color = color;

        return this;
    }

    public String toString()
    {
        return String.format("[%s]%s", m_title, m_color.toString());
    }
}
