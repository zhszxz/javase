package avltree;

//平衡二叉树
public class AVLTree {
    TreeNode root;

    //按照二叉排序树的规则添加节点
    public void add(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        if (root == null) {
            root = treeNode;
        } else {
            add(treeNode, root);
        }
    }

    private void add(TreeNode treeNode, TreeNode cur) {
        //插入节点小于当前节点，向左递归插入
        if (treeNode.val < cur.val) {
            if (cur.left == null) {
                cur.left = treeNode;
            } else {
                add(treeNode, cur.left);
            }
        }
        //插入节点大于等于当前节点，向右递归插入
        else {
            if (cur.right == null) {
                cur.right = treeNode;
            } else {
                add(treeNode, cur.right);
            }
        }
        //添加节点后，判断是否需要旋转
        if (getRightHeight(cur) - getLeftHeight(cur) > 1) {//局部右旋（若需要），整体左旋
            if (cur.right != null && getLeftHeight(cur.right) > getRightHeight(cur.right)) {
                rightRotation(cur.right);
            }
            leftRotation(cur);
        } else if (getLeftHeight(cur) - getRightHeight(cur) > 1) {//局部左旋（若需要），整体右旋
            if (cur.left != null && getLeftHeight(cur.left) < getRightHeight(cur.left)) {
                leftRotation(cur.left);
            }
            rightRotation(cur);
        }
    }

    //返回node左子树的高度
    public int getLeftHeight(TreeNode treeNode) {
        return treeNode.left == null ? 0 : getHeight(treeNode.left);
    }

    //返回node右子树的高度
    public int getRightHeight(TreeNode treeNode) {
        return treeNode.right == null ? 0 : getHeight(treeNode.right);
    }

    //返回以node为根节点的子树的高度
    public int getHeight(TreeNode treeNode) {
        return Math.max(treeNode.left == null ? 0 : getHeight(treeNode.left), treeNode.right == null ? 0 : getHeight(treeNode.right)) + 1;
    }

    //平衡二叉树左旋
    private void leftRotation(TreeNode treeNode) {
        //1.创建新节点，值为当前结点的值
        TreeNode newTreeNode = new TreeNode(treeNode.val);
        //2.把新节点的左子树置为当前节点的左子树
        newTreeNode.left = treeNode.left;
        //3.把新节点的右子树置为当前节点右子树的左子树
        newTreeNode.right = treeNode.right.left;
        //4.把当前结点的值置为右子节点的值
        treeNode.val = treeNode.right.val;
        //5.把当前节点右子树置为右子树的右子树
        treeNode.right = treeNode.right.right;
        //6.把当前节点左子树置为新节点
        treeNode.left = newTreeNode;
    }

    //平衡二叉树右旋
    private void rightRotation(TreeNode treeNode) {
        //1.创建新节点，值为当前结点的值
        TreeNode newTreeNode = new TreeNode(treeNode.val);
        //2.把新节点的右子树置为当前节点的右子树
        newTreeNode.right = treeNode.right;
        //3.把新节点的左子树置为当前节点左子树的右子树
        newTreeNode.left = treeNode.left.right;
        //4.把当前结点的值置为左子节点的值
        treeNode.val = treeNode.left.val;
        //5.把当前节点左子树置为左子树的左子树
        treeNode.left = treeNode.left.left;
        //6.把当前节点右子树置为新节点
        treeNode.right = newTreeNode;
    }

    //查找待删除节点
    private TreeNode search(int value) {
        if (root == null) {
            return null;
        }
        return search(value, root);
    }

    private TreeNode search(int value, TreeNode cur) {
        if (value == cur.val) {
            return cur;
        } else if (value < cur.val && cur.left != null) {
            return search(value, cur.left);
        } else if (value >= cur.val && cur.right != null) {
            return search(value, cur.right);
        } else {
            return null;
        }
    }

    //查找待删除节点的父节点
    public TreeNode searchParent(int value) {
        if (root == null) {
            return null;
        }
        if (root.val == value) {
            return null;
        }
        return searchParent(value, root);
    }

    private TreeNode searchParent(int value, TreeNode cur) {
        if ((cur.left != null && value == cur.left.val) || (cur.right != null && value == cur.right.val)) {
            return cur;
        } else if (cur.left != null && value < cur.val) {
            return searchParent(value, cur.left);
        } else if (cur.right != null && value >= cur.val) {
            return searchParent(value, cur.right);
        } else {
            return null;
        }

    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        TreeNode target = search(value);
        if (target == null) {
            return;
        }
        //若找到了待删除的节点且树只有一个根节点，说明根节点是待删除的节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        TreeNode parent = searchParent(value);
        //若删除的是叶子节点
        if (target.left == null && target.right == null) {
            if (target == parent.left) {
                parent.left = null;
            } else if (target == parent.right) {
                parent.right = null;
            }
        }//若删除的是有左右子树的节点
        else if (target.left != null && target.right != null) {
            TreeNode par = target;
            TreeNode min = par.right;
            if (min.left == null) {
                target.val = min.val;
                target.right = null;
            } else if (min.left != null) {
                par = par.right;
                min = min.left;
                while (true) {
                    if (min.left == null) {
                        break;
                    }
                    min = min.left;
                    par = par.left;
                }
                target.val = min.val;
                par.left = null;
            }
        }//删除的是有一个子树的节点
        else {
            //若target有左子节点
            if (target.left != null) {
                if (parent != null) {
                    if (target == parent.left) {
                        parent.left = target.left;
                    } else if (target == parent.right) {
                        parent.right = target.left;
                    }
                } else {
                    root = target.left;
                }
            }//若target有右子节点
            else if (target.right != null) {
                if (parent != null) {
                    if (target == parent.left) {
                        parent.left = target.right;
                    } else if (target == parent.right) {
                        parent.right = target.right;
                    }
                } else {
                    root = target.right;
                }
            }
        }
    }

    public void inOrder() {
        if (root == null) {
            return;
        }
        inOrder(root);
    }

    private void inOrder(TreeNode cur) {
        if (cur.left != null) {
            inOrder(cur.left);
        }
        System.out.println(cur);
        if (cur.right != null) {
            inOrder(cur.right);
        }
    }

}
