package com.example.start.Controller;

import com.example.start.Model.Scp;
import com.example.start.Service.ScpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ScpController {
    @Autowired
    private ScpService scpService;

    // display list of scps
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("list", scpService.getAllScps());
        return "index";
    }

    @GetMapping("/AddNewScp")
    public String showNewScpForm(Model model) {
        Scp scp = new Scp();
        model.addAttribute("scp", scp);
        return "new_scp";
    }

    @PostMapping("/SaveScp")
    public String saveScp(@ModelAttribute("scp") Scp scp) {
        // save Scp to database
        scpService.saveScp(scp);
        return "redirect:/";
    }

    @GetMapping("/deleteScp/{id}")
    public String deleteScp(@PathVariable(value = "id") long id){
        // call delete scp method
        scpService.deleteScp(id);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") long id, Model model){
        // get SCP from the service

        Scp scp = scpService.getScpById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("scp", scp);
        return "update_scp";
    }

    @GetMapping("/page/{pageNr}")
    public String findPaginated(@PathVariable(value = "pageNr") int pageNr, Model model){
        int pageSize = 11;

        Page<Scp> page = scpService.findPaginated(pageNr, pageSize);
        List<Scp> scpList = page.getContent();
        model.addAttribute("currentPage", pageNr);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalRows", page.getTotalElements());
        model.addAttribute("listScp", scpList);
        return "index";
    }

}
