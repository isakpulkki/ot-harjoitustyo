package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class KassapaateTest {

    Kassapaate kassapaate;
    Maksukortti maksukortti;

    @Before
    public void setUp(){
        kassapaate = new Kassapaate();
        maksukortti = new Maksukortti(400);
    }

    @Test
    public void syoEdullisesti(){
        kassapaate.syoEdullisesti(240);
        assertEquals(kassapaate.kassassaRahaa(), 100240);
    }
    @Test
    public void syoEdullisestiLiianVahanRahaa(){
        kassapaate.syoEdullisesti(200);
        assertEquals(kassapaate.kassassaRahaa(), 100000);
    }

    @Test
    public void syoMaukkaasti(){
        kassapaate.syoMaukkaasti(400);
        assertEquals(kassapaate.kassassaRahaa(), 100400);
    }

    @Test
    public void syoMaukkaastiLiianVahanRahaa(){
        kassapaate.syoMaukkaasti(100);
        assertEquals(kassapaate.kassassaRahaa(), 100000);
    }

    @Test
    public void syoEdullisestiKortilla(){
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(maksukortti.saldo(), 160);
    }

    @Test
    public void syoEdullisestiKortillaEiMeneNegatiiviseksi(){
        kassapaate.syoEdullisesti(maksukortti);
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(maksukortti.saldo(), 160);
    }


    @Test
    public void syoMaukkaastiKortilla(){
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(maksukortti.saldo(), 0);
    }

    @Test
    public void syoMaukkaastiKortillaEiMeneNegatiiviseksi(){
        kassapaate.syoMaukkaasti(maksukortti);
        maksukortti.lataaRahaa(100);
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(maksukortti.saldo(), 100);
    }

    @Test
    public void lataaRahaaKortille(){
        kassapaate.lataaRahaaKortille(maksukortti, 10);
        assertEquals(maksukortti.saldo(), 410);
    }

    @Test
    public void lataaRahaaKortilleEiLisaaNegatiivista(){
        kassapaate.lataaRahaaKortille(maksukortti, -10);
        assertEquals(maksukortti.saldo(), 400);
    }

    @Test
    public void Kassapaate(){
        assertEquals(kassapaate.kassassaRahaa(), 100000);
    }
    @Test
    public void maukkaitaLounaitaMyyty(){
        kassapaate.syoMaukkaasti(maksukortti);
        assertEquals(kassapaate.maukkaitaLounaitaMyyty(), 1);
    }

    @Test
    public void edullisiaLounaitaMyyty(){
        kassapaate.syoEdullisesti(maksukortti);
        assertEquals(kassapaate.edullisiaLounaitaMyyty(), 1);
    }
}