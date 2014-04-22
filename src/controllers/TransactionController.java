package controllers;

import java.util.ArrayList;

import models.BuyTransaction;
import models.RemovalTransaction;
import models.SellTransaction;

public class TransactionController {
	
	public static ArrayList<BuyTransaction> buyTransactionList;
	public static ArrayList<SellTransaction> sellTransactionList;
	public static ArrayList<RemovalTransaction> removalTransactionList;
	
	public TransactionController(){
		buyTransactionList = new ArrayList<BuyTransaction>();
		sellTransactionList = new ArrayList<SellTransaction>();
		removalTransactionList = new ArrayList<RemovalTransaction>();
		

		
		removalTransactionList.add(new RemovalTransaction());
	}
	
}
