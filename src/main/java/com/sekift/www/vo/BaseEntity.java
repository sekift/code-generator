package com.sekift.www.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author sekift
 * @date 2020/10/20 11:15
 * @description 分页所用参数，默认1页10条数据
 **/
@Data
@ApiModel(description="分页基础实例")
public class BaseEntity {
    /**
     * 当前页码
     */
    @ApiModelProperty(value = "当前页码（用于展示，插入数据时不用传）", notes = "默认1", example = "1", position = 100)
    private Integer page = 1;
    /**
     * 每页行数
     */
    @ApiModelProperty(value = "每页行数（用于展示，插入数据时不用传）", notes = "默认10", example = "10", position = 101)
    private Integer rows = 10;
}
