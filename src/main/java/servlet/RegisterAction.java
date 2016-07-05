package servlet;
import java.awt.event.ActionEvent;
import java.util.Date;
import java.util.Map;

import org.apache.catalina.User;

import com.sun.corba.se.spi.orbutil.fsm.Action;
import com.sun.corba.se.spi.orbutil.fsm.FSM;
import com.sun.corba.se.spi.orbutil.fsm.Input;

import model.Usre;
import service.RegisterService;
import util.Md5Encode;


public class RegisterAction extends ActionEvent implements Action{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = null;
	private static final String ERROR = null;
	public RegisterAction(Object source, int id, String command) {
		super(source, id, command);
		// TODO Auto-generated constructor stub
	}

	private String username;
    private String password;
    
    private RegisterService registerService;
    public String execute() throws Exception{
        System.out.println("begin action");
        
        
        Usre user=new Usre();
        user.setUsername(username);
        user.setPassword(Md5Encode.MD5Encode(password));
        ((Usre) user).setCredits(10);
        ((Usre) user).setLastVisit(new Date());
        if(this.registerService.Register((User) user)){
            return this.SUCCESS;
        } else{
            return this.ERROR;
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
    
    public void setRegisterService(RegisterService registerService) {
        this.registerService = registerService;
    }
	@Override
	public void doIt(FSM fsm, Input in) {
		// TODO Auto-generated method stub
		
	}
    
}