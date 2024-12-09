package com.example.demo.rule;

import org.springframework.stereotype.Service;

import com.example.demo.model.AssetDetail;

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
public interface BucketRuleEngine {
    public void basicValidation(AssetDetail AssetDetail, String fieldName) throws Exception;
    public void relationshipValidation(AssetDetail AssetDetail, String fieldName) throws Exception;
    public void dataMapping(AssetDetail AssetDetail, String fieldName) throws Exception;
    // public void basicValidationGcp() throws Exception;
    // public void relationshipValidationGcp() throws Exception;
    // public void dataMappingGcp() throws Exception;
    // public void basicValidationAws() throws Exception;
    // public void relationshipValidationAws() throws Exception;
    // public void dataMappingAws() throws Exception;
    // public void basicValidationAzure() throws Exception;
    // public void relationshipValidationAzure() throws Exception;
    // public void dataMappingAzure() throws Exception;
}
