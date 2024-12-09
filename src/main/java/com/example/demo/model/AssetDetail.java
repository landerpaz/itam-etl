package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssetDetail {
    
    //service detail
    private String sourceName;
    private String serviceName;
    private String mosaicServiceType;
    private String mosaicApi;
    private String stagingDocument;
    private String customRuleEngine;

    //relationship detail
    private String relationshipType;
    private String customRelationshipValidation;

    //data mapping detail
    private String upStreamField;
    private String downstreamTable;
    private boolean isMandatory;
    private String customValidation;
    private String customDataMapping;
    
    
}
