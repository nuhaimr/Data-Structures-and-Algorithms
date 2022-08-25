import java.util.*;

public class Sorting
{
        //class fields
        private int StudentID;
        private String StudentName;

        //Parameters with constructors
        public Sorting(int pStudentID, String pStudentName)
        {
                StudentID = pStudentID;
                StudentName = pStudentName;
        }
        //copy constructor
        public Sorting(Sorting pSorting)
        {
                StudentID = pSorting.getStudentID();
                StudentName = pSorting.getStudentName();
        }

        //default constructor
        public Sorting()
        {
                StudentID = 14495655;
                StudentName = "Sofia BonFiglio";
        }

        //accessors
        public int getStudentID()
        {
                return StudentID;
        }
        public String getStudentName()
        {
                return StudentName;
        }
        public void setStudentID(int pStudentID)
        {
                StudentID = pStudentID;
        }
        public void setStudentName(String pStudentName)
        {
                StudentName = pStudentName;
        }
        public String toString()
        {
                String sortingString;
                sortingString = " ID IS " +  StudentID + "\nName is" + StudentName;
                return sortingString;
        }
}
