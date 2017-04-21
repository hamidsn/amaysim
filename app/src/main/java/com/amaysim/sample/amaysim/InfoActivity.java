package com.amaysim.sample.amaysim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.amaysim.sample.amaysim.managers.DataCacheMgr;
import com.amaysim.sample.amaysim.mappings.ItemCollection;
import com.amaysim.sample.amaysim.utils.StringUtils;

import java.util.List;

import static com.amaysim.sample.amaysim.utils.CoreConst.PRODUCTS;
import static com.amaysim.sample.amaysim.utils.CoreConst.SUBSCRIPTIONS;


/**
 * Created by Hamid on 21/04/2017.
 */

public class InfoActivity extends AppCompatActivity {
    TextView name, expiry, balance_data, name_product, price_product;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        name = (TextView) findViewById(R.id.name);
        expiry = (TextView) findViewById(R.id.expiry);
        balance_data = (TextView) findViewById(R.id.balance_data);
        name_product = (TextView) findViewById(R.id.name_product);
        price_product = (TextView) findViewById(R.id.price_product);

        // We read data from DataCacheManager in all activities :)

        name.setText(DataCacheMgr.getInstance().restoreUserData().getTitle() + " " +
                DataCacheMgr.getInstance().restoreUserData().getFirst_name() + " " +
                DataCacheMgr.getInstance().restoreUserData().getLast_name());

        List<ItemCollection> userIncluded = DataCacheMgr.getInstance().restoreIncluded();
        for (int i = 0; i < userIncluded.size(); i++) {
            if (userIncluded.get(i).getType().equals(SUBSCRIPTIONS)) {
                balance_data.setText("Your data balance is " + String.valueOf(String.format("%.2f",
                        ((double) userIncluded.get(i).getIncluded_data_balance()) / 1024)) + " GB");
                expiry.setText("Your" + userIncluded.get(i).getPayment_type() + "plan expires on "
                        + userIncluded.get(i).getExpiry_date());

            } else if (userIncluded.get(i).getType().equals(PRODUCTS)) {
                name_product.setText("Product: " + userIncluded.get(i).getName());
                price_product.setText("Price: " + StringUtils.formatToCurrency
                        (userIncluded.get(i).getPrice()));
            }
        }


    }
}
