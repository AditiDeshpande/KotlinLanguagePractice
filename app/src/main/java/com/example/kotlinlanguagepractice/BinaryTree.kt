package com.example.kotlinlanguagepractice

import java.util.*

class BinaryTree(var value: Int , var left: BinaryTree? ,
var right: BinaryTree?){
    constructor(value: Int): this(value ,null ,null)

    fun size(): Int{
        var size = 1
        if(left != null){
            size += left!!.size()
        }
        if(right != null){
            size += right!!.size()
        }
        return size
    }

    fun height(): Int{

        // !! operator allows u to have NPE if the
        // value to it's left is null

        val left = if( left == null ) 0
        else left!!.height()

        val right: Int = if( right == null ) 0
        else right!!.height()

        return maxOf( left , right) + 1
    }

    fun insert(value: Int){
    //adds on the first empty level
        //Queue is interface so can't instantiate it
        var queue: Queue<BinaryTree> = ArrayDeque<BinaryTree>()
        queue.add(this)

        /*The poll() method is similar to remove()
        (dequeue operation), but it returns null
        if the Queue is empty instead of throwing an exception.*/

        while (!queue.isEmpty()){
            val x = queue.poll()
            if(x.left == null){
                x.left = BinaryTree(value)
                return
            }else if(x.right == null){
                x.right = BinaryTree(value)
                return
            }else{
                queue.add(x.left!!)
                queue.add(x.right!!)
            }
        }

    }

    fun getLeftTree(): BinaryTree?{
      return left
    }

    fun getRightTree(): BinaryTree?{
        return right
    }

//    fun displayTree(tree: BinaryTree){
//
//         for(vals in tree){
//            println(vals.left)
//            println(vals.right)
//        }
//    }
}

fun main(){
    var treeVar = BinaryTree(10)

    treeVar.insert(10)

    printData(treeVar)

    treeVar.insert(20)

    printData(treeVar)

    treeVar.insert(90)
    treeVar.insert(5)
    treeVar.insert(107)

    printData(treeVar)



}

fun printData(treeVar: BinaryTree){
    println("Tree's size is " + treeVar.size())

    println("Tree's height is " + treeVar.height())

    println("Left Tree elements are as follows: ")

    println(treeVar.getLeftTree()?.value)

    println("Right Tree elements are as follows: ")

    println(treeVar.getRightTree()?.value)

    println("Left's left : "+treeVar.getLeftTree()?.left?.value)

    println("Left's right : "+treeVar.getLeftTree()?.right?.value)

    println("Right's left : "+treeVar.getRightTree()?.left?.value)

    println("Right's right : "+treeVar.getRightTree()?.right?.value)

}