package com.sekift.www.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/09 16:21
 * @description: 终端类型标息
 **/
@Data
@ApiModel(description="终端类型标息")
public class TerminalTypeInfoVO {
    @ApiModelProperty(value = "ID", required = false, readOnly = false,example = "", allowEmptyValue = true, position = 1)
    private Integer id;

    @ApiModelProperty(value = "终端形态ID（1：硬件终端；2：软件终端）", required = false, readOnly = false,example = "", allowEmptyValue = true, position = 2)
    private Byte trmlFormId;

    @ApiModelProperty(value = "产品类型ID", required = false, readOnly = false,example = "", allowEmptyValue = true, position = 3)
    private Integer prdctTypeId;

    @ApiModelProperty(value = "终端形态名称", required = false, readOnly = false,example = "", allowEmptyValue = true, position = 4)
    private String trmlFormName;

    @ApiModelProperty(value = "产品类型名称", required = false, readOnly = false,example = "", allowEmptyValue = true, position = 5)
    private String prdctTypeName;

    @ApiModelProperty(value = "更新时间", required = false, readOnly = false,dataType = "date", example = "2020-10-20 10:40:00", allowEmptyValue = true, position = 6)
    private Date updateTime;

}
