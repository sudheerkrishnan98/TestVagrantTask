package com.testvagrant;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;
import org.testng.internal.annotations.IAnnotationTransformer;

public class RetryTC implements IAnnotationTransformer{


	public void transform(ITestAnnotation a, Class testClass, Constructor testConstructor, Method testMethod) {
		IRetryAnalyzer r= a.getRetryAnalyzer();
		
		if(r==null) {
			a.setRetryAnalyzer(RetryFailedTest.class);
		}
	}
}
