package cn.devcorp.demo.utils;

import java.util.List;

/**
 * Description: 数据树
 *
 * @author YL
 * @date 2019/8/6 15:28
 *
 * <pre>
 *              www.devcorp .cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public interface DataTree<T> {

    /**
     * Description:
     * <获得主键>
     * @author YL
     * @date 16:06 2019/8/8
     * @return java.lang.Long
     **/
    Long getId();

    /**
     * Description:
     * <获得父级id>
     * @author YL
     * @date 16:06 2019/8/8
     * @return java.lang.Long
     **/
    Long getParentId();

    /**
     * Description:
     * <子列表赋值>
     * @author YL
     * @date 16:08 2019/8/8
     * @param childList 1
     **/
    void setChildList(List<T> childList);

    /**
     * Description:
     * <获得子节点列表>
     * @author wenxiaopeng
     * @date 22:03 2021/06/21
     * @return java.util.List<T>
     **/
    List<T> getChildList();

}
