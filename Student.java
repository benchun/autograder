public class Student
{
	private String name;
	private double grades[] = new double[6];
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String n)
	{
		if (n.length() > 1)
		{
			name = n;
		}
	}
	
	public void setGrades(double g0, double g1, double g2, double g3, double g4, double g5)
	{
		grades[0] = g0;
		grades[1] = g1;
		grades[2] = g2;
		grades[3] = g3;
		grades[4] = g4;
		grades[5] = g5;
	}
	
	void setGrades( String g0, String g1, String g2, String g3, String g4, String g5 )
	{
		grades[0] = convertLetterGradeToNumber( g0 );
		grades[1] = convertLetterGradeToNumber( g1 );
		grades[2] = convertLetterGradeToNumber( g2 );
		grades[3] = convertLetterGradeToNumber( g3 );
		grades[4] = convertLetterGradeToNumber( g4 );
		grades[5] = convertLetterGradeToNumber( g5 );
	}
	
	public double getGPA()
	{
		double sum = 0;
		for (double g : grades)
		{
			sum += g;
		}
		return sum / grades.length;
	}
	
	public double getCollegeGPA()
	{
		double sum = 0;
		for (double g : grades)
		{
			sum += convertGradeToCollegeGrade(g);
		}
		return sum / grades.length;
	}
	
	public int convertGradeToCollegeGrade( double g )
	{
		int grade = 0;
		if (g >= 0.7) grade = 1;
		if (g >= 1.7) grade = 2;
		if (g >= 2.7) grade = 3;
		if (g >= 3.7) grade = 4;
		return grade;
	}
	
	public void printStudentRecord()
	{
		System.out.println( "Name: " + name );
		System.out.println( "GPA: " + getGPA() );
		System.out.println( "College GPA: " + getCollegeGPA() );
	}
	
	
	double convertLetterGradeToNumber( String x )
	{
		double answer = 0.0;
		String letter = x.substring(0,1);
		
		if      ( letter.equals("A") ) answer = 4.0;
		else if ( letter.equals("B") ) answer = 3.0;
		else if ( letter.equals("C") ) answer = 2.0;
		else if ( letter.equals("D") ) answer = 1.0;
		else answer = 0.0;
		
		if (x.length() == 2)
		{
			String modifier = x.substring(1,2);
			if (modifier.equals("+"))
			{
				answer += 0.3;
			}
			else if (modifier.equals("-"))
			{
				answer -= 0.3;
			}
		}
		return answer;
	}
	
}