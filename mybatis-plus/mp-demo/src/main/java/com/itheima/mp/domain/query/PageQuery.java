package com.itheima.mp.domain.query;

import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "分页条件实体")
public class PageQuery {
    @ApiModelProperty("页码")
    private Integer pageNo = 1;
    @ApiModelProperty("每页大小")
    private Integer pageSize = 5;
    @ApiModelProperty("排序字段")
    private String order;
    @ApiModelProperty("是否升序")
    private Boolean isAsc = false;

    public <T> Page<T> toPage(OrderItem... defaultOrderItem) {
        //封装分页条件
        Page<T> page = Page.of(pageNo, pageSize);
        //排序条件
        if (order != null) {
            page.addOrder(new OrderItem(order, isAsc));
            return page;
        }
        if (defaultOrderItem != null) {
            page.addOrder(defaultOrderItem);
        }
        return page;
    }

    public <T> Page<T> toPageOrderByCreateTimeDesc() {
        return toPage(new OrderItem("create_time", false));
    }

    public <T> Page<T> toPageOrderByUpdateTimeDesc() {
        return toPage(new OrderItem("update_time", false));
    }
}
