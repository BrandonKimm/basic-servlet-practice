package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("RequestParamServlet.service");

        System.out.println("[전체파라미터 조회 start]");
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + "=" + request.getParameter(paramName)));
        System.out.println("[전체파라미터 조회 end]");
        System.out.println();

        System.out.println("[단일파라미터 조회 start");
        String username = request.getParameter("username");
        String age = request.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("username = " + username);
        System.out.println("[단일파라미터 조회 end]");

        System.out.println("[중복파라미터 조회 start]");
        String[] usernames = request.getParameterValues("username");
        System.out.println(Arrays.stream(usernames).count());
        Arrays.stream(usernames).forEach(a -> System.out.println(a));
        System.out.println("[중복파라미터 조회 end]");

        response.getWriter().write("ok");

    }
}
