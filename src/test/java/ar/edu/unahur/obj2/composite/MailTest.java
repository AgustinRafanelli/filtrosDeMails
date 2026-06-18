package ar.edu.unahur.obj2.composite;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.composite.Agrupable;
import ar.edu.unahur.obj2.composite.filtros.Adjunto;
import ar.edu.unahur.obj2.composite.filtros.AsuntoContiene;
import ar.edu.unahur.obj2.composite.filtros.FiltroCompuesto;
import ar.edu.unahur.obj2.composite.filtros.Tamanio;
import ar.edu.unahur.obj2.composite.mail.Mail;

public class MailTest {

    @Test
    void dadoUnMailConAsuntoMuyImportanteYTamanio250ConAdjunto_cumpleFiltroConTieneAdjuntoConTamanioMinimo230(){
        Mail mail = new Mail("Jony", "Test", "Muy importante", 250, true, "Este mail es muy importante");
        Agrupable tamanio = new Tamanio(mail, 230);
        Agrupable adjunto = new Adjunto(mail);
        Agrupable asuntoContiene = new AsuntoContiene(mail, "importante");
    
        Agrupable compuesto = new FiltroCompuesto(
            Arrays.asList(tamanio, adjunto, asuntoContiene)
        );

        mail.setFiltro(compuesto);

        assertTrue(mail.filtrate());
    }
}
