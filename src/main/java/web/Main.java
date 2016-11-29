package web;
import org.springframework.ui.*;
import org.springframework.boot.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

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

}
