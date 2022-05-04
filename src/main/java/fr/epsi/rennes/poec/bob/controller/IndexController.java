package fr.epsi.rennes.poec.bob.controller;


import fr.epsi.rennes.poec.bob.domain.Response;
import fr.epsi.rennes.poec.bob.service.AgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

    @Autowired
    private AgeService ageService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Page d'accueil");
        return "index";
    }

    @GetMapping("/public/whats_my_age")
    public String age() {
        return "age";
    }

    @GetMapping("/public/what_is_my_age")
    @ResponseBody
    public Response<Integer> age(
        @RequestParam String birthDate
    )
    {
        int age = ageService.age(birthDate);
        Response<Integer> response = new Response<>();
        response.setData(age);
        return response;
    }
}
