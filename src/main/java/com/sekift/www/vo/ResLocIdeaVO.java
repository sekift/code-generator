package com.sekift.www.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: yinzhang.lu
 * @date: 2020/11/30 14:49
 * @description: 活动创意
 **/
@Data
@ApiModel(description="活动创意")
public class ResLocIdeaVO {
    @ApiModelProperty(value = "创意ID", required = false, readOnly = false,example = "", allowEmptyValue = true, position = 1)
    private Integer id;

    @ApiModelProperty(value = "资源位ID", required = false, readOnly = false,example = "", allowEmptyValue = true, position = 2)
    private Integer resLocId;

    @ApiModelProperty(value = "创意名称", required = false, readOnly = false,example = "", allowEmptyValue = true, position = 3)
    private String ideaName;

    @ApiModelProperty(value = "资源内容配置用户ID", required = false, readOnly = false,example = "", allowEmptyValue = true, position = 4)
    private Integer userId;

    @ApiModelProperty(value = "更新时间", required = false, readOnly = false,dataType = "date", example = "2020-10-20 10:40:00", allowEmptyValue = true, position = 5)
    private Date updateTime;

}
