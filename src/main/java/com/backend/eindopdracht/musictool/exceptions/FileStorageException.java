package com.backend.eindopdracht.musictool.exceptions;

public class FileStorageException extends RuntimeException {

    private static final long serialVersonUID = 1L;
    private String msg;

    public FileStorageException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
