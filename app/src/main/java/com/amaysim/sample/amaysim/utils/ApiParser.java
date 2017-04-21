package com.amaysim.sample.amaysim.utils;

import android.util.Log;

import com.amaysim.sample.amaysim.managers.DataCacheMgr;
import com.amaysim.sample.amaysim.mappings.ItemCollection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.amaysim.sample.amaysim.utils.CoreConst.ATTRIBUTES;
import static com.amaysim.sample.amaysim.utils.CoreConst.AUTO_RENEWAL;
import static com.amaysim.sample.amaysim.utils.CoreConst.CONTACT_NUMBER;
import static com.amaysim.sample.amaysim.utils.CoreConst.CREDIT;
import static com.amaysim.sample.amaysim.utils.CoreConst.CREDIT_EXPIRY;
import static com.amaysim.sample.amaysim.utils.CoreConst.DATA;
import static com.amaysim.sample.amaysim.utils.CoreConst.DATA_USAGE_THRESHOLD;
import static com.amaysim.sample.amaysim.utils.CoreConst.DOB;
import static com.amaysim.sample.amaysim.utils.CoreConst.EXPIRY_DATE;
import static com.amaysim.sample.amaysim.utils.CoreConst.E_ADDRESS;
import static com.amaysim.sample.amaysim.utils.CoreConst.E_ADDRESS_VERIFIED;
import static com.amaysim.sample.amaysim.utils.CoreConst.E_SUBS_STATUS;
import static com.amaysim.sample.amaysim.utils.CoreConst.FIRST_NAME;
import static com.amaysim.sample.amaysim.utils.CoreConst.ID_;
import static com.amaysim.sample.amaysim.utils.CoreConst.INCLUDED;
import static com.amaysim.sample.amaysim.utils.CoreConst.INCLUDED_C;
import static com.amaysim.sample.amaysim.utils.CoreConst.INCLUDED_D;
import static com.amaysim.sample.amaysim.utils.CoreConst.INCLUDED_D_B;
import static com.amaysim.sample.amaysim.utils.CoreConst.INCLUDED_I_T;
import static com.amaysim.sample.amaysim.utils.CoreConst.INCLUDED_I_T_B;
import static com.amaysim.sample.amaysim.utils.CoreConst.INCLUDED_R_C_B;
import static com.amaysim.sample.amaysim.utils.CoreConst.INCLUDED_R_D_B;
import static com.amaysim.sample.amaysim.utils.CoreConst.LAST_NAME;
import static com.amaysim.sample.amaysim.utils.CoreConst.MSN;
import static com.amaysim.sample.amaysim.utils.CoreConst.NAME;
import static com.amaysim.sample.amaysim.utils.CoreConst.NEXT_BILLING_DATE;
import static com.amaysim.sample.amaysim.utils.CoreConst.PAYMENT_TYPE;
import static com.amaysim.sample.amaysim.utils.CoreConst.PRICE;
import static com.amaysim.sample.amaysim.utils.CoreConst.PRIMARY_SUBS;
import static com.amaysim.sample.amaysim.utils.CoreConst.RELATED;
import static com.amaysim.sample.amaysim.utils.CoreConst.SELF;
import static com.amaysim.sample.amaysim.utils.CoreConst.TITLE;
import static com.amaysim.sample.amaysim.utils.CoreConst.TYPE;
import static com.amaysim.sample.amaysim.utils.CoreConst.UNBILLED_CHARGES;
import static com.amaysim.sample.amaysim.utils.CoreConst.UN_I_TALK;
import static com.amaysim.sample.amaysim.utils.CoreConst.UN_I_TEXT;
import static com.amaysim.sample.amaysim.utils.CoreConst.UN_TALK;
import static com.amaysim.sample.amaysim.utils.CoreConst.UN_TEXT;


public class ApiParser {
    static String ERROR_MESSAGE = "Json parsing error: ";
    static String TAG = "APRPARSER";

