package com.kkh.springdemo.mvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // add an initbinder ... to convert trim input strings
    // remove leading and trailing whitespace
    // resolve issue for our validation

    @InitBinder // Valid annotaion 으로 검증이 필요한 객체를 가져오기 전에 수행 할 메소드
    public void initBinder(WebDataBinder dataBinder) {

        // delete whilte space
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        // register on this data binder
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

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

        System.out.println("Last name : |" + theCustomer.getLastName() + "|");
        System.out.println("Binding result: " + theBindingResult);

        if (theBindingResult.hasErrors()) {
            return "customer-form";
        }

        return "customer-confirmation";
    }
}
