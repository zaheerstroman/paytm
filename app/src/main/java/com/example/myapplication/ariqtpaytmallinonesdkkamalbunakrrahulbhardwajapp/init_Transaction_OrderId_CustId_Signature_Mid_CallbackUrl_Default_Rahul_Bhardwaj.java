package com.example.myapplication.ariqtpaytmallinonesdkkamalbunakrrahulbhardwajapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class init_Transaction_OrderId_CustId_Signature_Mid_CallbackUrl_Default_Rahul_Bhardwaj {

    @SerializedName("head")
    @Expose
    private Head head;
    @SerializedName("body")
    @Expose
    private Body body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public class Head {

        @SerializedName("responseTimestamp")
        @Expose
        private String responseTimestamp;
        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("signature")
        @Expose
        private String signature;

        public String getResponseTimestamp() {
            return responseTimestamp;
        }

        public void setResponseTimestamp(String responseTimestamp) {
            this.responseTimestamp = responseTimestamp;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getSignature() {
            return signature;
        }

        public void setSignature(String signature) {
            this.signature = signature;
        }

    }

    public class Body {

        @SerializedName("resultInfo")
        @Expose
        private ResultInfo resultInfo;
        @SerializedName("txnToken")
        @Expose
        private String txnToken;
        @SerializedName("isPromoCodeValid")
        @Expose
        private boolean isPromoCodeValid;
        @SerializedName("authenticated")
        @Expose
        private boolean authenticated;

        public ResultInfo getResultInfo() {
            return resultInfo;
        }

        public void setResultInfo(ResultInfo resultInfo) {
            this.resultInfo = resultInfo;
        }

        public String getTxnToken() {
            return txnToken;
        }

        public void setTxnToken(String txnToken) {
            this.txnToken = txnToken;
        }

        public boolean isIsPromoCodeValid() {
            return isPromoCodeValid;
        }

        public void setIsPromoCodeValid(boolean isPromoCodeValid) {
            this.isPromoCodeValid = isPromoCodeValid;
        }

        public boolean isAuthenticated() {
            return authenticated;
        }

        public void setAuthenticated(boolean authenticated) {
            this.authenticated = authenticated;
        }

    }

    public class ResultInfo {

        @SerializedName("resultStatus")
        @Expose
        private String resultStatus;
        @SerializedName("resultCode")
        @Expose
        private String resultCode;
        @SerializedName("resultMsg")
        @Expose
        private String resultMsg;

        public String getResultStatus() {
            return resultStatus;
        }

        public void setResultStatus(String resultStatus) {
            this.resultStatus = resultStatus;
        }

        public String getResultCode() {
            return resultCode;
        }

        public void setResultCode(String resultCode) {
            this.resultCode = resultCode;
        }

        public String getResultMsg() {
            return resultMsg;
        }

        public void setResultMsg(String resultMsg) {
            this.resultMsg = resultMsg;
        }

    }


    public class TxnAmount {

        @SerializedName("value")
        @Expose
        private String value;
        @SerializedName("currency")
        @Expose
        private String currency;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }


    }

    public class UserInfo {

        @SerializedName("custId")
        @Expose
        private String custId;

        public String getCustId() {
            return custId;
        }

        public void setCustId(String custId) {
            this.custId = custId;
        }

    }
}
