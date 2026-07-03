package binrysorttree;

//二叉排序树
public class BinrySortTree {
    private Node root;

    //按照二叉排序树的规则添加节点
    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (root == null) {
            root = node;
        } else {
            add(node, root);
        }
    }

    private void add(Node node, Node cur) {
        //插入节点小于当前节点，向左递归插入
        if (node.value < cur.value) {
            if (cur.left == null) {
                cur.left = node;
            } else {
                add(node, cur.left);
            }
        }
        //插入节点大于等于当前节点，向右递归插入
        else {
            if (cur.right == null) {
                cur.right = node;
            } else {
                add(node, cur.right);
            }
        }
    }

    //查找待删除节点
    private Node search(int value) {
        if (root == null) {
            return null;
        }
        return search(value, root);
    }

    private Node search(int value, Node cur) {
        if (value == cur.value) {
            return cur;
        } else if (value < cur.value && cur.left != null) {
            return search(value, cur.left);
        } else if (value >= cur.value && cur.right != null) {
            return search(value, cur.right);
        } else {
            return null;
        }
    }

    //查找待删除节点的父节点
    public Node searchParent(int value) {
        if (root == null) {
            return null;
        }
        if (root.value == value) {
            return null;
        }
        return searchParent(value, root);
    }

    private Node searchParent(int value, Node cur) {
        if ((cur.left != null && value == cur.left.value) || (cur.right != null && value == cur.right.value)) {
            return cur;
        } else if (cur.left != null && value < cur.value) {
            return searchParent(value, cur.left);
        } else if (cur.right != null && value >= cur.value) {
            return searchParent(value, cur.right);
        } else {
            return null;
        }

    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        Node target = search(value);
        if (target == null) {
            return;
        }
        //若找到了待删除的节点且树只有一个根节点，说明根节点是待删除的节点
        if (root.left == null && root.right == null) {
            root = null;
            return;
        }
        Node parent = searchParent(value);
        //若删除的是叶子节点
        if (target.left == null && target.right == null) {
            if (target == parent.left) {
                parent.left = null;
            } else if (target == parent.right) {
                parent.right = null;
            }
        }//若删除的是有左右子树的节点
        else if (target.left != null && target.right != null) {
            Node par = target;
            Node min = par.right;
            if (min.left == null) {
                target.value = min.value;
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
                target.value = min.value;
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

    private void inOrder(Node cur) {
        if (cur.left != null) {
            inOrder(cur.left);
        }
        System.out.println(cur);
        if (cur.right != null) {
            inOrder(cur.right);
        }
    }
}
