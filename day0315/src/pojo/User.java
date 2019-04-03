package pojo;

import java.util.Arrays;

public class User {
    public User(String username, String password, String sex, int age, String[] hobbys) {
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.hobbys = hobbys;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", hobbys=" + Arrays.toString(hobbys) +
                '}';
    }

    private String username;
    private String password;
    private String sex;
    private int age;
    private String[] hobbys;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String[] getHobbys() {
        return hobbys;
    }

    public void setHobbys(String[] hobbys) {
        this.hobbys = hobbys;
    }
}
