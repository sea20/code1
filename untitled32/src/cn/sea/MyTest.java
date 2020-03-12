package cn.sea;

import cn.sea.dao.SQLDao;
import cn.sea.user.User;
import org.junit.Test;

public class MyTest {
    @Test
    public void a(){
        User user = new User();
        user.setId("2000");
        user.setCoach(true);
        user.setSelfStudy(false);
        new SQLDao().study(user);
    }
    @Test
    public void b(){
        User user = new User();
        user.setId("20010");
        user.setName("啊");
        user.setPassword("a123456a");
        user.setCoach(true);
        user.setSelfStudy(false);
        Boolean register = new SQLDao().register(user);
        System.out.println(register);
    }
    @Test
    public void c(){
        User user = new User();
        user.setId("115");
        user.setName("啊");
        user.setPassword("1111111");
        user.setCoach(true);
        user.setSelfStudy(false);
        Boolean register = new SQLDao().login(user);
        System.out.println(register);
    }

}
