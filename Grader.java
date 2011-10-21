import java.lang.reflect.Field;
import java.lang.reflect.Method;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream; 
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Grader
{
	private static int maxTasks = 100;
	private static int currentTask = 0;
	private static int[] score = new int[maxTasks];
	private static int[] scorePossible = new int[maxTasks];
	private static String[] hints = new String[maxTasks];


	private static PrintStream originalOut = System.out;
	private static InputStream originalIn = System.in;
	private static ByteArrayOutputStream os = new ByteArrayOutputStream();
	private static ByteArrayInputStream is;	
	private static PrintStream ps = new PrintStream(os); 
	
	private final static double EPSILON = 0.00001;
	
	public static boolean equals(double a, double b){
		return a == b ? true : Math.abs(a - b) < EPSILON;
	}
	
	public static void captureSystemOut()
	{
		os.reset();
		System.setOut(ps);
	}
	
	public static void resetSystemOut()
	{
		System.setOut(originalOut);
	}
	
	public static void setInput(String input)
	{
		is = new ByteArrayInputStream(input.getBytes());
		System.setIn( is );
	}
	
	public static boolean systemOutContains(String needle)
	{
		return os.toString().contains(needle);
	}
	
	public static boolean classExists(String className)
	{
		boolean exists = false;
		try
		{	
			Class c = Class.forName(className);
			exists = true;
		}
		catch (ClassNotFoundException e)
		{
			exists = false;
		}
		return exists;
	}
	
	
	public static boolean hasMethod(Class c, String methodName)
	{
		boolean canHaz = false;
		try
		{
			Method[] allMethods = c.getDeclaredMethods();
			for ( Method m : allMethods )
			{
				if( m.getName().equals(methodName) )
					canHaz = true;
			}
		}
		catch (Exception e)
		{
			canHaz = false;
		}
		return canHaz;
	}

	public static boolean hasMethod(Class c, String methodName, Class returnType)
	{
		boolean canHaz = false;
		try
		{
			Method[] allMethods = c.getDeclaredMethods();
			for ( Method m : allMethods )
			{
				if( m.getName().equals(methodName) &&
					m.getReturnType().equals(returnType) )
				{	
					canHaz = true;
				}
			}
		}
		catch (Exception e)
		{
			canHaz = false;
		}
		return canHaz;
	}	
	
	public static boolean hasMethod(Class c, String methodName, Class returnType, Class[] args)
	{
		boolean canHaz = false;
		try
		{
			Method[] allMethods = c.getDeclaredMethods();
			for ( Method m : allMethods )
			{
				if( m.getName().equals(methodName) &&
					m.getReturnType().equals(returnType) )
				{	
					Class[] params = m.getParameterTypes();
					if ( args.length == params.length )
					{
						canHaz = true;
						for(int i = 0; i<args.length; i++)
						{
							if( !args[i].equals(params[i]) )
								return false;
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			canHaz = false;
		}
		return canHaz;
	}
	
	public static void beginTask(String taskName)
	{
		System.out.print(currentTask+"\t"+taskName+"... ");
		captureSystemOut();
	}
	
	public static void endTask()
	{
		System.setOut(originalOut);
		System.setIn(originalIn);
		
		printScore(currentTask);
		currentTask++;
	}
	
	public static void setHint(String h)
	{
		hints[currentTask] = h;
	}
	
	public static void setScorePossible(int max)
	{
		scorePossible[currentTask] = max;
	}

	public static void setScore(int x)
	{
		score[currentTask] = x;
	}
	
	public static void incrementScore()
	{
		increaseScore(1);
	}
	
	public static void increaseScore(int n)
	{
		score[currentTask] += n;
		score[currentTask] = Math.min( score[currentTask], scorePossible[currentTask] );
	}

	public static void printScore(int i)
	{
		
		System.out.println( score[i] + "/" + scorePossible[i] );
		if ( (score[i] < scorePossible[i]) && 
			 (hints[currentTask] != null) )
		{
			System.out.println( "\tHINT: " + hints[currentTask] +"\n");
		}
	}
	
	public static void printTotalScore()
	{
		int total = 0;
		int totalPossible = 0;
		for ( int s : score )
		{
			total += s;
		}
		for ( int sp : scorePossible )
		{
			totalPossible += sp;
		}
		System.out.println("\nTOTAL = " + total + "/" + totalPossible + "\n");
	}
}