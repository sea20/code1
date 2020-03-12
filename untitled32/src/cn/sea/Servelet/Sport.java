package cn.sea.Servelet;

import cn.sea.dao.SQLDao;
import cn.sea.user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sport")
public class Sport extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String basketball = request.getParameter("basketball");
        String football = request.getParameter("football");
        String tableTennis = request.getParameter("tableTennis");
        User user = (User) request.getSession().getAttribute("user");
        if(basketball!=null){
            user.setBasketball(true);
        }
        if(football!=null){
            user.setFootball(true);
        }
        if(tableTennis!=null){
            user.setTableTennis(true);
        }
        new SQLDao().sport(user);
        request.getRequestDispatcher("/submitSuccess.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
