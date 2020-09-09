package com.example.kotlinlanguagepractice

import java.util.*

class BinaryTree(var value: Int , isRoot: Boolean , var left: BinaryTree? ,
var right: BinaryTree?){
    constructor(value: Int): this(value , false ,null , null)
    constructor(root: Int , isRoot: Boolean) : this(root , isRoot , null , null)

    private var root: Int = 0
    private var isRoot: Boolean = false


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
        var leftCount: Int
        var rightCount: Int
        if(isRoot) {
            return 0
        } else {

            leftCount = if (left?.left == null ) 0
               else left?.left?.height()!!

            rightCount = if(right?.right == null ) 0
                else right?.right?.height()!!

            println("leftCount = "+leftCount )
            println("rightCount = "+rightCount)

            return maxOf(leftCount , rightCount) + 1
        }
    }

    fun insert(value: Int , isRoot: Boolean){
    //adds on the first empty level
        //Queue is interface so can't instantiate it
        var queue: Queue<BinaryTree> = ArrayDeque<BinaryTree>()
        queue.add(this)

        this.isRoot = isRoot

        /*The poll() method is similar to remove()
        (dequeue operation), but it returns null
        if the Queue is empty instead of throwing an exception.*/

        while (!queue.isEmpty()){
            var x = queue.poll()

            if(isRoot) {
                x = BinaryTree(value , isRoot)
                this.root = x.value
                return
            }
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

    fun getRoot(): Int {
        return root
    }

}

fun main(){
    var treeVar = BinaryTree(10)

    treeVar.insert(10 , true)

    println("\n\nAfter inserting root 10 into tree ")

    printData(treeVar)

    treeVar.insert(20 , false)

    println("\n\nAfter inserting first node 20 into tree ")

    printData(treeVar)

    treeVar.insert(90 , false)
    treeVar.insert(5 , false)
    treeVar.insert(107 , false)

    println("\n\nAfter inserting three nodes 90 , 5 , 107 into tree ")

    printData(treeVar)

    treeVar.insert(1 , false)
    treeVar.insert(2 , false)
    treeVar.insert(3 , false)

    println("\n\nAfter inserting three nodes 1 , 2 , 3  into tree ")

    printData(treeVar)
}

fun printData(treeVar: BinaryTree){

    println("Tree's size is : " + treeVar.size())

    println("Tree's height is : " + treeVar.height())

    println("Root element is : "+treeVar.getRoot())

    println("Left Tree elements are as follows: ")

    println(treeVar.getLeftTree()?.value)

    println("Right Tree elements are as follows: ")

    println(treeVar.getRightTree()?.value)

    println("Left's left : "+treeVar.getLeftTree()?.left?.value)

    println("Left's right : "+treeVar.getLeftTree()?.right?.value)

    println("Right's left : "+treeVar.getRightTree()?.left?.value)

    println("Right's right : "+treeVar.getRightTree()?.right?.value)

    /*
    Will write the improved logic for this later :P :D
     */
    println("Left's left left: "+treeVar.getLeftTree()?.left?.left?.value)

}

/*
Output

Need to check the height issue it's showing +1 height and if we don't do +1
in return of maxOf it's showing 0 for everyone need to check.

in foll. output height is showing right but only for these number of nodes
if one more level is added again height is wrong it should take left tree
count as 2 + 1 = 3 it should show height 3 for last insertion of element 3
Will check this issue later.

After inserting root 10 into tree
Tree's size is : 1
Tree's height is : 0
Root element is : 10
Left Tree elements are as follows:
null
Right Tree elements are as follows:
null
Left's left : null
Left's right : null
Right's left : null
Right's right : null
Left's left left: null


After inserting first node 20 into tree
Tree's size is : 2
leftCount = 0
rightCount = 0
Tree's height is : 1
Root element is : 10
Left Tree elements are as follows:
20
Right Tree elements are as follows:
null
Left's left : null
Left's right : null
Right's left : null
Right's right : null
Left's left left: null


After inserting three nodes 90 , 5 , 107 into tree
Tree's size is : 5
leftCount = 0
rightCount = 0
leftCount = 1
rightCount = 0
Tree's height is : 2
Root element is : 10
Left Tree elements are as follows:
20
Right Tree elements are as follows:
90
Left's left : 5
Left's right : 107
Right's left : null
Right's right : null
Left's left left: null


After inserting three nodes 1 , 2 , 3  into tree
Tree's size is : 8
leftCount = 0
rightCount = 0
leftCount = 0
rightCount = 0
leftCount = 1
rightCount = 1
Tree's height is : 2
Root element is : 10
Left Tree elements are as follows:
20
Right Tree elements are as follows:
90
Left's left : 5
Left's right : 107
Right's left : 1
Right's right : 2
Left's left left: 3

 */