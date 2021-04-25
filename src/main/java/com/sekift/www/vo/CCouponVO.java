package com.sekift.www.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yinzhang.lu
 * @date: 2021/04/25 16:31
 * @description: 满减劵
 **/
@Data
@ApiModel(description="满减劵")
public class CCouponVO {
    @ApiModelProperty(value = "id", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 1)
    private Integer id;

    @ApiModelProperty(value = "优惠劵唯一code", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 2)
    private String couponCode;

    @ApiModelProperty(value = "优惠劵名称", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 3)
    private String couponName;

    @ApiModelProperty(value = "领取页面顶部图", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 4)
    private String headerImg;

    @ApiModelProperty(value = "领取页面底部颜色", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 5)
    private String footerColor;

    @ApiModelProperty(value = "总发行量", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 6)
    private Integer couponTotal;

    @ApiModelProperty(value = "有效期开始时间，可能是当期时间", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       dataType = "date", example = "2020-12-12 12:00:00", allowEmptyValue = true, position = 7)
    private Date beginTime;

    @ApiModelProperty(value = "有效期结束时间，当期时间加天数", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       dataType = "date", example = "2020-12-12 12:00:00", allowEmptyValue = true, position = 8)
    private Date endTime;

    @ApiModelProperty(value = "可领取用户，1-全部，2-新人，3-指定，4-首单", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 9)
    private Byte canUseUser;

    @ApiModelProperty(value = "每人限领", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 10)
    private Integer userPer;

    @ApiModelProperty(value = "使用门槛", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 11)
    private BigDecimal useThreshold;

    @ApiModelProperty(value = "面额", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 12)
    private BigDecimal faceValue;

    @ApiModelProperty(value = "可用商品范围", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 13)
    private String canUseGoods;

    @ApiModelProperty(value = "领取方式，1-手动，2-被动", required = false, accessMode = ApiModelProperty.AccessMode.READ_WRITE,
                       example = "", allowEmptyValue = true, position = 14)
    private Byte getMode;

}