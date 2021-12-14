package com.bupt.exception;

/**
 * @Author czgggggggg
 * @Date 2021/12/13
 * @Description
 */
public class SensitiveException extends Exception {
    String word;

    public SensitiveException(String word){
        this.word = word;
    }

    public SensitiveException(String message, String word){
        super(message);
        this.word = word;
    }

    public String getWord(){
        return word;
    }
}
