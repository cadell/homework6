/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package errorhandlingexample;

/**
 * The Purpose of the class is to define the student Object. Which is mainly 
 * defined by the student last name and GPA.
 * @author cadelmonterde
 */
public class Student implements Comparable<Student>{
    
    private String lastName;
    private double gpa;
    
    /**
     * Constructor to create a student object with a last name and GPA as parameters.
     * @param ln
     * @param aGPA 
     */
    public Student(String ln, double aGPA)
    {
        lastName = ln;
        gpa = aGPA;
    }

    /**
     * Returns the current lastName held by the object
     * @return 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the current GPA held by the object.
     * @return 
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Allows the user to set a new lastName.
     * @param lastName 
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Allows the user to set a new GPA.
     * @param gpa 
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * toString method used to display what the object holds.
     * @return 
     */
    @Override
    public String toString() {
        return "Student{" + "lastName=" + lastName + ", gpa=" + gpa + '}';
    }

    /**
     * The compareTo method compares one GPA to another, returns 0 if the are equal
     * one if the object one is bigger than the parameter object and negative one
     * otherwise.
     * @param o
     * @return 
     */
    @Override
    public int compareTo(Student o) {
        if(gpa == o.getGpa())
        return 0;
        else if(gpa > o.getGpa()) return -1;
        else return 1;
    }
    
    
}
