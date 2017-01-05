
object HelloWorld extends App {

    val employees = List("neal", "s", "stu", "j", "rich", "bob", "aiden", "j", "ethan",
        "liam", "mason", "noah", "lucas", "jacob", "jayden", "jack")

    val result = employees
        .filter(_.length() > 1)
        .map(_.capitalize)
        .reduce(_+","+_)

    println(result)

}


HelloWorld.main(args)

