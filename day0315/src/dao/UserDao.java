package dao;


import pojo.User;

import java.util.*;

public class UserDao {
    private static Map<String, User> users;
    static{
        users=new HashMap<String,User>();
        for (int i = 1; i <10 ; i++) {
            users.put("admin"+i,new User("admin"+i,
                    "666666",Math.random()>0.5?"男":"女",15+new Random().nextInt(20),
                    new String[]{"足球","篮球","购物","看电影"}));
        }
    }

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    public Map<String,Object> login(String username, String password) {
        User user = users.get(username);
        Map<String, Object> result = new HashMap<String, Object>();
        if (user == null) {
            result.put("flag", false);
            result.put("msg", "用户不存在");
        } else {
            if (user.getPassword().equals(password)) {
                result.put("flag", true);
                result.put("msg", user);
            } else {
                result.put("flag", false);
                result.put("msg", "密码不正确");
            }
        }
        return result;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    public boolean addUser(User user)
    {
        if(users.containsKey(user.getUsername()))
        {
            return false;
        }
        users.put(user.getUsername(),user);
        return true;
    }
    public List<User> getAllUsers()
    {
        List<User> lstUsers=new ArrayList<User>();
        Set<String> keySets = users.keySet();
        for(String key:keySets)
        {
            lstUsers.add(users.get(key));

        }
        return lstUsers;
    }

}
