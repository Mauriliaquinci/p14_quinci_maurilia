package testfunzionale;
import org.junit.runners.Suite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({LoginTest.class,TestPrenotazioneEsame.class, TestAccettaRifiutaVoto.class})

public class TestSuite2 {
}