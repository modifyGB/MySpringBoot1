/*
 * @Description: demo controller
 * @Version: 1.0
 * @Autor: Renhetian
 * @Date: 2021-11-10 12:30:21
 * @LastEditors: Renhetian
 * @LastEditTime: 2021-12-21 01:02:16
 */
package springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("msg", "MySpringBoot");
        return "index";
    }
}