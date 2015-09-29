package com.myneu.project.Dao;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.myneu.project.pojo.FinalProductsOrder;
import com.myneu.project.pojo.Product;
public class PdfDao {
	ArrayList<List<Product>> proList = new ArrayList<List<Product>>();
	public void proceedToCheckout(HttpServletRequest request, HttpServletResponse response, ArrayList<FinalProductsOrder> prodList, String customerName,
			float total)
			throws Exception{
		
		
		response.setContentType("application/pdf");
        Document document = new Document();
        
        try{
        	File theDir = new File("C:\\OrderedItems");
        	  // if the directory does not exist, create it
        	  if (!theDir.exists()) {
        	    System.out.println("creating directory: " + theDir);
        	    boolean result = theDir.mkdir();  
        	     if(result) {    
        	       System.out.println("DIR created");  
        	     }
        	  }
        	
        	 OutputStream file = new FileOutputStream(new File("C:\\OrderedItems\\FinalProducts.pdf"));
//             PdfWriter.getInstance(document, response.getOutputStream());
        	 PdfWriter.getInstance(document, file);
        /*	  PdfWriter.getInstance(document, response.getOutputStream());*/
             document.open();
             
             
            Paragraph p1 = new Paragraph("Registered user Name: " + customerName);
            Paragraph p2 = new Paragraph(" ");
             document.add(p1);
             document.add(p2);
             document.add(new Paragraph("Invoice Details"));
         
             document.add(new Paragraph(total));
             PdfPTable table = new PdfPTable(3);
             
             
           /*  List<Product> lp  = new ArrayList<Product>();
             for(List<Product> l : prodList){
            	 lp = l;
             }*/
             	
             FinalProductsOrder pTemp = null;
             
             table.addCell("Product ID");
             table.addCell("Product Name");
             table.addCell("Product Price");
             
             for(FinalProductsOrder p: prodList){
            	pTemp = p ;
            	 
            	 table.addCell(String.valueOf(pTemp.getProductId()));
            	 table.addCell(pTemp.getProductName());
            	
            	 table.addCell(String.valueOf(pTemp.getPrice()));
             /*    table.addCell(String.valueOf(selectedQuantit));
              * 
                */
            	 
             }
              
                
             document.add(table);
             document.addAuthor(String.valueOf(total));
             
             document.close();
            file.close();
           
        }
         catch (Exception e) { 
             e.printStackTrace();
         }
      
	}
}