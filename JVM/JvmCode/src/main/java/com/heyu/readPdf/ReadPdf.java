package com.heyu.readPdf;


import com.asprise.ocr.Ocr;
import com.asprise.util.pdf.PDFReader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ReadPdf {

    public static void main(String[] args) throws IOException {
        File f = new File("e:/1.pdf");
        PDFReader reader = new PDFReader(f);
        reader.open(); // open the file.
        int pages = reader.getNumberOfPages();

        for(int i=0; i < pages; i++) {
            BufferedImage img = reader.getPageAsImage(i);

            // recognizes both characters and barcodes
            String text = new Ocr().recognize(img, Ocr.RECOGNIZE_TYPE_ALL, Ocr.PROP_PDF_OUTPUT_FILE);
            System.out.println("Page " + i + ": " + text);
        }

        reader.close(); // finally, close the file.
        /*try {
            PDDocument document = PDDocument.load(f);
            int numberOfPages = document.getNumberOfPages();
            System.out.println("页码数： " + numberOfPages);
            document.
            PDResources resources = document.getPage(0).getResources();
            Iterable<COSName> xObjectNames = resources.getXObjectNames();
            int count = 1;
            if(xObjectNames != null) {
                Iterator<COSName> iterator = xObjectNames.iterator();
                while (iterator.hasNext()) {
                    COSName key = (COSName) iterator.next();
                    if (resources.isImageXObject(key)) {
                        try {
                            PDImageXObject image = (PDImageXObject) resources.getXObject(key);
                            BufferedImage bimage = image.getImage();
                            ImageIO.write(bimage, "jpg", new File("e:/" + count + ".jpg"));
                            count++;
                            System.out.println(count);
                        } catch (Exception e) {
                        }
                    }

                }
            }

            InputStream contents = document.getPage(0).getContents();
            File f1 = new File("e:/2.png");
            FileOutputStream fos = new FileOutputStream(f1);
            f1.createNewFile();
            IOUtils.copy(contents, fos);
            for(int i = 0; i < numberOfPages; i++) {

            }
            fos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
