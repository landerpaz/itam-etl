package com.example.demo.rule;

import com.example.demo.model.AssetDetail;

public class BucketRuleEngineImpl implements BucketRuleEngine {

    @Override
    public void basicValidation(AssetDetail AssetDetail, String fieldName)  throws Exception {
        System.out.println("ComputeEngineRuleImpl.basicValidation");
        switch (fieldName) {
            case "serviceUniqueId":
                System.out.println("ComputeEngineRuleImpl.basicValidation - custom basic validation for serviceUniqueId");
                break;
        
            default:
                break;
        }
        
    }

    @Override
    public void relationshipValidation(AssetDetail AssetDetail, String fieldName)  throws Exception {
        System.out.println("ComputeEngineRuleImpl.relationshipValidation");
        switch (fieldName) {
            case "serviceUniqueId":
                System.out.println("ComputeEngineRuleImpl.basicValidation - custom relationship validation for serviceUniqueId");
                break;
        
            default:
                break;
        }

    }

    @Override
    public void dataMapping(AssetDetail AssetDetail, String fieldName)  throws Exception{
        System.out.println("ComputeEngineRuleImpl.dataMapping");
        switch (fieldName) {
            case "serviceUniqueId":
                System.out.println("ComputeEngineRuleImpl.basicValidation - custom data mapping for serviceUniqueId");
                break;
        
            default:
                break;
        }
        
    }
    
}
