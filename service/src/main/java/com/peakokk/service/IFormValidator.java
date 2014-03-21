package com.peakokk.service;

import org.springframework.validation.Errors;

public interface IFormValidator
{
    public void signUpvalidate(Object target, Errors errors);
}