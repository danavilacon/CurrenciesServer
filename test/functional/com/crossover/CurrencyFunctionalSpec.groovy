package com.crossover

import com.crossover.pages.currency.*
import geb.spock.GebReportingSpec


class CurrencyFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to CurrencyListPage

		then:
		at CurrencyListPage
	}
	
	def "should be able to create a valid Currency"() {
		when:
		to CurrencyListPage

		and:
		createButton.click()

		then:
		at CurrencyCreatePage

		when:
		codeField = "Foo"
		countryField = "Foo"
			
		and:
		saveButton.click()

		then:
		at CurrencyShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Currency was successfully created"
	}
	
	def "should be able to sort the Currency List"() {
		given:
		to CurrencyListPage

		when:
		codeSort.click()
		
		then:
		codeSort.classes().contains("asc")

		when:
		countrySort.click()
		
		then:
		countrySort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Currency List"() {
		given:
		to CurrencyListPage

		when:
		codeFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		countryFilter = "Foo"
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Currency"() {
		when:
		to CurrencyListPage

		and:
		rows.first().editButton.click()

		then:
		at CurrencyEditPage
		
		when:
		codeField = "Foo!"
		countryField = "Foo!"
		
		and:
		saveButton.click()
		
		then:
		at CurrencyShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Currency was successfully updated"
	}
	
	def "should be able to delete the first Currency"() {
		when:
		to CurrencyListPage

		and:
		rows.first().deleteButton.click()

		then:
		at CurrencyListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Currency was successfully deleted"
      }
	
}