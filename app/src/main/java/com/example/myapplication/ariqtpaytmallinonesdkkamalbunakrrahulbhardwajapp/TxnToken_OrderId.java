package com.example.myapplication.ariqtpaytmallinonesdkkamalbunakrrahulbhardwajapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TxnToken_OrderId {

    @SerializedName("orderId")
    @Expose
    private String orderId;
    @SerializedName("txnToken")
    @Expose
    private String txnToken;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTxnToken() {
        return txnToken;
    }

    public void setTxnToken(String txnToken) {
        this.txnToken = txnToken;
    }

}
