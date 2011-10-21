public class ClassroomTestDrive
{
	public static void main(String[] args)
	{
		Classroom c = new Classroom();
		
		Student s1 = new Student();
		s1.setGrades(3.3, 3.3, 3.3, 3.3, 3.3, 3.3);
		
		c.addStudent(s1);
		
		Student s2 = new Student();
		s2.setGrades(3.3, 3.3, 3.3, 3.0, 3.0, 3.0);
		
		c.addStudent(s2);
		
		System.out.println("Classroom size: " + c.size());
		System.out.println("Classroom GPA: " + c.getClassAverageGPA());
		System.out.println("Classroom college GPA: " + c.getClassAverageCollegeGPA());
		
		c.createStudents(40);
		c.removeStudent(2);
		
		System.out.println();
		System.out.println("Classroom size: " + c.size());
		System.out.println("Classroom GPA: " + c.getClassAverageGPA());
		System.out.println("Classroom college GPA: " + c.getClassAverageCollegeGPA());
	}	
}