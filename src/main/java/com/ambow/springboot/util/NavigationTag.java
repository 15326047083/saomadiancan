package com.ambow.springboot.util;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class NavigationTag extends TagSupport {
    static final long serialVersionUID = 2372405317744358833L;

    private String bean = "page";

    private String url = null;

    private int number = 5;

    @Override
    public int doStartTag() throws JspException {
        JspWriter writer = pageContext.getOut();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Page page = (Page) request.getAttribute(bean);
        if (page == null)
            return SKIP_BODY;
        url = resolveUrl(url, pageContext);
        try {

            int pageCount = page.getTotal() / page.getSize();
            if (page.getTotal() % page.getSize() > 0) {
                pageCount++;
            }
            writer.print("<nav><ul class=\"pagination\">");

            String homeUrl = append(url, "page", 1);

            String backUrl = append(url, "page", pageCount);

            if (page.getPage() > 1) {
                String preUrl = append(url, "page", page.getPage() - 1);
                preUrl = append(preUrl, "rows", page.getSize());
                writer.print("<li><a href=\"" + homeUrl + "\">" + "首页</a></li>");
                writer.print("<li><a href=\"" + preUrl + "\">" + "上一页</a></li>");
            } else {
                writer.print("<li class=\"disabled\"><a href=\"#\">" + "首页</a></li>");
                writer.print("<li class=\"disabled\"><a href=\"#\">" + "上一页 </a></li>");
            }

            int indexPage = 1;
            if (page.getPage() - 2 <= 0) {
                indexPage = 1;
            } else if (pageCount - page.getPage() <= 2) {
                if (pageCount < 5) {
                    indexPage = 1;
                } else {
                    indexPage = pageCount - 4;
                }
            } else {
                indexPage = page.getPage() - 2;
            }
            for (int i = 1; i <= number && indexPage <= pageCount; indexPage++, i++) {
                if (indexPage == page.getPage()) {
                    writer.print("<li class=\"active\"><a href=\"#\">" + indexPage
                            + "<spanclass=\"sr-only\"></span></a></li>");
                    continue;
                }
                String pageUrl = append(url, "page", indexPage);
                pageUrl = append(pageUrl, "rows", page.getSize());
                writer.print("<li><a href=\"" + pageUrl + "\">" + indexPage + "</a></li>");
            }

            if (page.getPage() < pageCount) {
                String nextUrl = append(url, "page", page.getPage() + 1);
                nextUrl = append(nextUrl, "rows", page.getSize());
                writer.print("<li><a href=\"" + nextUrl + "\">" + "下一页</a></li>");
                writer.print("<li><a href=\"" + backUrl + "\">" + "尾页</a></li>");
            } else {
                writer.print("<li class=\"disabled\"><a href=\"#\">" + "下一页</a></li>");
                writer.print("<li class=\"disabled\"><a href=\"#\">" + "尾页</a></li>");
            }
            writer.print("</nav>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    private String append(String url, String key, int value) {
        return append(url, key, String.valueOf(value));
    }


    private String append(String url, String key, String value) {
        if (url == null || url.trim().length() == 0) {
            return "";
        }
        if (url.indexOf("?") == -1) {
            url = url + "?" + key + "=" + value;
        } else {
            if (url.endsWith("?")) {
                url = url + key + "=" + value;
            } else {
                url = url + "&amp;" + key + "=" + value;
            }
        }
        return url;
    }

    private String resolveUrl(String url, javax.servlet.jsp.PageContext pageContext) throws JspException {
        Map params = pageContext.getRequest().getParameterMap();
        for (Object key : params.keySet()) {
            if ("page".equals(key) || "rows".equals(key)) {
                continue;
            }
            Object value = params.get(key);
            if (value == null) {
                continue;
            }
            if (value.getClass().isArray()) {
                url = append(url, key.toString(), ((String[]) value)[0]);
            } else if (value instanceof String) {
                url = append(url, key.toString(), value.toString());
            }
        }
        return url;
    }

    public String getBean() {
        return bean;
    }

    public void setBean(String bean) {
        this.bean = bean;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}