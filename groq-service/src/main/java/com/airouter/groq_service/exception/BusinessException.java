package com.airouter.groq_service.exception;

import com.openai.models.beta.threads.runs.Run;

public class BusinessException extends RuntimeException {

    public BusinessException(String message){
        super(message);
    }
}
