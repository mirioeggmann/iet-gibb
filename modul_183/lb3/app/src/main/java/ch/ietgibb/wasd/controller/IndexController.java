package ch.ietgibb.wasd.controller;

import ch.ietgibb.wasd.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class IndexController {

    @Autowired
    CommandService commandService;

    @GetMapping("/")
    public ModelAndView getIndex(@RequestParam(required = false) Optional<String> sysout) {
        ModelAndView modelAndView = new ModelAndView("index");

        if (!sysout.isPresent()) {
            modelAndView.addObject("commandResult", "Execute a command please.");
        } else if (!commandService.isValidOption(sysout.get())) {
            modelAndView.addObject("commandResult", "Invalid param selected!");
        } else {
            modelAndView.addObject("commandResult", commandService.runCommand(sysout.get()));
        }

        return modelAndView;
    }
}
