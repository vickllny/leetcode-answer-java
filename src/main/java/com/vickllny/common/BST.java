package com.vickllny.common;

public class BST {
    private TreeNode root;

    public BST(TreeNode root){
        this.root = root;
    }

    public TreeNode get(int key){
        TreeNode current = this.root;
        while (current != null && current.val != key){
            if(key < current.val){
                current = current.left;
            }else {
                current = current.right;
            }
        }
        return current;
    }

    public void addNode(int val){
        TreeNode current = root;
        while (true){
            if(val < current.val){
                if(current.left == null){
                    current.left = new TreeNode(val);
                    break;
                }else {
                    current = current.left;
                }
            }else if(val > current.val){
                if(current.right == null){
                    current.right = new TreeNode(val);
                    break;
                }else {
                    current = current.right;
                }
            }else {
                break;
            }
        }
    }

    public void removeNode(int val){
        TreeNode parent = root;
        TreeNode current = root;
        boolean isLeftChild = true;
        while (current != null && current.val != val){
            parent = current;
            if(val < current.val){
                current = current.left;
                isLeftChild = true;
            }else {
                current = current.right;
                isLeftChild = false;
            }
        }
        if(current == null){
            return;
        }
        //case1 no children
        if(current.left == null && current.right == null){
            if(root == current){
                root = null;
            }else if(isLeftChild){
                parent.left = null;
            }else {
                parent.right = null;
            }
        } else if (current.left != null) {
            //find max node
            //找出左子树的最大节点作为新的节点
            TreeNode maxNodeParent = current.left;
            TreeNode maxNode = current.left;
            while (maxNode.right != null){
                maxNodeParent = maxNode;
                maxNode = maxNode.right;
            }
            if(current == root){
                if (maxNode != current.left) {
                    if (maxNode.left != null) {
                        maxNodeParent.right = maxNode.left;
                    }
                    maxNode.left = current.left;
                }
                if(current.right != null){
                    maxNode.right = current.right;
                }
                root = maxNode;
                return;
            }

            if(isLeftChild){
                parent.left = maxNode;
            }else {
                parent.right = maxNode;
            }
            //左子树的最大节点不是当前节点的左子节点，并且最大左子节点的左子节点不等于null
            //将最大子节点的父节点的右子节点指向最大子节点的左子节点
            if(maxNode != current.left && maxNode.left != null){
                maxNodeParent.right = maxNode.left;
            }
            //将最大子节点的左子节点指向当前节点的左子节
            maxNode.left = current.left;
        }else {
            //左子树是null  右子树不为null
            //找出最小节点作为新的节点
            TreeNode minNodeParent = current.right;
            TreeNode minNode = current.right;
            while (minNode.left != null){
                minNodeParent = minNode;
                minNode = minNode.left;
            }

            if(current == root){
                if(minNode.right != null){
                    minNodeParent.left = minNode.right;
                }
                minNode.right = current.right;
                root = minNode;
                return;
            }

            if(isLeftChild){
                parent.left = minNode;
            }else {
                parent.right = minNode;
            }
            if(current.right != minNode && minNode.right != null){
                minNodeParent.left = minNode.right;
            }
            minNode.right = current.right;
        }

    }
}
