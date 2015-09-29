package com.myneu.project.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.mvc.SimpleFormController;
import com.myneu.project.Dao.UsersDao;
import com.myneu.project.pojo.Users;
@SuppressWarnings("deprecation")
@Controller("/adduser.htm")
public class TestSimpleFormController extends SimpleFormController {
    public TestSimpleFormController()
    {
    	setFormView("registration");
    	setSuccessView("successregistration");
    	setCommandName("users");
    	setCommandClass(Users.class);
    	//setValidator(new UserValidator());
    }
    @Override
    protected void doSubmitAction(Object command) throws Exception
    {
        Users newUser = (Users) command;
        try
        {
            UsersDao userDao = new UsersDao();
            userDao.registerCustomer(newUser);
            
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}