package leetcode

class Q98 {
    fun isValidBST(root: TreeNode?): Boolean {
        return recursiveValidBST(root, null, null)
    }

    private fun recursiveValidBST(root: TreeNode?, leftValue: Int?, rightValue: Int?): Boolean {
        if (root == null) return true
        else if ((leftValue != null && root.`val` <= leftValue) || (rightValue != null && root.`val` >= rightValue)) return false

        return recursiveValidBST(root.left, leftValue, root.`val`) && recursiveValidBST(root.right, root.`val`, rightValue)
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main () {
    val q98 = Q98()

    // test
    // [5,4,6,null,null,3,7]
    val childLeftNode = TreeNode(4)
    val childRightNode = TreeNode(6)
    childRightNode.left = TreeNode(3)
    childRightNode.right = TreeNode(7)

    val root = TreeNode(5)
    root.left = childLeftNode
    root.right = childRightNode

    println(q98.isValidBST(root))
}