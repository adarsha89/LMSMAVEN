package com.Home;

public enum Designation
{
  JUNIOR_ASSOCIATE("JUNIOR ASSOCIATE"), ASSOCIATE("ASSOCIATE"), SENIOR_ASSOCIATE("SENIOR ASSOCIATE"), MANAGER("MANAGER"), SENIOR_MANAGER("SENIOR MANAGER"), DIRECTOR("DIRECTOR"), VP("VP"), CEO("CEO");

  private String designation;

  private Designation(String enteredDesignation) { this.designation = enteredDesignation; }


  public String getDesignationValue()
  {
    return this.designation;
  }
  public void setDesignationValue(String enteredDesignation)
  {
	  this.designation = enteredDesignation; 
  }
  public static Designation fromString(String designationString) {
	    if (designationString != null) {
	      for (Designation b : Designation.values()) {
	        if (designationString.equalsIgnoreCase(b.designation)) {
	          return b;
	        }
	      }
	    }
	    return null;
	  }
}