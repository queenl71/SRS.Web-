package service;

import org.apache.catalina.User;

import dao.UserDao;

public class RegisterService {
    private UserDao<?> userDao;
    public boolean Register(User user){
        System.out.println("begin Service");
        return userDao.register(user);
        
    }
    public void setUserDao(UserDao<?> userDao) {
        this.userDao = userDao;
    }
    

}