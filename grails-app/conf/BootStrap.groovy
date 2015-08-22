import com.crossover.*

class BootStrap {

	def customMarshallerRegistrar

    def init = { servletContext ->
		customMarshallerRegistrar.registerMarshallers()
		
		// Currency
		def currencyUSD = new Currency(code: 'USD',country: 'United States Dollar').save(flush: true)
		def currencyEUR = new Currency(code: 'EUR',country: 'Euro Member Countries').save(flush: true)
		def currencyCLP = new Currency(code: 'CLP',country: 'Chilean Peso').save(flush: true)
		assert Currency.count() == 3

		// Exchange
		def conversionUsdEur = new Conversion(currencyFrom: currencyUSD, currencyTo: currencyEUR ).save(flush: true)
		def conversionUsdClp = new Conversion(currencyFrom: currencyUSD, currencyTo: currencyCLP ).save(flush: true)
		def conversionEurUsd = new Conversion(currencyFrom: currencyEUR, currencyTo: currencyUSD ).save(flush: true)
		def conversionEurClp = new Conversion(currencyFrom: currencyEUR, currencyTo: currencyCLP ).save(flush: true)
		def conversionClpUsd = new Conversion(currencyFrom: currencyCLP, currencyTo: currencyUSD ).save(flush: true)
		def conversionClpEur = new Conversion(currencyFrom: currencyCLP, currencyTo: currencyEUR ).save(flush: true)
		
		assert Conversion.count() == 6

		// Rate
		def today = new Date()
		def rateUsdEur = new Rate(conversion: conversionUsdEur,date: today, value: 0.8780170862125).save(flush: true)
		def rateUsdClp = new Rate(conversion: conversionUsdClp,date: today, value: 0.0014347202295).save(flush: true)
		def rateEurUsd = new Rate(conversion: conversionEurUsd,date: today, value: 1.13893).save(flush: true)

		assert Rate.count() == 3

	}
    def destroy = {
    }
}
