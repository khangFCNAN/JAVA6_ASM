package com.poly.service;

public class DuplicateEntryException extends Exception {
    public DuplicateEntryException(String message) {
        super(message);
    }
}