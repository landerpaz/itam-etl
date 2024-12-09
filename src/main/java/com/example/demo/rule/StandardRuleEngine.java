package com.example.demo.rule;

import org.springframework.stereotype.Service;

/**
 * This interface is the parent compute engine class for CSP compute engine service types
 * It has all the common functionalities across CSPs
 * 
 * It has methods
 * 1. basicValidation() - custom validation
 * 2. relationshipValidation() - relationship validation, validation will be done by calling SN API
 * 3. dataMapping() - collect and frame data payload to send request to SN API to load target tables.
 * 
 * Note : no return type, any error during validation custom exception will be thrown, Main class will register the exception message in couchbase
 * staging table against the correponding document. Exception handling needs to handled well with proper custom message.
 * 
 */
@Service
public interface StandardRuleEngine {
    public void basicValidation() throws Exception;
    public void relationshipValidation() throws Exception;
    public void dataMapping() throws Exception;
}
