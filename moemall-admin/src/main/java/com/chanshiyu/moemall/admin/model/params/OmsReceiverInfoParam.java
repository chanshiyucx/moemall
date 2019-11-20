package com.chanshiyu.moemall.admin.model.params;

import lombok.Data;

/**
 * @author SHIYU
 * @date 2019/11/19 15:37
 * @description 订单修改收货人信息参数
 */
@Data
public class OmsReceiverInfoParam {
    private Long orderId;
    private String receiverName;
    private String receiverPhone;
    private String receiverPostCode;
    private String receiverDetailAddress;
    private String receiverProvince;
    private String receiverCity;
    private String receiverRegion;
    private Integer status;
}
