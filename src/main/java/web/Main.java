package web;
import java.util.*;
import org.hibernate.*;
import javax.servlet.http.*;
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
		s.flush();
		s.close();
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	String showLoginPage() {
		return "login";
	}
	@RequestMapping(method=RequestMethod.POST, value="/login")
	String checkPassword(String email, String password, 
			HttpSession session) {
		boolean correct = false;
		String data = encode(password);
		Session database = factory.openSession();
		Query query = database.createQuery(
				"from Member where email = :e");
		query.setParameter("e", email);
		List list = query.list();
		if (list.size() == 1) {
			Member m = (Member)list.get(0);
			if (m.password.equals(data)) {
				correct = true;
			}
		}
		
		if (correct) {
			Member m = (Member)list.get(0);
			session.setAttribute("member", m);
			return "redirect:/shop";
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping("/shop")
	String showMemberShop(HttpSession session) {
		Member m = (Member)session.getAttribute("member");
		if (m == null) {
			return "redirect:/login";
		} else {
			return "shop";
		}
	}

	@Autowired
	SessionFactory factory;
	
	String encode(String s) {
		String result = "";
		try {
			java.security.MessageDigest digest = 
					java.security.MessageDigest.
					getInstance("SHA-256");
			byte[] hash = digest.digest(s.getBytes("UTF-8"));
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					result += '0';
				result += hex;
			}
		} catch (Exception e) {}
		return result;
	}
}
