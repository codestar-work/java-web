package web;
import org.hibernate.*;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.*;

@Controller
public class Main {

	@RequestMapping("/")
	String showHome() {
	  return "index";
	}

	@RequestMapping("/test") @ResponseBody
	int test() {
	  return 555;
	}

	@RequestMapping("/register")
	String showRegisterPage() {
		return "register";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	String registerNewMember(String email, String password,
			String name) {
		Member m = new Member();
		m.name = name;
		m.email = email;
		m.password = password;
		Session s = factory.openSession();
		s.save(m);
		s.close();
		return "index";
	}

	@Autowired
	SessionFactory factory;
}
