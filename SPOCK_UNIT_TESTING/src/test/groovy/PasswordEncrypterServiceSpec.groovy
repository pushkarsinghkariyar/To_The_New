package testCase

import Source.PasswordEncrypterService
import Source.User
import spock.lang.Specification

class PasswordEncrypterServiceSpec extends Specification {

    def "to test encryption status"()
    {
           String password = "pushkar"

          when:

          PasswordEncrypterService passwordEncrypterService = new PasswordEncrypterService()
          String encryptedPassword1 = passwordEncrypterService.encrypt(password)

          then:
          def decoded = new String(encryptedPassword1.decodeBase64())
          password==decoded
         
    }
    }

