/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4Suite.java to edit this template
 */
package vj.cardshark;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author PC
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({vj.cardshark.CardSharkTest.class, vj.cardshark.DadoTest.class, vj.cardshark.JugadorTest.class, vj.cardshark.BarajaTest.class, vj.cardshark.ColorTest.class, vj.cardshark.TestTest.class, vj.cardshark.CartaTest.class, vj.cardshark.FiguraTest.class, vj.cardshark.FueraDeRangoExceptionTest.class})
public class CardsharkSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
