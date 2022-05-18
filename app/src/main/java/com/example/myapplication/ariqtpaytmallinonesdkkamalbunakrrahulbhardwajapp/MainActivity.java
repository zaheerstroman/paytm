package com.example.myapplication.ariqtpaytmallinonesdkkamalbunakrrahulbhardwajapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;
import com.paytm.pgsdk.TransactionManager;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private String TAG = "MainActivity";
    private ProgressBar progressBar;
    private EditText txnAmount;

    List<TxnToken_OrderId> billlist = new ArrayList<>();
    AppSharedpref appSharedpref;

//    private String midString = "phUBdn85816267299329", txnAmountString = "", orderIdString = "", txnTokenString = "";

//    private String midString ="Your production mode MID here", txnAmountString="", orderIdString="", txnTokenString="";
//    private String midString = "phUBdn85816267299329", txnAmountString = "1", orderIdString = "ORDERID_9878677", txnTokenString = "db68b4afec0a43cfb61295fb48a6415a1649850417167";
//    private String midString = "phUBdn85816267299329", txnAmountString = "1", orderIdString = "Paytm_order_1649921138", txnTokenString = "fd95fc1fc75145a3b35f2535d5ee52c61649921137549";
//    private String midString = "phUBdn85816267299329", txnAmountString = "1", orderIdString = "order_4587", txnTokenString = "5bdb6a5142524fd5a7d2bc398d08ba791649929683965";

//    -------------------------------------------------------------------------------------------------------------------
    //    7382714389
//    Paytm Mini App

//    private String midString = "gXJKzg69117446715397", txnAmountString = "", orderIdString = "", txnTokenString = "";

//    private String midString = "gXJKzg69117446715397", txnAmountString = "1", orderIdString = "Paytm_order_1650272245", txnTokenString = "";
//    private String midString = "gXJKzg69117446715397", txnAmountString = "1", orderIdString = "Paytm_order_1649936599", txnTokenString = "69357ea0d3b94708b0bd9fae696e80c01650010642947";
//   private String midString = "gXJKzg69117446715397", txnAmountString = "1", orderIdString = "ORDERID_98765", txnTokenString = "14bad5083d874b01907cc27523b381821650019480597";
//   private String midString = "gXJKzg69117446715397", txnAmountString = "1", orderIdString = "Paytm_order_1650261516", txnTokenString = "fc2752db491f4f22bae6d8dd0f6b5eff1650261516982";

//    ---------------------------------------------------------------------------------------------------------------------

//    QR

//    private String midString = "LKPHip25982739917049", txnAmountString = "", orderIdString = "", txnTokenString = "";


//    ----------------------------------------------------------------------------------------------------------------------------------------------

//    8500596282
//    website/app

//    private String midString = "uDCgra49195416773464", txnAmountString = "", orderIdString = "", txnTokenString = "";
  private String midString = "DMFzHh87373541678799", txnAmountString = "", orderIdString = "", txnTokenString = "";



    private Button btnPayNow;
    private Integer ActivityRequestCode = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnPayNow = (Button) findViewById(R.id.txnProcessBtn);
        txnAmount = (EditText) findViewById(R.id.txnAmountId);

