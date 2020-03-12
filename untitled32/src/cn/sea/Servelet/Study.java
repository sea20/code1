package cn.sea.Servelet;

import cn.sea.dao.SQLDao;
import cn.sea.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/study")
public class Study extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String selfStudy = request.getParameter("selfStudy");
        String coach = request.getParameter("coach");
        User user = (User) request.getSession().getAttribute("user");
        if(selfStudy!=null){
            user.setSelfStudy(true);
        }
        if(coach!=null){
            user.setCoach(true);
        }
        new SQLDao().study(user);
        request.getRequestDispatcher("/submitSuccess.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
