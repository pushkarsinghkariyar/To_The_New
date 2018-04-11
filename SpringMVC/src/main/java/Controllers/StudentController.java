package Controllers;

import Models.StudentCO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class StudentController {

    @RequestMapping("/")

    public ModelAndView myDefault(){
        ModelAndView modelAndView=new ModelAndView("index");
        return modelAndView;
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String hello(){
        return "hello world";
    }


    @RequestMapping("/getmodel")
    public ModelAndView get(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("msg","hello world from controller");
        return modelAndView;
    }


    @RequestMapping("/getpathvar/{id}/{name}")
    /* public ModelAndView get2(@PathVariable("id") int sid,@PathVariable("name") String sname){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("data","Sudent id is :"+sid+" and name is :"+sname);
            return modelAndView;
    }*/


    public ModelAndView get3(@PathVariable Map<String,String> hm){
    ModelAndView modelAndView=new ModelAndView("index");
    String sid=hm.get("id");
    String name=hm.get("name");
    modelAndView.addObject("data",sid+" "+name);
    return modelAndView;
    }


    @RequestMapping("/savedata")
    public ModelAndView get4(@RequestParam("sid") int id,@RequestParam("sname") String name){
        ModelAndView modelAndView=new ModelAndView("studentData");
        modelAndView.addObject("sdata",id+" "+name);
        return modelAndView;
    }


    @RequestMapping("/studata")
    public ModelAndView get5(@RequestParam("fname") String fn,@RequestParam("lname") String ln){
        StudentCO obj=new StudentCO();
        obj.setFname(fn+"xyz");
        obj.setLname(ln);
        ModelAndView modelAndView=new ModelAndView("studentData");
        modelAndView.addObject("objx",obj);
        return modelAndView;

    }

    public ModelAndView get6(@ModelAttribute("objx") StudentCO obj){
        ModelAndView modelAndView=new ModelAndView("studentData");
        return modelAndView;
    }

    @ModelAttribute
    public void setHeading(Model m){
        m.addAttribute("head","TTN");

    }
}
