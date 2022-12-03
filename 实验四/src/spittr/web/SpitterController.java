package spittr.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

/**
 * 吐槽者控制类
 * 
 * @author wben
 * @version v1.0
 */
@Controller
/*
 * 将Model中的spitter参数保存到了session中（如果Model中没有spitter参数，而session中存在一个spitter参数，
 * 那么SessionAttribute会讲这个参数塞进Model中） SessionAttribute只能作用在类上。
 * 
 * 将Model中的被注解的attrName属性保存在一个SessionAttributesHandler中，在每个RequestMapping的方法执行后，
 * 这个SessionAttributesHandler都会将它自己管理的“属性”从Model中写入到真正的HttpSession；同样，
 * 在每个RequestMapping的方法执行前，
 * SessionAttributesHandler会将HttpSession中的被@SessionAttributes注解的属性写入到新的Model中。
 */
@SessionAttributes({ "spitter" })
@RequestMapping("/spitter")
public class SpitterController {

	@Autowired
	private SpitterRepository spitterRepository;

	/**
	 * 进入注册
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/register", method = GET)
	public String showRegistrationForm(Model model) {

		// 等价于model.addAttribute("spitter", new Spitter());
		model.addAttribute(new Spitter());
		return "registerForm";
	}

	/**
	 * 提交注册信息，提交成功后跳转到用户信息
	 * 
	 * @param spitter
	 * @param errors
	 * @return
	 */
	@RequestMapping(value = "/register", method = POST)
	public String processRegistration(@Valid Spitter spitter, Errors errors, HttpSession session) {
		if (errors.hasErrors()) {
			return "registerForm";
		}

		spitter = spitterRepository.save(spitter);
		// session.setAttribute("spitter", spitter);

		// System.out.println(spitter.getId());
		// return "redirect:/login" ;
		return "redirect:/spitter/" + spitter.getUserName();
	}

	/**
	 * 用户信息页面
	 * 
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{userName}", method = GET)
	public String showSpitterProfile(@PathVariable String userName, Model model) {
		/*
		 * @PathVariable("xxx") 通过 @PathVariable
		 * 可以将URL中占位符参数{xxx}绑定到处理器类的方法形参中@PathVariable(“xxx“)
		 * 用于将请求URL中的模板变量映射到功能处理方法的参数上，即取出uri模板中的变量作为参数
		 */

		Spitter spitter = spitterRepository.findByUserName(userName);
		if (spitter != null) {
			model.addAttribute(spitter);
			return "profile";
		} else {
			return "redirect:/";
		}
	}

}
