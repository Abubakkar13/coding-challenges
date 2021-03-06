package com.practise.invoice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;

@Component
public class CreateInvoice extends CalculatorImpl{

    ArrayList<Item> updatedInvoiceList = new ArrayList<>();
    double finalPriceAfterTaxApplied;
    double totalSalesTax;
    void createInvoice(ArrayList<Item> itemList) {
        finalPriceAfterTaxApplied=0;
        totalSalesTax=0;
        for (Item listItem : itemList) {
            double itemPriceBeforeTax = listItem.getCost();
            Item itemWithTaxApplied = getItemFinalPriceIncludingTax(listItem);
            totalSalesTax = totalSalesTax + (itemWithTaxApplied.getCost() - itemPriceBeforeTax*itemWithTaxApplied.getQuantity());
            updatedInvoiceList.add(itemWithTaxApplied);

        }
        finalPriceAfterTaxApplied = getFinalPurchasedPrice(updatedInvoiceList);
        printInvoice(updatedInvoiceList, totalSalesTax, finalPriceAfterTaxApplied);


    }

    void printInvoice(ArrayList<Item> updatedInvoiceList, double totalSalesTax, double finalPriceAfterTaxApplied) {
        for (Item listItem : updatedInvoiceList) {
            System.out.println(listItem.getQuantity()+" "+listItem.getItemName()+": "+listItem.getCost());
        }
        System.out.println("Sales Taxes: "+totalSalesTax);
        System.out.println("Total: "+finalPriceAfterTaxApplied);
    }
}
