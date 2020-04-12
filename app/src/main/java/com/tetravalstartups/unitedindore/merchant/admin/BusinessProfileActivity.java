package com.tetravalstartups.unitedindore.merchant.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.tetravalstartups.unitedindore.R;

public class BusinessProfileActivity extends AppCompatActivity implements View.OnClickListener {

    //Class members
    private TextInputEditText etBName;
    private TextInputEditText etBDesc;
    private AutoCompleteTextView atvBCat;
    private AutoCompleteTextView atvBSubCat;
    private AutoCompleteTextView atvBArea;
    private TextInputEditText etBShopNo;
    private TextInputEditText etBShopAddressL1;
    private TextInputEditText etBShopAddressL2;
    private TextInputEditText etBShopPincode;
    private TextInputEditText etBPhoneNumber1;
    private TextInputEditText etBPhoneNumber2;
    private TextInputEditText etBPhoneNumber3;
    private TextInputEditText etBWhatsappNumber;
    private TextInputEditText etBEmailAddress;
    private TextInputEditText etBWebsite;
    private TextInputEditText etBInstagram;
    private TextInputEditText etBLinkedIn;
    private MaterialButton btnProceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_profile);
        init();
    }

    private void init() {
        etBName = findViewById(R.id.etBName);
        etBDesc = findViewById(R.id.etBDesc);
        atvBCat = findViewById(R.id.atvBCat);
        atvBSubCat = findViewById(R.id.atvBSubCat);
        atvBArea = findViewById(R.id.atvBArea);
        etBShopNo = findViewById(R.id.etBShopNo);
        etBShopAddressL1 = findViewById(R.id.etBShopAddressL1);
        etBShopAddressL2 = findViewById(R.id.etBShopAddressL2);
        etBShopPincode = findViewById(R.id.etBShopPincode);
        etBPhoneNumber1 = findViewById(R.id.etBPhoneNumber1);
        etBPhoneNumber2 = findViewById(R.id.etBPhoneNumber2);
        etBPhoneNumber3 = findViewById(R.id.etBPhoneNumber3);
        etBWhatsappNumber = findViewById(R.id.etBWhatsappNumber);
        etBEmailAddress = findViewById(R.id.etBEmailAddress);
        etBWebsite = findViewById(R.id.etBWebsite);
        etBInstagram = findViewById(R.id.etBInstagram);
        etBLinkedIn = findViewById(R.id.etBLinkedIn);
        btnProceed = findViewById(R.id.btnProceed);

        //Appling onClick to button

        btnProceed.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        uiValidate();
    }

    // Applying Validation on onClick

    private void uiValidate() {
        String biz_name = etBName.getText().toString();
        if(TextUtils.isEmpty(biz_name)){
            etBName.requestFocus();
            etBName.setError("Enter Business Name");
            return;
        }
        String biz_des = etBDesc.getText().toString();
        if(TextUtils.isEmpty(biz_des)){
            etBDesc.requestFocus();
            etBDesc.setError("Enter Business Description");
            return;
        }
        String biz_cat = atvBCat.getText().toString();
        if(TextUtils.isEmpty(biz_cat)){
            atvBCat.requestFocus();
            atvBCat.setError("Enter Business Category");
            return;
        }

        String biz_SubCat = atvBSubCat.getText().toString();
        if(TextUtils.isEmpty(biz_SubCat)){
            atvBSubCat.requestFocus();
            atvBSubCat.setError("Enter Business Sub Category");
            return;
        }

        String biz_Area = atvBArea.getText().toString();
        if(TextUtils.isEmpty(biz_Area)){
            atvBArea.requestFocus();
            atvBArea.setError("Enter Business Area");
            return;
        }

        String biz_ShopNo = etBShopNo.getText().toString();
        if(TextUtils.isEmpty(biz_ShopNo)){
            etBShopNo.requestFocus();
            etBShopNo.setError("Enter Business Shop No.");
            return;
        }

        String shop_add1 = etBShopAddressL1.getText().toString();
        if(TextUtils.isEmpty(shop_add1)){
            etBShopAddressL1.requestFocus();
            etBShopAddressL1.setError("Enter Business Address");
            return;
        }

        String shop_add2 = etBShopAddressL2.getText().toString();

        String shop_PinCode = etBShopPincode.getText().toString();

        String biz_phoneNo1 = etBPhoneNumber1.getText().toString();

        if(TextUtils.isEmpty(biz_phoneNo1)){
            etBPhoneNumber1.requestFocus();
            etBPhoneNumber1.setError("Enter PhoneNumber");
            return;
        }

        String biz_phoneNo2 = etBPhoneNumber2.getText().toString();

        String biz_phoneNo3 = etBPhoneNumber3.getText().toString();

        String biz_whatsAppNo = etBWhatsappNumber.getText().toString();

        String biz_Email = etBEmailAddress.getText().toString();

        String biz_Website = etBWebsite.getText().toString();

        String biz_Instagram = etBInstagram.getText().toString();

        String biz_LinkedIn = etBLinkedIn.getText().toString();



    }
}