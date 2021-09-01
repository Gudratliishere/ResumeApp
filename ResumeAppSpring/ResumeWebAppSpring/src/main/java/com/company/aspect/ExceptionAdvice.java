package com.company.aspect;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionAdvice
{
    private static final Logger LOG = Logger.getLogger(ExceptionAdvice.class.getName());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView handleValidationException (final Exception internalServerException)
    {
        LOG.log(Level.SEVERE, null, internalServerException);
        
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("message", internalServerException.getMessage());
        
        return mv;
    }
}
