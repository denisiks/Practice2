open class Person(val name: String, val birthYear: Int) {
    val age: Int = 2021 - birthYear
}
class Student(Sname: String, Syear: Int,var extramural: Boolean = false, var averageGrade: Double)
    : Person(Sname,Syear)
{
}
class Lecturer(Lname:String, Lyear:Int, var degree : String,var experienceFrom : Int)
    : Person(Lname,Lyear)
{
}
fun main() {
    val persons: List<Person> = listOf(
        Student("Холопов Денис", 2001, false, 4.3),
        Student("Федин Дмитрий", 2000, false, 3.7),
        Student("Шлаев Семён", 2002, true, 4.0),
        Student("Николаев Кирилл", 2001, true, 4.7),
        Student("Сарайкин Кирилл", 2003, false, 3.4),
        Lecturer("Коваленко Роман",1993,"кандидат педагогических наук",2017),
        Lecturer("Путина Анна",1986,"доктор юридических наук",2012),
        Lecturer("Сергеев Михаил",1984,"кандидат физико-математических наук",2007),
        Lecturer("Шумахер Михаил",1977,"доктор технических наук",2004),
        Lecturer("Филин Илья",1969,"доктор исторических наук",2000),
    )
    println("Сортировка списка Persons по возрасту в порядке убывания:")
    persons.sortByAge().forEach{println("${it.name} - ${it.age}")}

    println("\nСортировка списка Students по имени в порядке убывания:")
    val students = mutableListOf<Student>()
    persons.forEach{if(it is Student) students.add(it)}
    students.sortByNameStudents().forEach{println("${it.name}")}

    println("\nСортировка студентов-очников по средней оценке в порядке убывания")
    students.sortByAverageGrade(true).forEach{println("${it.name} - ${it.averageGrade}")}

}
fun List<Person>.sortByAge(): List<Person>{

    return this.sortedByDescending{it.age}
}

fun List<Student>.sortByNameStudents(): List<Student>{

    return this.sortedByDescending{it.name}
}

fun List<Student>.sortByAverageGrade(exceptExtramural: Boolean): List<Student> {

    return if (!exceptExtramural)
        this.sortedByDescending { it.averageGrade }
    else {
        this.filter { !it.extramural }.sortedByDescending { it.averageGrade }
    }
}