import java.util.ArrayList;

public class Classroom
{
	private ArrayList<Student> roster = new ArrayList<Student>();
	
	public void addStudent(Student s)
	{
		roster.add(s);
	}
	
	public void removeStudent(int i)
	{
		roster.remove(i);
	}
	
	public int size()
	{
		return roster.size();
	}
	
	double getClassAverageGPA()
	{
		double total = 0;
		for(Student s: roster)
		{
			total += s.getGPA();
		}
		return total / size();
	}
	
	double getClassAverageCollegeGPA()
	{
		double total = 0;
		for(Student s: roster)
		{
			total += s.getCollegeGPA();
		}
		return total / size();
	}
	
	void createStudents(int x)
	{
		roster = new ArrayList<Student>();
		while(x>0)
		{
			Student s = new Student();
			s.setGrades( Math.random()*4,
						 Math.random()*4,
						 Math.random()*4,
						 Math.random()*4,
						 Math.random()*4,
						 Math.random()*4  );
			roster.add(s);
			x--;
		}
	}
}