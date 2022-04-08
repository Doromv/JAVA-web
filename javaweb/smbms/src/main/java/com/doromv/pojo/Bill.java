package com.doromv.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * (SmbmsBill)实体类
 *
 * @author makejava
 * @since 2022-01-20 17:41:06
 */
public class Bill implements Serializable {
    private static final long serialVersionUID = -34190690589772605L;
    /**
     * 主键ID
     */
    private Long id;
    /**
     * 账单编码
     */
    private String billcode;
    /**
     * 商品名称
     */
    private String productname;
    /**
     * 商品描述
     */
    private String productdesc;
    /**
     * 商品单位
     */
    private String productunit;
    /**
     * 商品数量
     */
    private Double productcount;
    /**
     * 商品总额
     */
    private Double totalprice;
    /**
     * 是否支付（1：未支付 2：已支付）
     */
    private Integer ispayment;
    /**
     * 创建者（userId）
     */
    private Long createdby;
    /**
     * 创建时间
     */
    private Date creationdate;
    /**
     * 更新者（userId）
     */
    private Long modifyby;
    /**
     * 更新时间
     */
    private Date modifydate;
    /**
     * 供应商ID
     */
    private Long providerid;

    private String providerName;//供应商名称

    private String getProviderName(){return providerName;}

    private void  setProviderName(String providerName){this.providerName=providerName;}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductdesc() {
        return productdesc;
    }

    public void setProductdesc(String productdesc) {
        this.productdesc = productdesc;
    }

    public String getProductunit() {
        return productunit;
    }

    public void setProductunit(String productunit) {
        this.productunit = productunit;
    }

    public Double getProductcount() {
        return productcount;
    }

    public void setProductcount(Double productcount) {
        this.productcount = productcount;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getIspayment() {
        return ispayment;
    }

    public void setIspayment(Integer ispayment) {
        this.ispayment = ispayment;
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

    public Long getProviderid() {
        return providerid;
    }

    public void setProviderid(Long providerid) {
        this.providerid = providerid;
    }

}

