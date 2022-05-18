package com.example.myapplication.ariqtpaytmallinonesdkkamalbunakrrahulbhardwajapp;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ServiceInterface {

//    String BASE_URL = "http://10.11.2.122/paytm-all-in-one-completecode/paytmallinone_init_transaction/";
//    String BASE_URL = "http://192.168.43.71/paytm-all-in-one-completecode/paytmallinone_init_transaction/paytmallinone/";
//    String BASE_URL = "http://10.11.2.122/paytm-all-in-one-completecode/paytmallinone_init_transaction/paytmallinone/";
//    String BASE_URL = "http://10.11.2.122/paytm-all-in-one-completecode/paytmallinone_init_transaction/paytmallinone/index.php";

//    String BASE_URL = "http://10.11.2.122/paytm_kamal_bunkar_assynch";


//    String BASE_URL = "http://10.11.2.122/paytm-all-in-one-completecode_test_staging/paytmallinone_init_transaction/paytmallinone/";
//    String BASE_URL = "http://10.11.2.122/paytm-all-in-one-completecode_Production/paytmallinone_init_transaction/paytmallinone/";
//    String BASE_URL = "http://10.11.2.122:80/paytm-all-in-one-completecode_Production/paytmallinone_init_transaction/paytmallinone/";

//    String BASE_URL = "http://10.11.2.122:80/paytm-all-in-one-completecode_Production/paytmallinone_init_transaction/paytmallinone/";
//    String BASE_URL = "http://10.13.7.38:80/paytm-all-in-one-completecode_Production/paytmallinone_init_transaction/paytmallinone/";

        String BASE_URL = "http://10.13.7.38/paytm-all-in-one-completecode_Production/paytmallinone_init_transaction/paytmallinone/";
//    String BASE_URL = "http://10.11.2.122/paytm-all-in-one-completecode_Production/paytmallinone_init_transaction/paytmallinone/";

    // method,, return type ,, secondary url
    @Multipart

//    signature + txnToken + ORDER_ID=Paytm_order_1652339737
//    @POST("init_Transaction.php")

//    signature + txnToken
//    @POST("init_Transaction_Purna.php")

//    73282714389 zaheerkhamx143@gmail.com
//    @POST("init_Transaction_OrderId_Rahul_Bhardwaj.php")
//    @POST("init_Transaction_OrderId_CustId_Signature_Mid_CallbackUrl_Default_Rahul_Bhardwaj.php")

//    8500596281 kingstromanx@gmail.com
    @POST("init_Transaction_OrderId_Kshama_Himanshu_Bhardwaj.php")

//    @POST("process_Transaction_Purna.php")
//    @POST("paytmallinone/init_Transaction.php")
//    @POST("paytmallinone/init_Transaction_kamal_tutorial.php")

    Call<TxnToken_OrderId> generateTokenCall(
            @Part("code") RequestBody language,
            @Part("MID") RequestBody mid,
            @Part("ORDER_ID") RequestBody order_id,
            @Part("AMOUNT") RequestBody amount
    );

}
