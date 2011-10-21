public class ClassroomGrader extends Grader
{

	public static void main( String[] args )
	{
		System.out.println("CLASSROOM LAB AUTO-GRADER\n");
		
		/////////////////////////////////////
		
		beginTask("Checking for required classes");
		setHint("Be sure you have Classroom, ClassroomTestDrive, and Student classes");
		setScorePossible(1);
		
		if (classExists("Classroom") &&
			classExists("ClassroomTestDrive") &&
			classExists("Student") )
		{
			setScore(1);
		}
		endTask();
		
		/////////////////////////////////////
		
		beginTask("Checking Classroom methods");
		setHint("Be sure you have all the required methods, return types, and parameter lists");
		setScorePossible(4);
		setScore(0);
		
		Class[] studentParam = {Student.class};
		boolean addStudent = hasMethod(Classroom.class, "addStudent", void.class, studentParam);
		
		Class[] intParam = {int.class};
		boolean removeStudent = hasMethod(Classroom.class, "removeStudent", void.class, intParam);
		
		Class[] noParams = {};
		boolean size = hasMethod(Classroom.class, "size", int.class, noParams);
		
		if (addStudent && removeStudent && size)
		{
			incrementScore();
		}
		
		if ( hasMethod(Classroom.class, "getClassAverageGPA", double.class, noParams) )
		{
			incrementScore();
		}
		
		if ( hasMethod(Classroom.class, "getClassAverageCollegeGPA", double.class, noParams) )
		{
			incrementScore();
		}
		
		if ( hasMethod(Classroom.class, "createStudents", void.class, intParam) )
		{
			incrementScore();
		}
		
		endTask();
		
		/////////////////////////////////////
		
		beginTask("Testing add, remove, and size");
		setScorePossible(1);
		
		Classroom c = new Classroom();
		Student s = new Student();
		c.addStudent(s);
		c.addStudent(s);
		c.addStudent(s);
		c.addStudent(s);
		c.removeStudent(3);
		if (c.size() == 3) incrementScore();
		
		endTask();
		
		/////////////////////////////////////
		
		beginTask("Testing createStudents");
		setScorePossible(2);
		
		c = new Classroom();
		c.addStudent(s);
		c.createStudents(15);

		if (c.size() == 15)
		{
			incrementScore();
		}
		
		double ag = c.getClassAverageGPA();
		double ac = c.getClassAverageCollegeGPA();
		
		if ((ag<4.0 && ag>0.0) &&
		 	(ac<4.0 && ag>0.0) ) {
		 		
		    incrementScore();
		}
		
		endTask();

		/////////////////////////////////////
		
		beginTask("Testing class average GPA methods");
		setScorePossible(2);
		
		c = new Classroom();
		
		Student bMinus = new Student();
		bMinus.setGrades(2.7, 2.7, 2.7, 2.7, 2.7, 2.7);
		
		c.addStudent(bMinus);
		c.addStudent(bMinus);
		c.addStudent(bMinus);
		
		Student bMinus2 = new Student();
		bMinus2.setGrades(2.7, 2.7, 2.7, 2.7, 2.7, 2.7);
		
		c.addStudent(bMinus2);
		c.addStudent(bMinus2);
		c.addStudent(bMinus2);

		ag = c.getClassAverageGPA();
		ac = c.getClassAverageCollegeGPA();

		if (equals(ac, 3.0)) incrementScore();
		if (equals(ag, 2.7)) incrementScore();
		
		endTask();
				
		/////////////////////////////////////
		
		printTotalScore();
	}
}