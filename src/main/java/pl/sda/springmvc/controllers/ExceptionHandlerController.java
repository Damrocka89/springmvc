package pl.sda.springmvc.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.springmvc.exceptions.NotFoundProductException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(NotFoundProductException.class)
    public ModelAndView productNotFound(Exception exception) {
        ModelAndView mnv = new ModelAndView("error");
        mnv.addObject("message", exception.getMessage());
        return mnv;
    }


}
