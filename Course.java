import java.util.*;
import java.io.*;

public class Course{

  private Subject subject;
  private int number;
  
  private static ArrayList<Course> courses = new ArrayList<Course>();
  
  public static Course GetCourse(String courseCode){
    for(Course c: courses){
      if(c.toString().equals(courseCode)){
	return c;
      }
    }
    return null;
  }

	/*public static void main(String[] args){
		Subject.LoadFromFile();
		Course.LoadFromFile();
		System.out.println(courses.size());
		for(Course c: courses){
			System.out.println(c.toString());
		}		
	}*/


  
  public static void LoadFromFile(){
  try{
    Scanner scan = new Scanner(new File("Courses.txt"));
    while(scan.hasNextLine()){
      Scanner line = new Scanner(scan.nextLine());
      String subjectCode = line.next();
      int courseNumber = line.nextInt();
      new Course(Subject.GetSubjectByCode(subjectCode), courseNumber);
    }
    } catch (IOException e){
      System.out.println(e);
    }
  }
  
  @Override
  public String toString(){
    return subject.GetCode() + Integer.toString(number);
  }
  
  public Course(Subject s, int n){
    subject = s;
    number = n;
    courses.add(this);
  }

}
