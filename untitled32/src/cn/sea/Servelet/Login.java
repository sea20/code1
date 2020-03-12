package cn.sea.Servelet;

import cn.sea.dao.SQLDao;
import cn.sea.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/login")
public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = new User();
        user.setPassword(request.getParameter("password"));
        user.setId(request.getParameter("id"));
        Boolean flag = new SQLDao().login(user);
        if(flag==true){
            request.getSession().setAttribute("name",user.getName());
            request.getSession().setAttribute("user",user);
            response.setStatus(302);
            String path = URLEncoder.encode("邀约界面", "utf-8");
            response.sendRedirect("/sea/"+path+"/index.jsp");
        }else{
            request.getSession().setAttribute("loginError","学号或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
