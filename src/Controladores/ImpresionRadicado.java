
package Controladores;
    
import Modelos.Consultas.ImprimirRadicacion;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.standard.ColorSupported;
import javax.print.attribute.standard.PrinterName;

public class ImpresionRadicado {
    public void imprimirRadicado(ImprimirRadicacion impre) throws IOException, PrintException{
        String ruta = "src//radicado.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if(archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("VENTURAGROUP");
            bw.newLine();
            bw.write("RECIBIDO PARA VERIFICACION");
            bw.newLine();
            bw.write("SEDE: "+impre.getSede());
            bw.newLine();
            bw.write("RADICADO POR: "+ impre.getUsuarioRadicacion());
            bw.newLine();
            bw.write("ENVIADO A: "+ impre.getUsuarioDestino());
            bw.newLine();
            bw.write("NUMERO DE RADICADO: "+impre.getNumeroRadicacion());
            bw.newLine();
            bw.write("FECHA: "+ impre.getFecha());
            bw.newLine();
            bw.newLine();
            bw.write("Firma:______________________________");  
        } else {
              bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("VENTURAGROUP");
            bw.newLine();
            bw.write("RECIBIDO PARA VERIFICACION");
            bw.newLine();
            bw.write("SEDE: "+impre.getSede());
            bw.newLine();
            bw.write("RADICADO POR: "+ impre.getUsuarioRadicacion());
            bw.newLine();
            bw.write("ENVIADO A: "+ impre.getUsuarioDestino());
            bw.newLine();
            bw.write("NUMERO DE RADICADO: "+impre.getNumeroRadicacion());
            bw.newLine();
            bw.write("FECHA: "+ impre.getFecha());
            bw.newLine();
            bw.newLine();
            bw.write("Firma:_____________________________");       
        }
        bw.close();
        
        //Archivo que se desea imprimir
        FileInputStream inputStream = new FileInputStream(archivo);

        //Formato de Documento
        DocFlavor docFormat = DocFlavor.INPUT_STREAM.AUTOSENSE;
        //Lectura de Documento
        Doc document = new SimpleDoc(inputStream, docFormat, null);

        //Nombre de la impresoraarchivoarchivo
        String printerName = "Generic / Text Only";

        //Inclusion del nombre de impresora y sus atributos
        AttributeSet attributeSet = new HashAttributeSet();
        attributeSet.add(new PrinterName(printerName, null));
        attributeSet = new HashAttributeSet();
        //Soporte de color o no
        attributeSet.add(ColorSupported.NOT_SUPPORTED);

        PrinterJob job = PrinterJob.getPrinterJob();
        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        int selectedService = 0;
        for(int i = 0; i < services.length;i++){
            if(services[i].getName().equals(printerName)){
                selectedService = i;
            }
        }
        //Busqueda de la impresora por el nombre asignado en attributeSet
        services = PrintServiceLookup.lookupPrintServices(docFormat, attributeSet);
        System.out.println("Imprimiendo en : " + services[selectedService].getName());
        DocPrintJob printJob = services[selectedService].createPrintJob();
        //Envio a la impresora
        printJob.print(document, new HashPrintRequestAttributeSet());
        inputStream.close();
    }
}
