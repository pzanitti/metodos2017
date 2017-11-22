
package carnets;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.awt.Desktop;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class pdf {
    public static final String HTML = "src/carnets/PDF.template.html";

    public void emitirLicencia(Carnet carnet, Titular titular) throws IOException, DocumentException {
        String file = System.getProperty("user.home") + "/Desktop/" + carnet.getNumero() + ".pdf";
        
        File fileHandle = new File(file);
        fileHandle.getParentFile().mkdirs();

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();

        String content = readFile(HTML, StandardCharsets.UTF_8);
        content = content.replace("{{ clase }}", Character.toString(carnet.getClase().letra));
        content = content.replace("{{ clase.descripcion }}", carnet.getClase().descripcion);
        content = content.replace("{{ emision }}", carnet.getEmision().toString());
        content = content.replace("{{ expiracion }}", carnet.getExpiracion().toString());

        content = content.replace("{{ numero }}", String.valueOf(carnet.getNumero()));
        content = content.replace("{{ nombres }}", titular.getNombres());
        content = content.replace("{{ apellidos }}", titular.getApellidos());
        content = content.replace("{{ domicilio }}", titular.getDireccion());
        content = content.replace("{{ grupoSanguineo }}", titular.getGrupoSanguineo().nombre);
        content = content.replace("{{ factorSanguineo }}", Character.toString(titular.getFactorSanguineo().signo));
        content = content.replace("{{ donante }}", titular.isDonante()? "Sí" : "No");
        content = content.replace("{{ observaciones }}", titular.getObservaciones());
        
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell();
        ElementList list = XMLWorkerHelper.parseToElementList(content, null);
        
        for (Element element : list) {
            cell.addElement(element);
        }
        table.addCell(cell);
        document.add(table);

        document.close();
        
        Desktop.getDesktop().open(fileHandle);
    }
   
    private String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }
}
