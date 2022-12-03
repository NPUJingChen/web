package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import spittr.db.ManagerRepository;
import spittr.db.SpitterRepository;
import spittr.db.SpittleRepository;
import spittr.domain.Manager;
import spittr.domain.Spittle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * 管理员控制类
 *
 * @author chenjing
 */
@Controller
@SessionAttributes({ "manager" })
@RequestMapping("/manager")

public class ManagerController {

    @Autowired
    private ManagerRepository managerRepository;
    @Autowired
    private SpitterRepository spitterRepository;
    @Autowired
    private SpittleRepository spittleRepository;

    /**
     * 请求管理员登录
     *
     * @return
     */
    @RequestMapping(value = "/login", method = GET)
    public String showManagerLogin() {

        return "managerLogin";
    }

    /**
     * 提交登录请求
     *
     * @param userName
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = POST)
    public String processManagerLogin(@RequestParam(value = "userName", defaultValue = "") String userName,
                                      @RequestParam(value = "password", defaultValue = "") String password,
                                      HttpSession session, HttpServletRequest request) {
        Manager manager = managerRepository.findByUserName(userName, password);
        if (manager != null && manager.getIsDelete() != 0) {
            session.setAttribute("manager", manager);
            return "managerView";
        } else {
            return "loginError";
        }
    }

    /**
     * 获取管理员列表
     *
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/check_manager", method = GET)
    public String managerList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, Model model) {
        if (pageSize <= 0) {
            pageSize = PaginationSupport.PAGESIZE;
        }
        model.addAttribute("managerList", managerRepository.findPage(pageNo, pageSize));
        return "managerList";
    }

    /**
     * 增加管理员
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/add", method = GET)
    public String showAddManager(Model model) {

        return "registerManager";
    }

    /**
     * 提交管理员添加请求
     *
     * @param manager
     * @param errors
     * @return
     */
    @RequestMapping(value = "/add", method = POST)
    public String processRegistration(@Valid Manager manager, Errors errors) {
        if (errors.hasErrors()) {
            return "registerManager";
        }

        manager = managerRepository.save(manager);

        return "successful";
    }

    /**
     * 获取删除管理员请求
     *
     * @return
     */
    @RequestMapping(value = "/delete", method = GET)
    public String managerDelete() {
        return "managerDelete";
    }

    /**
     * 提交管理员删除请求
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "/delete", method = POST)
    public String mDelete(@RequestParam(value = "userName", defaultValue = "") String userName) {
        int isDelete = 0;
        boolean manager = managerRepository.DeleteM(userName, isDelete);
        return "successful";
    }

    /**
     * 提交管理员信息更新
     *
     * @param userName
     * @param password
     * @param email
     * @param phoneNo
     * @param model
     * @return
     */
    @RequestMapping(value = "/update", method = POST)
    public String update(@RequestParam(value = "userName", defaultValue = "") String userName,
                         @RequestParam(value = "password", defaultValue = "") String password,
                         @RequestParam(value = "email", defaultValue = "") String email,
                         @RequestParam(value = "phoneNo", defaultValue = "") String phoneNo, Model model) {
        boolean manager = managerRepository.updatePasswd(userName, password, email, phoneNo);
        return "managerView";
    }

    /**
     * 获取spitter列表
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/check_spitter",method = GET)
    public String spitterList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize, Model model){
        if (pageSize <= 0){
            pageSize = PaginationSupport.PAGESIZE;
        }
        model.addAttribute("spitterList",spitterRepository.findPage(pageNo,pageSize));
        return "spitterList";
    }

    /**
     * 获取spittle列表
     * @param pageNo
     * @param pageSize
     * @param model
     * @return
     */
    @RequestMapping(value = "/check_spittle",method = GET)
    public String spittleList(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                              @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,Model model) {

        if (pageSize <= 0) {
            pageSize = PaginationSupport.PAGESIZE;
        }
        PaginationSupport<Spittle> spittle = spittleRepository.findPage(pageNo, pageSize);
        for (Spittle s : spittle.getItems()) {
            System.out.println(s.getIschecked());
        }
        model.addAttribute("spittleList", spittle);
        return "spittleList";
    }

    /**
     * 获取管理员审核
     * @return
     */
    @RequestMapping(value = "/examine",method = GET)
    public String spittleExamine(){
        return "spittleExamine";
    }

    /**
     * 提交管理员审核
     * @param id
     * @param session
     * @return
     */
    @RequestMapping(value = "/examine",method = POST)
    public String examineSpittle(@RequestParam(value = "id", defaultValue = "") long id,HttpSession session){
        Date check_time = new Date();
        Manager manager = (Manager) session.getAttribute("manager");
        long check_id =manager.getId();
        System.out.println(check_id + ", " + manager.getUserName());
        spittleRepository.updateSpittle(check_id,check_time,id);
        return "successful";
    }

    /**
     * 获取删除spittle请求
     * @return
     */
    @RequestMapping(value = "/deletespittle",method = GET)
    public String deleteSpittle(){
        return "spittleDelete";
    }

    /**
     * 提交删除请求
     * @param id
     * @return
     */
    @RequestMapping(value = "/deletespittle",method = POST)
    public String spittleDelete(@RequestParam(value = "id", defaultValue = "") long id){
        spittleRepository.delete(id);
        return "successful";
    }
}