//        billlist = appSharedpref.getlistofBillsprofiledataurl();

        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("ddMMyyyy");
        String date = df.format(c.getTime());
        Random rand = new Random();
        int min = 1000, max = 9999;

        // nextInt as provided by Random is exclusive of the top value so you need to add 1
        int randomNum = rand.nextInt((max - min) + 1) + min;
        orderIdString = date + String.valueOf(randomNum);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txnAmountString = txnAmount.getText().toString();
                String errors = "";
                if (orderIdString.equalsIgnoreCase("")) {
                    errors = "Enter valid Order ID here\n";
                    Toast.makeText(MainActivity.this, errors, Toast.LENGTH_SHORT).show();

                } else if (txnAmountString.equalsIgnoreCase("")) {
                    errors = "Enter valid Amount here\n";
                    Toast.makeText(MainActivity.this, errors, Toast.LENGTH_SHORT).show();

                } else {
                    getToken();
                }
            }
        });

    }

    private void getToken() {

        Log.e(TAG, " get token start");
        progressBar.setVisibility(View.VISIBLE);

        ServiceWrapper serviceWrapper = new ServiceWrapper(null);
        Call<TxnToken_OrderId> call = serviceWrapper.getTokenCall("12345", midString, orderIdString, txnAmountString);
//        Call<Token_Res_Purna> call = serviceWrapper.getTokenCall("12345", midString, orderIdString, txnAmountString);
//        Call<init_Transaction_OrderId_CustId_Signature_Mid_CallbackUrl_Default_Rahul_Bhardwaj> call = serviceWrapper.getTokenCall("12345", midString, orderIdString, txnAmountString);


        call.enqueue(new Callback<TxnToken_OrderId>() {
            @Override
            public void onResponse(Call<TxnToken_OrderId> call, Response<TxnToken_OrderId> response) {
                Log.e(TAG, " response " + response.isSuccessful());
                progressBar.setVisibility(View.GONE);
                try {

                    if (response.isSuccessful() && response.body() != null) {
//                    if (response.isSuccessful()) {

//                        if (response.body().getBody().getTxnToken() != "") {
//                        if (response.body().getTxnToken() != "") {
//                        if (!response.body().getTxnToken().equals("")) {

//                        if (response.body().getTxnToken() !="" && response.body().getOrderId() !="") {
                      if (!response.body().getTxnToken().equals("") && !response.body().getOrderId().equals("")) {


//                            Log.e(TAG, " transaction token : " + response.body().getBody().getTxnToken());
                            Log.e(TAG, " transaction token : " + response.body().getTxnToken());
                            Log.e(TAG, " Order Id : " + response.body().getOrderId());
//                            startPaytmPayment(response.body().getBody().getTxnToken());
                            startPaytmPayment(response.body().getTxnToken(), response.body().getOrderId());
                        } else {
                            Log.e(TAG, " Token status false");
                        }
                    }
                } catch (Exception e) {
                    Log.e(TAG, " error in Token Res " + e.toString());
                }
            }

            @Override
            public void onFailure(Call<TxnToken_OrderId> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Log.e(TAG, " response error " + t.toString());
            }
        });


    }

    private void startPaytmPayment(String txnToken, String orderId) {

        orderIdString = orderId;
        txnTokenString = txnToken;
        // for test mode use it
//        String host = "https://securegw-stage.paytm.in/";
        // for production mode use it
        String host = "https://securegw.paytm.in/";
//        String host = "https://www.ariqt.com";
        Log.e(TAG, " order_id : " + orderIdString);
//        Log.e(TAG, " Order Id : " + orderIdString);
//        orderIdString= "1804202275455555786568910";

        String orderDetails = "MID: " + midString + ", OrderId: " + orderIdString + ", TxnToken: " + txnTokenString
                + ", Amount: " + txnAmountString;
        Log.e(TAG, "order details "+ orderDetails);

//        Transaction URL:-
//        $PAYTM_TXN_URL='https://securegw-stage.paytm.in/theia/order/process';
//        Transaction Status URL:-
//        $PAYTM_TXN_URL='https://securegw-stage.paytm.in/theia/order/status';

//        String callBackUrl = host;
        String callBackUrl = host + "theia/paytmCallback?ORDER_ID=" + orderIdString;
//        String callBackUrl = host + "theia/paytmCallback?orderId=" + orderIdString;
//        String callBackUrl = host + "theia/initiateTransaction?orderId="+orderIdString;
//        String callBackUrl = host + "theia/processTransaction?orderId="+orderIdString;
//        String callBackUrl = host + "theia/processTransaction?ORDER_ID="+orderIdString;
//        String callBackUrl = host + "theia/processTransaction?ORDER_ID=ORDS7854856"+orderIdString;

        Log.e(TAG, " callback URL " + callBackUrl);

        PaytmOrder paytmOrder = new PaytmOrder(orderIdString, midString, txnTokenString, txnAmountString, callBackUrl);

        TransactionManager transactionManager = new TransactionManager(paytmOrder, new PaytmPaymentTransactionCallback() {
            @Override
            public void onTransactionResponse(Bundle bundle) {
//                Toast.makeText(getApplicationContext(), "Payment Transaction response " + inResponse.toString(), Toast.LENGTH_LONG).show();
                Log.e(TAG, "Response (onTransactionResponse) : " + bundle.toString());
            }

            @Override
            public void networkNotAvailable() {
                Log.e(TAG, "network not available ");
            }

            @Override
            public void onErrorProceed(String s) {
                Log.e(TAG, " onErrorProcess " + s.toString());
            }

            @Override
            public void clientAuthenticationFailed(String s) {
                Log.e(TAG, "Client auth " + s);
            }

            @Override
            public void someUIErrorOccurred(String s) {
                Log.e(TAG, " UI error " + s);
            }

            @Override
            public void onErrorLoadingWebPage(int i, String s, String s1) {
                Log.e(TAG, " error loading web " + s + "--" + s1);
            }

            @Override
            public void onBackPressedCancelTransaction() {
                Log.e(TAG, "backPress ");
            }

            @Override
            public void onTransactionCancel(String s, Bundle bundle) {
                Log.e(TAG, " transaction cancel " + s);
            }
        });

        transactionManager.setShowPaymentUrl(host + "theia/api/v1/showPaymentPage");
        transactionManager.startTransaction(this, ActivityRequestCode);
        transactionManager.setAppInvokeEnabled(false);
//        transactionManager.setShowPaymentUrl("https://securegw-stage.paytm.in/theia/api/v1/showPaymentPage");
        transactionManager.setEmiSubventionEnabled(true);
//        transactionManager.startTransaction(this, requestCode);
//        transactionManager.startTransactionAfterCheckingLoginStatus(this, clientId, requestCode);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e(TAG, " result code " + resultCode);
        // -1 means successful  // 0 means failed
        // one error is - nativeSdkForMerchantMessage : networkError
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ActivityRequestCode && data != null) {
            Bundle bundle = data.getExtras();
            if (bundle != null) {
                for (String key : bundle.keySet()) {
                    Log.e(TAG, key + " : " + (bundle.get(key) != null ? bundle.get(key) : "NULL"));
                }
            }
            Log.e(TAG, " data " + data.getStringExtra("nativeSdkForMerchantMessage"));
            Log.e(TAG, " data response - " + data.getStringExtra("response"));
/*
 data response - {"BANKNAME":"WALLET","BANKTXNID":"1395841115",
 "CHECKSUMHASH":"7jRCFIk6eRmrep+IhnmQrlrL43KSCSXrmMP5pH0hekXaaxjt3MEgd1N9mLtWyu4VwpWexHOILCTAhybOo5EVDmAEV33rg2VAS/p0PXdk\u003d",
 "CURRENCY":"INR","GATEWAYNAME":"WALLET","MID":"EAcR4116","ORDERID":"100620202152",
 "PAYMENTMODE":"PPI","RESPCODE":"01","RESPMSG":"Txn Success","STATUS":"TXN_SUCCESS",
 "TXNAMOUNT":"2.00","TXNDATE":"2020-06-10 16:57:45.0","TXNID":"202006101112128001101683631290118"}
  */
            Toast.makeText(this, data.getStringExtra("nativeSdkForMerchantMessage")
//                    + data.getStringExtra("8500596281"), Toast.LENGTH_SHORT).show();
//                   + data.getStringExtra("7382714389"), Toast.LENGTH_SHORT).show();
                    + data.getStringExtra("response"), Toast.LENGTH_SHORT).show();
//                     + data.getStringExtra(""), Toast.LENGTH_SHORT).show();


        } else {
            Log.e(TAG, " payment failed");
        }
    }

}