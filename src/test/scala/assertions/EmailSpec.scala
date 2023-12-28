package assertions

import com.h2.entities.Email

class EmailSpec extends BaseUnitSpec{

  behavior of "An Email"

  it should "Return an email object for a valid String" in {
    val email = Email("howdy@google.com")

    assert(email.localPart === "howdy")
    assert(email.domain === "google.com")
  }

  it should "Return email object for valid String" in {
    assertResult("jim"){
      Email("jim@google.com").localPart
    }
  }

  it should "throw and exception when an email does not contain '@' symbol" in {
    assertThrows[IllegalArgumentException]{
      Email("jim.com")
    }
  }

  it should "throw and exception when an email contains more than one '@' symbol" in {
    assertThrows[IllegalArgumentException]{
      Email("jim@google@yahoo.com")
    }
  }

  it should "intercept error message when no '@' symbol is provided" in {
    val exception = intercept[IllegalArgumentException]{
      Email("google.com")
    }
    assert(exception.isInstanceOf[IllegalArgumentException])
    assert(exception.getMessage.contains("does not contain '@' symbol"))
  }
}
