package com.example.kotlinlanguagepractice

class Tree(var value: Int){
    val children: MutableList<Tree> = mutableListOf()


    /*

    https://stackoverflow.com/questions/44429419/what-is-basic-difference-between-fold-and-reduce-in-kotlin-when-to-use-which

    listOf(1, 2, 3).fold(0) { sum, element -> sum + element }
The first call to the lambda will be with parameters 0 and 1.

listOf(1, 2, 3).reduce { sum, element -> sum + element }
The first call to the lambda here will be with parameters 1 and 2.

-> operator
https://stackoverflow.com/questions/42646016/what-does-the-arrow-operator-do-in-kotlin#:~:text=The%20%2D%3E%20is%20a%20separator.,R%2C%20T)%20%2D%3E%20R

     */
    fun size(): Int{
            return children.fold(
                1,
                {size , child -> size + child.size()}
            )
    }

    fun height(): Int{
        return 1 + (children.map { it.size() }.max() ?: 0 )
    }

    fun add(value: Int){
        children.add(Tree(value))
    }

    fun getTreeValues(): MutableList<Tree>{
        return children
    }
}

fun main(){
    var treeVar = Tree(10)

    treeVar.add(10)

    println("Tree's size is " + treeVar.size())
    println("Tree's height is "+ treeVar.height())

    val iterate = treeVar.getTreeValues()
    for(element in iterate){
        println(""+element.value)
    }

    treeVar.add(20)

    println("Tree's size is " + treeVar.size())
    println("Tree's height is "+ treeVar.height())


    for(element in iterate){
        println(""+element.value)
    }

    treeVar.add(90)
    treeVar.add(5)
    treeVar.add(107)

    println("Tree's size is " + treeVar.size())
    println("Tree's height is "+ treeVar.height())

    for(element in iterate){
        println(""+element.value)
    }

}


/*
Output

Why the size is +1 than actual size

Tree's size is 2
Tree's height is 2
10
Tree's size is 3
Tree's height is 2
10
20
Tree's size is 6
Tree's height is 2
10
20
90
5
107


 */
