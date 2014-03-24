package webservices.webservices.rest.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.json.simple.*;

import sun.org.mozilla.javascript.internal.ObjToIntMap;

import com.vlee.ejb.customer.TxQueueObject;


public class TestModel extends TxQueueObject{
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
	
	private String toAddIndex ="\"accidentDate\": \"Jan1, 11 2: 00: 00AM\",\"amountCommission\": 0,\"billingAdd1\": \"\",\"billingAdd2\": \"\",\"billingAdd3\": \"\"," +
	"\"billingCity\": \"\",\"billingCompanyName\": \"\",\"billingCountry\": \"\",\"billingEmail\": \"\",\"billingFax\": \"\",\"billingHandphone\": \"\"," +
	"\"billingPhone1\": \"\",\"billingPhone2\": \"\",\"billingState\": \"\",\"billingZip\": \"\",\"claimAmount\": 0,\"codeDealer\": \"\",\"codeDept\": \"\"," +
	"\"codeProject\": \"\",\"codeSalesman\": \"\",\"codeSupplier\": \"\",\"consignmentId\": 0,\"custSource\": \"CIMBBankCreditCard\"," +
	"\"expDeliveryTimeStart\": \"Feb13, 2014 2: 06: 55AM\",\"groupDiscount\": 0,\"incoterms\": \"\",\"label_id\": 0,\"loyaltyCardPkid\": 0," +
	"\"loyaltyCardStatus\": \"\",\"loyaltyJTxnReversalStatus\": \"\",\"loyaltyJTxnStatus\": \"\",\"loyaltyPointsAwarded\": 0,\"loyaltyPointsRedeemed\": 0," +
	"\"loyaltyProcessReversalStatus\": \"\",\"loyaltyProcessStatus\": \"\",\"mCostOfGoodsSold\": 0,\"mCurrency\": \"\",\"mCurrency2\": \"\"," +
	"\"mCustSvcCtrId\": 1,\"mDefaultRowsNumber\": 15,\"mDeliveryOrder\": 0,\"mDescription\": \"\",\"mDisplayFormat\": \"it1\"," +
	"\"mDocType\": \"cust_invoice_index\",\"mEntityCode\": \"\",\"mEntityContactPerson\": \"\",\"mEntityGuid\": \"d3705095-de7c-4d2a-8af3-bfb646801139\"," +
	"\"mEntityName\": \"ALLIEDMARINEu0026EQUIPMENTSDNBHD\",\"mEntityTable\": \"cust_account_index\",\"mForeignKey\": 0," +
	"\"mForeignTable\": \"\",\"mForeignText\": \"\",\"mGuid\": \"B137E868-F0A5-49BA-B1E9-B20146D8882E\",\"mIdInvoice\": 0,\"mIdentityNumber\": \"\"," +
	"\"mLastUpdate\": \"Feb13, 2014 2: 06: 52AM\",\"mLocationId\": -1,\"mOutstandingAmt\": 0,\"mOutstandingAmt2\": 0,\"mOutstandingBfPdc\": 0," +
	"\"mPCCenter\": -1,\"mPaymentTermsId\": 0,\"mPkid\": 100001,\"mReceiptId\": 0,\"mReferenceNo\": \"\",\"mRemarks\": \"\",\"mSalesTxnId\": 0," +
	"\"mState\": \"created\",\"mStatus\": \"active\",\"mStmtNumber\": 0,\"mStmtType\": \"\"," +
	"\"mTotalAmt2\": 0,\"mTxnType\": \"\",\"mUserIdUpdate\": 536,\"mWorkOrder\": 0,\"membershipCardPkid\": 0," +
	"\"permitDoc1\": \"\",\"permitDoc2\": \"\",\"permitDoc3\": \"\",\"permitNo\": \"\",\"policyNumber\": \"\",\"posId\": 107,\"rebate1Consume\": 0," +
	"\"rebate1Date\": \"Jan1, 11 2: 00: 00AM\",\"rebate1Gain\": 0,\"rebate1Option\": \"\",\"rebate2Consume\": 0,\"rebate2Date\": \"Jan1, 11 2: 00: 00AM\"," +
	"\"rebate2Gain\": 0,\"rebate2Option\": \"\",\"receiverAdd1\": \"\",\"receiverAdd2\": \"\",\"receiverAdd3\": \"\",\"receiverCity\": \"\"," +
	"\"receiverCompanyName\": \"\",\"receiverCountry\": \"\",\"receiverEmail\": \"\",\"receiverFax\": \"\",\"receiverHandphone\": \"\"," +
	"\"receiverKey\": 0,\"receiverName\": \"\",\"receiverPhone1\": \"\",\"receiverPhone2\": \"\",\"receiverState\": \"\"," +
	"\"receiverTable\": \"\",\"receiverTitle\": \"\",\"receiverZip\": \"\",\"runningNo\": \"\",\"salesId\": 0,\"subtype1\": \"\"," +
	"\"subtype2\": \"\",\"subtype3\": \"\",\"synchroKey\": \"B137E868-F0A5-49BA-B1E9-B20146D8882E\",\"taxAmount\": 0,\"taxAmount2\": 0," +
	"\"taxDateConverted\": \"Jan1, 11 2: 00: 00AM\",\"taxEntityName\": \"\",\"taxFilingCycle\": \"\",\"taxFilingDate\": \"Jan1, 11 2: 00: 00AM\"," +
	"\"taxFilingPkid\": 0,\"taxFilingStatus\": \"\",\"taxRunningNo1\": \"\",\"taxRunningNo2\": \"\",\"taxRunningNoDate\": \"Jan1, 11 2: 00: 00AM\"," +
	"\"taxRunningNoType\": \"\",\"taxType\": \"\",\"tcCreateTime\": \"Jan1, 11 2: 00: 00AM\",\"tcDocPkid\": 100001,\"terms1Date\": \"Jan1, 11 2: 00: 00AM\"," +
	"\"terms1DiscAmt\": 0,\"terms1DiscPct\": 0,\"terms1Option\": \"\",\"terms2Date\": \"Jan1, 11 2: 00: 00AM\",\"terms2DiscAmt\": 0," +
	"\"terms2DiscPct\": 0,\"terms2Option\": \"\",\"timeCreate\": \"Feb13, 2014 2: 06: 55AM\",\"trackingNo\": \"\",\"tradersRemarks\": \"\"," +
	"\"transportDate\": \"Jan1, 11 2: 00: 00AM\",\"transportDoc1\": \"\",\"transportDoc2\": \"\",\"transportDoc3\": \"\",\"txnDoc1\": \"\"," +
	"\"txnDoc2\": \"\",\"txnDoc3\": \"\",\"userId\": 0,\"vecDocLink\": [],\"vecRct\": [],\"whtFilingCycle\": \"\",\"whtFilingDate\": \"Jan1, 11 2: 00: 00AM\"," +
	"\"whtFilingStatus\": \"\",\"whtTaxAmount\": 0,\"whtTaxBalance\": 0,\"whtTaxCode\": \"\",\"whtTaxRate\": 0,\"whtTaxType\": \"\",\"xrate\": 0";
	
	
	private String toAddItem = "\"bomConvertMode\": \"\",\"bomConvertStatus\": \"\",\"bomConvertTime\": \"Jan1, 11 2: 00: 00AM\",\"bomConvertUser\": 0,\"bomId\": 0," +
	"\"bomSourceLoc\": 0,\"bomTargetLoc\": 0,\"codeDealer\": \"\",\"codeDepartment\": \"\",\"codeProject\": \"\",\"codeSalesman\": \"\"," +
	"\"colSerial\": [],\"colSerialObj\":{\"batchNumber\": \"\",\"currency\": \"\",\"currency2\": \"\",\"docKey\": 1011,\"docRefKey\": 0," +
	"\"docRefTable\": \"\",\"docTable\": \"document_item\",\"entityId\": 536,\"entityTable\": \"cust_account_index\"," +
	"\"expiryDate\": \"Dec31, 9999 12: 00: 00AM\",\"guid\": \"6F038ACE-DEFD-461A-A658-847880254BA9\",\"intReserved1\": 0,\"itemId\": 1007," +
	"\"loyaltyLogic\": \"\",\"loyaltyPointsAwarded\": 0,\"loyaltyPointsRedeemed\": 0,\"namespace\": \"cust\",\"parentGuid\": \"\"," +
	"\"personInCharge\": 536,\"processNode\": 0,\"quantity\": 1,\"refStockId\": 0,\"remarks\": \"\",\"schTime\": \"Feb13, 2014 2: 06: 18AM\"," +
	"\"serialNumber\": \"1111\",\"state\": \"cre\",\"status\": \"act\",\"stockDelta\": 0,\"stockId\": 0,\"strReserved1\": \"\",\"strReserved2\": \"\"," +
	"\"strReserved3\": \"\",\"strReserved4\": \"\",\"timeEdit\": \"Feb13, 2014 2: 06: 18AM\",\"txnCode\": \"\",\"txnTime\": \"Feb13, 2014 12: 00: 00AM\"," +
	"\"txnType\": \"S\",\"unitCostCsg\": 0,\"unitPrice\": 100558,\"unitPrice2\": 0,\"userIdEdit\": 536,\"warrantyEnd\": \"Dec31, 9999 12: 00: 00AM\"," +
	"\"warrantyStart\": \"Jan1, 11 2: 00: 00AM\"},\"date_end\": \"Jan1, 11 2: 00: 00AM\",\"date_start\": \"Jan1, 11 2: 00: 00AM\"," +
	"\"docType\": \"cust_invoice_item\",\"glCodeCredit\": \"\",\"glCodeDebit\": \"\",\"jobsheetItemId\": 0,\"jobsheet_index_pkid\": 0," +
	"\"loyaltyJTxnReversalStatus\": \"NOACTION\",\"loyaltyJTxnStatus\": \"NOACTION\",\"loyaltyLogic\": \"\",\"loyaltyPointsAwarded\": 0," +
	"\"loyaltyPointsRedeemed\": 0,\"loyaltyProcessReversalStatus\": \"NOACTION\",\"loyaltyProcessStatus\": \"NOACTION\",\"mBarCode\": \"\"," +
	"\"mBdName1\": \"\",\"mBdValue1\": 0,\"mCurrency\": \"\",\"mCurrency2\": \"\",\"mDocGuid\": \"B137E868-F0A5-49BA-B1E9-B20146D8882E\"," +
	"\"mGuid\": \"BFD78640-6FEB-4918-97F0-C7EFDE1A8C84\",\"mIntName1\": \"\",\"mIntName2\": \"\",\"mIntValue1\": 0,\"mIntValue2\": 0," +
	"\"mInvoiceId\": 100001,\"mItemCode\": \"ATL4251320K\",\"mItemId\": 1007,\"mOutstandingQty\": 1,\"whtTaxType\": \"\",\"whtTaxRate\": 0," +
	"\"mParentId\": 0,\"mPic1\": 0,\"mPic2\": 0,\"mPic3\": 0,\"mPkid\": 1008,\"mPosItemGuid\": \"\",\"mPosItemId\": 0,\"mPosItemType\": \"\"," +
	"\"mRemarks\": \"\",\"whtTaxCode\": \"\",\"mState\": \"\",\"mStatus\": \"\",\"mStrName1\": \"cust_sales_order_index\"," +
	"\"mStrName2\": \"cust_sales_order_item\",\"mStrName3\": \"cust_sales_order_item\",\"mStrValue1\": \"100004\",\"mStrValue2\": \"1008\"," +
	"\"mStrValue3\": \"2E87937F-556A-469C-BEAC-A061DE232F17\",\"mTaxAmt\": 0,\"mTaxAmt2\": 0,\"mUnitCommission\": 0,\"mUnitCostMa\": 0," +
	"\"mUnitDiscount\": 0,\"mUnitDiscount2\": 0,\"mUnitPriceQuoted2\": 0,\"mUnitPriceStd\": 100558,\"mUnitPriceStd2\": 0,\"package_group\": \"\"," +
	"\"pseudoCode\": \"\",\"pseudoCurrency\": \"\",\"pseudoDescription\": \"\",\"pseudoLogic\": \"\",\"pseudoName\": \"\",\"pseudoPrice\": 0," +
	"\"pseudoQty\": 0,\"serialNumbers\": \"1111\",\"src_document_guid\": \"2E87937F-556A-469C-BEAC-A061DE232F17\",\"src_document_key\": 1008," +
	"\"src_document_table\": \"cust_sales_order_item\",\"stkId\": 0,\"stkLocationCode\": \"\",\"stkLocationId\": 0,\"taxCode\": \"\"," +
	"\"taxFilingCycle\": \"\",\"taxFilingDate\": \"Jan1, 11 2: 00: 00AM\",\"taxFilingStatus\": \"\",\"taxOption\": \"\",\"taxRate\": 0,\"taxType\": \"\"," +
	"\"uom\": \"\",\"uomRatio\": 0,\"vecBatchExpiry\": [],\"vecDiscountElement\": [],\"warrantyExpiry\": \"Jan1, 11 2: 00: 00AM\"," +
	"\"warrantyOption\": \"\",\"warrantyType\": \"\",\"whtFilingCycle\": \"\",\"whtFilingDate\": \"Jan1, 11 2: 00: 00AM\",\"whtTaxAmount\": 0," +
	"\"whtTaxBalance\": 0,\"mSerialized\": true,\"mPackageParent\": false,\"mPackage\": false";

