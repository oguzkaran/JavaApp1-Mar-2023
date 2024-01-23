package org.csystem.app.io.file.data;

import java.io.*;

public class Sensor implements Serializable {
    @Serial
    private static final long serialVersionUID = -1L;

    private int m_id;
    private String m_name;
    private String m_description = "No description yet!...";
    private ConnectionInfo m_connectionInfo;

    @Serial
    private void writeObject(ObjectOutputStream oos) throws IOException
    {
        oos.writeInt(m_id);
        oos.writeUTF(m_name);
        oos.writeInt(m_connectionInfo.getPortNum());
        oos.writeUTF(m_connectionInfo.getHost());
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException
    {
        m_id = ois.readInt();
        m_name = ois.readUTF();
        m_connectionInfo = new ConnectionInfo(ois.readInt(), ois.readUTF());
    }

    public Sensor(int id, String name, ConnectionInfo connectionInfo)
    {
        m_id = id;
        m_name = name;
        m_connectionInfo = connectionInfo;
    }

    public int getId()
    {
        return m_id;
    }

    public void setId(int id)
    {
        m_id = id;
    }

    public String getName()
    {
        return m_name;
    }

    public void setName(String name)
    {
        m_name = name;
    }

    public String getDescription()
    {
        return m_description;
    }

    public void setDescription(String description)
    {
        m_description = description;
    }

    public ConnectionInfo getConnectionInfo()
    {
        return m_connectionInfo;
    }

    public void setConnectionInfo(ConnectionInfo connectionInfo)
    {
        m_connectionInfo = connectionInfo;
    }

    public String toString()
    {
        return String.format("[%d]%s", m_id, m_name);
    }
}