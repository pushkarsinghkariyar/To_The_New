package testCase

import Source.DiscountType
import Source.EmailService
import Source.Product
import Source.SaleException
import Source.Transaction
import Source.User
import spock.lang.IgnoreRest
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class TransactionSpec extends Specification {

    def "test"() {

    }

    def "test the sell product method"() {
        setup:
        User user1 = new User( balance: 3000)

        User user2 = new User(balance: 6000)

        Product product = new Product(price: 4000)

        Transaction transaction1 = new Transaction()
        Transaction transaction2 = new Transaction()

        when:
        transaction1.sell(product, user1)
        user1.purchase(product)
        then:
        thrown(SaleException)

        when:
        transaction2.sell(product, user2)
        user2.purchase(product)

        then:
        user2.purchasedProducts.size() == 2


    }

    def "test cancel method"() {
        given:

        Product product = new Product(name: 'p1', price: 200)
        User user = new User(isPrivellegedCustomer: true,balance: 800)
        Transaction transaction = new Transaction()

        transaction.calculateDiscount(product, user)
        user.cancelPurchase(product)

        when:
        transaction.cancelSale(product, user)
        then:
        user.purchasedProducts.size() == 0
    }



    def " test to check discount calculation method"() {
        given:

        Product product = new Product(name: 'p1', price: 100, discountType: DiscountType.NONE)

        Product product1 = new Product(name: 'p2', price: 100, discountType: DiscountType.PRIVELLEGE_ONLY)

        Product product2 = new Product(name: 'p3', price: 100, discountType: DiscountType.ALL)

        User user = new User(isPrivellegedCustomer: true)

        User user1 = new User(isPrivellegedCustomer: false)

        Transaction transaction = new Transaction()



        when:
        BigDecimal discount = transaction.calculateDiscount(product, user)
        then:
        discount == 0


        when:
        BigDecimal discount1 = transaction.calculateDiscount(product1, user)
        then:
        discount1 == 30


        when:
        BigDecimal discount2 = transaction.calculateDiscount(product1, user1)
        then:
        discount2 == 10

        when:
        BigDecimal discount3 = transaction.calculateDiscount(product2, user1)
        then:
        discount3 == 10


    }
}