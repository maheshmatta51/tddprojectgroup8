import entity.Customer;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.CustomerService;

public class CustomerServiceTest {

   private CustomerService customerService;

    //Mandana Khashayar
    //test initializer
    @Before
    public void initialize(){
         customerService = new CustomerService();
    }

    //Mandana Khashayar
    //tearDown after the test
    @After
    public void tearDown(){
        customerService=null;
    }

    //Author : Mandana Khashayar
    //test getUniqueCustomerIdBasedOnNameAndFamily in CustomerService class
    @Test
    public void testUniqueCustomerIdBasedOnNameAndFamily(){

       String st= customerService.getUniqueCustomerIdBasedOnNameAndFamily("Mandana","Khashayar",0);
        Assert.assertEquals(st,"M0A1N2D3A4N5A6K7H8A9S10H11A12Y13A14R15");
    }

    //Author : Mandana Khashayar
    //test AddNewCustomer in CustomerService class

    @Test
    public void testAddNewCustomer(){
        Customer customer=new Customer();
        customer.setName("Mandana");
        customer.setFamily("Khashayar");
        customer.setUniqueId("M0A1N2D3A4N5A6K7H8A9S10H11A12Y13A14R15");
        customerService.addNewCustomer(customer);
        boolean exist= customerService.getCustomers().stream().anyMatch(c -> "MandanaKhashayar".equals(c.getName()+c.getFamily()))
                ;
        Assert.assertTrue(exist);

    }

}