    public static void parseData(JSONObject jObject) {

        try {
            JSONObject jsonObject = jObject.getJSONObject(DATA);
            ItemCollection dataObject = new ItemCollection();
            dataObject = RR(jsonObject);
            DataCacheMgr.cacheUserData(dataObject);
        } catch (JSONException e) {
            Log.e(TAG, ERROR_MESSAGE + e.getMessage());
        }


        List<ItemCollection> jsonObjects = new ArrayList<ItemCollection>();
        JSONArray jsonArray = null;
        ItemCollection newItemObject = new ItemCollection();
        jsonArray = jObject.optJSONArray(INCLUDED);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonChildNode = null;
            try {
                jsonChildNode = jsonArray.getJSONObject(i);
                newItemObject = RR(jsonChildNode);
                jsonObjects.add(newItemObject);
                // to find the msn login
                JSONObject attribute = jsonChildNode.getJSONObject(ATTRIBUTES);
                if (attribute.has(MSN)) {
                    DataCacheMgr.setMSNLogin(attribute.getString(MSN));
                }

            } catch (final JSONException e) {
                Log.e(TAG, ERROR_MESSAGE + e.getMessage());
            }
        }
        DataCacheMgr.cacheIncluded(jsonObjects);
    }

    private static ItemCollection RR(JSONObject jsonChildNode) {

        ItemCollection newItemObject = new ItemCollection();
        try {
            newItemObject.setType(jsonChildNode.has(TYPE) ? jsonChildNode.getString(TYPE) : "");
            newItemObject.setId(jsonChildNode.has(ID_) ? jsonChildNode.getString(ID_) : "");
            JSONObject attributes = jsonChildNode.has(ATTRIBUTES) ? jsonChildNode.getJSONObject
                    (ATTRIBUTES) : new JSONObject();

            newItemObject.setPayment_type(attributes.has(PAYMENT_TYPE) ? attributes.getString
                    (PAYMENT_TYPE) : "");
            newItemObject.setUnbilled_charges(attributes.has(UNBILLED_CHARGES) ?
                    attributes.getString(UNBILLED_CHARGES) : "");
            newItemObject.setNext_billing_date(attributes.has(NEXT_BILLING_DATE) ?
                    attributes.getString(NEXT_BILLING_DATE) : "");
            newItemObject.setTitle(attributes.has(TITLE) ? attributes.getString(TITLE) : "");
            newItemObject.setFirst_name(attributes.has(FIRST_NAME) ? attributes.getString(FIRST_NAME) : "");
            newItemObject.setLast_name(attributes.has(LAST_NAME) ? attributes.getString(LAST_NAME) : "");
            newItemObject.setDate_of_birth(attributes.has(DOB) ? attributes.getString(DOB) : "");
            newItemObject.setContact_number(attributes.has(CONTACT_NUMBER) ?
                    attributes.getString(CONTACT_NUMBER) : "");
            newItemObject.setEmail_address(attributes.has(E_ADDRESS) ?
                    attributes.getString(E_ADDRESS) : "");
            newItemObject.setEmail_address_verified(attributes.has(E_ADDRESS_VERIFIED) ?
                    attributes.getBoolean(E_ADDRESS_VERIFIED) : false);
            newItemObject.setEmail_subscription_status(attributes.has(E_SUBS_STATUS) ?
                    attributes.getBoolean(E_SUBS_STATUS) : false);
            newItemObject.setMsn(attributes.has(MSN) ? attributes.getString(MSN) : "");
            newItemObject.setCredit(attributes.has(CREDIT) ? attributes.getInt(CREDIT) : 0);
            newItemObject.setCredit_expiry(attributes.has(CREDIT_EXPIRY) ?
                    attributes.getString(CREDIT_EXPIRY) : "");
            newItemObject.setData_usage_threshold(attributes.has(DATA_USAGE_THRESHOLD) ?
                    attributes.getBoolean(DATA_USAGE_THRESHOLD) : false);
            newItemObject.setIncluded_rollover_credit_balance(attributes.has(INCLUDED_R_C_B) ?
                    attributes.getString(INCLUDED_R_C_B) : "");
            newItemObject.setIncluded_data_balance(attributes.has(INCLUDED_D_B) ?
                    attributes.getInt(INCLUDED_D_B) : 0);
            newItemObject.setIncluded_credit_balance(attributes.has(INCLUDED_R_C_B) ?
                    attributes.getString(INCLUDED_R_C_B) : "");
            newItemObject.setIncluded_rollover_data_balance(attributes.has(INCLUDED_R_D_B) ?
                    attributes.getString(INCLUDED_R_D_B) : "");
            newItemObject.setIncluded_international_talk_balance(attributes.has(INCLUDED_I_T_B) ?
                    attributes.getString(INCLUDED_I_T_B) : "");
            newItemObject.setExpiry_date(attributes.has(EXPIRY_DATE) ?
                    attributes.getString(EXPIRY_DATE) : "");
            newItemObject.setAuto_renewal(attributes.has(AUTO_RENEWAL) ?
                    attributes.getBoolean(AUTO_RENEWAL) : false);
            newItemObject.setPrimary_subscription(attributes.has(PRIMARY_SUBS) ?
                    attributes.getBoolean(PRIMARY_SUBS) : false);
            newItemObject.setName(attributes.has(NAME) ? attributes.getString(NAME) : "");
            newItemObject.setIncluded_data(attributes.has(INCLUDED_D) ?
                    attributes.getString(INCLUDED_D) : "");
            newItemObject.setIncluded_credit(attributes.has(INCLUDED_C) ?
                    attributes.getString(INCLUDED_C) : "");
            newItemObject.setIncluded_international_talk(attributes.has(INCLUDED_I_T) ?
                    attributes.getString(INCLUDED_I_T) : "");
            newItemObject.setUnlimited_text(attributes.has(UN_TEXT) ?
                    attributes.getBoolean(UN_TEXT) : false);
            newItemObject.setUnlimited_talk(attributes.has(UN_TALK) ?
                    attributes.getBoolean(UN_TALK) : false);
            newItemObject.setUnlimited_international_text(attributes.has(UN_I_TEXT) ?
                    attributes.getBoolean(UN_I_TEXT) : false);
            newItemObject.setUnlimited_international_text(attributes.has(UN_I_TALK) ?
                    attributes.getBoolean(UN_I_TALK) : false);
            newItemObject.setPrice(attributes.has(PRICE) ? attributes.getInt(PRICE) : 0);
            newItemObject.setSelf(attributes.has(SELF) ? attributes.getString(SELF) : "");
            newItemObject.setRelated(attributes.has(RELATED) ? attributes.getString(RELATED) : "");
        } catch (final JSONException e) {
            Log.e(TAG, ERROR_MESSAGE + e.getMessage());
        }
        return newItemObject;
    }
}
