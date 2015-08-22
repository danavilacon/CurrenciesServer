package com.crossover

import com.crossover.pages.rate.*
import geb.spock.GebReportingSpec


class RateFunctionalSpec extends GebReportingSpec {

	def "should be able to view list page"() {
		when:
		to RateListPage

		then:
		at RateListPage
	}
	
	def "should be able to create a valid Rate"() {
		when:
		to RateListPage

		and:
		createButton.click()

		then:
		at RateCreatePage

		when:
		conversionField = conversionField.find('option').value()
		dateField = "01/01/2001"
		valueField = valueField.find('option').value()
			
		and:
		saveButton.click()

		then:
		at RateShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Rate was successfully created"
	}
	
	def "should be able to sort the Rate List"() {
		given:
		to RateListPage

		when:
		conversionSort.click()
		
		then:
		conversionSort.classes().contains("asc")

		when:
		dateSort.click()
		
		then:
		dateSort.classes().contains("asc")

		when:
		valueSort.click()
		
		then:
		valueSort.classes().contains("asc")
	
	}
	
	def "should be able to filter the Rate List"() {
		given:
		to RateListPage

		when:
		conversionFilter = conversionFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }

		when:
		dateFilter = "01/01/2001"
		
		then:
		waitFor { rows.size() > 0 }

		when:
		valueFilter = valueFilter.find('option').value()
		
		then:
		waitFor { rows.size() > 0 }
	
	}
	
	def "should be able to edit the first Rate"() {
		when:
		to RateListPage

		and:
		rows.first().editButton.click()

		then:
		at RateEditPage
		
		when:
		conversionField = conversionField.find('option').value()
		dateField = "02/01/2001"
		valueField = valueField.find('option').value()
		
		and:
		saveButton.click()
		
		then:
		at RateShowPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Rate was successfully updated"
	}
	
	def "should be able to delete the first Rate"() {
		when:
		to RateListPage

		and:
		rows.first().deleteButton.click()

		then:
		at RateListPage

		and:
		successMessage.displayed

		and:
		successMessage.text().contains "Rate was successfully deleted"
      }
	
}