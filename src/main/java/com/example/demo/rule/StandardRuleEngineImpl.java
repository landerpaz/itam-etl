package com.example.demo.rule;

public class StandardRuleEngineImpl implements StandardRuleEngine {

    @Override
    public void basicValidation()  throws Exception {
        System.out.println("ComputeEngineRuleImpl.basicValidation");
        
    }

    @Override
    public void relationshipValidation()  throws Exception {
        System.out.println("ComputeEngineRuleImpl.relationshipValidation");

    }

    @Override
    public void dataMapping()  throws Exception{
        System.out.println("ComputeEngineRuleImpl.dataMapping");
        
    }
    
}
