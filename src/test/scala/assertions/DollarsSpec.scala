package assertions

import com.h2.entities.Dollars

class DollarsSpec extends BaseUnitSpec{

  behavior of  "A Dollar"

  it should "Create a correct dollar object for number 10 as input" in {
    val tenDollars = Dollars(10)

    assert("$10" === tenDollars.toString)
  }

  it should "Correctly identify that $10 is greater than $5" in {
    val tenDollars = Dollars(10)
    val fiveDollars = Dollars(5)

    assert(tenDollars > fiveDollars)
  }

  it should "Correctly identify that $2 is less than $5" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assert(twoDollars < fiveDollars)
  }

  it should "Correctly add two Dolalr amounts" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assertResult("$7"){
      (twoDollars + fiveDollars).toString
    }
  }

  it should "Correctly subtract two Dolalr amounts" in {
    val twoDollars = Dollars(2)
    val fiveDollars = Dollars(5)

    assertResult("$3"){
      (fiveDollars - twoDollars).toString
    }
  }

  it should "Correctly equality of amounts" in {
    val twoDollars = Dollars(2)
    val anotherTwoDollars = Dollars(2)

    assertResult(true){
      twoDollars === anotherTwoDollars
    }
  }

  it should "throw an exception when invalid integer is provided to create Dollars" in {
    assertThrows[ArithmeticException]{
      Dollars(10 / 0)
    }
  }

  it should "cancel test with assume keyword" in {
    val listToAssert: List[Dollars] = List.empty

    assume(listToAssert.size > 0)

    listToAssert.foreach(element => assert(element.isInstanceOf[Dollars] ))
  }
}
