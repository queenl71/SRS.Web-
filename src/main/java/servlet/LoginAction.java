package servlet;
import java.awt.event.ActionEvent;
import java.util.Map;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import model.Usre;
import service.LoginService;
import util.Md5Encode;

public class LoginAction extends ActionEvent implements Action{
    public LoginAction(Object source, int id, String command) {
		super(source, id, command);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID  =   1L ;
	private static final String SUCCESS = null;
	private static final String ERROR = null;
    private String username;
    private String password;
    
    private LoginService loginService;
    
    public void validate()
    {
        
    }
    
    
    public String execute() throws Exception
    {	
        
        Usre user=new Usre();
        user.setUsername(username);
        user.setPassword(Md5Encode.MD5Encode(password));
        boolean result=this.loginService.login(user);
        if(result){
            return this.SUCCESS;
        }else{
            return this.ERROR ;
        }	
        
    }

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

    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }


	@Override
	public void doIt(FSM fsm, Input in) {
		// TODO Auto-generated method stub
		
	}
    
    
    
}