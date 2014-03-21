package com.peakokk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.peakokk.DTO.UserDTO;
import com.peakokk.domain.User;
import com.peakokk.service.IFormValidator;
import com.peakokk.service.IUserService;

@Controller
public class UserController extends BaseController
{

    @Autowired
    IUserService userService;

    @Autowired
    IFormValidator formValidator;
    
   

    /**
     * PRIVATE VARIABLES
     */

    private static final String PAGE_CREATE_USER = "createUser";
   

    private static Logger logger = LogManager.getLogger(UserController.class);

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView home()
    {

        return new ModelAndView("register");

    }

    @RequestMapping(value = "/chefRegister", method = RequestMethod.GET)
    public ModelAndView chefRegister(ModelMap model)
    {
        model.addAttribute("user", new UserDTO());
        return new ModelAndView("chefRegister");

    }

    @RequestMapping(value = "/userRegister", method = RequestMethod.GET)
    public ModelAndView userRegister(ModelMap model)
    {

        model.addAttribute("user", new UserDTO());
        return new ModelAndView("userRegister");

    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") UserDTO user,
            BindingResult bindResult, HttpServletRequest request,
            HttpServletResponse response, ModelMap model)
    {
        String result1 = EMPTY_STRING;
        String message = ERROR_MESSAGE;
        
        int userType = user.getUserTypeId();

        String EmailId = user.getEmailId();
        logger.debug("Add User : Email ID : " + EmailId);

        Boolean emailFlag = userService.isEmailExist(EmailId);

        logger.debug("Add User : isEmailExist : " + emailFlag);
        if (!emailFlag)
        {

            user.setEmailRegister(false);

        }
        else

        {
            user.setEmailRegister(true);
        }
        formValidator.signUpvalidate(user, bindResult);

        ModelAndView modelAndView = null;
        if (bindResult.hasErrors())
        {
            logger.debug("Add User : Validation Failed  : ");
            logger.debug("Add User : Validation Failed  : userType : "  + userType);
            if(userType == 1) {                
                modelAndView = new ModelAndView("userRegister", "user", user);
            } else {
                modelAndView = new ModelAndView("chefRegister", "user", user);
            }
        }
        else
        {
            modelAndView = new ModelAndView("home");
            logger.debug("Add User : Validation Passed  : ");
            try
            {
               if(user != null)
               {
                    User usr = new User();
    
                    usr.setUsername(user.getUsername());
                    usr.setFirstName(user.getFirstName());
                    usr.setLastName(user.getLastName());
                    usr.setEmailId(user.getEmailId());
                    usr.setPassword(user.getPassword());
                    usr.setConfirmPassword(user.getConfirmPassword());
                    usr.setUserTypeId(user.getUserTypeId());
                    usr.setTermsCheckbox(user.isTermsCheckbox());
                    usr.setContactNumber(user.getContactNumber());
    
                    result1 = userService.saveUser(usr);
                    logger.debug("User registered Successfully");
               }
                //message = sendMessage(model, result1, SAVE_MESSAGE);

                

            }
            catch (DataAccessException e)
            {
                e.printStackTrace();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }

        /*if(ServletFileUpload.isMultipartContent(request))
        {
            try{
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item : multiparts)
                {
                    if(!item.isFormField())
                    {
                        String result;
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        String fullFilePath = UPLOAD_DIRECTORY + File.separator + name;
                        result=manualUpload.saveImgUrl(fullFilePath);
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + result);
                       
                    }
                }
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }       
        }
        else{
            request.setAttribute("message","Sorry this Servlet only handles file upload request");
        }
*/        
        
        return modelAndView;

    }

    /**
     * To get user details
     * 
     * @return
     */
    @RequestMapping(value = "/userDetail", method = RequestMethod.GET)
    public String userDetails(@ModelAttribute("formBean") UserDTO user,
            BindingResult bindResult, HttpServletRequest request,
            HttpServletResponse response, ModelMap model)
    {

        try
        {

            String userId = request.getParameter("userId");

            User user1 = userService.getUserDetails(userId);
            UserDTO usr = new UserDTO();

            model.addAttribute(ATTR_USER_DETAILS, user1);

        }
        catch (DataAccessException e)
        {
            e.printStackTrace();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return PAGE_CREATE_USER;

    }

    /**
     * To update the user
     * 
     * @return
     */
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public @ResponseBody
    String updateUser(@ModelAttribute("formBean") UserDTO user,
            BindingResult bindResult, HttpServletRequest request,
            HttpServletResponse response, ModelMap model)
    {

        String result = EMPTY_STRING;
        String message = ERROR_MESSAGE;
        try
        {

            User usr = new User();
            // set user details here
            result = userService.updateUser(usr);
            message = sendMessage(model, result, UPDATE_MESSAGE);

        }
        catch (DataAccessException e)
        {
            e.printStackTrace();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return message;
    }

    /**
     * To update the user
     * 
     * @return
     */
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public @ResponseBody
    String deleteUser(@ModelAttribute("formBean") UserDTO user,
            BindingResult bindResult, HttpServletRequest request,
            HttpServletResponse response, ModelMap model, HttpSession session)
    {

        String result = EMPTY_STRING;
        String message = ERROR_MESSAGE;
        try
        {
            result = userService.deleteUser(user);
            message = sendMessage(model, result, DELETE_MESSAGE);

        }
        catch (DataAccessException e)
        {
            e.printStackTrace();
            return message;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return message;
        }
        return message;
    }
    
    /*public static void main(String[] t)
    {
         final   Pattern EMAIL_PATTERN = Pattern.compile("[A-Za-z]+");
         System.out.println(EMAIL_PATTERN.matcher(null).matches());
        
    }*/

}
