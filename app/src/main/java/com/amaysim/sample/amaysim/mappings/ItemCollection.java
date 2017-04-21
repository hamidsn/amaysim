package com.amaysim.sample.amaysim.mappings;

import java.io.Serializable;

/**
 * Created by Hamid on 20/04/2017.
 */

public class ItemCollection implements Serializable {
    private String type;
    private String id;
    private String payment_type;
    private String unbilled_charges;
    private String next_billing_date;
    private String title;
    private String first_name;
    private String last_name;
    private String date_of_birth;
    private String contact_number;
    private String email_address;
    private boolean email_address_verified;
    private boolean email_subscription_status;
    private String msn;
    private int credit;
    private String credit_expiry;
    private boolean data_usage_threshold;
    private int included_data_balance;
    private String included_credit_balance;
    private String included_rollover_credit_balance;
    private String included_rollover_data_balance;
    private String included_international_talk_balance;
    private String expiry_date;
    private boolean auto_renewal;
    private boolean primary_subscription;
    private String name;
    private String included_data;
    private String included_credit;
    private String included_international_talk;
    private boolean unlimited_text;
    private boolean unlimited_talk;
    private boolean unlimited_international_text;
    private boolean unlimited_international_talk;
    private int price;
    private String self;
    private String related;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getUnbilled_charges() {
        return unbilled_charges;
    }

    public void setUnbilled_charges(String unbilled_charges) {
        this.unbilled_charges = unbilled_charges;
    }

    public String getNext_billing_date() {
        return next_billing_date;
    }

