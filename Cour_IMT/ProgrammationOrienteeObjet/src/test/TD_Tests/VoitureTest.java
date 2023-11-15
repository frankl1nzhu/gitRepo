package TD_Tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoitureTest {
    @Test
    public void testVoiture(){
        Voiture voiture = new Voiture("BMW", "530", 2020);
        voiture.setPuissance(700);
        voiture.setKm(150000);
        assertEquals(voiture.getMarque(), "BMW");
        assertEquals(voiture.getModele(), "530");
        assertTrue(voiture.getAnnee() > 2010);
        assertTrue(voiture.getKm() < 200000);
        assertTrue(voiture.getPuissance() < 800);
    }
}