package mrigor87.votingsystem.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.servlet.http.HttpServletRequest;

/**
 * User: gkislin
 * Date: 22.08.2014
 */
@Controller
public class RootController1 {


    @RequestMapping(value = "/votingsystem")
    public String root() {

        return "index";
    }


}
