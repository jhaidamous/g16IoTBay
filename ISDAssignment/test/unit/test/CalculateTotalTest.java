package unit.test;

 

import java.sql.SQLException;
import static junit.framework.Assert.assertEquals;
//import org.junit.Assert;
//import static junit.framework.Assert;

import org.junit.Test;

//import static org.junit.Assert.*;

//import uts.isd.model.Calculator;
import uts.isd.model.dao.OrderDAO;
import uts.isd.model.dao.*;

/**

 *

 * @author George

 */

public class CalculateTotalTest {

 
    private SQLDBConnecter connector;
    private OrderDAO orderDAO;

     

    public CalculateTotalTest() throws ClassNotFoundException, SQLException {
        connector = new SQLDBConnecter();
        orderDAO = new OrderDAO(connector.connection());

    }

 

    @Test

    public void evaluatesExpression() throws SQLException {       

        double sum = orderDAO.calculateTotal(1);

        assertEquals(2797, sum);

    }

     

//    @Test
//
//    public void testAdd(){
//
//        int res = calculator.add(2,5);
//
//        assertEquals(7,res);
//
//    }
//
//     
//
//    @Test
//
//    public void testSub(){
//
//        int res = calculator.subtract(5,3);
//
//        assertEquals(2,res);
//
//    }
//
//     
//
//    @Test
//
//    public void testMul(){
//
//        int res = calculator.mul(2,4);
//
//        assertEquals(8,res);
//
//    }

//     
//
//    @Test
//
//    public void testPow(){
//
//        double res = calculator.power(2, 3);
//
//        Assert.assertEquals(8.00,res,0.001);
//
//    }

}