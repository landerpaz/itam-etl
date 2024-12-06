package com.example.demo.rule;

import org.springframework.stereotype.Service;

public class GCPComputeEngineRuleImpl extends ComputeEngineRuleImpl {

    /**
     * This method invokes ComputeEngineRuleImpl.basicValidation to do the common validations for compute engines for all CSPs
     * and then local implementation has logic specif to CSP (GCP)
     */
    public void basicValidationGcp()  throws Exception {
        super.basicValidation();
        System.out.println("GCPComputeEngineRuleImpl.basicValidation");
        
    }

    /**
     * This method invokes ComputeEngineRuleImpl.relationshipValidation to do the common validations for compute engines for all CSPs
     * and then local implementation has logic specif to CSP (GCP)
     */
    public void relationshipValidationGcp() throws Exception {
        super.relationshipValidation();
        System.out.println("GCPComputeEngineRuleImpl.relationshipValidation");
        
    }

    /**
     * This method invokes ComputeEngineRuleImpl.dataMapping to do the common validations for compute engines for all CSPs
     * and then local implementation has logic specif to CSP (GCP)
     */
    public void dataMappingGcp() throws Exception {
        super.dataMapping();
        System.out.println("GCPComputeEngineRuleImpl.dataMapping");
        
    }
}
