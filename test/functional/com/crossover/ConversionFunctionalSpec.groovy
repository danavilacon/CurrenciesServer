package com.crossover

import com.crossover.pages.conversion.*
import geb.spock.GebReportingSpec


class ConversionFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to ConversionListPage

		then:
		at ConversionListPage
	}
	
	def "should be able to create a valid Conversion"() {
		when:
		to ConversionListPage

		and:
		createButton.click()

		then:
		at ConversionCreatePage

		when:
		currencyFromField = currencyFromField.find('option').value()
		currencyToField = currencyToField.find('option').value()
			
		and:
		saveButton.click()

		then:
		at ConversionShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Conversion was successfully created"
	}
	
	def "should be able to sort the Conversion List"() {
		given:
		to ConversionListPage

		when:
		currencyFromSort.click()
		
		then:
		currencyFromSort.classes().contains("asc")

		when:
		currencyToSort.click()
		
		then:
		currencyToSort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Conversion List"() {
		given:
		to ConversionListPage

		when:
		currencyFromFilter = currencyFromFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }

		when:
		currencyToFilter = currencyToFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Conversion"() {
		when:
		to ConversionListPage

		and:
		rows.first().editButton.click()

		then:
		at ConversionEditPage
		
		when:
		currencyFromField = currencyFromField.find('option').value()
		currencyToField = currencyToField.find('option').value()
		
		and:
		saveButton.click()
		
		then:
		at ConversionShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Conversion was successfully updated"
	}
	
	def "should be able to delete the first Conversion"() {
		when:
		to ConversionListPage

		and:
		rows.first().deleteButton.click()

		then:
		at ConversionListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Conversion was successfully deleted"
      }
	
}