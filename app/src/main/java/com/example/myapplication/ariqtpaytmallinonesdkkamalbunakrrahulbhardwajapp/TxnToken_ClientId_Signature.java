package com.example.myapplication.ariqtpaytmallinonesdkkamalbunakrrahulbhardwajapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TxnToken_ClientId_Signature {

    @SerializedName("head")
    @Expose
    private Token_Res_Kamal_Bunkar_Purna.Head head;
    @SerializedName("body")
    @Expose
    private Token_Res_Kamal_Bunkar_Purna.Body body;

    public Token_Res_Kamal_Bunkar_Purna.Head getHead() {
        return head;
    }

    public void setHead(Token_Res_Kamal_Bunkar_Purna.Head head) {
        this.head = head;
    }

    public Token_Res_Kamal_Bunkar_Purna.Body getBody() {
        return body;
    }

    public void setBody(Token_Res_Kamal_Bunkar_Purna.Body body) {
        this.body = body;
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
    public class Head {

        @SerializedName("responseTimestamp")
        @Expose
        private String responseTimestamp;
        @SerializedName("version")
        @Expose
        private String version;
        @SerializedName("clientId")
        @Expose
        private String clientId;
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

        public String getClientId() {
            return clientId;
        }

        public void setClientId(String clientId) {
            this.clientId = clientId;
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
        private Token_Res_Kamal_Bunkar_Purna.ResultInfo resultInfo;
        @SerializedName("txnToken")
        @Expose
        private String txnToken;
        @SerializedName("isPromoCodeValid")
        @Expose
        private boolean isPromoCodeValid;
        @SerializedName("authenticated")
        @Expose
        private boolean authenticated;

        public Token_Res_Kamal_Bunkar_Purna.ResultInfo getResultInfo() {
            return resultInfo;
        }

        public void setResultInfo(Token_Res_Kamal_Bunkar_Purna.ResultInfo resultInfo) {
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

}
