package cn.devcorp.demo.pojo;

import lombok.Data;

import java.util.List;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/12/10 15:29
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
@Data
public class Book {
    private Integer bid;
    private String bname;
    private List<Category> categoryList;
}
