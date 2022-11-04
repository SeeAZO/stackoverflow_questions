import org.apache.pdfbox.multipdf.Overlay;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class Watermark
{
	public static void main(String args[]) throws
	                                       IOException
	{
		PDDocument originalPDF = PDDocument.load(new File("..Original_PDF.pdf"));   // To adjust with actual path

		HashMap<Integer, String> overlayGuide = new HashMap<>();
		overlayGuide.put(1, "..A1_Horizontal_Watermark.pdf");   // To adjust with actual path

		Overlay overlay = new Overlay();
		overlay.setInputPDF(originalPDF);
		overlay.setOverlayPosition(Overlay.Position.BACKGROUND);
		originalPDF = overlay.overlay(overlayGuide);

		originalPDF.save(new File("C:\\AxaviaPdfServiceAPI\\temp\\watermarked.pdf"));

		overlay.close();
	}
}