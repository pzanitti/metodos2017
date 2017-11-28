
package carnets;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.ElementList;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import java.awt.Color;
import java.awt.Desktop;
 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class pdf {
    public static final String HTML = "src/carnets/PDF.template.html";
    public static final String BASE_LISTA_HTML = "src/carnets/baseListaPDF.template.html";
    public static final String CARNET_HTML = "src/carnets/carnetPDF.template.html";

    public void emitirLicencia(Carnet carnet, Titular titular) throws IOException, DocumentException {
        String file = System.getProperty("user.home") + "/Desktop/" + carnet.getNumero().get() + ".pdf";
        
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

        content = content.replace("{{ numero }}", String.valueOf(carnet.getNumero().get()));
        content = content.replace("{{ nombres }}", titular.getNombres());
        content = content.replace("{{ apellidos }}", titular.getApellidos());
        content = content.replace("{{ domicilio }}", titular.getDireccion());
        content = content.replace("{{ grupoSanguineo }}", titular.getGrupoSanguineo().nombre);
        content = content.replace("{{ factorSanguineo }}", Character.toString(titular.getFactorSanguineo().signo));
        content = content.replace("{{ donante }}", titular.isDonante()? "Sí" : "No");
        content = content.replace("{{ observaciones }}", carnet.getObservaciones());
        
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
    
    public void imprimirListaCarnets(List<Carnet> listaCarnets, String titulo, Boolean pintarExpirados) throws IOException, DocumentException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        String contenido = readFile(BASE_LISTA_HTML, StandardCharsets.UTF_8);
        contenido = contenido.replace("{{ titulo }}", titulo);
        
        //Completamos la lista
        String contenidoLista = "";
        String carnetTemplateString = readFile(CARNET_HTML, StandardCharsets.UTF_8);
        for(Carnet c : listaCarnets) {
            String temp = carnetTemplateString;
            
            Color color = Color.BLACK;
            if(pintarExpirados && c.isExpirado()) {
                color = Color.RED;
            }
            
            temp = temp.replace("{{ numero }}", c.getNumero().get().toString());
            temp = temp.replace("{{ nombre }}", c.getTitular().getNombres());
            temp = temp.replace("{{ apellido }}", c.getTitular().getApellidos());
            temp = temp.replace("{{ expiracion }}", c.getExpiracion().format(formatter));
            temp = temp.replace("{{ color }}", "rgb("+color.getRed()+","+color.getGreen()+","+color.getBlue()+")");
            
            contenidoLista += temp;
        }
        
        contenido = contenido.replace("{{ cuerpo_tabla }}", contenidoLista);
        
        
        String file = System.getProperty("user.home") + "/Desktop/" + titulo + ".pdf";
        
        File fileHandle = new File(file);
        fileHandle.getParentFile().mkdirs();

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(file));
        document.open();
        
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell();
        ElementList list = XMLWorkerHelper.parseToElementList(contenido, null);
        
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
