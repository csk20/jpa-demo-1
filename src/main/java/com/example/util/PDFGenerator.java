package com.example.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Array;
import java.util.stream.Stream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFGenerator {
	 public static ByteArrayInputStream customerPDFReport(String[] customers) {
		    Document document = new Document();
		        ByteArrayOutputStream out = new ByteArrayOutputStream();
		        
		        try {
		          
		          PdfWriter.getInstance(document, out);
		            document.open();
		          
		            // Add Text to PDF file ->
		          Font font = FontFactory.getFont(FontFactory.COURIER, 14, BaseColor.BLACK);
		          Paragraph para = new Paragraph( "Customer Table", font);
		          para.setAlignment(Element.ALIGN_CENTER);
		          document.add(para);
		          document.add(Chunk.NEWLINE);
		          
		          PdfPTable table = new PdfPTable(customers.length);
		          // Add PDF Table Header ->
		        
		          Stream.of(customers)
		          //  Stream.of("ID", "First Name", "Last Name")
		              .forEach(headerTitle -> {
		                  PdfPCell header = new PdfPCell();
		                  Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		                  header.setBackgroundColor(BaseColor.LIGHT_GRAY);
		                  header.setHorizontalAlignment(Element.ALIGN_CENTER);
		                  header.setBorderWidth(1);
		                  header.setPhrase(new Phrase(headerTitle, headFont));
		                  table.addCell(header);
		              });
		            for(String customer:customers) {
		           
		              PdfPCell idCell = new PdfPCell(new Phrase(customer));
		              idCell.setPaddingLeft(4);
		              idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		              idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		                table.addCell(idCell);
		 
		                PdfPCell firstNameCell = new PdfPCell(new Phrase(customer));
		                firstNameCell.setPaddingLeft(4);
		                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		                firstNameCell.setHorizontalAlignment(Element.ALIGN_LEFT);
		                table.addCell(firstNameCell);
		 System.out.println("............added");
		            }
			 
		               		       
		            document.add(table);
		            
		            document.close();
		        }catch(DocumentException e) {
		       //   logger.error(e.toString());
		        	System.out.println(e.toString());
		        }
		        
		    return new ByteArrayInputStream(out.toByteArray());
		  }
		
}
