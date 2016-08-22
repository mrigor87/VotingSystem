package mrigor87.votingsystem.web;

import mrigor87.votingsystem.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Igor on 22.08.2016.
 */
//@RestController
public class UserRestController extends AbstractUserController {
    public final String REST_URL="/rest/profile";



}
