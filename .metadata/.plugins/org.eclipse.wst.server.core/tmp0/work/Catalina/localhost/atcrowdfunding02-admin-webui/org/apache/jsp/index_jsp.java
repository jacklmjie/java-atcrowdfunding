/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.37
 * Generated at: 2020-08-31 03:43:55 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<!-- http://localhost:8080/atcrowdfunding02-admin-webui/test/ssm.html -->\r\n");
      out.write("<base\r\n");
      out.write("\thref=\"http://");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.serverName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(':');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.serverPort }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/\" />\r\n");
      out.write("<script type=\"text/javascript\" src=\"jquery/jquery-2.1.1.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#btn1\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\"url\" : \"send/array/one.html\", // 请求目标资源的地址\r\n");
      out.write("\t\t\t\t\"type\" : \"post\", // 请求方式\r\n");
      out.write("\t\t\t\t\"data\" : { // 要发送的请求参数\r\n");
      out.write("\t\t\t\t\t\"array\" : [ 5, 8, 12 ]\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"dataType\" : \"text\", // 如何对待服务器端返回的数据\r\n");
      out.write("\t\t\t\t\"success\" : function(response) { // 服务器端成功处理请求后调用的回调函数，response是响应体数据\r\n");
      out.write("\t\t\t\t\talert(response);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"error\" : function(response) { // 服务器端处理请求失败后调用的回调函数，response是响应体数据\r\n");
      out.write("\t\t\t\t\talert(response);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#btn2\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\"url\" : \"send/array/two.html\", // 请求目标资源的地址\r\n");
      out.write("\t\t\t\t\"type\" : \"post\", // 请求方式\r\n");
      out.write("\t\t\t\t\"data\" : { // 要发送的请求参数\r\n");
      out.write("\t\t\t\t\t\"array[0]\" : 5,\r\n");
      out.write("\t\t\t\t\t\"array[1]\" : 8,\r\n");
      out.write("\t\t\t\t\t\"array[2]\" : 12\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"dataType\" : \"text\", // 如何对待服务器端返回的数据\r\n");
      out.write("\t\t\t\t\"success\" : function(response) { // 服务器端成功处理请求后调用的回调函数，response是响应体数据\r\n");
      out.write("\t\t\t\t\talert(response);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"error\" : function(response) { // 服务器端处理请求失败后调用的回调函数，response是响应体数据\r\n");
      out.write("\t\t\t\t\talert(response);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#btn3\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 准备好要发送到服务器端的数组\r\n");
      out.write("\t\t\tvar array = [ 5, 8, 12 ];\r\n");
      out.write("\t\t\tconsole.log(array.length);\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 将JSON数组转换为JSON字符串\r\n");
      out.write("\t\t\tvar requestBody = JSON.stringify(array);\r\n");
      out.write("\t\t\t// \"['5','8','12']\"\r\n");
      out.write("\t\t\tconsole.log(requestBody.length);\r\n");
      out.write("\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\"url\" : \"send/array/three.html\", // 请求目标资源的地址\r\n");
      out.write("\t\t\t\t\"type\" : \"post\", // 请求方式\r\n");
      out.write("\t\t\t\t\"data\" : requestBody, // 请求体\r\n");
      out.write("\t\t\t\t\"contentType\" : \"application/json;charset=UTF-8\", // 设置请求体的内容类型，告诉服务器端本次请求的请求体是JSON数据\r\n");
      out.write("\t\t\t\t\"dataType\" : \"text\", // 如何对待服务器端返回的数据\r\n");
      out.write("\t\t\t\t\"success\" : function(response) { // 服务器端成功处理请求后调用的回调函数，response是响应体数据\r\n");
      out.write("\t\t\t\t\talert(response);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"error\" : function(response) { // 服务器端处理请求失败后调用的回调函数，response是响应体数据\r\n");
      out.write("\t\t\t\t\talert(response);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t$(\"#btn4\").click(function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 准备要发送的数据\r\n");
      out.write("\t\t\tvar student = {\r\n");
      out.write("\t\t\t\t\"stuId\" : 5,\r\n");
      out.write("\t\t\t\t\"stuName\" : \"tom\",\r\n");
      out.write("\t\t\t\t\"address\" : {\r\n");
      out.write("\t\t\t\t\t\"province\" : \"广东\",\r\n");
      out.write("\t\t\t\t\t\"city\" : \"深圳\",\r\n");
      out.write("\t\t\t\t\t\"street\" : \"后瑞\"\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"subjectList\" : [ {\r\n");
      out.write("\t\t\t\t\t\"subjectName\" : \"JavaSE\",\r\n");
      out.write("\t\t\t\t\t\"subjectScore\" : 100\r\n");
      out.write("\t\t\t\t}, {\r\n");
      out.write("\t\t\t\t\t\"subjectName\" : \"SSM\",\r\n");
      out.write("\t\t\t\t\t\"subjectScore\" : 99\r\n");
      out.write("\t\t\t\t} ],\r\n");
      out.write("\t\t\t\t\"map\" : {\r\n");
      out.write("\t\t\t\t\t\"k1\" : \"v1\",\r\n");
      out.write("\t\t\t\t\t\"k2\" : \"v2\"\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t};\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 将JSON对象转换为JSON字符串\r\n");
      out.write("\t\t\tvar requestBody = JSON.stringify(student);\r\n");
      out.write("\r\n");
      out.write("\t\t\t// 发送Ajax请求\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\t\"url\" : \"send/compose/object.json\",\r\n");
      out.write("\t\t\t\t\"type\" : \"post\",\r\n");
      out.write("\t\t\t\t\"data\" : requestBody,\r\n");
      out.write("\t\t\t\t\"contentType\" : \"application/json;charset=UTF-8\",\r\n");
      out.write("\t\t\t\t\"dataType\" : \"json\",\r\n");
      out.write("\t\t\t\t\"success\" : function(response) {\r\n");
      out.write("\t\t\t\t\tconsole.log(response);\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\t\"error\" : function(response) {\r\n");
      out.write("\t\t\t\t\tconsole.log(response);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\r\n");
      out.write("\t\t});\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<a href=\"test/ssm.html\">测试SSM整合环境</a>\r\n");
      out.write("\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\r\n");
      out.write("\t<button id=\"btn1\">Send [5,8,12] One</button>\r\n");
      out.write("\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\r\n");
      out.write("\t<button id=\"btn2\">Send [5,8,12] Two</button>\r\n");
      out.write("\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\r\n");
      out.write("\t<button id=\"btn3\">Send [5,8,12] Three</button>\r\n");
      out.write("\r\n");
      out.write("\t<br />\r\n");
      out.write("\t<br />\r\n");
      out.write("\r\n");
      out.write("\t<button id=\"btn4\">Send Compose Object</button>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
