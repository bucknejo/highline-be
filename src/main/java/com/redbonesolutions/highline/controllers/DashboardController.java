package com.redbonesolutions.highline.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/donotuse")
public class DashboardController {

    private final static Logger LOG = LoggerFactory.getLogger(DashboardController.class);

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String dashboard(Locale locale, Model model) {
        LOG.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "dashboard";
    }

}
