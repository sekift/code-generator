package com.sekift.www.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: yinzhang.lu
 * @date: 2020/12/17 17:06
 * @description: 资源位内容表
 **/
@Data
@ApiModel(description="资源位内容表")
public class ResLocPosTypeVO {
    @ApiModelProperty(value = "资源位位置编码", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 1)
    private String id;

    @ApiModelProperty(value = "资源位位置名称", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 2)
    private String name;

    @ApiModelProperty(value = "创建时间", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       dataType = "date", example = "2020-12-12 12:00:00", allowEmptyValue = true, position = 3)
    private Date createTime;

    @ApiModelProperty(value = "更新时间", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       dataType = "date", example = "2020-12-12 12:00:00", allowEmptyValue = true, position = 4)
    private Date updateTime;

}