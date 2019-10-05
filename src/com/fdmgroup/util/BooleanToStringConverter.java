package com.fdmgroup.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanToStringConverter implements AttributeConverter<Boolean, String> {

    public String convertToDatabaseColumn(Boolean value) {        
        return (value != null && value) ? "Y" : "N";            
        }    

    public Boolean convertToEntityAttribute(String value) {
        return "Y".equals(value);
        }
   }