package mum.customtag;


import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * Custom tag
 * 
 * @author Tan Tho Nguyen
 * @date 2018-03-21
 */
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
