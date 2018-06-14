package br.com.fiap.testes;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.fiap.util.GeraHash;

public class TestePDF {
	public static void main(String[] args) {

		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("c:\\cupons\\PDF_Teste.pdf"));
			document.open();

			// adicionando um paragrafo no documento
			Paragraph nm = new Paragraph("FIAP ROUPAS");
			nm.setAlignment(Element.ALIGN_CENTER);
			document.add(nm);
			Paragraph addr = new Paragraph("Av. Lins de Vaconcelos, 383 - Aclimação");
			addr.setAlignment(Element.ALIGN_CENTER);
			document.add(addr);
			Paragraph stt = new Paragraph("São Paulo / SP");
			stt.setAlignment(Element.ALIGN_CENTER);
			document.add(stt);

			document.add(new Paragraph("CPF/CNPJ: 15683857813"));
			document.add(new Paragraph("IE: 222.222.222.222"));
			document.add(new Paragraph("IM: 3.333.333-3"));

			document.add(new Paragraph("............................................................................"));

			PdfPTable table = new PdfPTable(4);
			PdfPCell cell = new PdfPCell(new Phrase("15/01/2018"));
			table.addCell(cell);
			cell = new PdfPCell(new Phrase("10:01:01"));
			table.addCell(cell);
			cell = new PdfPCell(new Phrase("CCF: 010333"));
			table.addCell(cell);
			cell = new PdfPCell(new Phrase("COO: 12345"));
			cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
			table.addCell(cell);
			table.setWidthPercentage(100);
			document.add(table);

			document.add(new Paragraph("CUPOM FISCAL"));

			PdfPTable tbh = new PdfPTable(9);
			tbh.addCell(new PdfPCell(new Phrase("ITEM")));
			tbh.addCell(new PdfPCell(new Phrase("CODIGO")));
			tbh.addCell(new PdfPCell(new Phrase("DESCRICAO")));
			tbh.addCell(new PdfPCell(new Phrase("QTD.")));
			tbh.addCell(new PdfPCell(new Phrase("UN.")));
			tbh.addCell(new PdfPCell(new Phrase("VL UNIT.(R$)")));
			tbh.addCell(new PdfPCell(new Phrase("ST")));
			tbh.addCell(new PdfPCell(new Phrase("VL")));
			tbh.addCell(new PdfPCell(new Phrase("ITEM(R$)")));
			tbh.setWidthPercentage(100);
			document.add(tbh);

			PdfPTable total = new PdfPTable(2);
			total.addCell(new PdfPCell(new Phrase("TOTAL R$")));
			PdfPCell to = new PdfPCell(new Phrase("24,80"));
			to.setHorizontalAlignment(Element.ALIGN_RIGHT);
			total.addCell(to);
			total.setWidthPercentage(100);
			document.add(total);

			// HASH
			document.add(new Paragraph(GeraHash.gera("numero_pedido_id_cliente_valor_total")));

			// dados da empresa
			document.add(new Paragraph("FIAP ROUPAS S/A MF. 4000 178 M1 ECF42"));
			document.add(new Paragraph("VERSÃO 01.00.01	ECF: 8233	LJ: 8233"));
			document.add(new Paragraph("QQQQQQQQQQQRTV 12/06/2018	20:01:56"));
			document.add(new Paragraph("FAB: BE000000000000000000000000 00"));

			document.addSubject("Gerando PDF em Java");
			document.addKeywords("www.fiap.com.br");
			document.addCreator("by 30SCJ");
			document.addAuthor("Fiap Team - Amanda, Evair, Lucas, Stiven");

		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();

	}
}
