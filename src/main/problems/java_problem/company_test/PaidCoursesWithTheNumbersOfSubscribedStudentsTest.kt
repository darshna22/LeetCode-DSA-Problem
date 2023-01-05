package java_problem.company_test

typealias Id = Int

data class Course(val id: Id, val name: String, val isPaid: Boolean)
data class Student(val id: Id, val name: String, val subscribedCourses: List<Course>)
interface Repository<T> {
    fun get(): Iterable<T>
}

class RepoImpl<T> : Repository<Student> {
    override fun get(): Iterable<Student> {
        return listOf(
            Student(
                id = 1,
                name = "MK",
                subscribedCourses = listOf(
                    Course(id = 1, name = "Maths", isPaid = true),
                    Course(id = 2, name = "Arts", isPaid = true)
                )
            ),
            Student(
                id = 1,
                name = "DK",
                subscribedCourses = listOf(
                    Course(id = 1, name = "Maths", isPaid = false),
                    Course(id = 2, name = "Arts", isPaid = true)
                )
            )
        )

    }

}


class University(private val repository: Repository<Student>) {
    fun getPaidCoursesWithTheNumbersOfSubscribedStudents(coursesCount: Int): Map<Course, Int> {
        val students = repository.get();

        println(students.first())
        val studentCourseMap = students.map { student ->
            val paidCourses = student.subscribedCourses.filter {
                it.isPaid
            }
            Pair(student, paidCourses)
        }.toMap()

        val courseMap = mutableMapOf<Course, Int>()
        studentCourseMap.map { (student, courses) ->
            courses.map { course ->
                if (!courseMap.containsKey(course)) {
                    courseMap[course] = 1
                } else {
                    courseMap[course] = courseMap[course]!! + 1
                }
            }
        }

        return courseMap
            .toList()
            .sortedByDescending { it.second }
            .take(coursesCount)
            .toMap()

    }


}

object Test {
    @JvmStatic
    fun main(array: Array<String>) {
        val university = University(RepoImpl<Student>());
        println(university.getPaidCoursesWithTheNumbersOfSubscribedStudents(1));
    }
}

