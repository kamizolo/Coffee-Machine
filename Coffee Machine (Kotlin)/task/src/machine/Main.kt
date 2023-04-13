package machine

fun main() {

    class coffeMachine() {

        var state = "choosing task"
        var water = 400
        var milk = 540
        var coffe = 120
        var cups = 9
        var money = 550

        val cWater = mutableListOf(250,350,200)
        val cMilk = mutableListOf(0,75,100)
        val cCoffe = mutableListOf(16,20,12)
        val cCost = mutableListOf(4,7,6)

        fun buy(type: Int) {

            var tWater = false
            var tMilk = false
            var tCoffe = false
            var tCup = false
            var all = false
            var comma = 3 // , , and

            if(water - cWater[type-1] >= 0) {
                tWater = true
                comma--
            }
            if(milk - cMilk[type-1] >= 0) {
                tMilk = true
                comma--
            }
            if(coffe - cCoffe[type-1] >= 0) {
                tCoffe = true
                comma--
            }
            if(cups > 0) {
                tCup = true
                comma--
            }

            if (tWater && tMilk && tCoffe && tCup) all = true

            if(all) {
                water -= cWater[type-1]
                milk -= cMilk[type-1]
                coffe -= cCoffe[type-1]
                cups--
                money += cCost[type-1]
                println("I have enough resources, making you a coffee!")
            }
            else {
                print("Sorry, not enough ")
                if (!tWater) print("water")
                if (comma > 1) {
                    print(", ")
                    comma--
                } else if (comma == 1) {
                    print(" and ")
                    comma--
                }

                if (!tMilk) print("milk")
                if (comma > 1) {
                    print(", ")
                    comma--
                } else if (comma == 1) {
                    print(" and ")
                    comma--
                }
                if (!tCoffe) print("coffe")
                if (comma == 1) {
                    print(" and ")
                    comma--
                }
                if (!tCup) print("cups")


                println("!")
            }



        }
        fun fill() {
            println("Write how many ml of water you want to add:")
            water += readln().toInt()
            println("Write how many ml of milk you want to add:")
            milk += readln().toInt()
            println("Write how many grams of coffee beans you want to add:")
            coffe += readln().toInt()
            println("Write how many disposable cups you want to add:")
            cups += readln().toInt()
        }
        fun take() {
            println("I gave you $$money")
            money = 0
        }

        fun list() {
            println("The coffee machine has:")
            println("$water ml of water")
            println("$milk ml of milk")
            println("$coffe g of coffee beans")
            println("$cups disposable cups")
            println("$$money of money")
        }

    }

    val coffeMaker = coffeMachine()

    while (true) {
        println("Write action (buy, fill, take, remaining, exit): ")
        var inn = readln()
        if (inn == "buy") {
            println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
            val choice = readln()
            if (choice == "back") continue
            coffeMaker.buy(choice.toInt())
        }
        else if (inn == "fill") coffeMaker.fill()
        else if (inn == "take") coffeMaker.take()
        else if (inn == "exit") break
        else if (inn == "remaining") coffeMaker.list()
    }


}
