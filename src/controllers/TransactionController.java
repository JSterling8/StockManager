package controllers;

import java.util.ArrayList;

import models.BuyTransaction;
import models.RemovalTransaction;
import models.SellTransaction;
import models.Transaction;

public class TransactionController {
	
	public static ArrayList<BuyTransaction> buyTransactionList;
	public static ArrayList<SellTransaction> sellTransactionList;
	public static ArrayList<RemovalTransaction> removalTransactionList;
	public static ArrayList<Transaction> transactionList;
	
	public TransactionController(){
		buyTransactionList = new ArrayList<BuyTransaction>();
		sellTransactionList = new ArrayList<SellTransaction>();
		removalTransactionList = new ArrayList<RemovalTransaction>();
		transactionList = new ArrayList<Transaction>();
		

		
		removalTransactionList.add(new RemovalTransaction());
	}
	
}
