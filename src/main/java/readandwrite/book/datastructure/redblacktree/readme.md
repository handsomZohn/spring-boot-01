##红黑树：
自平衡的二叉查找树。在红黑树的每个节点上都多出一个存储为表示节点的颜色，颜色只能是红色或者黑色。

###红黑树的特性：
#####每个节点非黑即红
#####根节点都是黑色的
#####每个页子节点（NIL）都是黑色的
#####如果一个节点是红色的，则它的子节点必须是黑色的
#####从一个节点到该节点的子孙节点的所有路径上都包含相同数量的黑色节点