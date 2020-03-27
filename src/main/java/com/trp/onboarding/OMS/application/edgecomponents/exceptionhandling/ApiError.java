package com.trp.onboarding.OMS.application.edgecomponents.exceptionhandling;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

/**
 * The type Custom API error class.
 */
public class ApiError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    private ApiError() {
        timestamp = LocalDateTime.now();
    }

    /**
     * Instantiates a new Api error.
     *
     * @param status the status
     */
    ApiError(HttpStatus status) {
        this();
        this.status = status;
    }

    /**
     * Instantiates a new Api error.
     *
     * @param status the status
     * @param ex     the ex
     */
    ApiError(HttpStatus status, Throwable ex) {
        this();
        this.status = status;
        this.message = "Unexpected error";
        this.debugMessage = ex.getLocalizedMessage();
    }

    /**
     * Instantiates a new Api error.
     *
     * @param status  the status
     * @param message the message
     * @param ex      the ex
     */
    ApiError(HttpStatus status, String message, Throwable ex) {
        this();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }

    /**
     * Gets HTTP status.
     *
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Sets HTTP status.
     *
     * @param status the status
     * @return the status
     */
    public ApiError setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Gets exception timestamp.
     *
     * @return the timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Sets exception timestamp.
     *
     * @param timestamp the timestamp
     * @return the timestamp
     */
    public ApiError setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Gets exception message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets exception message.
     *
     * @param message the message
     * @return the message
     */
    public ApiError setMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Gets exception debug message.
     *
     * @return the debug message
     */
    public String getDebugMessage() {
        return debugMessage;
    }

    /**
     * Sets exception debug message.
     *
     * @param debugMessage the debug message
     * @return the debug message
     */
    public ApiError setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
        return this;
    }

    /**
     * Gets exception sub errors.
     *
     * @return the sub errors
     */
    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    /**
     * Sets exception sub errors.
     *
     * @param subErrors the sub errors
     * @return the sub errors
     */
    public ApiError setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
        return this;
    }
}

