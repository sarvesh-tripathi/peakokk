package com.peakokk.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.peakokk.DTO.ProfilePageDTO;
import com.peakokk.service.IManualUpload;

@Controller
public class ChefProfilePageController extends BaseController
{
    
    @Autowired
    IManualUpload manualUpload;
    
    /**
     * Private variables
     */
    
    private final String UPLOAD_DIRECTORY = "//var//lib//tomcat7//webapps/images";
    

    @RequestMapping(value = "/editProfile", method = RequestMethod.GET)
    public ModelAndView editProfile(ModelMap model)
    {
        model.addAttribute("profilePage", new ProfilePageDTO());

        return new ModelAndView("editProfile");
    }
    
    /*@RequestMapping(value = "/manualUpload", method = RequestMethod.GET)
    public ModelAndView manualUpload(HttpServletRequest request,
            HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView("manualUpload");
        return modelAndView;
    }
*/

 
    
    
    @RequestMapping(value = "/saveProfile", method = RequestMethod.POST) 
    public ModelAndView saveProfile(@ModelAttribute("user") ProfilePageDTO profilePage,
            BindingResult bindResult,HttpServletRequest request, 
            HttpServletResponse response, ModelMap model) {
        
        
        
        ModelAndView modelAndView = null;
        
     return  modelAndView;   
        
    }
    
  @SuppressWarnings("unchecked")
    @RequestMapping(value = "/uploadFile", method = RequestMethod.GET) 
    public ModelAndView uploadFile(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("manualUpload");

        if(ServletFileUpload.isMultipartContent(request))
        {
            try{
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item : multiparts)
                {
                    if(!item.isFormField())
                    {
                        String name = new File(item.getName()).getName();
                        item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                        String fullFilePath = UPLOAD_DIRECTORY + File.separator + name;
                        String result = manualUpload.saveImgUrl(fullFilePath);
                        
                        System.out.println("============>" + result);
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
        return modelAndView;
    }
   
    
}
