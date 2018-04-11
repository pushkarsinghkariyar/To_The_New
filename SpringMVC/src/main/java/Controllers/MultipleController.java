package Controllers;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MultipleController extends MultiActionController {

    public ModelAndView first(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("x","Pushkar");
        return modelAndView;
    }


    public void second(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException
    {

        PrintWriter printWriter=response.getWriter();
        printWriter.println("<p>hello Pushkar</p>");


    }
}
