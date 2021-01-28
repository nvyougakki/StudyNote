package com.heyu.luceneStudy.bean;

import lombok.Data;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;

/**
 * @Author heyu
 * @Date 2021/1/21 15:28
 * @Package com.heyu.luceneStudy.bean
 * @Description
 **/
@Data
@Mapper
public class Order {

    private Integer id;

    private String no;

    private String state;

    private Integer productId;

    private String productNo;

    private String ticketRule;

    private Double buyMiles;

    private Integer payee;

    private String payeeName;

    private Double makeUnitPrice;

    private Double makeRmb;

    private Double otherMake;

    private Double makeTotal;

    private Date makeDate;

    private String makeAccount;

    private String makeOrderId;

    private String makeMan;

    private Integer payer;

    private String payerName;

    private Double payUnitPrice;

    private Double payRmb;

    private Double payOther;

    private Double payTotal;

    private Date payDate;

    private String payAccount;

    private String payOrderId;

    private String payMan;

    private Double unitDiff;

    private Double profit;

    private String creator;

    private Date createTime;

    private Integer operatorId;

    private String operatorName;

    private Date operateTime;

    private String remark;

    private String operatorRemark;

    private Integer passengerNum;

    private Integer creatorId;

    private String airCompany;

    private String ticketState;

    private Integer parentId;

    private String parentNo;

    private String ticketType;

    private Double makeMoney;

    private String makeRemark;

    private Double makeServiceMoney;

    private Double payMiles;

    private Double payMoney;

    private Double payServiceMoney;

    private String payRemark;

}
