package cn.sea.dao;

import cn.sea.user.User;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * 执行mysql
 */
public class SQLDao {
    private static JdbcTemplate jt;
    static{
        try {
            InputStream is = SQLDao.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties pro = new Properties();
            pro.load(is);
            DataSource ds = DruidDataSourceFactory.createDataSource(pro);
            jt = new JdbcTemplate(ds);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void study(User user){
        String sql = "replace into study values(?,?,?)"; //id 自习 辅导
        jt.update(sql,user.getId(),user.getSelfStudy(),user.getCoach());
    }
    public Boolean register(User user) {
        //Boolean res = false;
        String sql1 = "select id from user where id =?";
        List<Map<String, Object>> maps = jt.queryForList(sql1,user.getId());
        if(maps.size()==0){
            String sql2 = "insert into user values(?,?,?)";
            jt.update(sql2, user.getId(), user.getName(), user.getPassword());
            return true;
        }
        return false;
    }
    public void sport(User user){
        String sql = "replace into sport values(?,?,?,?)"; // id 篮球 足球 乒乓球
        jt.update(sql,user.getId(),user.getBasketball(),user.getFootball(),user.getTableTennis());
    }
    public Boolean login(User user){
        String sql1 = "select password from user where id =?";
        List<Map<String, Object>> maps = jt.queryForList(sql1,user.getId());
        System.out.println(maps.size());
        if(maps.size()!=0){
            for (Map<String, Object> map : maps) {
                String s = null;
                Object password = map.get("password");
                s = String.valueOf(password);
                if(s.equals(user.getPassword())){
                    //System.out.println("登录");
                    load(user);
                    return true;
                }
            }
        }
        return false;
    }
    public static void load(User user){
        String sql1 = "select name from user where id =?";
        List<Map<String, Object>> maps = jt.queryForList(sql1,user.getId());
        String s = null;
        if(maps.size()!=0){
            for (Map<String, Object> map : maps) {
                Object name = map.get("name");
                s = String.valueOf(name);
                user.setName(s);
            }
        }
    }
}
