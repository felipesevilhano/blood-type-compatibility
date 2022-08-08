package com.kamila.exception;

public class BloodAnalysisFailed extends RuntimeException{
    public BloodAnalysisFailed(String message) {
        super(message);
    }
}
