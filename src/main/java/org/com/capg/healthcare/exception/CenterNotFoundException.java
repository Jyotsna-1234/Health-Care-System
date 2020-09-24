package org.com.capg.healthcare.exception;

/**********************************************************************************
-Author                   :    AKRITI
-Created/Modified Date    :     20-09-2020
-Description              :     CenterNotFoundException class with constructor
*********************************************************************************/

public class CenterNotFoundException extends Exception{

	public CenterNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}