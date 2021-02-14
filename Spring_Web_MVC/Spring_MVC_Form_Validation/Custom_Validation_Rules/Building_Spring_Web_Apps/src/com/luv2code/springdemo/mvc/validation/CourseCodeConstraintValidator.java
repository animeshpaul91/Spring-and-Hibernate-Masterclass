package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String[] coursePrefix;

	@Override
	public void initialize(CourseCode courseCode) {
		coursePrefix = courseCode.value(); // this is "LUV"
	}

	@Override
	public boolean isValid(String userCode, ConstraintValidatorContext constraintValidatorContext) {

		// Our Business Logic
		if (userCode == null) return true;
		
		for(String tempPrefix: coursePrefix)
			if (userCode.startsWith(tempPrefix)) 
				return true;
		
		return false;		
	}

}
