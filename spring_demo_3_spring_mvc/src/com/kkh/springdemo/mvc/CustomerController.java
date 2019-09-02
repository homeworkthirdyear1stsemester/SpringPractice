package com.kkh.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

        theModel.addAttribute("customer", new Customer());
        // 해당 web page에 customer라는 객체 변수를 넣어준다

        return "customer-form";
    }

    @RequestMapping("/processForm")
    public String processForm(
            @Valid @ModelAttribute("customer") Customer theCustomer, // customer에 대해 validation rule에 따른다
            BindingResult theBindingResult) { // validation의 결과를 BindingResult에 넣어준다

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        } // error 존재할 경우

        return "customer-confirmation";
    }
}
