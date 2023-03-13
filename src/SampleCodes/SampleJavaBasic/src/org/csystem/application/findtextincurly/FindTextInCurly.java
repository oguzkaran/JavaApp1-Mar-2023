package org.csystem.application.findtextincurly;

public class FindTextInCurly {
	private String m_text;
	private String m_result;
	private boolean valid;
	
	public FindTextInCurly(String txt)
	{
		m_text = txt;
		m_result = m_text;
		valid = true;
	}
	
	public void findText()
	{
		for (;;) {
			int begin = m_result.indexOf("{");
			int end = m_result.lastIndexOf("}");
			
			if (begin == -1 && end != -1 || begin > end) {
				valid = false;
				break;
			}
			
			if (end == -1)
				break;
			
			m_result = m_result.substring(begin + 1, end);
		}
	}

	public String getText()
	{
		return m_text;
	}

	public void setText(String text)
	{
		m_text = text;
	}

	public String getResult()
	{
		return m_result;
	}

	public boolean isValid()
	{
		return valid;
	}
}