    public TestModel()
    {
    	
    }
    
    //To Add information which are not provided by Client to convert to standard format.
    public void updateJsonToStandardFormat()
    {
    	
    	
    	if(this.category == "index"){
    		//Replace the variable name according to server requirement
    		this.json = this.json.replace("CustomerID", "mEntityKey"); 
    		this.json = this.json.replace("TransactionDate", "mTimeIssued");
    		this.json = this.json.replace("TotalInvoiceAmount", "mTotalAmt");
    		
    		//Add details
    		this.json = this.json + toAddIndex;
    		
    	}
    	else if(this.category == "item"){
    		//Replace the variable name according to server requirement
    		this.json = this.json.replace("PricePerItem", "mUnitPriceQuoted");
    		this.json = this.json.replace("QuantityPerItem", "mTotalQty");
    		this.json = this.json.replace("DescriptionItem", "mName");
    		this.json = this.json.replace("SKU code", "itemCode");
    		
    		//Add details
    	}
    	else{
    		//error
    	}
    }
    
    public void copyObject(TxQueueObject objTxQ){
    	objTxQ.pkid = this.pkid;
	   	objTxQ.pkString = this.pkString;
	   	objTxQ.fkString = this.fkString;
	   	objTxQ.category = this.category;
	   	objTxQ.source = this.source;
	   	objTxQ.type = this.type;
	   	objTxQ.xml = this.xml;
	   	objTxQ.json = this.json;
	   	objTxQ.userid = this.userid;
	   	objTxQ.status = this.status;
	   	objTxQ.date_created = this.date_created;
	   	objTxQ.date_received = this.date_received;
	   	objTxQ.date_completed = this.date_completed;
	   	objTxQ.branchid = this.branchid;
	   	objTxQ.amount = this.amount;
	   	objTxQ.mode = this.mode;
	   	objTxQ.remarks = this.remarks;
    }
    
}
