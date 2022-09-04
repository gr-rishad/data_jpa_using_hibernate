package com.clinicalapis.Clinical.API.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClinicalDataRequest {

    private String componentName;
    private String componentValue;
    private int patientId;

}
