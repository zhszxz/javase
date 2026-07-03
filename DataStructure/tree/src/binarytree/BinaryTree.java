package binarytree;

public class BinaryTree {
    HeroNode root;

    //删除指定节点,将子节点提上来（优先左子节点）
    public boolean delete(int no) {
        if (root == null) {
            return false;
        } else if (no == root.no) {
            root = null;
            return true;
        }
        return delete(no, root);
    }

    public boolean delete(int no, HeroNode node) {
        if (node.left == null && node.right == null) {
            return false;
        }
        if (node.left != null && node.left.no == no) {
            //node.left = null;
            if (node.left.left != null) {
                HeroNode right = node.left.right;
                node.left = node.left.left;
                node.left.right = right;
            } else {
                node.left = node.left.right;
            }
            return true;
        }
        if (node.right != null && node.right.no == no) {
            //node.right = null;
            if (node.right.left != null) {
                HeroNode right = node.right.right;
                node.right = node.right.left;
                node.right.right = right;
            } else {
                node.right = node.right.right;
            }
            return true;
        }
        boolean flag = false;
        if (node.left != null) {
            flag = delete(no, node.left);
        }
        if (flag) {
            return flag;
        }
        if (node.right != null) {
            flag = delete(no, node.right);
        }
        return flag;
    }

    //前序遍历
    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(HeroNode node) {
        if (node != null) {
            System.out.println(node);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(HeroNode node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node);
            inOrder(node.right);
        }
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(HeroNode node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node);
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no) {
        return preOrderSearch(no, root);
    }

    public HeroNode preOrderSearch(int no, HeroNode node) {
        if (node == null) {
            return null;
        }
        if (no == node.no) {
            return node;
        }
        HeroNode res;
        res = preOrderSearch(no, node.left);
        if (res != null) {
            return res;
        }
        return preOrderSearch(no, node.right);
    }

    //中序遍历查找
    public HeroNode inOrderSearch(int no) {
        return inOrderSearch(no, root);
    }

    public HeroNode inOrderSearch(int no, HeroNode node) {
        if (node == null) {
            return null;
        }
        HeroNode res;
        res = inOrderSearch(no, node.left);
        if (res != null) {
            return res;
        }
        if (no == node.no) {
            return node;
        }
        return inOrderSearch(no, node.right);
    }

    //后序遍历查找
    public HeroNode postOrderSearch(int no) {
        return postOrderSearch(no, root);
    }

    public HeroNode postOrderSearch(int no, HeroNode node) {
        if (node == null) {
            return null;
        }
        HeroNode res;
        res = postOrderSearch(no, node.left);
        if (res != null) {
            return res;
        }
        res = postOrderSearch(no, node.right);
        if (res != null) {
            return res;
        }
        if (no == node.no) {
            return node;
        }
        return null;
    }
}
