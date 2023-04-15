package studio9;

import assignment7.Student;
import java.util.Map;
import java.util.HashMap;


public class UniversityDatabase {
	private final Map<String, Student> map;
	

	//TODO: Complete this class according to the studio instructions
	public UniversityDatabase() {
		this.map = new HashMap<String,Student>();
	}

	public void addStudent(String accountName, Student student) {
		map.put(accountName, student);

	}

	public int getStudentCount() {
		return map.size();
	}

	public String lookupFullName(String accountName) {
		if(map.get(accountName) != null)
		{
			return map.get(accountName).getFullName();
		}
		else 
			return null;
		
	}

	public double getTotalBearBucks() {
		double count=0;
		
		for(String s: map.keySet())
		{
			count+= map.get(s).getBearBucksBalance();
		}
		return count;
	}
}
