package cn.sea.Servelet;

import cn.sea.dao.SQLDao;
import cn.sea.user.User;
import com.sun.javaws.IconUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/regist")
public class Regist extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp; charset=utf-8");
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        request.getSession().setAttribute("name",name);
        String code = "1";//防止未输入验证码就提交产生空指针异常
        code = request.getParameter("code");
        //System.out.println("----");
        //System.out.println(request.getSession().getAttribute("code"));
        //request.setAttribute("name",name);
        Object code1 = request.getSession().getAttribute("code");
        if(code1.toString().equalsIgnoreCase(code)){
            User user = new User();
            user.setName(name);
            user.setId(id);
            user.setPassword(password);
            Boolean flag = new SQLDao().register(user);
            if(flag==false){
                request.getSession().setAttribute("idError","学号已存在重复");
                request.getRequestDispatcher("/regist.jsp").forward(request,response);
            }else {
                request.getSession().setAttribute("name",user.getName());
                request.getSession().setAttribute("user",user);
                response.setStatus(302);
                String path = URLEncoder.encode("邀约界面", "utf-8");
                response.sendRedirect("/sea/"+path+"/index.jsp");
            }
        }else{
            request.getSession().setAttribute("codeError","验证码错误");
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            //request.getRequestDispatcher("/邀约界面/index.jsp").forward(request,response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
