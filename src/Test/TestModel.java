package webservices.webservices.rest.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class TestModel {
	 public Long pkid; // standard pkid.
	 public String pkString; // a primary key string. this will probably be a UUID.
	 public String fkString;  // a foreign key string, also a UUID. the logic here is that in the case of sending cashsales, there needs to be
	                                     // 2 types of records: index and item. if the record is an item, then this field will be populated with the parent's
	                                     // pkString value. I believe this is a pretty good design, as its very generic AND allows infinite linking levels.
	 public String category; // holds 3 possible values, 'index', 'interim' and 'item'. index type records only have pkString values and can
	                                     // be considered the source point. item type records only have fkString values and can be considered the
	                                     // terminating point. interim type records, which currently do not exist, will have both pkString and fkString
	                                     // values and will be used as the in-between linkers in future ideas.
	public String source;  // this will determine if a record came from another EMP instance or a thick client instance.
	public String type; // this will determine the overall type of the record. for now, the only value available is 'cashsale'.
	public String xml; // this is where the xml string will be stored. i will find out the maximum number of characters that a string field can
	                              // hold and set it near that.
	public String json;
	    
	public Integer userid; // this is the userid of the person who generates the transaction.
	public String status; // only two statuses at the moment, 'pending' and 'complete'. i think its enough, but feel free to suggest any other.
	public Timestamp date_created; //the creation date of the transaction. this will only be populated on the thick client side.
	public Timestamp date_received; //the received date of the transaction. this will only be populated on the EMP side.
	public Timestamp date_completed; //the completion date of the transaction. this will only be populated on the EMP side.
	public Integer branchid;
	public BigDecimal amount;
	public String mode; // Mode = "ADD", "UPDATE", "CANCEL"
	public String remarks; //20131014 #20086 RAYHAN
	
    public TestModel()
    {
    	
    }
    
    
    //To Add information which are not provided by Client to convert to standard format.
    public String fillUpJsonToStandardFormat()
    {
    	if(this.category == "index"){
    		//Follow index structure
    	}
    	else if(this.category == "item"){
    		//Follow item structure
    	}
    	else{
    		//error
    	}
        	
    	return this.json;
    }
    
    /*public String toAdd = ""json": {
        "accidentDate": "Jan1, 11 2: 00: 00AM",
        "amountCommission": 0,
        "billingAdd1": "",
        "billingAdd2": "",
        "billingAdd3": "",
        "billingCity": "",
        "billingCompanyName": "",
        "billingCountry": "",
        "billingEmail": "",
        "billingFax": "",
        "billingHandphone": "",
        "billingPhone1": "",
        "billingPhone2": "",
        "billingState": "",
        "billingZip": "",
        "claimAmount": 0,
        "codeDealer": "",
        "codeDept": "",
        "codeProject": "",
        "codeSalesman": "",
        "codeSupplier": "",
        "consignmentId": 0,
        "custSource": "CIMBBankCreditCard",
        "expDeliveryTimeStart": "Feb13, 2014 2: 06: 55AM",
        "groupDiscount": 0,
        "incoterms": "",
        "label_id": 0,
        "loyaltyCardPkid": 0,
        "loyaltyCardStatus": "",
        "loyaltyJTxnReversalStatus": "",
        "loyaltyJTxnStatus": "",
        "loyaltyPointsAwarded": 0,
        "loyaltyPointsRedeemed": 0,
        "loyaltyProcessReversalStatus": "",
        "loyaltyProcessStatus": "",
        "mCostOfGoodsSold": 0,
        "mCurrency": "",
        "mCurrency2": "",
        "mCustSvcCtrId": 1,
        "mDefaultRowsNumber": 15,
        "mDeliveryOrder": 0,
        "mDescription": "",
        "mDisplayFormat": "it1",
        "mDocType": "cust_invoice_index",
        "mEntityCode": "",
        "mEntityContactPerson": "",
        "mEntityGuid": "d3705095-de7c-4d2a-8af3-bfb646801139",
        "mEntityKey": 1013,
        "mEntityName": "ALLIEDMARINEu0026EQUIPMENTSDNBHD",
        "mEntityTable": "cust_account_index",
        "mForeignKey": 0,
        "mForeignTable": "",
        "mForeignText": "",
        "mGuid": "B137E868-F0A5-49BA-B1E9-B20146D8882E",
        "mIdInvoice": 0,
        "mIdentityNumber": "",
        "mLastUpdate": "Feb13, 2014 2: 06: 52AM",
        "mLocationId": -1,
        "mOutstandingAmt": 0,
        "mOutstandingAmt2": 0,
        "mOutstandingBfPdc": 0,
        "mPCCenter": -1,
        "mPaymentTermsId": 0,
        "mPkid": 100001,
        "mReceiptId": 0,
        "mReferenceNo": "",
        "mRemarks": "",
        "mSalesTxnId": 0,
        "mState": "created",
        "mStatus": "active",
        "mStmtNumber": 0,
        "mStmtType": "",
        "mTimeIssued": "Feb13, 2014 12: 00: 00AM",
        "mTotalAmt": 301000,
        "mTotalAmt2": 0,
        "mTxnType": "",
        "mUserIdUpdate": 536,
        "mWorkOrder": 0,
        "membershipCardPkid": 0,
        "permitDoc1": "",
        "permitDoc2": "",
        "permitDoc3": "",
        "permitNo": "",
        "policyNumber": "",
        "posId": 107,
        "rebate1Consume": 0,
        "rebate1Date": "Jan1, 11 2: 00: 00AM",
        "rebate1Gain": 0,
        "rebate1Option": "",
        "rebate2Consume": 0,
        "rebate2Date": "Jan1, 11 2: 00: 00AM",
        "rebate2Gain": 0,
        "rebate2Option": "",
        "receiverAdd1": "",
        "receiverAdd2": "",
        "receiverAdd3": "",
        "receiverCity": "",
        "receiverCompanyName": "",
        "receiverCountry": "",
        "receiverEmail": "",
        "receiverFax": "",
        "receiverHandphone": "",
        "receiverKey": 0,
        "receiverName": "",
        "receiverPhone1": "",
        "receiverPhone2": "",
        "receiverState": "",
        "receiverTable": "",
        "receiverTitle": "",
        "receiverZip": "",
        "runningNo": "",
        "salesId": 0,
        "subtype1": "",
        "subtype2": "",
        "subtype3": "",
        "synchroKey": "B137E868-F0A5-49BA-B1E9-B20146D8882E",
        "taxAmount": 0,
        "taxAmount2": 0,
        "taxDateConverted": "Jan1, 11 2: 00: 00AM",
        "taxEntityName": "",
        "taxFilingCycle": "",
        "taxFilingDate": "Jan1, 11 2: 00: 00AM",
        "taxFilingPkid": 0,
        "taxFilingStatus": "",
        "taxRunningNo1": "",
        "taxRunningNo2": "",
        "taxRunningNoDate": "Jan1, 11 2: 00: 00AM",
        "taxRunningNoType": "",
        "taxType": "",
        "tcCreateTime": "Jan1, 11 2: 00: 00AM",
        "tcDocPkid": 100001,
        "terms1Date": "Jan1, 11 2: 00: 00AM",
        "terms1DiscAmt": 0,
        "terms1DiscPct": 0,
        "terms1Option": "",
        "terms2Date": "Jan1, 11 2: 00: 00AM",
        "terms2DiscAmt": 0,
        "terms2DiscPct": 0,
        "terms2Option": "",
        "timeCreate": "Feb13, 2014 2: 06: 55AM",
        "trackingNo": "",
        "tradersRemarks": "",
        "transportDate": "Jan1, 11 2: 00: 00AM",
        "transportDoc1": "",
        "transportDoc2": "",
        "transportDoc3": "",
        "txnDoc1": "",
        "txnDoc2": "",
        "txnDoc3": "",
        "userId": 0,
        "vecDocLink": [],
        "vecRct": [],
        "whtFilingCycle": "",
        "whtFilingDate": "Jan1, 11 2: 00: 00AM",
        "whtFilingStatus": "",
        "whtTaxAmount": 0,
        "whtTaxBalance": 0,
        "whtTaxCode": "",
        "whtTaxRate": 0,
        "whtTaxType": "",
        "xrate": 0
    }*/
}
