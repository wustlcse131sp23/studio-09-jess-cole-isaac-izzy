package assignment7;

public class Student {
	private String firstName;//use the method to access instance variable -- that is why they are private
	private String lastName;
	private int ID;
	private int attemptedC;
	private double passingC;
	private double totalGrade;
	private double bearBucks;

	public Student(String first, String last, int id) {
		this.firstName = first;
		this.lastName = last;
		this.ID = id;// THIS NEEDS TO SHIFT FOR VARIATY OF ID NUMBERS
		this.attemptedC = 0;
		this.passingC = 0;
		this.totalGrade = 0.0;
		this.bearBucks = 0.0;
	}
/**
 * This combines the first and last name to get the full name
**/
	public String getFullName() {
		return firstName + " " + lastName;
	}
	/**
	 * This gets the ID
	**/
	public int getId() {
		return ID;
	}
	/**
	 * This gets the attempted Credits
	**/
	public int getTotalAttemptedCredits() {
		return attemptedC;
	}
	/**
	 * This gets the passing Credits
	**/
	public double getTotalPassingCredits() {
		return passingC;
	}
	/**
	 * This calculates the total grades divided by the total attempted credits to give GPA
	 * If attempted credits is negative or 0, or the total grade is not a number it return the there is no GPA
	**/
	public double calculateGradePointAverage() {// works
		if (attemptedC <= 0 || Double.isNaN(totalGrade)) {
			return Double.NaN;
		}

		return totalGrade / attemptedC;
	}
	/**
	 * This returns the grades earned in which they recieved at least a 1.7 (passed)
	**/
	public void submitGrade(double grade, int credits) {// Works
		attemptedC += credits;
		if (grade >= 1.7) {
			passingC += credits;
		}

		totalGrade += grade * credits;

	}
	/**
	 * uses the passing credit to determine what class year they are in
	**/
	public String getClassStanding() {// WORKS
		if (passingC < 30) {
			return "First Year";
		} else if (passingC < 60 && passingC >= 30) {
			return "Sophomore";
		} else if (passingC < 90 && passingC >= 60) {
			return "Junior";
		} else {
			return "Senior";
		}
	}
	/**
	 * This tells a person if they are eligible for honors based on GPA and credits
	**/
	public boolean isEligibleForPhiBetaKappa() { // WORKS
		if (passingC >= 98 && calculateGradePointAverage() >= 3.60) {
			return true;
		}
		if (passingC >= 75 && calculateGradePointAverage() >= 3.80) {
			return true;
		} else
			return false;

	}
	/**
	 * This is how you add bear bucks to a student account
	**/
	public void depositBearBucks(double amount) {// WORKS
		bearBucks += amount;
	}
	/**
	 * This takes away bear bucks from a students account
	**/
	public void deductBearBucks(double amount) {// WORKS
		bearBucks -= amount;
	}
	/**
	 * returns the bear bucks balance
	**/
	public double getBearBucksBalance() {// WORKS
		return bearBucks;
	}
	/**
	 * This is when a student removes all their bear bucks
	 * there is a 10 dollar forfeit, and returns the amount they get.
	**/
	public double cashOutBearBucks() {// WORKS
		double cashOut = bearBucks - 10;
		bearBucks = 0.0;
		if (cashOut <= 0.0) {
			return 0.0;
		}
		return cashOut;
	}
	/**
	 * returns the last name 
	**/
	private String getLastName() {
		return lastName;
	}
	/**
	 * This asks if the student has a hyphenated last name
	 * if they do, it takes their last name, and hyphanates it with the "other parents" last name using the getLastName method
	 * if not, just return the single last name
	 * 
	 * The two unused BB variables are coorisponding to the left over BB of the parents
	 * the new "legacy" student is created with the last name created 
	 * if there are left over BB, deposit it into the legacy's BB account for both parents
	 * return Legacy student
	**/

	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
		String lastName;
		if (isHyphenated == true) {
			lastName = getLastName() + "-" + otherParent.getLastName();
		} else {
			lastName = getLastName();
		}
		double unusedBearBucks = cashOutBearBucks();
		double unusedOtherParentBearBucks = otherParent.cashOutBearBucks();
		Student legacy = new Student(firstName, lastName, id);
		if (unusedBearBucks > 0.0) {
			legacy.depositBearBucks(unusedBearBucks);
		}
		if (unusedOtherParentBearBucks > 0.0) {
			legacy.depositBearBucks(unusedOtherParentBearBucks);
		}
		return legacy;
	}
	/**
	 * String toString returns the full info on the student
	 * first name, lastName, and ID
	**/
	public String toString() {// WORKS
		return firstName + " " + lastName + " (ID: " + ID + ")";
	}

}
