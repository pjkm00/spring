/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.59
 * Generated at: 2023-06-15 05:31:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.include;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class footer_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/views/include/footer_js.jsp", Long.valueOf(1686789799208L));
  }

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

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
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
      out.write("\r\n");
      out.write("  <!-- Control Sidebar -->\r\n");
      out.write("  <aside class=\"control-sidebar control-sidebar-dark\">\r\n");
      out.write("    <!-- Control sidebar content goes here -->\r\n");
      out.write("    <div class=\"p-3\">\r\n");
      out.write("      <h5>Title</h5>\r\n");
      out.write("      <p>Sidebar content</p>\r\n");
      out.write("    </div>\r\n");
      out.write("  </aside>\r\n");
      out.write("  <!-- /.control-sidebar -->\r\n");
      out.write("\r\n");
      out.write("  <!-- Main Footer -->\r\n");
      out.write("  <footer class=\"main-footer\">\r\n");
      out.write("    <!-- To the right -->\r\n");
      out.write("    <div class=\"float-right d-none d-sm-inline\">\r\n");
      out.write("      Anything you want\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- Default to the left -->\r\n");
      out.write("    <strong>Copyright &copy; 2014-2021 <a href=\"https://adminlte.io\">AdminLTE.io</a>.</strong> All rights reserved.\r\n");
      out.write("  </footer>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- ./wrapper -->\r\n");
      out.write("\r\n");
      out.write("<!-- REQUIRED SCRIPTS -->\r\n");
      out.write("\r\n");
      out.write("<!-- jQuery -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap/plugins/jquery/jquery.min.js\"></script>\r\n");
      out.write("<!-- Bootstrap 4 -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("<!-- AdminLTE App -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/bootstrap/dist/js/adminlte.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/4.7.7/handlebars.min.js\"></script>  \r\n");
      out.write("\t<!-- subMenu에 대한 javascript 템플릿 -->\r\n");
      out.write("<script type=\"text/x-handlebars-template\" id=\"subMenu-list-template\">\r\n");
      out.write("\t{{#each .}}\r\n");
      out.write("          <li class=\"nav-item\">\r\n");
      out.write("            <a href=\"{{murl}}\" class=\"nav-link\">\r\n");
      out.write("              <i class=\"{{micon}}\"></i>\r\n");
      out.write("              <p>{{mname}}</p>\r\n");
      out.write("            </a>\r\n");
      out.write("          </li>\r\n");
      out.write("\t{{/each}} \r\n");
      out.write("</script>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction printData(subMenuList, target, templateObj){\r\n");
      out.write("\t\t let template = Handlebars.compile(templateObj.html());\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t let resultHtml = '';\r\n");
      out.write("\t\t resultHtml += template(subMenuList);\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t target.html(resultHtml);\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction subMenu(mcode){\r\n");
      out.write("\t\tif(mcode != 'M000000'){\r\n");
      out.write("\t\t\t$.ajax({\r\n");
      out.write("\t\t\t\turl : \"");
      out.print(request.getContextPath());
      out.write("/common/subMenu.do?mcode=\" + mcode,\r\n");
      out.write("\t\t\t\tdataType : \"json\",\r\n");
      out.write("\t\t\t\tsuccess : function(data){\r\n");
      out.write("\t\t\t\t\tprintData(data, $('.subMenuList'), $('#subMenu-list-template'));\t\t\t\t\t\r\n");
      out.write("\t\t\t\t},\r\n");
      out.write("\t\t\t\terror : function(res){\r\n");
      out.write("\t\t\t\t\talert(res.status);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t})\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$('.subMenuList').html('');\r\n");
      out.write("\t\t}\r\n");
      out.write("\t};\r\n");
      out.write("\t\r\n");
      out.write("\tfunction goPage(murl, mcode){\r\n");
      out.write("\t\t//HTML5부터 history API를 사용하기 시작함\r\n");
      out.write("\t\t//주소 내역은 하나의 목록이다. 뒤로가기, 앞으로 가기는 목록 안에서 이동하는 것이다.\r\n");
      out.write("\t\t//따라서 목록에 새로운 주소를 추가하면 페이지를 이동한 셈이 된다.\r\n");
      out.write("\t\t//목록에 주소를 추가하기 위한 메서드가 HTML5에서 생겼다.\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tif(typeof(history.pushState) == 'function'){\r\n");
      out.write("\t\t\tlet renewURL = location.href;\r\n");
      out.write("\t\t\trenewURL = renewURL.substring(0, renewURL.indexOf(\".do\") + 3);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tif(mcode != 'M000000'){\r\n");
      out.write("\t\t\t\trenewURL += \"?mcode=\" + mcode;\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t\tconsole.log(renewURL);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t//기본형태 - history.pushState(state, title, url);\r\n");
      out.write("\t\t\t//state : 브라우저 이동 시 넘겨줄 데이터\r\n");
      out.write("\t\t\t//title : 변경할 브라우저 제목 (변경 원치 않으면 null)\r\n");
      out.write("\t\t\t//url : 변경할 주소\r\n");
      out.write("\t\t\thistory.pushState(mcode, null, renewURL);\r\n");
      out.write("\t\t};\r\n");
      out.write("\t\tconsole.log(murl);\r\n");
      out.write("\t\tif(murl != \"/main.do\"){\r\n");
      out.write("\t\t\t$('#if_list').prop('src', \"");
      out.print(request.getContextPath());
      out.write("\" + murl);\r\n");
      out.write("\t\t}else{\r\n");
      out.write("\t\t\t$('#if_list').prop('src', \"\");\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>");
      out.write("\r\n");
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