package cn.devcorp.demo.utils;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 树结构处理工具，适用于 {@link DataTree}
 *
 * @author wenxiaopeng
 * @date 2019/8/6 15:28
 *
 * <pre>
 *              www.devcorp .cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public class TreeUtil {

    private TreeUtil() {
        // make constructor private
    }

    /**
     * Description:为树形存储-从顶端整理>
     * <将平铺的节点转
     * @param nodes         节点列表
     * @author wenxiaopeng
     * @date 21:45 2021/06/21
     * @return java.util.List<T>
     **/
    public static <T extends DataTree<T>> List<T> fillingTree(List<T> nodes) {
        return fillingTree(nodes, null);
    }

    /**
     * Description:
     * <将平铺的节点转为树形存储>
     * @param nodes         节点列表
     * @param fatherId      父节点ID，适用于从树的中间开始整理，若从顶端整理，则为null
     * @author wenxiaopeng
     * @date 21:45 2021/06/21
     * @return java.util.List<T>
     **/
    public static <T extends DataTree<T>> List<T> fillingTree(List<T> nodes, Long fatherId) {
        Map<Long, List<T>> relations = new HashMap<>();
        for (T node : nodes) {
            List<T> relation = relations.computeIfAbsent(node.getParentId(), (p) -> new ArrayList<>());
            relation.add(node);
        }
        nodes.forEach(item -> {
            item.setChildList(relations.getOrDefault(item.getId(), new ArrayList<>()));
        });
        return relations.get(fatherId);
    }

}
