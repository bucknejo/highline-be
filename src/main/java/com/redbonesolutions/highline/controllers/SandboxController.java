package com.redbonesolutions.highline.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/service/sandbox")
@CrossOrigin(origins = "http://localhost:8090")
public class SandboxController {

    private final static Logger LOG = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String sandbox(Locale locale, Model model) {
        LOG.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "sandbox";
    }


}
