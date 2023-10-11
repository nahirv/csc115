public class A2Exercises {

	/*
	 * Purpose: get the number of students in the given course  	
	 *          with a grade above the given grade threshold
	 * Parameters: UvicCourse course
	 *             int gradeThreshold 
	 * Returns: int - the number of enrolled students with 	
	 *                a grade above gradeThreshold
	 */
	public static int countAbove(UvicCourse course, int gradeThreshold) {
		int count = 0;
		// TODO: implement this
		for (int i = 0; i < course.getClassList().length; i++) {
			if (course.getClassList()[i].getGrade() > gradeThreshold) {
				count++;
			}
		}
		return count;
	}
	
	/*
	 * Purpose: get the name of the class with the highest average
	 * Parameters: UvicCourse[] courses - the array of courses
	 * Returns: String - the name of the course with the highest average
	 * Precondition: the array has at least one course in it
	 * NOTE: if there are two are more courses with the same class average 
	 *       which is the highest value of all courses in the array,
	 *       the name of course that comes first in the array is returned
	 */
	public static String highestAverage(UvicCourse[] courses) {
		String courseName = courses[0].getName();
		// TODO: implement this	
		for (int i = 0; i < (courses.length - 1); i++) {
			if (courses[i].averageGrade() < courses[i+1].averageGrade()) {
				courseName = courses[i+1].getName();
			}
		}
		return courseName; // so it compiles
	}
	
	/*
	 * Purpose: get the average grade of the student with given sid
	 *          across all courses the student is enrolled in
	 * Parameters: UvicCourse[] courses - an array of courses
	 *             String sid - the sid of the student for which 
	 *                          to calculate the average grade for
	 * Returns: double - the average grade of the student with given sid
	 *                   -1 if the student is not in any of the courses	 
	 *
	 * Note: the student is not necessarily enrolled in the courses
	 *       found in the given array
	 */
	public static double studentAverage(UvicCourse[] courses, String sid) {
		// TODO: implement this	
		int sum = 0;
		int count = 0;
		for (int i = 0; i < courses.length; i++) {
			if (courses[i].getGrade(sid) != -1) {
				sum += courses[i].getGrade(sid);
				count++;
			}
		}
		if (count == 0) {
			return -1;
		} else {
			double avg = sum / count;
			return avg;
		}
	}
	
}