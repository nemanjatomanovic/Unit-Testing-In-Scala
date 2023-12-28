package matchers

import assertions.BaseUnitSpec
import com.h2.services.CustomerService

class StringSpec extends BaseUnitSpec{
  val customerService: CustomerService = new CustomerService {}

  behavior of "Customer service for Strings"

  it should "correctly match the customer email starting with first name" in {

    val (firstName, lastName, email, dob) = ("John", "Smith", "john@gmail.com", "1998/09/11")

    val customerId = customerService.createNewCustomer(firstName, lastName, email, dob)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should startWith (firstName.toLowerCase)
  }

  it should "correctly match the customer email ending with 'gmail.com'" in {

    val (firstName, lastName, email, dob) = ("John", "Smith", "john@gmail.com", "1998/09/11")

    val customerId = customerService.createNewCustomer(firstName, lastName, email, dob)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should endWith (email.split("@")(1))
  }

  it should "correctly match the customer email that includes '@' symbol" in {

    val (firstName, lastName, email, dob) = ("John", "Smith", "john@gmail.com", "1998/09/11")

    val customerId = customerService.createNewCustomer(firstName, lastName, email, dob)
    val customer = customerService.getCustomer(customerId).get

    customer.email.toString should include ("@")
  }

  it should "correctly match the customer date of birth as fullMatch regex" in {

    val (firstName, lastName, email, dob) = ("John", "Smith", "john@gmail.com", "1998/09/11")

    val customerId = customerService.createNewCustomer(firstName, lastName, email, dob)
    val customer = customerService.getCustomer(customerId).get

    customer.dateOfBirth.toString should fullyMatch regex "[0-9]{4}-[0-9]{2}-[0-9]{2}"
  }
}
