package com.teleco.entitlements.web;

import com.teleco.entitlements.config.AppProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ExampleController {

    @Autowired
    private AppProperties appProperties;

    @RequestMapping(value = "/propsFromGit", method = RequestMethod.GET)
    public List<String> propsFromGit() {
        ArrayList<String> props = new ArrayList<>();
        props.add(appProperties.getApplicationDevProperty());
        props.add(appProperties.getApplicationProperty());
        props.add(appProperties.getEntitlementsDevProperty());
        props.add(appProperties.getEntitlementsProperty());
        return props;
    }
}
