package cn.supermartin.martin.ssosingle.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author maxiaoding
 * @date 2017/11/12 下午3:32
 * @description:
 */
@Controller
public class LoginController {
    @RequestMapping("/")
    public String index_(HttpSession httpSession, ModelMap modelMap) {
        String username = (String) httpSession.getAttribute("username");
        modelMap.addAttribute("username", username);
        return "index";
    }

    @RequestMapping("/index")
    public String index(HttpSession httpSession, ModelMap modelMap) {
        String username = (String) httpSession.getAttribute("username");
        modelMap.addAttribute("username", username);
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/doLogin")
    public void login(String username, String userpwd, HttpServletResponse response, HttpServletRequest request) throws IOException {
        //赞未写验证用户名和密码是否正确
        //保存到session
        request.getSession().setAttribute("username", username);
        response.sendRedirect("/index");
    }


    @RequestMapping("/logout")
    public void login(HttpServletResponse response, HttpServletRequest request) throws IOException {
        //清空session
        request.getSession().removeAttribute("username");
        response.sendRedirect("/index");
    }
}
