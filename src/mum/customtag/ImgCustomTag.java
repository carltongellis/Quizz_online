package mum.customtag;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ImgCustomTag extends SimpleTagSupport {
	String src;
	String alt;
	String className;

	@Override
	public void doTag() throws JspException, IOException {
		JspWriter out = getJspContext().getOut();

		out.write(String.format("<img alt=%s src=%s class=%s>", alt, src, className));
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public void setAlt(String alt) {
		this.alt = alt;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}

}