    public void setNext_billing_date(String next_billing_date) {
        this.next_billing_date = next_billing_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public boolean isEmail_address_verified() {
        return email_address_verified;
    }

    public void setEmail_address_verified(boolean email_address_verified) {
        this.email_address_verified = email_address_verified;
    }

    public boolean isEmail_subscription_status() {
        return email_subscription_status;
    }

    public void setEmail_subscription_status(boolean email_subscription_status) {
        this.email_subscription_status = email_subscription_status;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getCredit_expiry() {
        return credit_expiry;
    }

    public void setCredit_expiry(String credit_expiry) {
        this.credit_expiry = credit_expiry;
    }

    public boolean isData_usage_threshold() {
        return data_usage_threshold;
    }

    public void setData_usage_threshold(boolean data_usage_threshold) {
        this.data_usage_threshold = data_usage_threshold;
    }

    public int getIncluded_data_balance() {
        return included_data_balance;
    }

    public void setIncluded_data_balance(int included_data_balance) {
        this.included_data_balance = included_data_balance;
    }

    public String getIncluded_credit_balance() {
        return included_credit_balance;
    }

    public void setIncluded_credit_balance(String included_credit_balance) {
        this.included_credit_balance = included_credit_balance;
    }

    public String getIncluded_rollover_credit_balance() {
        return included_rollover_credit_balance;
    }

    public void setIncluded_rollover_credit_balance(String included_rollover_credit_balance) {
        this.included_rollover_credit_balance = included_rollover_credit_balance;
    }

    public String getIncluded_rollover_data_balance() {
        return included_rollover_data_balance;
    }

    public void setIncluded_rollover_data_balance(String included_rollover_data_balance) {
        this.included_rollover_data_balance = included_rollover_data_balance;
    }

    public String getIncluded_international_talk_balance() {
        return included_international_talk_balance;
    }

    public void setIncluded_international_talk_balance(String included_international_talk_balance) {
        this.included_international_talk_balance = included_international_talk_balance;
    }

    public String getExpiry_date() {
        return expiry_date;
    }

    public void setExpiry_date(String expiry_date) {
        this.expiry_date = expiry_date;
    }

    public boolean isAuto_renewal() {
        return auto_renewal;
    }

    public void setAuto_renewal(boolean auto_renewal) {
        this.auto_renewal = auto_renewal;
    }

    public boolean isPrimary_subscription() {
        return primary_subscription;
    }

    public void setPrimary_subscription(boolean primary_subscription) {
        this.primary_subscription = primary_subscription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIncluded_data() {
        return included_data;
    }

    public void setIncluded_data(String included_data) {
        this.included_data = included_data;
    }

    public String getIncluded_credit() {
        return included_credit;
    }

    public void setIncluded_credit(String included_credit) {
        this.included_credit = included_credit;
    }

    public String getIncluded_international_talk() {
        return included_international_talk;
    }

    public void setIncluded_international_talk(String included_international_talk) {
        this.included_international_talk = included_international_talk;
    }

    public boolean isUnlimited_text() {
        return unlimited_text;
    }

    public void setUnlimited_text(boolean unlimited_text) {
        this.unlimited_text = unlimited_text;
    }

    public boolean isUnlimited_talk() {
        return unlimited_talk;
    }

    public void setUnlimited_talk(boolean unlimited_talk) {
        this.unlimited_talk = unlimited_talk;
    }

    public boolean isUnlimited_international_text() {
        return unlimited_international_text;
    }

    public void setUnlimited_international_text(boolean unlimited_international_text) {
        this.unlimited_international_text = unlimited_international_text;
    }

    public boolean isUnlimited_international_talk() {
        return unlimited_international_talk;
    }

    public void setUnlimited_international_talk(boolean unlimited_international_talk) {
        this.unlimited_international_talk = unlimited_international_talk;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSelf() {
        return self;
    }

    public void setSelf(String self) {
        this.self = self;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    /* public ItemCollection(String type, String id, Attributes attributes, Links links, Relationships relationships) {
        this.type = type;
        this.id = id;
        this.attributes = attributes;
        this.links = links;
        this.relationships = relationships;
    }*/

}


////////////
/*
public class ItemCollection {
    private String type;
    private String id;
    private Attributes attributes;
    private Links links;
    private Relationships relationships;

    public ItemCollection(String type, String id, Attributes attributes, Links links, Relationships relationships) {
        this.type = type;
        this.id = id;
        this.attributes = attributes;
        this.links = links;
        this.relationships = relationships;
    }


    public class Attributes {
        private String payment_type;
        private int unbilled_charges;
        private int next_billing_date;
        private String title;
        private String first_name;
        private String last_name;
        private String date_of_birth;
        private String contact_number;
        private String email_address;
        private boolean email_address_verified;
        private boolean email_subscription_status;
        private String msn;
        private int credit;
        private String credit_expiry;
        private boolean data_usage_threshold;
        private int included_data_balance;
        private int included_credit_balance;
        private int included_rollover_credit_balance;
        private int included_rollover_data_balance;
        private String included_international_talk_balance;
        private String expiry_date;
        private boolean auto_renewal;
        private boolean primary_subscription;
        private String name;
        private int included_data;
        private int included_credit;
        private int included_international_talk;
        private boolean unlimited_text;
        private boolean unlimited_talk;
        private boolean unlimited_international_text;
        private boolean unlimited_international_talk;
        private int price;

        public String getPayment_type() {
            return payment_type;
        }

        public void setPayment_type(String payment_type) {
            this.payment_type = payment_type;
        }

        public int getUnbilled_charges() {
            return unbilled_charges;
        }

        public void setUnbilled_charges(int unbilled_charges) {
            this.unbilled_charges = unbilled_charges;
        }

        public int getNext_billing_date() {
            return next_billing_date;
        }

        public void setNext_billing_date(int next_billing_date) {
            this.next_billing_date = next_billing_date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getDate_of_birth() {
            return date_of_birth;
        }

        public void setDate_of_birth(String date_of_birth) {
            this.date_of_birth = date_of_birth;
        }

        public String getContact_number() {
            return contact_number;
        }

        public void setContact_number(String contact_number) {
            this.contact_number = contact_number;
        }

        public String getEmail_address() {
            return email_address;
        }

        public void setEmail_address(String email_address) {
            this.email_address = email_address;
        }

        public boolean isEmail_address_verified() {
            return email_address_verified;
        }

        public void setEmail_address_verified(boolean email_address_verified) {
            this.email_address_verified = email_address_verified;
        }

        public boolean isEmail_subscription_status() {
            return email_subscription_status;
        }

        public void setEmail_subscription_status(boolean email_subscription_status) {
            this.email_subscription_status = email_subscription_status;
        }

        public String getMsn() {
            return msn;
        }

        public void setMsn(String msn) {
            this.msn = msn;
        }

        public int getCredit() {
            return credit;
        }

        public void setCredit(int credit) {
            this.credit = credit;
        }

        public String getCredit_expiry() {
            return credit_expiry;
        }

        public void setCredit_expiry(String credit_expiry) {
            this.credit_expiry = credit_expiry;
        }

        public boolean isData_usage_threshold() {
            return data_usage_threshold;
        }

        public void setData_usage_threshold(boolean data_usage_threshold) {
            this.data_usage_threshold = data_usage_threshold;
        }

        public int getIncluded_data_balance() {
            return included_data_balance;
        }

        public void setIncluded_data_balance(int included_data_balance) {
            this.included_data_balance = included_data_balance;
        }

        public int getIncluded_credit_balance() {
            return included_credit_balance;
        }

        public void setIncluded_credit_balance(int included_credit_balance) {
            this.included_credit_balance = included_credit_balance;
        }

        public int getIncluded_rollover_credit_balance() {
            return included_rollover_credit_balance;
        }

        public void setIncluded_rollover_credit_balance(int included_rollover_credit_balance) {
            this.included_rollover_credit_balance = included_rollover_credit_balance;
        }

        public int getIncluded_rollover_data_balance() {
            return included_rollover_data_balance;
        }

        public void setIncluded_rollover_data_balance(int included_rollover_data_balance) {
            this.included_rollover_data_balance = included_rollover_data_balance;
        }

        public String getIncluded_international_talk_balance() {
            return included_international_talk_balance;
        }

        public void setIncluded_international_talk_balance(String included_international_talk_balance) {
            this.included_international_talk_balance = included_international_talk_balance;
        }

        public String getExpiry_date() {
            return expiry_date;
        }

        public void setExpiry_date(String expiry_date) {
            this.expiry_date = expiry_date;
        }

        public boolean isAuto_renewal() {
            return auto_renewal;
        }

        public void setAuto_renewal(boolean auto_renewal) {
            this.auto_renewal = auto_renewal;
        }

        public boolean isPrimary_subscription() {
            return primary_subscription;
        }

        public void setPrimary_subscription(boolean primary_subscription) {
            this.primary_subscription = primary_subscription;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIncluded_data() {
            return included_data;
        }

        public void setIncluded_data(int included_data) {
            this.included_data = included_data;
        }

        public int getIncluded_credit() {
            return included_credit;
        }

        public void setIncluded_credit(int included_credit) {
            this.included_credit = included_credit;
        }

        public int getIncluded_international_talk() {
            return included_international_talk;
        }

        public void setIncluded_international_talk(int included_international_talk) {
            this.included_international_talk = included_international_talk;
        }

        public boolean isUnlimited_text() {
            return unlimited_text;
        }

        public void setUnlimited_text(boolean unlimited_text) {
            this.unlimited_text = unlimited_text;
        }

        public boolean isUnlimited_talk() {
            return unlimited_talk;
        }

        public void setUnlimited_talk(boolean unlimited_talk) {
            this.unlimited_talk = unlimited_talk;
        }

        public boolean isUnlimited_international_text() {
            return unlimited_international_text;
        }

        public void setUnlimited_international_text(boolean unlimited_international_text) {
            this.unlimited_international_text = unlimited_international_text;
        }

        public boolean isUnlimited_international_talk() {
            return unlimited_international_talk;
        }

        public void setUnlimited_international_talk(boolean unlimited_international_talk) {
            this.unlimited_international_talk = unlimited_international_talk;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

    private class Links {
        private String self;
        private String related;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getRelated() {
            return related;
        }

        public void setRelated(String related) {
            this.related = related;
        }
    }

    private class Relationships {
        // todo

    }

}


*/

