package service;
import org.apache.catalina.User;

import dao.UserDao;
import model.Usre;

public class LoginService {
	 private UserDao<?> userdao;
	    public boolean login(Usre user) throws Exception{
	        boolean flag=false;
	        if(userdao.checkUser(user.getUsername(), user.getPassword())){
	            flag=true;
	        }
	        return flag;
	    }
	    public void setUserdao(UserDao<?> userdao) {
	        this.userdao = userdao;
	    }

}
