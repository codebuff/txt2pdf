package net.codebuff;
/**********************************
 @author Deepankar Tyagi
 **********************************/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import net.codebuff.views.Pdfcreated;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
public class PdfUtils {
	Document document = new Document();
	public static Pdfcreated diag;
	private String filename = "Java Assignment_" + FileUtil.name + ".pdf";

	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	public void createPDF() {


		try {
			PdfWriter.getInstance(document, new FileOutputStream(filename));

			document.open();
			addMetaData(document);
			addTitle();
			addtoPDf();
			document.close();
			diag = new Pdfcreated();
			diag.setVisible(true);

		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void addtoPDf() throws FileNotFoundException,
			DocumentException {
		String str;
		while (!FileUtil.javaFiles.isEmpty()) {
			String curFile = FileUtil.javaFiles.remove(0);
			Paragraph title = new Paragraph();
			title.setAlignment(1);
			title.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD,
					BaseColor.BLUE));
			title.add(new Phrase(curFile));
			document.add(title);
			addEmptyLine(title, 1);

			Paragraph paragraph = new Paragraph();
			paragraph.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 8,
					Font.NORMAL, BaseColor.BLACK));
			// Scanner sc = new Scanner(new File(curFile));
			try (BufferedReader br = new BufferedReader(new FileReader(curFile))) {
				String sCurrentLine;

				while ((sCurrentLine = br.readLine()) != null) {


					if (sCurrentLine.lastIndexOf('\t') > 0) {
						for (int i = 0; i != sCurrentLine.lastIndexOf('\t'); i++) {
							paragraph.add(new Phrase("       "));
						}
					}
					paragraph.add(new Phrase(sCurrentLine + "\n\t"));
					// System.out.println(sCurrentLine);

					}
				// }

			} catch (IOException e) {
				e.printStackTrace();
			}
			document.add(paragraph);
		}

	}

	private static void addEmptyLine(Paragraph paragraph, int number) {
		for (int i = 0; i < number; i++) {
			paragraph.add(new Paragraph("  "));
		}
	}

	public void addTitle() throws DocumentException {

		Paragraph title = new Paragraph();
		title.setAlignment(1);
		title.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD,
				BaseColor.RED));
		title.add(new Phrase("Java Assignment"));
		document.add(title);

		addEmptyLine(title, 2);

		Paragraph name = new Paragraph();
		name.setAlignment(0);
		name.setFont(new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD,
				BaseColor.GRAY));
		name.add(new Phrase("  Name     : " + FileUtil.name + "\n"));
		name.add(new Phrase("  Enrollno : " + FileUtil.rollno
				+ "\n\n"));
		document.add(name);

		addEmptyLine(title, 2);
	}


	private static void addMetaData(Document document) {
		document.addTitle("Java Assignemnt" + FileUtil.rollno);
		document.addSubject("contains all the java codes");
		// document.addKeywords("Java, PDF");
		document.addAuthor(FileUtil.name);
		document.addCreator("pdf maker by DT");
	}
}

