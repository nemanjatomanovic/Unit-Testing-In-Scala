package matchers

import assertions.BaseUnitSpec
import com.h2.services.Currency

class EqualitySpec extends BaseUnitSpec{

  behavior of "Currency Equals"
  it should "match two 10 USD currencies as equals when using 'should equal' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should equal (currency2)
  }

  it should "match two 10 USD currencies as equals when using 'should ===' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should === (currency2)
  }

  it should "match two 10 USD currencies as equals when using 'shouldEqual' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldEqual currency2
  }

  it should "match two 10 USD currencies as equals when using 'shouldBe' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 shouldBe currency2
  }

  it should "match two 10 USD currencies as equals when using 'should be' syntax" in {
    val currency1: Currency = "10 USD"
    val currency2: Currency = "10 USD"

    currency1 should be (currency2)
  }
}
