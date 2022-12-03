package spittr.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spittr.db.SpittleRepository;
import spittr.domain.Spitter;
import spittr.domain.Spittle;
/**
 * 吐槽控制器类
 * 
 * @author wben
 * @version v1.0
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

	@Autowired
	private SpittleRepository spittleRepository;

	/**
	 * 最新吐槽
	 * @param count
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public List<Spittle> spittles(@RequestParam(value = "count", defaultValue = "20") int count) {
		return spittleRepository.findRecent(count);
	}

	/**
	 * 查看单个吐槽
	 * @param spittleId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(@PathVariable("spittleId") long spittleId, Model model) {
		model.addAttribute(spittleRepository.findOne(spittleId));
		return "spittle";
	}

	/**
	 * 新建一个吐槽
	 * @param request
	 * @param form
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String saveSpittle(HttpServletRequest request, SpittleForm form, Model model, HttpSession session)
			throws Exception {
		spittleRepository
				.save(new Spittle(null, (Spitter) session.getAttribute("spitter"), form.getMessage(), new Date()));
		return "redirect:/spittles";
	}

}
