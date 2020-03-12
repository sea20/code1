package cn.sea.Servelet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码
 * @author a
 */
@WebServlet("/code")
public class Code extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = image.getGraphics();
        g.setColor(Color.ORANGE);
        g.fillRect(0,0,width-1,height-1);
        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890";
        Random ran = new Random();
        StringBuilder code = new StringBuilder();
        g.setColor(Color.red);
        for (int i = 1; i <= 4; i++) {
            char ch = str.charAt(ran.nextInt(str.length()));
            code.append(ch);
            g.drawString(ch+"",width/5*i,height/2);
        }
        g.setColor(Color.BLACK);
        for (int j = 0; j < 5; j++) {
            g.drawLine(ran.nextInt(width),ran.nextInt(height),ran.nextInt(width),ran.nextInt(height));
        }
        request.getSession().setAttribute("code",code);
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
