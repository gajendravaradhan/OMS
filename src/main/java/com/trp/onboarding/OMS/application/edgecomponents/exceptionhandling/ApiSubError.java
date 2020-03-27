package com.trp.onboarding.OMS.application.edgecomponents.exceptionhandling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * The Custom Api sub error abstract class.
 */
abstract class ApiSubError {

}

/**
 * The custom Api validation error class.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    /**
     * Instantiates a new Api validation error.
     *
     * @param object  the object
     * @param message the message
     */
    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }

    /**
     * Gets object.
     *
     * @return the object
     */
    public String getObject() {
        return object;
    }

    /**
     * Sets object.
     *
     * @param object the object
     * @return the object
     */
    public ApiValidationError setObject(String object) {
        this.object = object;
        return this;
    }

    /**
     * Gets field.
     *
     * @return the field
     */
    public String getField() {
        return field;
    }

    /**
     * Sets field.
     *
     * @param field the field
     * @return the field
     */
    public ApiValidationError setField(String field) {
        this.field = field;
        return this;
    }

    /**
     * Gets rejected value.
     *
     * @return the rejected value
     */
    public Object getRejectedValue() {
        return rejectedValue;
    }

    /**
     * Sets rejected value.
     *
     * @param rejectedValue the rejected value
     * @return the rejected value
     */
    public ApiValidationError setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
        return this;
    }

    /**
     * Gets exception sub error message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets exception sub error message.
     *
     * @param message the message
     * @return the message
     */
    public ApiValidationError setMessage(String message) {
        this.message = message;
        return this;
    }
}