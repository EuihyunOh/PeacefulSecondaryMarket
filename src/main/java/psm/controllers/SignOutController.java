package psm.controllers;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

@Component("/auth/signout.do")
public class SignOutController implements Controller {
	
	@Override
	public String execute(Map<String, Object> model) throws Exception {
		HttpSession session = (HttpSession)model.get("session");
		session.invalidate();
		return "redirect:../trade/list.do";
	}

}
