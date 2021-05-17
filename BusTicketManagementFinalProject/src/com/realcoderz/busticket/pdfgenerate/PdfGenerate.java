package com.realcoderz.busticket.pdfgenerate;




	import java.io.FileNotFoundException;
	import java.util.List;

	import com.itextpdf.kernel.pdf.PdfDocument;
	import com.itextpdf.kernel.pdf.PdfWriter;
	import com.itextpdf.layout.Document;
	import com.itextpdf.layout.element.Paragraph;
import com.realcoderz.busticket.bean.BookingStatus;


	public class PdfGenerate {
		

		public void pdfGenerate(BookingStatus bookingstatus) throws FileNotFoundException
		{
		
		  PdfWriter pdfw = new PdfWriter("E:\\Ticket/abc.pdf");
		  PdfDocument pdf = new PdfDocument(pdfw);
		  pdf.addNewPage();
		  Document document = new Document(pdf);
		  
		  Paragraph p1 = new Paragraph("passengerId\t\tbusId\t\tNO.Of seats\t\tPrice\t\tDate");
		  document.add(p1);
		 
			  Paragraph p2 = new Paragraph(+bookingstatus.getPassenger().getPassengerid()+"\t\t" +bookingstatus.getBus().getBusId() +"\t\t"+bookingstatus.getNoOfSeats() +"\t\t"+bookingstatus.getPrice() +"\t\t"+bookingstatus.getDate());			 
			 document.add(p2);
			
			 int totalprice=bookingstatus.getNoOfSeats()*bookingstatus.getPrice();
		  
		  Paragraph p3 =  new Paragraph("Total Amount - "+totalprice);
		  document.add(p3);
	  
		  document.close();

	     }
	
}
