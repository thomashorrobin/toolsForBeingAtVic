import java.util.*;
import java.io.*;

public class Subject{
  
  private String SubjectName;
  private String SubjectCode;
  
  private static ArrayList<Subject> subjects = new ArrayList<Subject>();
  
  public static Subject GetSubjectByCode(String code){
    for(Subject s: subjects){
      if(s.GetCode().equals(code)){
	return s;
      }
    }
    return null;
  }
  
  public static void main(String[] args){
    LoadFromFile();
    System.out.println(GetSubjectByCode("MGMT").GetName());
  }
  
  public static void LoadFromFile(){
  try{
    Scanner scan = new Scanner(new File("Subjects.txt"));
    while(scan.hasNextLine()){
      Scanner line = new Scanner(scan.nextLine());
      String code = line.next();
      String name = line.nextLine().trim();
      new Subject(name, code, true);
    }
    } catch (IOException e){
      System.out.println(e);
    }
  }
  
  public static void SaveToFile(){
  try{
    PrintStream ps = new PrintStream(new File("Subjects.txt"));
    for(Subject s: subjects){
      ps.println(s.GetCode() + " " + s.GetName());
    }
    ps.flush();
    ps.close();
  } catch (IOException e){
    System.out.println(e);
  }
  }
  
  public Subject(String name, String code){
    Subject s = GetSubjectByCode(code);
    SubjectName = name;
    SubjectCode = code;
    subjects.add(this);
  }
  
  private Subject(String name, String code, Boolean AddToList){
    SubjectName = name;
    SubjectCode = code;
    if(AddToList){
    subjects.add(this);
    }
  }
  
  public String GetName(){ return SubjectName; }
  public String GetCode(){ return SubjectCode; }
  
  public void Rename(String newName){ SubjectName = newName; }
}
