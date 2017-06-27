import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({TestCarrieraStudente.class,
				TestDocente.class,
				TestEsame.class, TestStudente.class,
				TestPromemoria.class, TestInsegnamento.class,
				TestPrenotazione.class, TestUtenteRegistrato.class,
				TestSistema.class,PrenotazioneEsameTest.class,
				AutenticazioneTest.class
				})
public class TestSuite1 {
}
