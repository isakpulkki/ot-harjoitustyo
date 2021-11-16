package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertNotNull(kortti);
    }

    @Test
    public void saldoOk(){
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void saldonKasvattaminen(){
        kortti.lataaRahaa(1990);
        assertEquals("saldo: 20.0", kortti.toString());
    }

    @Test
    public void otaRahaa(){
        kortti.otaRahaa(10);
        assertEquals("saldo: 0.0", kortti.toString());
    }

    @Test
    public void otaRahaaLiikaa(){
        kortti.otaRahaa(20);
        assertEquals("saldo: 0.10", kortti.toString());
    }

}
