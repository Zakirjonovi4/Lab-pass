import java.util.Scanner

fun main(){
    val scan = Scanner(System.`in`)
    var complete:Int = 0 // Полное совпадение
    var partial:Int = 0 // Частичное совпадение
    var attempts:Int = 0 // Попытки
    val randomNum = (1000..9999).random()
    var numberString:String = randomNum.toString()
    println(numberString)

    println("Попробуйте разгадать четырехзначное число")
//    println("Введите первую попытку: ")
    var numberUser:Int = 0
    var numberUserStr:String
    println(randomNum)
    while (numberUser != randomNum){
        complete = 0
        partial = 0
        println("Введите предполагаемое число: ")
        numberUser = scan.nextLine().trim().toInt() // Считали первое число
        numberUserStr = numberUser.toString()
        if (numberUser <= 999) return

       /* Проверяем полные совпадения, с неполными еще есть проблемы*/

        if (numberUserStr[0] == numberString[0]) complete++
            else if((numberUserStr[0] == numberString[1]) || (numberUserStr[0] == numberString[2]) || (numberUserStr[0] == numberString[3])){
                partial++
            }
        if (numberUserStr[1] == numberString[1]) complete++
           else if((numberUserStr[1] == numberString[0]) || (numberUserStr[1] == numberString[2]) || (numberUserStr[1] == numberString[3])){
                partial++
           }
        if (numberUserStr[2] == numberString[2]) complete++
            else if((numberUserStr[2] == numberString[0]) || (numberUserStr[2] == numberString[1]) || (numberUserStr[2] == numberString[3])){
                partial++
            }
        if (numberUserStr[3] == numberString[3]) complete++
            else if((numberUserStr[3] == numberString[0]) || (numberUserStr[3] == numberString[1]) || (numberUserStr[3] == numberString[2])){
                partial++
            }



/*        if (((numberUserStr[0] == numberString[1]) || (numberUserStr[0] == numberString[2]) || (numberUserStr[0] == numberString[3]))) partial++
            else if (((numberUserStr[1] == numberString[0]) || (numberUserStr[1] == numberString[2]) || (numberUserStr[1] == numberString[3]))) partial++
                else if (((numberUserStr[2] == numberString[0]) || (numberUserStr[2] == numberString[1]) || (numberUserStr[2] == numberString[3]))) partial++
                    else if (((numberUserStr[3] == numberString[0]) || (numberUserStr[3] == numberString[1]) || (numberUserStr[3] == numberString[2]))) partial++*/
        if ((partial-complete) >= 0 ) partial -= complete

        println("Колличество полных совпадений: $complete, частичных совпадений: $partial")
    }

    println("Вы выйграли! Правильно число $randomNum")
}