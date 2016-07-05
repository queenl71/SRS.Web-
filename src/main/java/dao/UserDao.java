package dao;

import org.apache.catalina.User;

import daoImpl.mock.IUserDao;
import model.Usre;

public class UserDao<JdbcTemplate> implements IUserDao  {
    private JdbcTemplate jdbcTemplate;
    
    //注入
    
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    public void addUser1(User user) {
        // TODO Auto-generated method stub
        
    }

    

    public void delUser1(User user) {
        // TODO Auto-generated method stub
        
    }

    public User findUserByName1(String username) {
        // TODO Auto-generated method stub
        return null;
    }

    public void updateUser1(User user) {
        // TODO Auto-generated method stub
        
    }

  

 

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
}