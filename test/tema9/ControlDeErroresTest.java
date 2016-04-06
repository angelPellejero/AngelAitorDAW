///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package tema9;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author VESPERTINO
// */
//public class ControlDeErroresTest {
//    
//    public ControlDeErroresTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of metodo1 method, of class ControlDeErrores.
//     */
//    @Test
//    public void testMetodo1() {
//        System.out.println("metodo1");
//        int dividento = -5;
//        int divisor = 2;
//        int resultado, resultado2;
//        int[] expResult = null;
//        int[] result = ControlDeErrores.metodo2(dividento, divisor);
//        resultado=result[0];
//        resultado2=result[1];
//        assertEquals(-2, resultado);
//        assertEquals(-1, resultado2);
//    }
//
//    /**
//     * Test of metodo2 method, of class ControlDeErrores.
//     */
//    @Test
//    public void testMetodo2() {
//        System.out.println("metodo2");
//        int dividento = 4;
//        int divisor = 2;
//        int resultado, resultado2;
//        int[] expResult = null;
//        int[] result = ControlDeErrores.metodo2(dividento, divisor);
//        resultado=result[0];
//        resultado2=result[1];
//        assertEquals(2, resultado);
//        assertEquals(0, resultado2);
//    }
//        @Test
//    public void testMetodo3() {
//        System.out.println("metodo3");
//        int dividento = 5;
//        int divisor = -2;
//        int resultado, resultado2;
//        int[] expResult = null;
//        int[] result = ControlDeErrores.metodo2(dividento, divisor);
//        resultado=result[0];
//        resultado2=result[1];
//        assertEquals(-2, resultado);
//        assertEquals(1, resultado2);
//    }
//            @Test
//    public void testMetodo4() {
//        System.out.println("metodo4");
//        int dividento = 0;
//        int divisor = 6;
//        int resultado, resultado2;
//        int[] expResult = null;
//        int[] result = ControlDeErrores.metodo2(dividento, divisor);
//        resultado=result[0];
//        resultado2=result[1];
//        assertEquals(0, resultado);
//        assertEquals(0, resultado2);
//    }
//    
//                @Test
//    public void testMetodo5() {
//        System.out.println("metodo5");
//        int dividento = 0;
//        int divisor = 0;
//        int resultado, resultado2;
//        int[] expResult = null;
//        int[] result = ControlDeErrores.metodo1(dividento, divisor);
//         assertNull(result);
//    }
//    
//                @Test
//    public void testMetodo6() {
//        System.out.println("metodo6");
//        int dividento = 5;
//        int divisor = 0;
//        int[] expResult = null;
//        int[] result = ControlDeErrores.metodo2(dividento, divisor);
//        assertNull(result);
//    }
//
//    
}
